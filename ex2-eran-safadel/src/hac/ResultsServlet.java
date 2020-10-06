package hac;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet that Show the results of survey, if you vote more than once - display message to client
 */

@WebServlet(name = "ResultsServlet" , urlPatterns = "/ResultsServlet")
public class ResultsServlet extends HttpServlet
{
    /** function doPost - show Result to user
     * @param request - request from client
     * @param response - response to client
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        showResult(request,response);
    }

    /**
     *function that check if user vote more than once, if true - display message to client and build html for client
     *@param request - request from client
     * @param response - response to client
     */
    private void showResult(HttpServletRequest request, HttpServletResponse response) {

        String item = request.getParameter("item");
        VoteResArr voteResArr= (VoteResArr)getServletContext().getAttribute("ListOfFile");
        try {
            if (checkParamsWrong(request, response)|| fillSurvey(item, response)){
                return;
            }

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter toClient = response.getWriter();
            request.getRequestDispatcher("/StartPage.html").include(request,response);
            request.getRequestDispatcher("/tablePage.html").include(request,response);
            checkCookies(request,toClient,response,voteResArr);
            buildHtml(toClient,voteResArr);
            toClient.println("<form action = /StartServlet method = post> <BR><BR><input type=\"submit\" name = btnSubmit value= Back> </form> ");
            request.getRequestDispatcher("/resultsPageFinal.html").include(request, response);
            toClient.close();
        }
        catch (RedirectException | ParamsWrongException | ServletException e)
        {
            System.err.println(e.toString());
        }
        catch (IOException e)
        {
            try
            {
                request.getRequestDispatcher("/ErrorConnect.html").include(request, response);
            }
            catch (IOException | ServletException e1){ System.err.println(e1.toString());}
        }
    }

    /**
     * function that build html to client
     * @param toClient - PrintWriter type for response to client
     * @param voteResArr - ArrayList that save all results of survey
     */
    private void buildHtml(PrintWriter toClient, VoteResArr voteResArr)
    {

        for (int i = 0; i < voteResArr.getSizeList(); i++)
        {
            toClient.println(

                    " <tr>\n" +
                            "    <td>" + voteResArr.getAnswerByIndex(i) + "</td>\n" +
                            "    <td>" + voteResArr.getCountByIndex(i)+ "</td>\n" +
                            "  </tr>\n");
        }

    }

    /**
     * function that check if create cookie for user - if so - the count of vote not increased else
     * count of vote increased by one
     * @param request - request from client
     * @param toClient -  PrintWriter type for response to client
     * @param response -  response to client
     * @param voteResArr -  ArrayList that save all results of survey
     */
    private void checkCookies(HttpServletRequest request, PrintWriter toClient, HttpServletResponse response, VoteResArr voteResArr)
    {
        boolean isEntered =true;
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie value : cookies) {
                if (value.getName().compareTo("myCookie") == 0) {
                    isEntered = false;
                    toClient.println("<div class=\"text-danger\"> <h6> You  already voted! </h6></div>");
                    break;
                }
            }
        }

        if (isEntered)
        {
            Cookie cookie = new Cookie("myCookie", "valCookie");
            response.addCookie(cookie);
            voteResArr.setCountOfIndex(Integer.parseInt(request.getParameter("item")));
        }
    }


    /**
     * function that check if survey already filled
     * @param item - string that symbolize  what user clicked
     * @param response - response from user
     * @return  boolean that indicate if was a clicked or not
     * @throws RedirectException - Exception that indicate Fail of Redirect
     */
    private Boolean fillSurvey(String item, HttpServletResponse response ) throws RedirectException {
        if(item == null)
        {
            try {
                response.sendRedirect("/StartServlet");
            } catch (IOException e) {
                throw new RedirectException();
            }
            return true;
        }
        return false;

    }

    /**
     * function that check if params of url is valid
     * @param request  - request to user
     * @param response  - response from user
     * @return boolean that indicate if params ok or not
     * @throws ParamsWrongException -  Exception that indicate Fail of params
     */
    private boolean checkParamsWrong(HttpServletRequest request, HttpServletResponse response) throws ParamsWrongException {
        if(request.getQueryString()!=null)
        {
            try
            {
                request.getRequestDispatcher("/ErrorQueryGet.html").include(request, response);
            }
            catch (IOException | ServletException e)
            {
                throw new ParamsWrongException();
            }
            return true;
        }
        return false;
    }
    /**
     *function doGet - read to function doPost
     * @param request -  request to user
     * @param response - response from user
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        doPost(request,response);
    }
}
