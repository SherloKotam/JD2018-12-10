package by.it.yarmolenka.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError()),
    LOGOUT(new CmdLogout()),
    LOGIN(new CmdLogin());

    Cmd command;

    Action(Cmd command){
        this.command = command;
    }

    public static Action define(HttpServletRequest req) {
        String cmd = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(cmd);
        } catch (Exception e){
            return Action.ERROR;
        }
    }

    public String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }
}
