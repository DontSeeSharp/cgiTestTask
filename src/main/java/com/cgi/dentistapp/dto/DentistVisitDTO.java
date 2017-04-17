package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

/**
 * Created by serkp on 2.03.2017.
 */
public class DentistVisitDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date visitDate;

    @NotNull
    Time visitTime;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(String dentistName, Date visitDate, Time visitTime) {
        this.dentistName = dentistName;
        this.visitDate = visitDate;
        this.visitTime = visitTime;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Time getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Time visitTime) {
        this.visitTime = visitTime;
    }
}
