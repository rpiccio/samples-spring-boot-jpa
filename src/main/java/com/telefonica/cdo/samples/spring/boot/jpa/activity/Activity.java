package com.telefonica.cdo.samples.spring.boot.jpa.activity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "activity")
public class Activity {

    @Getter
    @Id
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "activity")
    @Setter
    private List<Action> actions;

}
