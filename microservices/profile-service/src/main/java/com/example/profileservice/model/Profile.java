package com.example.profileservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile {

    @Id
    private String id;
    private String displayName;
    private String displayStatus;
    private String avatarUrl;
    private boolean emailNews;

//    public boolean isEmailNews() {
//        return emailNews;
//    }
//


    //    statistic
//
//    private List<String> subscriptions;
//
//    private List<String> subscribers;


}