package by.it.moroz.jd03.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Cmd {

    Action execute(HttpServletRequest req, HttpServletResponse pesp) throws Exception;

}
