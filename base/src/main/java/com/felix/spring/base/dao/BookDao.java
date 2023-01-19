package com.felix.spring.base.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.felix.spring.base.entity.Book;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-13
 */
@Component
public class BookDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void insert(Book book) {
        String sql = "insert into book(name, price) values (?, ?)";
        Object[] args = {book.getName(), book.getPrice()};
        jdbcTemplate.update(sql, args);
    }

    public void update(Book book) {
        String sql = "update book as b "
                + "set b.name = :name, b.price = :price "
                + "where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", book.getId())
                .addValue("name", book.getName())
                .addValue("price", book.getPrice());
        namedParameterJdbcTemplate.update(sql, param);
    }

    public Book select(Long id) {
        String sql = "select * from book where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, param, Book.class);
    }

    public List<Book> selectAll() {
        String sql = "select * from book";
        MapSqlParameterSource param = new MapSqlParameterSource();
        return namedParameterJdbcTemplate.queryForList(sql, param, Book.class);
    }

    public void delete(Long id) {
        String sql = "delete from book where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);
        namedParameterJdbcTemplate.update(sql, param);
    }
}
