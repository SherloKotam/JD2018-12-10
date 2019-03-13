package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {
    static User findUser(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if (session==null){
            return null;
        }
        Object oUser = request.getSession().getAttribute("user");

        if (oUser != null)
            return (User) oUser;
        else
            return null;
    }

    public static String getHash(User user){
        String key=user.getEmail()+user.getLogin()+user.getPassword();
        return DigestUtils.md5Hex(key);
    }

    static void setCookie(HttpServletRequest req, Cookie cookie){
        HttpServletResponse resp =
                (HttpServletResponse) req.getAttribute("resp");
        resp.addCookie(cookie);
    }

    static void loadImage(HttpServletRequest req, String filename){
        try {
            Part reqPart = req.getPart("fileimg");
            if (reqPart.getSize() > 0) {
                try (
                        InputStream fileimg = reqPart.getInputStream();
                        OutputStream fileout = new FileOutputStream(
                                req.getServletContext().getRealPath(filename)
                        );
                ) {
                    byte[] bytes = new byte[
                            Math.min(128 * 1024, fileimg.available())
                            ];
                    while (fileimg.available() > 0) {
                        int size = fileimg.read(bytes);
                        fileout.write(bytes, 0, size);
                    }

                }
            }
        }catch (IOException|ServletException e){

        }
    }
}
