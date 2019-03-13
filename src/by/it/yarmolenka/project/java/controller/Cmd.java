package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Cmd {
    Action execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
