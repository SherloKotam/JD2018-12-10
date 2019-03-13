package by.it.yarmolenka.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

class CmdLogin implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.LOGIN;
    }
}
