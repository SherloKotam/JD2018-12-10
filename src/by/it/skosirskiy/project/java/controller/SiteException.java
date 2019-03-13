package by.it.skosirskiy.project.java.controller;

public class SiteException extends Exception {
    public SiteException() {
    }

    public SiteException(String message) {
        System.out.println(message);
    }

    public SiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteException(Throwable cause) {
        super(cause);
    }
}
