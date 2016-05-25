package com.hqf.tutorials.springboot.dao;

import com.hqf.tutorials.springboot.models.Demo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 使用JdbcTemplate操作数据库.
 * Created by huoquanfu on 2016/5/25.
 */
@Repository
public class DemoDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过id获取demo对象.
     *
     * @param id
     * @return
     */
    public Demo getById(long id) {
        String sql = "select *from Demo where id=?";
        RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
