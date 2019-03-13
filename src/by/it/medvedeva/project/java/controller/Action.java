package by.it.medvedeva.project.java.controller;

import by.it.medvedeva.project.java.controller.*;
import by.it.medvedeva.project.java.controller.Cmd;

enum Action {


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
    LOGOUT {
        {
            cmd = new CmdLogout();
            jsp ="/logout.jsp";
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





}
