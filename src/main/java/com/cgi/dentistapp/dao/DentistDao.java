package com.cgi.dentistapp.dao;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by siimsams on 17.04.2017.
 */
@Repository
public class DentistDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(DentistEntity dentistEntity) {
        entityManager.persist(dentistEntity);
    }

    public List<DentistEntity> getAllDentists() {
        return entityManager.createQuery("SELECT e FROM DentistEntity e").getResultList();
    }

    public DentistEntity getDentistById(Long id) {
        return entityManager.find(DentistEntity.class, id);
    }
}
