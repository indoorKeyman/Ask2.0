package com.example.News.controller;

import com.example.News.dto.NewsDTO;
import com.example.News.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<NewsDTO>> getAllNews () {

        log.info("Request getAllNews received");

        List result = newsService.getAllNews();

        if (!result.isEmpty()){
            log.info("Response getAllNews sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_news")
    public ResponseEntity<String> makeNews (
            @RequestBody NewsDTO request
    ) {

        log.info("Request makeNews received");

        Boolean result = newsService.makeNews(
                request.getMember_index(),
                request.getTitle(),
                request.getContent(),
                request.getCategory(),
                request.getCategory()
        );

        if (result){
            log.info("Response makeNews sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful makeNews" : "Failed makeNews" );
    }

    @DeleteMapping("/delete_news")
    public ResponseEntity<String> deleteNews (
            @RequestParam Integer news_index
    ) {

        log.info("Request deleteNews received");

        Boolean result = newsService.deleteNews(news_index);

        if (result){
            log.info("Response deleteNews sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful deleteNews" : "Failed deleteNews" );
    }

    @PatchMapping("/update_news")
    public ResponseEntity<String> updateNews(
            @RequestParam Integer news_index,
            @RequestBody NewsDTO request
    ) {

        log.info("Request updateNews received");

        Boolean result = newsService.updateNews(
                news_index,
                request.getTitle(),
                request.getContent(),
                request.getCategory(),
                request.getTags()
        );

        if (result) {
            log.info("Response updateNews sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful updateNews" : "Failed updateNews");
    }
}
