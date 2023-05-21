package com.example.blogservice.model.dto;


import com.example.blogservice.model.PostStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class PostResponseDto {

    private Long id;

    private String title;

    private String content;

    private PostStatus postStatus;

    private Instant createAt;

    private Instant updateAt;

    private String author;

}
