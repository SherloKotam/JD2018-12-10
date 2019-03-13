package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdResetDb implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) {
        Dao.getDao().reset();
        return Action.INDEX;
    }
}
