package by.it.yarmolenka.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

interface Cmd {
    Action execute(HttpServletRequest req);
}
