package by.it.migunko.project.java.controller;

import by.it.migunko.project.java.beans.Tours;
import by.it.migunko.project.java.beans.User;
import by.it.migunko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

class CmdCreateTour implements Cmd {
    @Override
   public Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null){
            return Action.LOGIN;
        }
        User user = (User) oUser;

        if (Util.isPost(req)){
            String description = Util.getString(req, "description");
            String typeOfTravel = Util.getString(req, "typeOfTravel");
            String destination = Util.getString(req, "destination");
            String hotel = Util.getString(req, "hotel");
            int countOfNights = Util.getInteger(req, "countOfNights");
            double price = Util.getDouble(req, "price");
            Tours tours = new Tours(0,
                    description,
                    typeOfTravel,
                    destination,
                    hotel,
                    countOfNights,
                    price,
                    user.getId());
            Dao.getDao().tours.create(tours);
            return Action.PROFILE;
        }
        return null;
    }
}
