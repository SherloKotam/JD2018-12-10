package by.it.skosirskiy.project.java.controller;


import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.beans.Status;
import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session==null)
            return null;
        Object oUser = session.getAttribute("user");
        if (oUser == null) {
            return null;
        } else {
            return (User) oUser;
        }
    }

    static Request findRequest(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session==null)
            return null;
        Object oRequest = session.getAttribute("request");
        if (oRequest == null) {
            return null;
        } else {
            return (Request) oRequest;
        }
    }
    static List<Status> getStatuses(HttpServletRequest req) throws SQLException {
        return Dao.getDao().status.getAll("");

    }

    public static String getHash(User user){
        String key=user.getEmail()+user.getLogin()+user.getPassword()+"asffasfxcz/*-+xcФымФЫВ";
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie){
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }
}
