package com.rufu.springboot.jpa_and_hibernate.course.jdbc;

import com.rufu.springboot.jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
    """
        insert into course (id, name, author) 
        values (?, ?, ?);
  
    """;

    private static String DELETE_QUERY =
    """
        delete from course where id = ?
    """;


    private static String SELECT_QUERY =
            """
                SELECT * FROM course WHERE id = ?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(int id) {
//        ResultSet -> Bean -> Row Mapper ==>

        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}
