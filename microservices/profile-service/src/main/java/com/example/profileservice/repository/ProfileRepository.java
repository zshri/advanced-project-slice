package com.example.profileservice.repository;


import com.example.profileservice.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;


@Repository
//public interface ProfileRepository extends ReactiveCrudRepository<Profile, String> {
//public interface ProfileRepository extends ReactiveMongoRepository<Profile, Long> { // todo так Long или String?
public interface ProfileRepository extends MongoRepository<Profile, Long> { // todo так Long или String?

//    Flux<Profile> findAllByValue(String value);
//    Mono<Profile> findFirstByOwner(Mono<String> owner);

//    @Query("{'name' : 'name'}")
//    Flux<Profile> findProfiles();


//    @Meta(maxScanDocuments = 3) // (2)
//    Flux<Book> findByAuthorsOrderByPublishingYearDesc( // (3)
//                                                       Flux<String> authors
//    );
//    @Query("{ 'authors.1': { $exists: true } }") // (4)
//    Flux<Book> booksWithFewAuthors();
}