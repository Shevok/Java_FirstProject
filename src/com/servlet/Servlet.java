package com.servlet;

import com.mysql.User;
import com.mysql.UserDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

@WebServlet("/")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> users = UserDB.select();
        request.setAttribute("users", users);
        RequestDispatcher Dispatcher = getServletContext().getRequestDispatcher("/Show.jsp");
        Dispatcher.forward(request, response);
        //request.getRequestDispatcher("/Show.jsp").forward(request, response);
    }
}

