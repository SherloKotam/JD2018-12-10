package by.it.skosirskiy.project.java.controller;
import by.it.skosirskiy.project.java.beans.Address;
import by.it.skosirskiy.project.java.beans.Request;
import by.it.skosirskiy.project.java.beans.Status;
import by.it.skosirskiy.project.java.beans.User;
import by.it.skosirskiy.project.java.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CmdCreateRequest implements Cmd {
    @Override
    public Action execute(HttpServletRequest req) throws SiteException, SQLException {

//        HttpSession httpSession= req.getSession(false);
//        if(httpSession==null){ return Action.LOGIN;} почему-то всегде не null
        HttpSession httpSession= req.getSession();

        if(httpSession.getAttribute("user")==null){ return Action.LOGIN;}


        if(Form.isPost(req)){
            Dao dao= Dao.getDao();

            String city = Form.getString(req, "city","[a-zA-Zа-яА-Я_-]{3,}");
            String street = Form.getString(req, "street","[a-zA-Zа-яА-Я0-9- ]{3,}");
            String house = Form.getString(req, "house","[a-zA-Zа-яА-Я0-9_-]{3,}");
            Integer flat = Form.getInt(req,"flat");
            Address address= new Address(0, city,street,house,flat);
            dao.address.create(address);
            String where=String.format(" WHERE `city`='%s' AND `street`='%s' AND `house`='%s' AND `flat`='%d'",city,street,house,flat);
            List<Address> addressForId = Dao.getDao().address.getAll(where);
            int address_id= addressForId.get(0).getId();
            String type = Form.getString(req, "type",".{3,160}"); // от 3 до 160 символов
            Timestamp date_create = Timestamp.valueOf(LocalDateTime.now());
            Timestamp date_complete = new Timestamp(0L);
            date_complete.setTime(date_create.getTime()+259200000L);  // прибавляем 3 дня
            Long user_id =Util.findUser(req).getId();
            Integer status_id = Form.getInt(req,"status_id");
            Request request= new Request(0,type,date_create,date_complete,user_id,status_id,address_id);
            if(dao.request.create(request)){
                return Action.INDEX;
            }
        }

        List<Status> statuses = Dao.getDao().status.getAll("");
        req.setAttribute("statuses",statuses);
        return Action.CREATEREQUEST;
    }
}
