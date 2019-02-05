package com.zhzye;

import com.zhzye.dao.NovelDao;
import com.zhzye.entity.Novel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class NovelDaoTest {
    @Autowired
    private NovelDao novelDao;

    @Test
    public void createTable() {
        novelDao.createTable();
    }

    @Test
    public void dropTable() {
        novelDao.dropTable();
    }

    @Test
    public void createNovel() {
        Novel novel = new Novel();
        novel.setTitle("a");
        novel.setUrl("http://a");
        novelDao.createNovel(novel);
    }

    @Test
    public void batchCreateNovels() {
        List<Novel> novels = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int novelId = (int) (Math.random() * 1000000);
            Novel novel = new Novel();
            novel.setTitle("novel_" + novelId);
            novel.setUrl("http://www.baidu.com/" + novelId);
            novels.add(novel);
        }
        novelDao.batchCreateNovels(novels);
    }

    @Test
    public void getAllNovels() {
        List<Novel> novels = novelDao.getallNovels();
        System.out.println(novels);
    }
}
