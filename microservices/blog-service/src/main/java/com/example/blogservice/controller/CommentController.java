package com.example.blogservice.controller;

import com.example.blogservice.model.Comment;
import com.example.blogservice.model.dto.CommentDto;
import com.example.blogservice.model.dto.PostResponseDto;
import com.example.blogservice.service.CommentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final Log log = LogFactory.getLog(getClass());

    final String principal = "Principal";

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


//    todo Validate id
    @GetMapping("/{postId}")
    public ResponseEntity<?> getComments(
//            Principal principal,
            @PathVariable Long postId,
            @RequestParam(defaultValue = "0") int page
    ){
        Pageable pageable = PageRequest.of(page, 10, Sort.by("createAt").descending());
        Page<Comment> commentPage = commentService.getComments(postId, pageable);

        return new ResponseEntity<>(commentPage, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addComment(
//            Principal principal,
           @RequestBody CommentDto commentDto
    ){
        Comment comment = commentService.addComment(principal, commentDto);

        return ResponseEntity.ok(comment);
    }


}
