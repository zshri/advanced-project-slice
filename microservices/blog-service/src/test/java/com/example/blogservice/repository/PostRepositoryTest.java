package com.example.blogservice.repository;

import com.example.blogservice.model.Post;
import com.example.blogservice.model.PostStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;



/*
* Testcontainers will automatically provide a database container instance for the tests.
*
* */


@ExtendWith(SpringExtension.class)
@DataJpaTest
//@TestPropertySource(properties = {
////        "spring.flyway.enabled=false",
////        "spring.jpa.hibernate.ddl-auto=create-drop"
////        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///test-db"
//})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTest {

//    @Bean
//    @Profile("test")
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("sa");
//
//        return dataSource;
//    }
// configure entityManagerFactory
// configure transactionManager
// configure additional Hibernate properties

    @Autowired
    private PostRepository postRepository;
    private Post postInit ;

    private Post postSave ;

    @BeforeEach
    public void setUp() {
        postInit = Post.builder()
                .title("Set up post  ")
                .content("Content")
                .postStatus(PostStatus.SAVE)
                .createAt(Instant.now())
                .author("tom")
                .build();

        postSave = postRepository.save(postInit);
    }

    @AfterEach
    public void tearDown() {
//        postRepository.deleteAll();
//        post = null;
    }


    @Test
    public void findById(){
//        тестировать фрейворк пустая трата времени
        Post fetchedPost = postRepository.findById(postSave.getId()).get();
        assertEquals(postSave, fetchedPost);
    }



}
