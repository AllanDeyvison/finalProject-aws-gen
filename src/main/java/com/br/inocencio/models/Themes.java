package com.br.inocencio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "themes")
public class Themes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String descrition;


    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("theme")
    private List<Posts> posts;

    public Themes() {
    }

    public Themes(Integer id, String descrition, List<Posts> posts) {
        this.id = id;
        this.descrition = descrition;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}
