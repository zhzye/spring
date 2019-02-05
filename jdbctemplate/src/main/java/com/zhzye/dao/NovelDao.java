package com.zhzye.dao;

import com.zhzye.entity.Novel;

import java.util.List;

public interface NovelDao {
    void createTable();
    void dropTable();
    void createNovel(Novel novel);
    void batchCreateNovels(List<Novel> novels);
    List<Novel> getallNovels();
}
