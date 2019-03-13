package by.it.yarmolenka.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.ERROR;
    }
}
