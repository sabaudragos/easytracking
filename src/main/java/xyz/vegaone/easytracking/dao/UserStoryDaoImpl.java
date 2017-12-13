package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.UserStory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserStoryDaoImpl implements UserStoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserStory getUserStory(Long id) {
        return entityManager.find(UserStory.class, id);
    }

    @Override
    @Transactional
    public void createUserStory(UserStory userStory) {
        entityManager.persist(userStory);
    }

    @Override
    @Transactional
    public void updateUserStory(UserStory userStory) {
        entityManager.merge(userStory);
    }

    @Override
    public void deleteUserStory(UserStory userStory) {
        entityManager.remove(userStory);
    }
}