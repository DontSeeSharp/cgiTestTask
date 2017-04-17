package com.cgi.dentistapp.dto;

import com.cgi.dentistapp.dao.DentistDao;
import com.cgi.dentistapp.dao.entity.DentistEntity;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by siimsams on 17.04.2017.
 */

public class SearchDTO {
    @NotNull
    Long dentistId;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Nullable
    Date start;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    @Nullable
    Date end;

    public SearchDTO() {
    }

    public SearchDTO(Long dentistId, Date start, Date end) {
        this.dentistId = dentistId;
        this.start = start;
        this.end = end;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
