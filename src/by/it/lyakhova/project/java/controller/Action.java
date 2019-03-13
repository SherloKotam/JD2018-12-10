package by.it.lyakhova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    SIGNUP(new CmdSignup()),
    LOGIN(new CmdLogin()),
    CREATETOUR(new CmdCreateTour()),
    PROFILE(new CmdProfile()),
    EDITUSERS(new CmdEditUsers()),
    LOGOUT(new CmdLogout()),
    RESETDB(new CmdResetDb());



    Action(Cmd command){
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/" + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req){

        try {
            String command = req.getParameter("command").toUpperCase();
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.INDEX;
        }
    }
}
