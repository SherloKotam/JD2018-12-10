package by.it.zagurskaya.project.java.controller;

import by.it.zagurskaya.project.java.controller.cash.*;
import by.it.zagurskaya.project.java.controller.cash.cmdcurrency.CmdAllCurrency;
import by.it.zagurskaya.project.java.controller.cash.cmdcurrency.CmdRateCB;
import by.it.zagurskaya.project.java.controller.cash.cmdcurrency.CmdRateNB;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.CmdBalance;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.CmdPayment;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.CmdUseroperations;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdcheck.*;
import by.it.zagurskaya.project.java.controller.cash.cmdoperation.cmdpayment.*;
import by.it.zagurskaya.project.java.controller.cash.cmdreport.*;

import javax.servlet.http.HttpServletRequest;

public enum Action {

    INDEX(new CmdIndex()),
    ERROR(new CmdError()),
    RESETDB(new CmdResetDB()),
    LOGIN(new CmdLogin()),
    EDITUSERS(new CmdEditUsers()),
    LOGOUT(new CmdLogout()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),

    //    CASH
    MAIN(new CmdMain()),
    DUTIES(new CmdDuties()),
    CURRENCY(new CmdCurrency()),
    OPERATION(new CmdOperation()),
    REPORT(new CmdReport()),
    EXIT(new CmdExit()),


    //    CASH / CMDCURRENCY
    ALLCURRENCY(new CmdAllCurrency()),
    RATECB(new CmdRateCB()),
    RATENB(new CmdRateNB()),

    //    CASH / CMDOPERATION
    PAYMENT(new CmdPayment()),
    BALANCE(new CmdBalance()),
    USEROPERATIONS(new CmdUseroperations()),

//   CASH / CMDOPERATION/CMDPAYMENT
    SELECTPAYMENT(new CmdSelectPayment()),
    PAYMENT10_01(new CmdPayment10_01()),
    PAYMENT10_02(new CmdPayment10_02()),
    PAYMENT20_01(new CmdPayment20_01()),
    PAYMENT20_02(new CmdPayment20_02()),
    PAYMENT998(new CmdPayment998()),
    PAYMENT1000(new CmdPayment1000()),
    PAYMENT1100(new CmdPayment1100()),
    PAYMENT1100BALANCE(new CmdPayment1100Balance()),

//   CASH / CMDOPERATION/CMDCHECK
    CHECK10(new CmdCheck10()),
    CHECK20(new CmdCheck20()),
    CHECK998(new CmdCheck998()),
    CHECK1000(new CmdCheck1000()),
    CHECK1100(new CmdCheck1100()),



    //    CASH / CMDREPORT
    SPRREPORTS(new CmdSprReports()),
    REPORT1(new CmdReport1()),
    REPORT2(new CmdReport2()),
    REPORT3(new CmdReport3()),
    ENTRIES(new CmdEntries());

    Cmd command;
    String PATH = "";

    Action(String PATH) {
        this.PATH = PATH;
    }

    public String getPATH() {
        return PATH;
    }

    public void setPATH(String PATH) {
        this.PATH = PATH;
    }

    Action(Cmd command) {
        this.command = command;
    }

    String getJsp() {
        return PATH + name().toLowerCase() + ".jsp";
    }

    static Action define(HttpServletRequest req) {
        try {
            String command = req.getParameter("command").toUpperCase();
            return Action.valueOf(command);
        } catch (Exception e) {
            return Action.INDEX;
        }
    }


}
