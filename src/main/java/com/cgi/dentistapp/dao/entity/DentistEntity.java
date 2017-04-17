package com.cgi.dentistapp.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by siimsams on 17.04.2017.
 */
@Entity
@Table(name = "dentist")
public class DentistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dentist_id")
    private Long id;

    @Size(min = 1, max = 50)
    @Column(name = "dentist_name", unique=true, nullable = false)
    private String dentistName;

    public DentistEntity() {
    }

    public DentistEntity(String dentistName) {
        this.dentistName = dentistName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }
}
