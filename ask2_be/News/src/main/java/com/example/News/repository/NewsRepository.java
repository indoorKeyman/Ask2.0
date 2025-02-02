package com.example.News.repository;


import com.example.News.dto.NewsDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class NewsRepository {
    private final SqlSessionTemplate sql;

    public List<NewsDTO> getAllNews(){
        return sql.selectList("News.getAllNews");
    }

    public Integer makeNews(Map<String, Object> params){
        return sql.insert("News.makeNews", params);
    }

    public Integer deleteNews(Map<String, Object> params){
        return sql.delete("News.deleteNews", params);
    }

    public Integer updateNews(Map<String, Object> params){
        return sql.update("News.updateNews", params);
    }



}
