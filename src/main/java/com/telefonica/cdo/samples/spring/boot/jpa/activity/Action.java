package com.telefonica.cdo.samples.spring.boot.jpa.activity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "action")
public class Action {

    @Getter
    @Id
    @Setter
    private Long id;

    @Getter
    @JoinColumn(name = "activity_id")
    @JsonBackReference
    @ManyToOne
    @Setter
    private Activity activity;

    @Getter
    @Setter
    private String name;

}
