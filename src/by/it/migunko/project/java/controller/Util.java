package by.it.migunko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class Util {

    private static final String POST = "post";
    private static final String STRING = "[\\+A-za-z0-9\\s]+";
    private static final String EMAIL = "[0-9A-Za-z]{0,20}@[0-9A-Za-z]{0,10}\\.[a-z]{2,4}";
    private static final String INTEGER = "-?[0-9]+";
    private static final String DOUBLE = "-?[0-9]+\\.?([0-9]*)";
    private static final String LONG = "-?[0-9]+";

    private static String getString(HttpServletRequest req, String field, String pattern){
        String value = req.getParameter(field);
        if (value.matches(pattern)){
            return value;
        } else {
            req.setAttribute("help_"+field, field+" incorrect");
            return null;
        }
    }

    static String getEmail(HttpServletRequest req, String field){
        return getString(req, field, EMAIL);
    }

    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase(POST);
    }

    static String getString(HttpServletRequest req, String field) {
        return getString(req, field, STRING);
    }

    static Integer getInteger(HttpServletRequest req, String field) {
        String value = getString(req, field, INTEGER);
        return value == null ? null : Integer.valueOf(value);
    }

    static Double getDouble(HttpServletRequest req, String field) {
        String value = getString(req, field, DOUBLE);
        return value == null ? null : Double.valueOf(value);
    }

    static Long getLong(HttpServletRequest req, String field) {
        String value = getString(req, field, LONG);
        return value == null ? null : Long.valueOf(value);
    }
}
