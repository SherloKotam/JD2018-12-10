package by.it.migunko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {
 Action execute(HttpServletRequest req)
            throws Exception;
}
