package com.cgi.dentistapp.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dentistapp.dao.DentistVisitDao;
import com.cgi.dentistapp.dao.entity.DentistVisitEntity;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    private DentistVisitDao dentistVisitDao;

    public void addVisit(String dentistName, Date visitDate, Time visitTime) {
        DentistVisitEntity visit = new DentistVisitEntity(dentistName, visitDate, visitTime);
        dentistVisitDao.create(visit);
    }

    public List<DentistVisitEntity> listVisits () {
        return dentistVisitDao.getAllVisits();
    }

    public List<String> listDentists () {
        return dentistVisitDao.getAllDentists();
    }

}
