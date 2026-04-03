package org.example.proiect.model;

import jakarta.persistence.*;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private Long id;

    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    private Integer duration;

    private Double score;

    @Column(name = "genre_id")
    private Long genreId;

    // Constructori
    public Movie() {}

    // Getteri si Setteri (Obligatorii pentru ca Spring sa poata citi/scrie datele)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Date getReleaseDate() { return releaseDate; }
    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }

    public Long getGenreId() { return genreId; }
    public void setGenreId(Long genreId) { this.genreId = genreId; }
}