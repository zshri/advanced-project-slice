package com.example.blogservice.model.dto;

import com.example.blogservice.model.PostStatus;
import com.example.blogservice.util.EnumNamePattern;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
* @author zshri
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class PostCreateDto {

    @NotEmpty(message = "Post title empty")
    @Size(min = 2, message = "Post title should have min. 2 characters")
    private String title;

    @NotEmpty(message = "Post content empty")
    private String content;

//    @EnumNamePattern(regexp = "SAVE|PUBLISH|DELETE") //todo валидация довести до ума!
//    @CustomerTypeSubset(anyOf = {PostStatus.SAVE, PostStatus.PUBLISH, PostStatus.DELETE})
    private PostStatus postStatus;


}
