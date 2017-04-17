package com.cgi.dentistapp.dao.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "dentist_visit")
public class DentistVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private DentistEntity dentist;

    @Column(name = "visit_date")
    private Date visitDate;

    public DentistVisitEntity() {
    }

    public DentistVisitEntity(DentistEntity dentist, Date visitDate) {
        this.setVisitDate(visitDate);
        this.setDentist(dentist);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public DentistEntity getDentist() {
        return dentist;
    }

    public void setDentist(DentistEntity dentist) {
        this.dentist = dentist;
    }
}
