package by.it.subach.project.java.controller;

import by.it.subach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDB implements Cmd {


    @Override
    public Action execute(HttpServletRequest req) throws Exception {

        if(req.getParameter("reset") != null){
            String message = "DataBase successfully reset!";
            req.setAttribute("message", message);
        }

        if(Form.isPost(req)){
            DAO.getInstance().reset();

        }

        return Action.RESETDB;
    }
}