package com.example.blogservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.Instant;
import java.util.*;


@Entity
@Getter
@Setter
@ToString
@Table(
        name = "POST",
//        schema="SCHOOL",
        indexes = {
                @Index(
                        name = "IDX_TITLE",
                        columnList = "title"
                ),
                @Index(
                        name = "IDX_AUTHOR_title",
                        columnList = "author, title"
                )
        })
public class Post extends BaseEntity {

    //    @Length(max = 55, message = "Title too long (more than 55)")
//    @NotNull
//    @Column(nullable = false, length = 5)
    private String title;

    //    @NotBlank(message = "Please fill the message")
//    @Length(max = 2048, message = "Text  too long (more than 2kB)")
//    @Size(
//            min = 2,
//            max = 255,
//            message = "N"
//    )
//    @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
    private String content;


//    @ElementCollection
//    @CollectionTable(name = "COMMENTS1")
//    @OrderColumn
//    @Column(name = "comment")
//    private List<String> comments1 = new ArrayList<String>();

//    @ElementCollection
//    @CollectionTable(name = "COMMENTS2")
////    @MapKeyColumn(name = "comment")
//    private Map<String, Comment2 > comments2 = new HashMap<String, Comment2>();

//    @Type(type = "custom_collection_type")
//    private List<String> topics = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "likes")
    @Column(name = "user_id")
    private Set<String> likes = new HashSet<String>();


    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    private Instant createAt;

    private Instant updateAt;

    private String author;


    @OneToMany(mappedBy = "post",
            fetch = FetchType.LAZY, // Значение по умолчанию
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
//          , orphanRemoval = true) // Включает CascadeType.REMOVE
    )
    @JsonIgnore
    protected List<Comment> commentList = new ArrayList<Comment>();


    public Post() {
    }


    public Post(String title, String content, Set<String> likes, PostStatus postStatus, Instant createAt, Instant updateAt, String author) {
        this.title = title;
        this.content = content;

        this.likes = likes;
        this.postStatus = postStatus;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
    }

    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public void switchLike(String principal) {

        if (this.likes.contains(principal)) {
            this.likes.remove(principal);
        } else {
            this.likes.add(principal);
        }

    }

    public static class PostBuilder {
        private String title;
        private String content;
        private Set<String> likes;
        private PostStatus postStatus;
        private Instant createAt;
        private Instant updateAt;
        private String author;

        PostBuilder() {
        }

        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }


        public PostBuilder likes(Set<String> likes) {
            this.likes = likes;
            return this;
        }

        public PostBuilder postStatus(PostStatus postStatus) {
            this.postStatus = postStatus;
            return this;
        }

        public PostBuilder createAt(Instant createAt) {
            this.createAt = createAt;
            return this;
        }

        public PostBuilder updateAt(Instant updateAt) {
            this.updateAt = updateAt;
            return this;
        }

        public PostBuilder author(String author) {
            this.author = author;
            return this;
        }

        public Post build() {
            return new Post(this.title, this.content, this.likes, this.postStatus, this.createAt, this.updateAt, this.author);
        }

        public String toString() {
            return "Post.PostBuilder(title=" + this.title + ", content=" + this.content + ", likes=" + this.likes + ", postStatus=" + this.postStatus + ", createAt=" + this.createAt + ", updateAt=" + this.updateAt + ", author=" + this.author + ")";
        }
    }
}
