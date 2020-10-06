package hac;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static hac.Utils.ERROR_CONNECTION;

/**
 * Servlet that responsible for build the form that shows to user
 */
@WebServlet(name = "FormServlet", urlPatterns = "/FormServlet")
public class FormServlet extends HttpServlet
{
    /**
     *called to doGet
     * @param request - request to  server
     * @param response -response from server
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        doGet(request,response);

    }

    /**
     *check if not enter to query something and  showForm to user
     * @param request - request to  server
     * @param response -response from server
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        try {

            if (request.getQueryString() != null)
                request.getRequestDispatcher("/ErrorQueryGet.html").include(request, response);
            showForm(request, response);
        }
        catch (ServletException | IOException e)
        {
            try {
                request.getRequestDispatcher("/ErrorConnect.html").include(request, response);
            }
            catch (IOException | ServletException e1) {System.err.println(ERROR_CONNECTION);}
        }
    }

    /**
     * show from is a func that build  the form to client
     * @param request - request to  server
     * @param response -response from server
     * @throws IOException - indicate IOException
     * @throws ServletException - indicate ServletException
     */
    private void showForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("/StartPage.html").include(request, response);
        out.println(" <h5>" + getServletContext().getAttribute("Question") + "</h5>");
        out.println(" <form method=\"POST\" action=\"ResultsServlet\">");
        VoteResArr voteResArr = (VoteResArr) getServletContext().getAttribute("ListOfFile");
        for (int i = 0; i < voteResArr.getSizeList(); ++i) {
            out.println("<input type=\"radio\" name = item value =" + i + ">" + voteResArr.getAnswerByIndex(i) + "</radio><br/>");
        }
        out.println(" <BR><BR><input type=\"submit\" name = btnSubmit value= Send>" + "</form> </body></html>");
        out.close();
    }


}
