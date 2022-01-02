package com.bridge.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteCSV {

    public static void main(String[] args) {
        String path = "C:\\Users\\Navneet\\Documents\\OOPs\\OpenCSVAndGson\\src\\main\\resources\\Demo.csv";

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(path));
            StatefulBeanToCsv<CSVUser> beanToCSV = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<CSVUser> users = new ArrayList<>();
            users.add(new CSVUser("Rahul", "abc@gmail.com", 737464232, "India"));
            users.add(new CSVUser("Ajay", "ajay@gmail.com", 823723438, "India"));
            users.add(new CSVUser("Manoj", "manoj@gmail.com", 903463742, "India"));
            beanToCSV.write(users);
            writer.close();
        } catch (IOException e) {

        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
