package com.example.blogservice.service;

import com.example.blogservice.model.Post;
import com.example.blogservice.model.PostStatus;
import com.example.blogservice.model.dto.PostCreateDto;
import com.example.blogservice.model.dto.PostResponseDto;
import com.example.blogservice.model.exception.NotFoundResourceEx;
import com.example.blogservice.repository.PostRepository;
import com.sun.jdi.event.ExceptionEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
public class PostService {

    @Autowired
    PostRepository postRepository;


    public ResponseEntity<?> getById(String principal , Long id) throws NotFoundResourceEx {

        // todo протестировать
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundResourceEx("not found")); // todo откуда он берет ошибку?

        String principal2 = "principal2"; //todo del str

        switch (post.getPostStatus()) {
            case PUBLISH -> {
                return new ResponseEntity<>(post, HttpStatus.OK);
            }
            case SAVE, DELETE -> {
                if (post.getAuthor().equals(principal2)) {
                    return new ResponseEntity<>(post, HttpStatus.OK);
                } else new ResponseEntity<>(HttpStatus.LOCKED);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // todo ??
    }

    public Post save(String principal ,PostCreateDto postCreateDto){

        Post post = Post.builder()
                .title(postCreateDto.getTitle())
                .content(postCreateDto.getContent())
                .postStatus(postCreateDto.getPostStatus())
                .createAt(Instant.now())
                .author(principal)
                .build();



        return postRepository.save(post);
    }

    public ResponseEntity<?> update(String principal, Long id, PostCreateDto postCreateDto){

        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundResourceEx("not found"));

        String principal2 = "principal2"; // todo del

        if (post.getAuthor().equals(principal)) {
            post.setTitle(postCreateDto.getTitle());
            post.setContent(postCreateDto.getContent());
            post.setPostStatus(postCreateDto.getPostStatus());
            post.setUpdateAt(Instant.now());

            return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.LOCKED);
    }

    public ResponseEntity<?> delete(String principal, Long id){
//        log.debug("Deleting review for productId: {}", productId);
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundResourceEx("not found"));

        if (post.getAuthor().equals(principal)) {
            postRepository.deleteById(id);
            return new ResponseEntity<>(post, HttpStatus.OK) ;
        } return new ResponseEntity<>(HttpStatus.LOCKED);
    }




    public PostResponseDto convertToPostResponseDto(final Post post){

        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
//                .content(post.getContent().substring(0, 2)) // if (post.getContent()
                .content(post.getContent())
                .postStatus(post.getPostStatus())
                .createAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .author(post.getAuthor()).build();
    }




//    todo Refactor methods

    public Page<PostResponseDto> getAll(Pageable pageable){

        Post example = Post.builder()
                .postStatus(PostStatus.PUBLISH)
                .build();

        Page<Post> postPage = postRepository.findAll(Example.of(example) , pageable);

        final Page<PostResponseDto> postResponseDtoPage = postPage.map(this::convertToPostResponseDto);

        return postResponseDtoPage ;
    }


    public Page<PostResponseDto> getAllUserPub(String principal, Pageable pageable) {

        Post example = Post.builder()
                .postStatus(PostStatus.PUBLISH)
                .author(principal)
                .build();

        Page<Post> postPage = postRepository.findAll(Example.of(example), pageable);

        Page<PostResponseDto> postResponseDtoPage = postPage.map(this::convertToPostResponseDto);

        return postResponseDtoPage;
    }

    public Page<PostResponseDto> getAllUserSave(String principal, Pageable pageable) {

        Post example = Post.builder()
                .postStatus(PostStatus.SAVE)
                .author(principal)
                .build();

        Page<Post> postPage = postRepository.findAll(Example.of(example), pageable);

        Page<PostResponseDto> postResponseDtoPage = postPage.map(this::convertToPostResponseDto);

        return postResponseDtoPage;
    }

    public Page<PostResponseDto> getAllUserDelete(String principal, Pageable pageable) {

        Post example = Post.builder()
                .postStatus(PostStatus.DELETE)
                .author(principal)
                .build();

        Page<Post> postPage = postRepository.findAll(Example.of(example), pageable);

        Page<PostResponseDto> postResponseDtoPage = postPage.map(this::convertToPostResponseDto);

        return postResponseDtoPage;
    }


}
