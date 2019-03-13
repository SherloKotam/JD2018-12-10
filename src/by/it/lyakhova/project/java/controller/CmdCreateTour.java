package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.*;
import by.it.lyakhova.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCreateTour implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {
        User user = Util.findUser(request);
        if (user==null)
            return Action.LOGIN;
        if (Form.isPost(request)){
            Tour tour = new Tour();
            tour.setName(Form.getString(request, "name" , "[ A-Za-z0-9_-]{4,}"));//"[A-Za-z0-9_-]{4,}"
            tour.setTour_type_id(Form.getLong(request,"tour_type_id", "[0-9]+"));//"[0-9]+"
            tour.setPlace_id(Form.getLong(request,"place_id", "[0-9]+" ));//"[0-9]+"
            tour.setTransport_id(Form.getLong(request,"transport_id", "[0-9]+"));//"[0-9]+"
            tour.setHousing_id(Form.getLong(request,"housing_id", "[0-9]+" ));//"[0-9]+"
            tour.setPrice(Form.getInt(request,"price", "[0-9]+" ));//"[0-9]+"
            tour.setDate(Form.getString(request,"date", "[0-9]{2}.[0-9]{2}.20[0-9]{2}" ));//"[0-9]{2}.[0-9]{2}.20[0-9]{2}"
            tour.setDuration(Form.getInt(request,"duration" ));//"[0-9]{3}"
            tour.setHot(Form.getInt(request,"hot", "[0|1]"));//"[0|1]"
            tour.setDiscount(Form.getInt(request,"discount", "[0-9]+" ));//"[0-9]+"


            if (Dao.getDao().tour.create(tour)){
                Util.loadImage(request, "images/tour" + tour.getId());
                return Action.INDEX;
            }
        }
        List<TourType> types = Dao.getDao().tourType.getAll();
        request.setAttribute("tour_type", types);

        List<Place> places = Dao.getDao().place.getAll();
        request.setAttribute("place", places);

        List<Transport> transports = Dao.getDao().transport.getAll();
        request.setAttribute("transport", transports);

        List<Housing> housings = Dao.getDao().housing.getAll();
        request.setAttribute("housing", housings);

        return Action.CREATETOUR;
    }
}
