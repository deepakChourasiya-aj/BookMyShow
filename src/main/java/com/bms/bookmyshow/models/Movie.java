package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
     // NAME,RELEASE YEAR, ACTOR, DIRECTOR, LANGUAGES, LITTLE DESCRIPTION ALSO WE THERE, GENRE,
    private String name;
    private Date releaseDate;
    private List<Feature> features;
}
