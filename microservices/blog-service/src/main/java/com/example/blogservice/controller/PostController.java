package com.example.blogservice.controller;


import com.example.blogservice.model.Post;
import com.example.blogservice.model.dto.PostCreateDto;
import com.example.blogservice.model.dto.PostResponseDto;
import com.example.blogservice.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

// todo page size limit 10-20 how?

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    final String principal = "Principal";
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<?> getPosts(
//            Principal principal,
//            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
//            @ParameterObject Pageable pageable
//            @RequestParam(defaultValue = "id,desc") String[] sort
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAll(pageable);

        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity<?> getUserPubPosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserPub(principal.getName() , pageable);

        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<?> getUserSavePosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserSave(principal.getName() , pageable);

        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> getUserDeletePosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserDelete(principal.getName(), pageable);

        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPost(
//            Principal principal,
            @Valid @RequestBody PostCreateDto postCreateDto
    ) {
        Post savePost = postService.save(principal, postCreateDto);
        log.info("post create " + savePost.getId() );

        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(
//            Principal principal,
            @PathVariable Long id
    ) {
        return postService.getById(principal, id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePost(
            Principal principal,
            @PathVariable Long id,
            @Valid @RequestBody PostCreateDto postCreateDto
    ) {
        return postService.update(principal.getName(), id, postCreateDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(
            Principal principal,
            @PathVariable Long id
    ) {
        return postService.delete(principal.getName(), id);
    }

    @GetMapping("/{postId}/like")
    public ResponseEntity<?> likePost(
            Principal principal,
            @PathVariable Long postId
    ) {
        log.info("post like  " + postId );

        return postService.likePost(principal.getName(), postId);
    }

}
