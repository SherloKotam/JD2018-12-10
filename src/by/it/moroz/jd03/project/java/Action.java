package by.it.moroz.jd03.project.java;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    SIGNUP(new CmdSighUp()),
    LOGIN(new CmdLogin()),
    ORDER(new CmdOrder()),
    PROFILE(new CmdProfile()),
    RESET(new CmdReset()),
    RESTAURANT(new CmdRestaurant()),
    ADMIN(new CmdAdmin());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

     static Action define(HttpServletRequest req){
        String command = req.getParameter("command").toUpperCase();
        try{
            return Action.valueOf(command);
        }catch (Exception e){
            return Action.ERROR;
        }

    }

    String getJSP(){
         return "/"+name().toLowerCase()+".jsp";
    }


}
