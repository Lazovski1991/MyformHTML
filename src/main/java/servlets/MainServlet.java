package servlets;

import config.DataBaseConn;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String way = request.getParameter("way");
        RequestDispatcher requestDispatcher;

        if (way.isEmpty()) requestDispatcher = request.getRequestDispatcher("/addBase");

        else  requestDispatcher = request.getRequestDispatcher("/add");

        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseConn dataBaseConn = new DataBaseConn();
        List<User> list = dataBaseConn.listBase();

        request.setAttribute("list", list);

        request.getRequestDispatcher("listBD.jsp").forward(request, response);
    }
}
