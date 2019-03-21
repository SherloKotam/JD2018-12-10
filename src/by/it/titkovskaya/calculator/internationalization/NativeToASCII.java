package by.it.titkovskaya.calculator.internationalization;

import java.io.*;

public class NativeToASCII {
    public static void main(String[] args) {
        File dir = new File(System.getProperty("user.dir")  + "/src/by/it/titkovskaya/calculator/internationalization");
        if (dir.exists() && dir.isDirectory()){
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains(".txt"))
                        process(file);
                }
            }
        } else System.out.println("Error!!!");
    }

    private static void process(File file) {
        File fileOut = new File(file.getAbsolutePath().replace(".txt", ".properties"));
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            while (reader.ready()){
                int i = reader.read();
                if (i<128)
                    writer.write(i);
                else writer.write("\\u"+String.format("%04x",i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
    }
}
