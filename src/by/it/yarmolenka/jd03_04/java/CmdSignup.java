package by.it.yarmolenka.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

class CmdSignup implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) {
        return Action.SIGNUP;
    }
}
