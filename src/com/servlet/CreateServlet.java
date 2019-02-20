package com.servlet;

import com.mysql.User;
import com.mysql.UserDB;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            int age = Integer.parseInt(request.getParameter("age"));

            User user = new User(id, firstname, lastname,age);
            UserDB.insert(user);
            RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/");
            Dispatcher.forward(request, response);
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}