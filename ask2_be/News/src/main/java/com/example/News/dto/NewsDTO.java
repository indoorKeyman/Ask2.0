package com.example.News.dto;

import lombok.*;
import java.sql.*;

@Setter
@Getter
public class NewsDTO {

    private int news_index;

    private int member_index;

    private String title;

    private String content;

    private String category;

    private String tags;

    private Timestamp created_date;

    private Timestamp updated_date;

}
