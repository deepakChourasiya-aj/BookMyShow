package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    // WHAT IS REQ FOR THEATER THINK
    // NAME,CITY,REGION,LIST OF SCREENS,THREATRE ID,EXCAT ADDRESS
    // id WILL BE COMING FROM THE BASE MODEL OK.
    private String name;
    private Region region;
    private List<Screen> screens;

}
