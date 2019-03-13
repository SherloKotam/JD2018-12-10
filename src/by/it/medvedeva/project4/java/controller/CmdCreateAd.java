package by.it.medvedeva.project4.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

class CmdCreateAd implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SQLException {
        if (Form.isPost(req)){


        }

        return null;
    }
}
