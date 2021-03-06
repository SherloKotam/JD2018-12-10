package by.it.zagurskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Form {

    public static boolean isPost(HttpServletRequest req){
        return req.getMethod().
                equalsIgnoreCase("post");
        }

    public  static String getString(HttpServletRequest req, String name) throws SiteException {
        return getString(req,name,".*");
    }

    public static String getString(HttpServletRequest req, String name, String pattern) throws SiteException {
        try {
            String value = new String(req.getParameter(name).getBytes("ISO-8859-1"), StandardCharsets.UTF_8);
            if (value.matches(pattern))
                return value;
            else
                throw new SiteException("Value "+value+" incorrect");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getInt(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Integer.parseInt(value);
    }

    public static long getLong(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Long.parseLong(value);
    }

    public static double getDouble(HttpServletRequest req, String name){
        String value = req.getParameter(name);
        return Double.parseDouble(value);
    }

//    public static long[] getLongArray(HttpServletRequest req, String name){
////        String[] value = req.getParameterValues(name);
//        long[] longs = new long[req.getParameterValues(name).length];
//        for (int i = 0 ; i < req.getParameterValues(name).length; i++) {
//            longs[i] = Long.parseLong(req.getParameterValues(name)[i]);
//        }
//        return longs;
//    }
    public static long[] getLongArray(HttpServletRequest req, String name){
        String[] value = req.getParameterValues(name);
        long[] longs = new long[value.length];
        for (int i = 0 ; i < value.length; i++) {
            longs[i] = Long.parseLong(value[i]);
//            longs[i] = Long.valueOf(value[i]);
        }
        return longs;
    }
    public static double[] getDoubleArray(HttpServletRequest req, String name){
        String[] value = req.getParameterValues(name);
        double[] values = new double[value.length];
        for (int i = 0 ; i < value.length; i++) {
            values[i] = Math.round(Double.parseDouble(value[i])* 100.0) / 100.0;
        }
        return values;
    }

    public static String[] getStringArray(HttpServletRequest req, String name){
        String[] value = req.getParameterValues(name);
        return value;
    }
}
