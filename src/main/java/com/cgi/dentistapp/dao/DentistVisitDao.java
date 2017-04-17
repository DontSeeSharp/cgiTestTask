package com.cgi.dentistapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import org.springframework.stereotype.Repository;

import com.cgi.dentistapp.dao.entity.DentistVisitEntity;

import java.util.Date;
import java.util.List;

@Repository
public class DentistVisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(DentistVisitEntity visit) {
        entityManager.persist(visit);
    }

    public List<DentistVisitEntity> getAllVisits() {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e").getResultList();
    }

    public List<DentistVisitEntity> getVisitsByDentist(DentistEntity dentistId) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE e.dentist = :dentistId")
                .setParameter("dentistId", dentistId)
                .getResultList();
    }

    public List<DentistVisitEntity> getVisitsByStartDate(Date start) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE e.visitDate > :startDate")
                .setParameter("startDate", start)
                .getResultList();
    }

    public List<DentistVisitEntity> getVisitsByEndDate(Date end) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE e.visitDate < :endDate")
                .setParameter("endDate", end)
                .getResultList();
    }

    public List<DentistVisitEntity> getVisitsByAndDates(DentistEntity dentistId, Date startDate) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE e.dentist = :dentistId AND " +
                "e.visitDate > :startDate")
                .setParameter("dentistId", dentistId)
                .setParameter("startDate", startDate)
                .getResultList();
    }

    public List<DentistVisitEntity> getVisitsByAndDates(DentistEntity dentistId, Date startDate, Date endDate) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE (e.dentist = :dentistId) " +
                "AND (e.visitDate BETWEEN :startDate AND :endDate)")
                .setParameter("dentistId", dentistId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    public List<DentistVisitEntity> getVisitsByDentistAndEnd(DentistEntity dentistId, Date endDate) {
        return entityManager.createQuery("SELECT e FROM DentistVisitEntity e WHERE e.dentist = :dentistId AND " +
                "e.visitDate < :endDate")
                .setParameter("dentistId", dentistId)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
