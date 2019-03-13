package by.it.medvedeva.project4.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

interface Cmd {

    Action execute(HttpServletRequest req) throws Exception;


}
