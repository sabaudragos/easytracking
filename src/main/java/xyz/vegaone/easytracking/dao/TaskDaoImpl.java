package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task getTask(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    @Transactional
    public void createTask(Task task) {
        entityManager.persist(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        entityManager.merge(task);
    }

    @Override
    public void deleteTask(Task task) {
        entityManager.remove(task);
    }
}