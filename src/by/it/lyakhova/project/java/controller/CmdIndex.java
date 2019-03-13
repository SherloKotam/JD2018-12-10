package by.it.lyakhova.project.java.controller;

import by.it.lyakhova.project.java.bean.*;
import by.it.lyakhova.project.java.dao.ConnCreator;
import by.it.lyakhova.project.java.dao.Dao;
import by.it.lyakhova.project.java.dao.MyUniversalDao;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CmdIndex implements Cmd {
    @Override
    public Action execute(HttpServletRequest request) throws Exception {

        long start = 0;
        if (request.getParameter("start")!=null)
            start=Form.getLong(request, "start");

        List<TourText> tour = getAll(" LIMIT "+start+",12");
        request.setAttribute("tour", tour);

        List<Tour> tours = Dao.getDao().tour.getAll();
        request.setAttribute("tours", tours);

        List<TourType> types = Dao.getDao().tourType.getAll("INNER JOIN tours ON tour_type.id=tours.tour_type_id");
        request.setAttribute("tour_type", types);

        int tourCount = types.size();
        request.setAttribute("tourCount", tourCount);

        return Action.INDEX;
    }


    public List<TourText> getAll(String where) throws Exception {
        List<TourText> tour = new ArrayList<>();
        Class textCl = TourText.class;
        Field[] fields = textCl.getDeclaredFields();
        Method[] methods = textCl.getDeclaredMethods();
        try (Connection connection = ConnCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT tours.id, tours.name, tour_type.type, place.country, place.town," +
                    "transport.type, housing.type, tours.price, tours.date, tours.duration, tours.hot," +
                    "tours.discount FROM tours " +
                    "INNER JOIN tour_type ON tour_type.id=tours.tour_type_id " +
                    "INNER JOIN place ON place.id=tours.place_id " +
                    "INNER JOIN transport ON transport.id=tours.transport_id " +
                    "INNER JOIN housing ON housing.id=tours.housing_id" + where;


            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TourText text = new TourText();

                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    StringBuilder str = new StringBuilder();
                    String name = fields[i - 1].getName();
                    String nameF = name.substring(0,1).toUpperCase()+name.substring(1);
                    str.append("set").append(nameF);

                    if(fields[i-1].getType()==int.class||fields[i-1].getType()==Integer.class) {
                        for (int j = 0; j < methods.length; j++) {
                            if (methods[j].getName().equalsIgnoreCase(String.valueOf(str))) {
                                methods[j].invoke(text, resultSet.getInt(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()==long.class||fields[i-1].getType()==Long.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getLong(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()==String.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getString(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()==boolean.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getBoolean(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()==short.class||fields[i-1].getType()==Short.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getShort(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()==byte.class||fields[i-1].getType()==Byte.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getByte(i));
                            }
                        }
                    }
                    if(fields[i-1].getType()== Date.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase(String.valueOf(str))){
                                methods[j].invoke(text, resultSet.getDate(i));
                            }
                        }
                    }
                }
                tour.add(text);
            }
        }
        return tour;
    }
}
