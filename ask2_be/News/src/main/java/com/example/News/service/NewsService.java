package com.example.News.service;

import com.example.News.dto.NewsDTO;
import com.example.News.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public List<NewsDTO> getAllNews(){
        return newsRepository.getAllNews();
    }

    public Boolean makeNews(
            Integer member_index,
            String title,
            String content,
            String category,
            String tags
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("member_index", member_index);
        params.put("title", title);
        params.put("content", content);
        params.put("category", category);
        params.put("tags", tags);

        return newsRepository.makeNews(params) > 0 ? true : false;
    }

    public Boolean deleteNews(Integer news_index){

        Map<String, Object> params = new HashMap<>();
        params.put("news_index", news_index);

        return newsRepository.deleteNews(params) > 0 ? true : false;
    }

    public Boolean updateNews(
            Integer news_index,
            String title,
            String content,
            String category,
            String tags
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("news_index", news_index);
        params.put("title", title);
        params.put("content", content);
        params.put("category", category);
        params.put("tags", tags);

        return newsRepository.updateNews(params) > 0 ? true : false;
    }
}
