package com.example.profileservice.web;

import com.example.profileservice.model.Profile;
import com.example.profileservice.repository.ProfileRepository;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    String principal = "Principal11";


    @GetMapping
    @ResponseBody
    public ResponseEntity<Profile> getProfile(
//            Principal principal
    ) {
        Optional<Profile> myProfile = profileRepository.findOne(Example.of(Profile.builder().id(principal).build()));

        if (myProfile.isPresent()) {
            return ResponseEntity.ok(myProfile.get());
        } else {
            Profile profile = createProfile(principal);
            return ResponseEntity.ok(profile);
        }
    }

    public Profile createProfile(String principal) {

        Profile profile = Profile.builder()
                .id(principal)
                .displayName(principal)
                .displayStatus("hi all").build();

        Profile response = profileRepository.save(profile);

        System.out.printf("log: profile %s create%n", profile.getId());
        return response;
    }


////    реактивный метод отменяем
//    @GetMapping
//    @ResponseBody
////    @ApiIgnore @CookieValue(CookieName.AUTHENTICATION) String token
//    public Mono<ResponseEntity<Profile>> getProfile(
////            Principal principal
//    ) {
//        profileRepository.findOne(Example.of(Profile.builder().id(principal).build()));
//        return profile.map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.notFound().build());
////                .defaultIfEmpty(()-> {
////                    ResponseEntity.ok(createProfile(principal));
////                });
////                .defaultIfEmpty(createProfile(principal).map(u -> ResponseEntity.ok(u))));
//
////                        Mono.fromCallable(() -> {
////                    Mono<Profile> profileMono = createProfile(principal);
////                    return profileMono.map(u ->ResponseEntity.ok(u));
//////                        createProfile(principal).map(u -> ResponseEntity.ok(u)));
////    }));
//    };

    @GetMapping("/{uuid}")
    @ResponseBody
//    @ApiIgnore @CookieValue(CookieName.AUTHENTICATION) String token
    public ResponseEntity<Profile> getProfileByUUID(
//            Principal principal,
            @PathVariable(required = false) String uuid
    ) {
        Optional<Profile> profileById = profileRepository.findOne(Example.of(Profile.builder().id(uuid).build()));

        return profileById.map(ResponseEntity::ok) .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
// Пример отличия
//        if (profileById.isPresent()) {
//            return ResponseEntity.ok(profileById.get());
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }


    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody ResponseEntity<Profile>  updateProfile(@RequestBody Profile profile) {

        if (profile.getId().equals(principal)) {
            Profile response = profileRepository.save(profile);
            System.out.println("log: profile create");
            return ResponseEntity.ok(response);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }










    @GetMapping("/test")
    public ResponseEntity test1() {
//
//        Query query = new Query();
//        query.with(Sort.by(Sort.Direction.ASC, "age"));
//        List<Profile> users = mongoTemplate.find(query,Profile.class);

        return (ResponseEntity) ResponseEntity.notFound();

    }

    @GetMapping("/test2")
    public ResponseEntity test2() {
        return ResponseEntity.ok(generateCharacters());
    }

    public Flux<Character> generateCharacters() {

        return Flux.generate(() -> 97, (state, sink) -> {
            char value = (char) state.intValue();
            sink.next(value);

            return state + 1;
        });
    }


}