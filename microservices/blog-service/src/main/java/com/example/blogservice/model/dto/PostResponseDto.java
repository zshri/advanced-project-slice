package com.example.blogservice.model.dto;


import com.example.blogservice.model.PostStatus;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class PostResponseDto {

    private Long id;

    private String title;

    private String content;

    private PostStatus postStatus;

    private Set<String> likes;

    private Integer countComments;

    private Instant createAt;

    private Instant updateAt;

    private String author;

}
