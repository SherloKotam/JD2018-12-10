package by.it.zagurskaya.project.java.controller.cash.cmdreport;

import by.it.zagurskaya.project.java.beans.UserOperation;


public class Report1  {
    private UserOperation userOperation;
    private double sum933;

    public Report1() {
    }

    public Report1(UserOperation userOperation, double sum933) {
        this.userOperation = userOperation;
        this.sum933 = sum933;
    }

    public UserOperation getUserOperation() {
        return userOperation;
    }

    public void setUserOperation(UserOperation userOperation) {
        this.userOperation = userOperation;
    }

    public double getSum933() {
        return sum933;
    }

    public void setSum933(double sum933) {
        this.sum933 = sum933;
    }

    @Override
    public String toString() {
        return "Report1{" +
                "userOperation=" + userOperation +
                ", sum933=" + sum933 +
                '}';
    }
}
