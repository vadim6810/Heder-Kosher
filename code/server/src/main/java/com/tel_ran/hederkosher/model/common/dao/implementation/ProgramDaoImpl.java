package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.ProgramDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProgramDaoImpl implements ProgramDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public boolean addProgram(Program program) {
        if (program == null) {
            return false;
        }
        em.persist(program);
        return true;
    }

    @Override
    @Transactional
    public boolean updateProgram(Program program) {
        if (program == null) {
            return false;
        }
        final Program oldProgram = em.find(Program.class, program.getId());
        if (oldProgram == null) {
            return false;
        }
        final Program newProgram = em.merge(program);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteProgram(long id) {
        final Program program = em.find(Program.class, id);
        if (program == null) {
            return false;
        }
        em.remove(program);
        return true;
    }

    @Override
    public Program getProgramById(long id) {
        Program program = null;
        try {
            program = (Program) em.createQuery("SELECT p FROM Program p WHERE p.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return program;
    }

    @Override
    public List<Program> getAllPrograms() {
        return (List<Program>) em.createQuery("SELECT p FROM Program p").getResultList();
    }

    @Override
    public List<Program> getCreatedPrograms(long userId) {
        return (List<Program>) em.createQuery("SELECT p FROM Program p WHERE p.creator.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Program> getAssignedPrograms(long userId) {
        return (List<Program>) em.createQuery("SELECT p FROM Program p JOIN p.clients c WHERE c.id = :userId")
                .setParameter("userId", userId)
                .getResultList(); //TODO
    }

}
