package by.it.zagurskaya.project.java.init;

import org.apache.commons.codec.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C_InsertData {
    public void readСommands(Connection connection) throws SQLException {

        String filePath = getPath(C_InsertData.class, "cash_zagurskaya.sql");
        StringBuilder textFromFile = new StringBuilder();
        textFromFile = readTextFile(filePath, textFromFile);
        List<String> comandsInsertList = new ArrayList<>();
        comandsInsertList = readCommandsFromSqlToList(textFromFile);
        insertDataToTable(connection, comandsInsertList);
    }

        private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getResource("").toString()
                .replaceAll("/WEB-INF/.*", "/")
                .replace("file:/", "") + "sql/";

        return path + filename;
    }
//    private static String getPath(Class<?> clazz, String filename) {
//        String path = clazz.getName();
//        path = path.replace(clazz.getSimpleName(), "");
//        path = path.replace(".", File.separator);
//        path = System.getProperty("user.dir")
//                + File.separator + "src" + File.separator + path;
//        return path + filename;
//    }

    private static StringBuilder readTextFile(String path, StringBuilder textFromFile) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charsets.UTF_8))) {
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                textFromFile.append(value).append('\n');
                int i = 0;
            }
            //  System.out.println("конец файла");
        } catch (IOException e) {
            System.err.println("что-то пошло не так, т.к. " + e.getMessage());
        }
        return textFromFile;
    }

    private static List<String> readCommandsFromSqlToList(StringBuilder text) {
        return Arrays.stream(Arrays.stream(text.toString()
                .split("\n"))
                .filter(s -> s.length() != 0)
                .filter(s -> !s.startsWith("-- "))
                .collect(Collectors.joining())
                .split(";"))
                .map(s -> s + ";")
                .filter(s -> s.startsWith("INSERT"))
                .collect(Collectors.toList());
    }

    private void insertDataToTable(Connection connection, List<String> commands) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            for (String string : commands) {
                statement.executeUpdate(string);
            }
        }
    }
}
