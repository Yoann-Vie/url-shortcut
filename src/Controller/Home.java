package Controller;

import Model.Url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "home", urlPatterns = "")
public class Home extends HttpServlet {

    /**
     * Home get action
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward(request, response);
    }

    /**
     * Home post action
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String url = request.getParameter("base-url");

        try {
            Url urlItem = new Url();
            urlItem.setBaseUrl(url).shortUrl().persist();

            HttpSession session = request.getSession();
            session.setAttribute("url", urlItem);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        this.getServletContext().getRequestDispatcher( "/success.jsp" ).forward(request, response);
    }
}
