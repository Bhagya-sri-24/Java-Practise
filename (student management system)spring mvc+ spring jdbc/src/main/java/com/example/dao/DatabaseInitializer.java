package com.example.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements InitializingBean {
    private final JdbcTemplate jdbc;

    public DatabaseInitializer(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @Override
    public void afterPropertiesSet() {
        jdbc.execute("CREATE TABLE IF NOT EXISTS students (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "email VARCHAR(150) NOT NULL," +
                "course VARCHAR(100) NOT NULL," +
                "enrolled_date DATE)");
        // seed (only if empty)
        Integer count = jdbc.queryForObject("SELECT COUNT(*) FROM students", Integer.class);
        if (count != null && count == 0) {
            jdbc.update("INSERT INTO students(name,email,course,enrolled_date) VALUES (?,?,?,CURRENT_DATE())",
                    "Bhagya","bhagya@example.com","Spring Basics");
            jdbc.update("INSERT INTO students(name,email,course,enrolled_date) VALUES (?,?,?,CURRENT_DATE())",
                    "Sri","sri@example.com","JDBC Fundamentals");
        }
    }
}
