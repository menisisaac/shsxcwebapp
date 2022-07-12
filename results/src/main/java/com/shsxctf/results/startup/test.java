package com.shsxctf.results.startup;

import com.shsxctf.results.models.Data_Processor;
import com.shsxctf.results.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class test implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        JdbcTemplate template = new JdbcTemplate();
        //Data_Processor dp = new Data_Processor("daf");
        //dp.sendToDataBase(jdbcTemplate);
    }
}
