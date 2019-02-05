package com.zhzye.dao.impl;

import com.zhzye.dao.NovelDao;
import com.zhzye.entity.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NovelDaoImpl implements NovelDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String TABLE = "novels";

    public void dropTable() {
        String sql = "drop table " + TABLE;
        jdbcTemplate.execute(sql);
    }

    public void createTable() {
        String sql = "create table " + TABLE + "(id bigint(20) not null auto_increment," +
                "novel_title varchar(50) not null," +
                "novel_url varchar(256) not null," +
                "created_at datetime not null default now()," +
                "primary key(`id`))";
        jdbcTemplate.execute(sql);
    }
    
    public void createNovel(Novel novel) {
        String sql = "insert into novels(novel_title, novel_url) values(?,?)";
        jdbcTemplate.update(sql, novel.getTitle(), novel.getUrl());
    }

    public void batchCreateNovels(List<Novel> novels) {
        String sql = "insert into novels(novel_title, novel_url) values(?,?)";
        List<Object[]> insertNovels = new ArrayList<>();
        for (Novel novel : novels) {
            insertNovels.add(new Object[]{novel.getTitle(), novel.getUrl()});
        }
        jdbcTemplate.batchUpdate(sql, insertNovels);
    }

    public List<Novel> getallNovels() {
        String sql = "select * from novels";
        List<Novel> novels = jdbcTemplate.query(sql, new RowMapper<Novel>() {
            public Novel mapRow(ResultSet resultSet, int i) throws SQLException {
                Novel novel = new Novel();
                novel.setTitle(resultSet.getString("novel_title"));
                novel.setUrl(resultSet.getString("novel_url"));
                novel.setCreated_at(resultSet.getDate("created_at"));
                return novel;
            }
        });
        return novels;
    }
}
