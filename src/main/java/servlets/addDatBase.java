package servlets;

import config.DataBaseConn;
import model.User;

import javax.print.MultiDocPrintService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "servlets.addDatBase")
public class addDatBase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseConn dataBaseConn = new DataBaseConn();

        User user = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("text"));

        dataBaseConn.addDatabase(user);


        response.sendRedirect("/addDataBase.html");
    }
}
