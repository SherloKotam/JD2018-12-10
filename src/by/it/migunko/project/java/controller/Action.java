package by.it.migunko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {
    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    LOGIN(new CmdLogin()),
    EDITUSERS(new CmdEditUsers()),
    CREATETOUR(new CmdCreateTour()),
    PROFILE(new CmdProfile()),
    RESETDB(new CmdResetDB()),
    SIGNUP(new CmdSignUp());


    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;


    String jsp = "/"+this.toString().toLowerCase()+".jsp";

    static Action defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
        System.out.println("command="+command);
        if (command != null && !command.isEmpty()) {
            return Action.valueOf(command.toUpperCase());
        }else
            return Action.INDEX;

    }
}
