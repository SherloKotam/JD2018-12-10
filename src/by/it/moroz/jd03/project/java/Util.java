package by.it.moroz.jd03.project.java;

import by.it.moroz.jd03.project.java.beans.Order;
import by.it.moroz.jd03.project.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    static Order findOrder(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session==null)
            return null;
        Object oOrder = session.getAttribute("order");
        if (oOrder == null) {
            return null;
        } else {
            return (Order) oOrder;
        }
    }

    public static String getHash(User user) {
        String key = user.getEmail() + user.getLogin() + user.getPassword() + "SHA1PRNG";
        return DigestUtils.md5Hex(key);
    }
}
