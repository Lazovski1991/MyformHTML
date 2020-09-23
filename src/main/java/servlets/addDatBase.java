package servlets;

import config.DataBaseConn;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "servlets.addDatBase")
public class addDatBase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        DataBaseConn dataBaseConn = new DataBaseConn();

        User user = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("text"));

        dataBaseConn.addDatabase(user);


        try {
            response.sendRedirect("/addDataBase.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseConn dataBaseConn = new DataBaseConn();

        User user = new User();
        User newUser = new User();


        user.setName(request.getParameter("name"));

        newUser = dataBaseConn.selectBase(user);
        /*PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1>"+ newUser.getId() + " " + newUser.getName()+ "</h1>");
        pw.println("</html>")*/;
        request.setAttribute("user", newUser);

        request.getRequestDispatcher("userDB.jsp").forward(request, response);

    }
}
