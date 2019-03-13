package by.it.skosirskiy.project.java.controller;


import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import java.sql.Timestamp;
import java.util.List;

public class CmdEditRequests implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {
        Dao dao = Dao.getDao();

        if (Form.isPost(req)) {
            long id = Form.getLong(req, "id");
            String type = Form.getString(req, "type");
            Timestamp date_complete = new Timestamp(0L);
            long user_id = Form.getLong(req, "user_id");
            int status_id=Form.getInt(req,"status_id");
            int address_id=Form.getInt(req,"address_id");
            Request request = new Request(id, type, date_complete, date_complete, user_id, status_id,address_id);
            Request currentRequest = Util.findRequest(req);
            if (req.getParameter("update") != null) {
                dao.request.update(request);
                if (currentRequest != null && currentRequest.getId() == request.getId()) {
                    req.getSession().setAttribute("request", request);
                }
            } else if (req.getParameter("delete") != null) {
                dao.request.delete(request);
                if (currentRequest != null && currentRequest.getId() == request.getId())
                    return Action.LOGOUT;
            }
        }

        List<Request> requests = Dao.getDao().request.getAll("");
        System.out.println(requests.size());
        req.setAttribute("requests", requests);
        return Action.EDITREQUESTS;
    }
}
