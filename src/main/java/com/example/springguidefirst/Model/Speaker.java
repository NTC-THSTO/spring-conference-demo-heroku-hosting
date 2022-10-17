package com.example.springguidefirst.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Speaker")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // this is for serializing
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String bio;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore()
    private List<Session> sessions;
}
