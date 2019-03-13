package by.it.medvedeva.project4.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Action {

    RESET {
        {
            cmd = new CmdReset();
            jsp = "/reset.jsp";

        }
    },
    INDEX {
        {
            cmd = new CmdIndex();
            jsp = "/index.jsp";

        }
    },
    SIGNUP {
        {
            cmd = new CmdSignup();
            jsp ="/signup.jsp";
        }
    },
    LOGIN {
        {
            cmd = new CmdLogin();
            jsp ="/login.jsp";
        }
    },
    PROFILE {
        {
            cmd = new CmdProfile();
            jsp ="/profile.jsp";
        }
    },
    ERROR {
        {
            cmd = new CmdError();
            jsp = "/error.jsp";
        }
    };

    Cmd cmd  = new CmdError();
    public String jsp ="/error.jsp";

    String getJsp() {

        return "/" + this.name().toLowerCase() + ".jsp";
    }


    static Action define(HttpServletRequest req){
        Action result=Action.ERROR;
        String command = req.getParameter("command");
        if(command!=null && !command.isEmpty()){
            try {
                result=Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e) {

                //create our error

            }}
        return result;
    }



}
