package by.it.subach.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FrontController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp){
        req.setAttribute("resp", resp);
        Action action= Action.define(req);
        try {
            Action nextAction = action.command.execute(req);

            if (nextAction == action) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJsp());
                requestDispatcher.forward(req,resp);
            } else {
                resp.sendRedirect("do?command="+nextAction.name().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private void ShowException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Action.ERROR.getJsp());
        StackTraceElement[] stackTrace = e.getStackTrace();
        String error = e.toString()+"<hr>"+
                Arrays.toString(stackTrace).replace(",", "<br>");
        req.setAttribute("error",error);
        requestDispatcher.forward(req, resp);
    }
}
