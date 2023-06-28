package com.example.profileservice.config;

import com.example.profileservice.model.Profile;
import com.example.profileservice.repository.ProfileRepository;
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.Collections;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mongo1";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://root:example@localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("profile");
    }
}



//@Configuration
//@EnableMongoRepositories
//public class MongoConfiguration extends AbstractReactiveMongoConfiguration {
//
//    @Override
//    protected String getDatabaseName() {
//        return "mongo1";
//    }
//
//    @Override
//    @Bean
//    public MongoClient reactiveMongoClient() {
//        return MongoClients.create("mongodb://root:example@localhost:27017");
//    }
//
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
//    }

//    @Bean
//    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
//    public CommandLineRunner loadData(ProfileRepository profileRepository) {
//        return (args) -> {
//            // save a couple of users
//            var users = Flux.just(
//                    new Profile("1", "name", "status", "url" ),
//                    new Profile("2", "name", "status", "url" ),
//                    new Profile("3", "name", "status", "url" )
//            );
//
//            profileRepository.saveAll(users).subscribe();
//
//
//        };
//    }
//}
