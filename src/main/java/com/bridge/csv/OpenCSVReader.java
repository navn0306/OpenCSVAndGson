package com.bridge.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {

    public static void main(String[] args) throws IOException, CsvException {

        String csvPath = "C:\\Users\\Navneet\\Documents\\OOPs\\OpenCSVAndGson\\src\\main\\resources\\User.csv";
        Reader reader = Files.newBufferedReader(Paths.get(csvPath));
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
        List<CSVUser> csvUsers = csvToBean.parse();

        System.out.println(csvUsers);
    }
}
