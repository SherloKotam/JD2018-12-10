package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.beans.Role;
import by.it.zagurskaya.project.java.dao.RoleDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrontController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        RoleDao roleDao = new RoleDao();
        List<Role> roles = new ArrayList<Role>();

        try {
            roles.addAll(roleDao.getAll());
            servletContext.setAttribute("roles", roles);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    // HttpServletRequest req - информация о запросе - т.е. ВХОД - то что читать
    // HttpServletResponse resp - информация о результате - т.е. ВЫХОД - то куда писать
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("resp", resp);
        Action action = Action.define(req);
        try {
            Action nextAction = action.command.execute(req);
            if (nextAction == action) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(action.getJsp());
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + nextAction.name().toLowerCase());
            }
        } catch (Exception e) {
            ShowException(req, resp, e);
        }
    }

    private void ShowException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Action.ERROR.getJsp());
        StackTraceElement[] stackTrace = e.getStackTrace();
        String error = e.toString() + "<hr>" +
                Arrays.toString(stackTrace).replace(",", "<br>");
        req.setAttribute("error", error);
        requestDispatcher.forward(req, resp);
    }
}
