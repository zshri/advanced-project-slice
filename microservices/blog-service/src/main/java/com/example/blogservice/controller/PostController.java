package com.example.blogservice.controller;


import com.example.blogservice.model.Post;
import com.example.blogservice.model.dto.PostCreateDto;
import com.example.blogservice.model.dto.PostResponseDto;
import com.example.blogservice.service.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    private final Log log = LogFactory.getLog(getClass());
//    final String principal = "Principal";

    @GetMapping
    public ResponseEntity<?> getPosts(
            Principal principal,
//            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
//            @RequestParam(defaultValue = "id,desc") String[] sort
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAll(pageable);
        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/publish")
    public ResponseEntity<?> getUserPubPosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserPub(principal.getName() , pageable);
        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/save")
    public ResponseEntity<?> getUserSavePosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserSave(principal.getName() , pageable);
        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> getUserDeletePosts(
            Principal principal,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        Page<PostResponseDto> postResponseDtoPage = postService.getAllUserDelete(principal.getName(), pageable);
        return new ResponseEntity<>(postResponseDtoPage, HttpStatus.OK);
    }


//    @DeleteMapping
//    public ResponseEntity<?> clearUserDelPosts(
////            Principal principal,
//    ) {
//        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
//    }





    @PostMapping
    public ResponseEntity<?> createPost(
            Principal principal,
            @RequestBody PostCreateDto postCreateDto
//            @Valid @RequestBody PostCreateDto postCreateDto
    ) {
        Post savePost = postService.save(principal.getName(), postCreateDto);
        log.info("post create " + savePost.getId() );
        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(
            Principal principal,
            @PathVariable Long id
    ) {
        return postService.getById(principal.getName(), id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }



    @PutMapping("/{id}")
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


//    @GetMapping("/{id}/like")
//    public ResponseEntity<?> likePost(@PathVariable Long id) {
//
//        String string = "like " + id;
//    return new ResponseEntity<>(string, HttpStatus.OK) ;
//}
//postService.findByPostId(postId)
//            .map(ResponseEntity::ok)
//            .orElseGet(() -> ResponseEntity.notFound().build());

}
