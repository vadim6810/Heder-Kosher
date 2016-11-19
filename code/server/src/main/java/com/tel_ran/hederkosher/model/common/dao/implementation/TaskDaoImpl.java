package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.TaskDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public boolean addTask(Task task) {
        if (task == null) {
            return false;
        }
        em.persist(task);
        return true;
    }

    @Override
    @Transactional
    public boolean updateTask(Task task) {
        if (task == null) {
            return false;
        }
        final Task oldTask = em.find(Task.class, task.getId());
        if (oldTask == null) {
            return false;
        }
        final Task newTask = em.merge(task);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTask(long id) {
        Task task = em.find(Task.class, id);
        if (task == null) {
            return false;
        }
        em.remove(task);
        return true;
    }

    @Override
    public Task getTaskById(long id) {
        Task task = null;
        try {
            task = (Task) em.createQuery("SELECT t FROM Task t join t.owner WHERE t.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) em.createQuery("SELECT t FROM Task t").getResultList();
    }

    @Override
    public List<Task> getTasksByProgram(Program program) {
        return (List<Task>) em.createQuery("SELECT t FROM Task t WHERE t.program = :program")
                .setParameter("program", program)
                .getResultList();
    }
}
