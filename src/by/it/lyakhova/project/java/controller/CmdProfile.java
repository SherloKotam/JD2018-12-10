package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.Tour;
import by.it.lyakhova.project.java.bean.TourUser;
import by.it.lyakhova.project.java.bean.User;
import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CmdProfile implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        User user = Util.findUser(request);
        if (user!=null){
            String where = String.format(" WHERE users_id='%d'", user.getId());
            List<TourUser> tourUsers = Dao.getDao().tourUser.getAll(where);
            List<Tour> tours = new ArrayList<>();

            for (TourUser tU : tourUsers) {
                tours.addAll(Dao.getDao().tour.getAll(" WHERE id=" + tU.getTours_id()));
            }


            request.setAttribute("tours", tours);
            return Action.PROFILE;
        }
        return Action.LOGIN;
    }
}
