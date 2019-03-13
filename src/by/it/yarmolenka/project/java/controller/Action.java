package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    INDEX(new CmdIndex()),
    LOGIN(new CmdLogin()),
    ERROR(new CmdError()),
    LOGOUT(new CmdLogout()),
    RESET(new CmdReset()),
    REGISTER(new CmdRegister()),
    GETEVENTS(new CmdGetEvents()),
    PROFILE(new CmdProfile()),
    ADMINPANELPROFILE(new CmdAdminPanelProfile()),
    EDITUSERS(new CmdEditUsers()),
    EDITRACES(new CmdEditRaces()),
    EDITEVENTS(new CmdEditEvents()),
    EDITBETS(new CmdEditBets()),
    CHANGEPASS(new CmdChangePass()),
    BET(new CmdBet());


    Cmd command;

    Action(Cmd command){
        this.command = command;
    }

    public static Action define(HttpServletRequest req) {
        try {
            String cmd = req.getParameter("command").toUpperCase();
            return Action.valueOf(cmd);
        } catch (Exception e){
            return Action.INDEX;
        }
    }

    public String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }
}
