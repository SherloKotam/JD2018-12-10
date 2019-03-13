package by.it.yarmolenka.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    @Override
    public void init() {
        ServletContext servletContext = getServletContext();
        try {
            Utils.setServletContextAttributes(servletContext);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        Action action = Action.define(req);
        try {
            Action nextAction = action.command.execute(req, resp);
            if (nextAction == action) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJsp());
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + nextAction.name().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
