package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        return Action.ERROR;
    }
}
