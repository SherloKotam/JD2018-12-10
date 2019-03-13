package by.it.subach.project.java.controller;

import by.it.subach.project.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Util {

    static User findUser(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return null;
        }
        Object oUser = req.getSession().getAttribute("user");
        if (oUser == null){
            return null;
        }
        else
            return (User) oUser;
    }

    public static String getHash(User user) {
        String key = user.getEmail()+user.getLogin()+user.getPassword() + "salt";
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie){
        HttpServletResponse resp = (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }
}
