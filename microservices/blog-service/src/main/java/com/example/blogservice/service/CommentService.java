package com.example.blogservice.service;

import com.example.blogservice.model.Comment;
import com.example.blogservice.model.Post;
import com.example.blogservice.model.PostStatus;
import com.example.blogservice.model.dto.CommentDto;
import com.example.blogservice.model.exception.NotFoundResourceEx;
import com.example.blogservice.repository.CommentRepository;
import com.example.blogservice.repository.PostRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Page<Comment> getComments(Long postId, Pageable pageable){

        Post post = postRepository.findById(postId).orElseThrow();

        Comment example = Comment.builder()
                .post(post).build();

        return commentRepository.findAll(Example.of(example) , pageable)
                .map(this::convertToResponse);
    }

    private Comment convertToResponse(Comment comment) {
//        comment.setPost(null);
        return comment;
    }

    public Comment addComment(String principal, CommentDto commentDto) {
        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(() -> new NotFoundResourceEx("not found"));
       if (post.getPostStatus().equals(PostStatus.PUBLISH)){
           Comment comment = Comment.builder()
                   .content(commentDto.getContent())
                   .createAt(Instant.now())
                   .author(principal)
                   .post(post)
                   .build();
           Comment save = commentRepository.save(comment);
           save.setPost(null);
           return save;
       }
       return null;
    }
}


