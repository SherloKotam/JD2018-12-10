package by.it.migunko.project.java.controller;

import by.it.migunko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

class CmdResetDB implements Cmd {
    @Override
   public Action execute(HttpServletRequest req) throws Exception {
        Dao.reset();
        return Action.LOGIN;
    }
}
