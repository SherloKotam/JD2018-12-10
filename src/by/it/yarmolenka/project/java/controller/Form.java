package by.it.yarmolenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class Form {


    public static String getString(HttpServletRequest req, String field) throws ProjectException {
        return getString(req, field, ".*");
    }

    public static String getString(HttpServletRequest req, String field, String pattern) throws ProjectException {
        String result = req.getParameter(field);
        if (result == null) return null;
        if (result.matches(pattern)) return result;
        else throw new ProjectException(field + result + " incorrect");
    }

    public static double getDouble(HttpServletRequest req, String parameter) {
        String result = req.getParameter(parameter);
        if (result.trim().matches(Patterns.DOUBLE)) {
            return Double.parseDouble(result);
        } else req.setAttribute("wrong_input", "Use numbers, \',\' and \'.\'");
        return -1;
    }

    public static long getLong(HttpServletRequest req, String parameter) {
        String param = req.getParameter(parameter);
        if (param.trim().matches(Patterns.LONG))
        return Long.parseLong(param);
        else return -1;
    }
}
