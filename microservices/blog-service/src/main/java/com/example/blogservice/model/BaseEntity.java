package com.example.blogservice.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;


@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity extends RepresentationModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
