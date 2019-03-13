package by.it.medvedeva.project.java.controller;

import by.it.medvedeva.project.java.controller.Action;

import javax.servlet.http.HttpServletRequest;

public class ActionDefiner {

    static by.it.medvedeva.project.java.controller.Action define(HttpServletRequest req){
        by.it.medvedeva.project.java.controller.Action result= by.it.medvedeva.project.java.controller.Action.ERROR;
       String command = req.getParameter("command");
       if(command!=null && !command.isEmpty()){
           try {
           result= by.it.medvedeva.project.java.controller.Action.valueOf(command.toUpperCase());
       }
       catch (IllegalArgumentException e) {

               //create our error

       }}
               return result;
    }


    }


