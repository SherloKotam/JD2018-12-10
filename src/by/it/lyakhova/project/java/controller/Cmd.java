package by.it.lyakhova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public interface Cmd {
    Action execute(HttpServletRequest request) throws Exception;
}
