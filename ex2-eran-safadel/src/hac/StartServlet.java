package hac;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;

import static hac.Utils.*;

/**
 * main section
 * Eran Safadel
 * ex2
 * this program  is survey for users and shows  the qes and ans for the survey
 * the program first of all reads data from file and save them on Context
 * after that show the result of survey to client
 */

@WebServlet(name = "StartServlet", urlPatterns = "/StartServlet",
        initParams = {
                @WebInitParam(name = "fileName", value = FILE_NAME)})

public class StartServlet extends HttpServlet
{
    /**
     * "INIT" function that read from file and insert the data to array
     * @param config -  configuration of program
     * @throws ServletException - indicate ServletException
     */
    @Override

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        String fileName = config.getInitParameter("fileName");
        VoteResArr voteResArr = VoteResArr.getInstance();
        config.getServletContext().setAttribute("Error", true);
        try (BufferedReader file = checkFile(config, fileName))
        {
            readFile(config, file, voteResArr);
        }
        catch (IOException e) {
            System.err.println(e.toString());
            config.getServletContext().setAttribute("Error", false);
        }
    }


    /**
     * function that read from file
     * @param config -  configuration of program
     * @param file - file from user
     * @param voteResArr - array that save result of Vote-(answer and count)
     * @throws IOException - throws IOException
     */
    private void readFile(ServletConfig config, BufferedReader file, VoteResArr voteResArr) throws IOException {

        String s ;

        if ((s = file.readLine()) != null)//q
        {
            config.getServletContext().setAttribute("Question", s);
            while ((s = file.readLine()) != null)//a
            {
                voteResArr.addIndex(new Vote(s, INITIALIZE));
            }
        }
        config.getServletContext().setAttribute("ListOfFile", voteResArr);
    }

    /**
     * function that check if url of  file is valid  if so return the file else throw IOException
     * @param config -  configuration of program
     * @param fileName - strin that indicate a poll.txt
     * @return BufferedReader - file to work with
     * @throws IOException - throws IOException
     */
    private BufferedReader checkFile(ServletConfig config, String fileName) throws IOException
    {

        URL url =  config.getServletContext().getResource(fileName);
        if(url == null)
            throw  new IOException();
        return new BufferedReader(new InputStreamReader(url.openStream()));

    }




    /**
     * func that read to doGet
     * @param request - request to  server
     * @param response -response from server
     * @throws ServletException - indicate ServletException
     * @throws IOException - throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }


    /**
     *  check if url is found on this program and check if the user not write on query something
     *  and check if the number of qeest and ans small then 3  if so go to FormServlet
     * @param request - request to  server
     * @param response -response from server
     * @throws ServletException - indicate ServletException
     * @throws IOException - throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url = request.getRequestURI();
        if(!((url.equals("/StartServlet")) || (url.equals("/FormServlet") )||  (url.equals("/ResultsServlet") )))
            return;

        if (request.getQueryString() != null) {
            request.getRequestDispatcher("/ErrorQueryGet.html").include(request, response);
            return;
        }

        VoteResArr list = (VoteResArr) getServletContext().getAttribute("ListOfFile");


        if (list.getSizeList() < SIZE_ANS + SIZE_QUEST || !(Boolean) getServletContext().getAttribute("Error")) {
            RequestDispatcher rd = request.getRequestDispatcher("/formSurvey.html");
            rd.include(request, response);
            return;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FormServlet");
        dispatcher.forward(request, response);
    }
}
