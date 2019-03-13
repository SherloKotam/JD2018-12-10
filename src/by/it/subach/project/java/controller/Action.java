package by.it.subach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    SIGNUP(new CmdSignup()),
    CATALOG(new CmdCatalog()),
    PRODUCTSLIST(new CmdProductsList()),
    RESETDB(new CmdResetDB()),
    ORDER(new CmdOrder()),
    CART(new CmdCart()),
    CHECKOUT(new CmdCheckout()),
    CREATECATEGORY(new CmdCreateCategory()),
    CREATEPRODUCT(new CmdCreateProduct()),
    EDITPRODUCTS(new CmdEditProducts()),
    PROFILE(new CmdProfile()),
    EDITUSERS(new CmdEditUsers()),
    LOGOUT(new CmdLogout()),
    CREATEUSER(new CmdCreateUser()),
    ADMIN(new CmdAdmin()),
    VIEWUSERS(new CmdViewUsers()),
    LOGIN(new CmdLogin());

    Action(Cmd command) {
        this.command = command;
    }

    Cmd command;

    String getJsp() {
        return "/" + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {

        String command = req.getParameter("command").toUpperCase();
        try {
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.ERROR;
        }

    }


}
