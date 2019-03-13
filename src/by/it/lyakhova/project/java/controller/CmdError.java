package by.it.lyakhova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        return Action.ERROR;
    }
}
