package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

/**
 * Created by serkp on 2.03.2017.
 */
public class DentistVisitDTO {
    @NotNull
    Long dentistId;

    @NotNull
    Date visitDate;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(Long dentistId, Date visitDate) {
        this.dentistId = dentistId;
        this.visitDate = visitDate;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
