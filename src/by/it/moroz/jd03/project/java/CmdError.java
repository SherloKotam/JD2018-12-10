package by.it.moroz.jd03.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdError implements Cmd {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        return Action.ERROR;
    }
}
