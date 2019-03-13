package by.it.lyakhova.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {

    static boolean isPost(HttpServletRequest req){
        return req.getMethod()
                .equalsIgnoreCase("post");
    }

    static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        String value = req.getParameter(name);
        if (value.matches(pattern)){
            return value;
        }
        else{
            throw new SiteException("Value " + value + " incorrect");
        }
    }

    static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req,name,".*");
    }


    static int getInt (HttpServletRequest request, String name, String pattern) throws SiteException {
        String value = request.getParameter(name);
        if (value.matches(pattern)) {
            return Integer.parseInt(value);
        }else {
            throw new SiteException("Value " + value + " incorrect");
        }
    }

    static int getInt(HttpServletRequest req, String name) throws SiteException {
        return getInt(req,name,".*");
    }

    static double getDouble(HttpServletRequest request, String name, String pattern) throws SiteException {
        String value = request.getParameter(name);
        if (value.matches(pattern)) {
            return Double.parseDouble(value);
        }else {
            throw new SiteException("Value " + value + " incorrect");
        }
    }

    static long getLong(HttpServletRequest request, String name, String pattern) throws SiteException {
        String value = request.getParameter(name);
        if (value.matches(pattern)){
            return Long.parseLong(value);
        }else{
            throw new SiteException("Value " + value + " incorrect");
        }
    }

    static long getLong(HttpServletRequest req, String name) throws SiteException {
        return getLong(req,name,".*");
    }
}
