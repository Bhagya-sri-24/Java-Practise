package com.example.dao;

import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbc;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static final RowMapper<Student> ROW_MAPPER = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setEmail(rs.getString("email"));
            s.setCourse(rs.getString("course"));
            Date d = rs.getDate("enrolled_date");
            s.setEnrolledDate(d != null ? d.toLocalDate() : null);
            return s;
        }
    };

    @Override
    public List<Student> findAll() {
        return jdbc.query("SELECT * FROM students ORDER BY id", ROW_MAPPER);
    }

    @Override
    public Optional<Student> findById(int id) {
        List<Student> result = jdbc.query("SELECT * FROM students WHERE id = ?", ROW_MAPPER, id);
        return result.stream().findFirst();
    }

    @Override
    public int save(Student s) {
        return jdbc.update("INSERT INTO students(name, email, course, enrolled_date) VALUES (?, ?, ?, ?)",
                s.getName(), s.getEmail(), s.getCourse(),
                s.getEnrolledDate() != null ? Date.valueOf(s.getEnrolledDate()) : null);
    }

    @Override
    public int update(Student s) {
        return jdbc.update("UPDATE students SET name=?, email=?, course=?, enrolled_date=? WHERE id=?",
                s.getName(), s.getEmail(), s.getCourse(),
                s.getEnrolledDate() != null ? Date.valueOf(s.getEnrolledDate()) : null,
                s.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbc.update("DELETE FROM students WHERE id=?", id);
    }
}
