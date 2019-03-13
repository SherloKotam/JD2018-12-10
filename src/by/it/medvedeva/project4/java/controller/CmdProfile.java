package by.it.medvedeva.project4.java.controller;

import by.it.medvedeva.project4.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException, SiteException {
        if  (!Util.checkUser(req))
            return Action.LOGIN;

        if(Form.isPost(req)){
            if(Form.getString(req, "logout")!=null){

                req.getSession().invalidate();
                return Action.LOGIN;
            }
        }

        return Action.PROFILE;
    }
}
