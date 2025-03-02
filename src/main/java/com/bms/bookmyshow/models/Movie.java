package com.bms.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // it is used when we have list of enums.
    private List<Feature> features;
}
