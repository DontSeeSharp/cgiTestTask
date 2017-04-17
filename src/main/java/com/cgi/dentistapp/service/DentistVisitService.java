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

    public List<DentistVisitEntity> listVisitsByDentist(DentistEntity dentistEntity) {
        return dentistVisitDao.getVisitsByDentist(dentistEntity);
    }

    public List<DentistVisitEntity> listVisitsByDentistAndDate(DentistEntity dentistEntity, Date start) {
        return dentistVisitDao.getVisitsByAndDates(dentistEntity, start);
    }

    public List<DentistVisitEntity> listVisitsByDentistAndDate(DentistEntity dentistEntity, Date start
            , Date finish) {
        return dentistVisitDao.getVisitsByAndDates(dentistEntity, start, finish);
    }

    public List<DentistVisitEntity> listVisitsByDentistAndEnd(DentistEntity dentistId, Date end) {
        return dentistVisitDao.getVisitsByDentistAndEnd(dentistId, end);
    }

    public List<DentistVisitEntity> listByEnd(Date end) {
        return dentistVisitDao.getVisitsByEndDate(end);
    }

    public List<DentistEntity> listDentists () {
        return dentistDao.getAllDentists();
    }

    public DentistEntity getDentistById(Long id) {
        return dentistDao.getDentistById(id);
    }

    public List<DentistVisitEntity> listByStart(Date start) {
        return dentistVisitDao.getVisitsByStartDate(start);
    }

    public DentistVisitEntity getVisitById(Long id) {
        return dentistVisitDao.getVisitById(id);
    }
}
