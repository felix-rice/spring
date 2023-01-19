package com.felix.spring.base.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.felix.spring.base.entity.Account;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-14
 */
@Component
public class AccountDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final BeanPropertyRowMapper<Account> rowMapper = new BeanPropertyRowMapper<>(Account.class);
    private static final String TABLE = "account";
    public AccountDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public void insert(Account account) {
        String sql = "insert into " + TABLE + " (user_id, balance) values(:userId, :balance)";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("userId", account.getUserId())
                .addValue("balance", account.getBalance());
        namedParameterJdbcTemplate.update(sql, param);
    }
    public void update(Account account) {
        String sql = "update " + TABLE + " set user_id = :userId, balance = :balance where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", account.getId())
                .addValue("userId", account.getUserId())
                .addValue("balance", account.getBalance());
        namedParameterJdbcTemplate.update(sql, param);
    }

    public Account select(long id) {
        String sql = "select * from " + TABLE + " where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, param, rowMapper);
    }
}
