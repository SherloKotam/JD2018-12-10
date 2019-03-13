package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        User user = Util.findUser(req);
        if(user != null){
//            String where = String.format(" WHERE `id`=" + user.getId());
            StringBuilder info = new StringBuilder();
            info.append("Login: ").append(user.getLogin()).append("<br>");
            info.append("Password: ").append(user.getPassword()).append("<br>");
            info.append("Email: ").append(user.getEmail()).append("<br>");
            req.setAttribute("info", info);
            return Action.PROFILE;
        }
        return Action.LOGIN;

    }
}
