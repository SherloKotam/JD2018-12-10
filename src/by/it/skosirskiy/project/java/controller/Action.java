package by.it.skosirskiy.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public enum Action{

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    CREATEREQUEST(new CmdCreateRequest()),
    EDITREQUESTS(new CmdEditRequests()),
    RESETDB(new CmdResetDB()),
    EDITUSERS(new CmdEditUsers()),
    SIGNUP(new CmdSignup());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp(){
        return "/"+name().toLowerCase()+".jsp";
    }

    static Action define(HttpServletRequest req){


        //System.out.println(command);
        try {
            String command= req.getParameter("command").toUpperCase();
            return Action.valueOf(command);

        }
        catch (Exception e){return Action.INDEX;}


    }

}
