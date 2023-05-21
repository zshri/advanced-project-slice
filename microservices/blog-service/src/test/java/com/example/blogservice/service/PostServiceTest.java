package com.example.blogservice.service;

import com.example.blogservice.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;


    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

}
