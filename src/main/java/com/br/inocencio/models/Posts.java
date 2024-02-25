package com.br.inocencio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String text;
    private Date date = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties("post")
    private Users user;

    @ManyToOne
    @NotNull
    @JsonIgnoreProperties("post")
    private Themes theme;

    public Posts() {
    }

    public Posts(Integer id, String title, String text, Date date, Users user, Themes theme) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.user = user;
        this.theme = theme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Themes getTheme() {
        return theme;
    }

    public void setTheme(Themes theme) {
        this.theme = theme;
    }
}
