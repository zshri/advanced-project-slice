package com.example.blogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;

@Entity
@Setter
@Getter
@ToString
@Builder
public class Comment extends BaseEntity {

    private String content;

    private Instant createAt;

    private Instant updateAt;

    private String author;


    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ITEM_ID", nullable = false)
    @JsonIgnore
    private Post post;


    public Comment() {


    }

    public Comment(String content, Instant createAt, Instant updateAt, String author, Post post) {
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
        this.post = post;
    }

}
