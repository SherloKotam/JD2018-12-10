package by.it.zagurskaya.project.java.controller.cash;

import javax.servlet.http.HttpServletRequest;

import by.it.zagurskaya.project.java.controller.Cmd;
import by.it.zagurskaya.project.java.controller.Action;

public class CmdOperation implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws Exception {
        Action.OPERATION.setPATH("/cash/");
        return Action.OPERATION;
    }
}
