package com.example.blogservice.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString
@Builder
public class Post extends BaseEntity {

//    @Length(max = 55, message = "Title too long (more than 55)")
    private String title;

//    @NotBlank(message = "Please fill the message")
//    @Length(max = 2048, message = "Text  too long (more than 2kB)")
    private String content;

    private PostStatus postStatus;

    private Instant createAt;

    private Instant updateAt;

    private String author;

    public Post() {}
    public Post(String title, String content, PostStatus postStatus, Instant createAt, Instant updateAt, String author) {
        this.title = title;
        this.content = content;
        this.postStatus = postStatus;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
    }
}
