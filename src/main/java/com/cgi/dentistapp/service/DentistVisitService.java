package com.cgi.dentistapp.service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.cgi.dentistapp.dao.DentistDao;
import com.cgi.dentistapp.dao.entity.DentistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dentistapp.dao.DentistVisitDao;
import com.cgi.dentistapp.dao.entity.DentistVisitEntity;

@Service
@Transactional
public class DentistVisitService {

    @Autowired
    private DentistVisitDao dentistVisitDao;

    @Autowired
    private DentistDao dentistDao;

    public void addVisit(DentistEntity dentistEntity, Date visitDate) {
        DentistVisitEntity visit = new DentistVisitEntity(dentistEntity, visitDate);
        dentistVisitDao.create(visit);
    }

    public List<DentistVisitEntity> listVisits () {
        return dentistVisitDao.getAllVisits();
    }

    public List<DentistEntity> listDentists () {
        return dentistDao.getAllDentists();
    }

    public DentistEntity getDentistById(Long id) {
        return dentistDao.getDentistById(id);
    }
}
