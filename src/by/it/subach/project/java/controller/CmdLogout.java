package by.it.subach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        if (Form.isPost(req)) {
            req.getSession().invalidate();
            return Action.LOGIN;
        }
        return Action.LOGOUT;
    }
}
