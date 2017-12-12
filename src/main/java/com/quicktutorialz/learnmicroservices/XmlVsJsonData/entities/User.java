package com.quicktutorialz.learnmicroservices.XmlVsJsonData.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})   //else it gives me error asking for one Task
@Entity @Table(name="users")
@AllArgsConstructor @NoArgsConstructor
@XmlRootElement                                                  //so I can get output data in XML too!
public class User {

    @Id @GeneratedValue @Column(name="ID")
    @Getter @Setter
    private Integer id;

    @Column(name="NAME")
    @Getter @Setter
    @NotBlank
    private String name;

    @Column(name="AGE")
    @Getter @Setter
    @NotNull
    private Integer age;

}
