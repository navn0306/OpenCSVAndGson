package com.bridge.csv;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndJson {

    public static void main(String[] args) {
        String jsonFile = "C:\\Users\\Navneet\\Documents\\OOPs\\OpenCSVAndGson\\src\\main\\resources\\User.json";
        String csvFile = "C:\\Users\\Navneet\\Documents\\OOPs\\OpenCSVAndGson\\src\\main\\resources\\User.csv";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFile));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
            List<CSVUser> csvUsers = csvToBean.parse();
            System.out.println(csvUsers);
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            System.out.println(json);
            FileWriter writer = new FileWriter(jsonFile);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(jsonFile));
            CSVUser[] csvUser = gson.fromJson(br, CSVUser[].class);
            System.out.println(Arrays.asList(csvUser));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
