package by.it.medvedeva.project.java.controller;

import by.it.medvedeva.project.java.controller.Action;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {

    abstract Action execute(HttpServletRequest req);

    @Override
    public String toString() {
        return super.toString();
    }
}
