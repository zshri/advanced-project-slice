package com.example.blogservice.model;

import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
import javax.persistence.*;

@MappedSuperclass
@ToString
public class BaseEntity extends RepresentationModel {

    //    todo проверить с авто инкрементом
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    @SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", initialValue = 1000, allocationSize = 10)
    private Long id;

////  todo По умолчанию для всех сущностей не повредит?
//    @Version
//    protected long version;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

//    public long getVersion() {
//        return this.version;
//    }

}
