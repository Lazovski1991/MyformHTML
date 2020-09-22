package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "servlets.addFile")
public class addFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File(request.getParameter("way"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String text = request.getParameter("text");





        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("E-mail: " + email + "\n");
            fileWriter.write("Text: " + text + "\n");
        }
        response.sendRedirect("/add.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
