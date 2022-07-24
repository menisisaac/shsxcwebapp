package com.shsxctf.admin.services;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ScheduleTextProcessor {
    private MultipartFile file;
    private List<String[]> events = new ArrayList<>();

    public ScheduleTextProcessor(MultipartFile file) {
        this.file = file;
    }

    public ScheduleTextProcessor() {

    }

    public void inputSchedule(JdbcTemplate template) {
        template.execute("TRUNCATE TABLE event");
        String sql ="INSERT  INTO event()";
    }

    public void formatResults(JdbcTemplate template, FileStorageService storageService) {
        String myDriver = "org.gjt.mm.mysql.Driver";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://host.docker.internal:3306/schedule?" + "user=root&password=password");
            PreparedStatement truncate = conn.prepareStatement("TRUNCATE TABLE event");
            truncate.execute();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Resource file = storageService.load("schedule.txt");
        List<String> lines = new ArrayList<>();
        try {
            File schedule = file.getFile();
            BufferedReader br = new BufferedReader(new FileReader(schedule));
            String st;
            while ((st = br.readLine()) != null)
                events.add(st.split(", "));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(String[] s : events) {
            sql(s[0], s[1], s[2], s[3]);
        }

    }

    public void sql(String name, String date, String time, String location) {

        String sql = "INSERT INTO event(name, date, time, location) VALUES (?,?,?,?)";
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            Connection conn = DriverManager.getConnection("jdbc:mysql://host.docker.internal:3306/schedule?" + "user=root&password=password");
            //Class.forName(myDriver);
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, date);
            preparedStmt.setString   (3, time);
            preparedStmt.setString(4, location);
            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        //} catch (ClassNotFoundException e) {
         //   System.out.println("af;ljfalkj");
        //    throw new RuntimeException(e);
        }
    }
    }
