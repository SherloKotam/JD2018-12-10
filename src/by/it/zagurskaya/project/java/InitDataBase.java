package by.it.zagurskaya.project.java;

import by.it.zagurskaya.project.java.init.C_CreateChema;
import by.it.zagurskaya.project.java.init.C_Reset;
import by.it.zagurskaya.project.java.init.C_CreateTable;
import by.it.zagurskaya.project.java.init.C_InsertData;

import java.sql.Connection;
import java.sql.SQLException;

public class InitDataBase {
    public static void main(String[] args) {
        try (Connection connectionChema = ConnCreator.getConnectionChema()) {
            new C_CreateChema().reset(connectionChema);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection = ConnCreator.getConnection()) {
            new C_Reset().reset(connection);
            new C_CreateTable().readСommands(connection);
            new C_InsertData().readСommands(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
