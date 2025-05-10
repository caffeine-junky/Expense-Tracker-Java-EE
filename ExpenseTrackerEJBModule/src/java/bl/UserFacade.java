/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author moses
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "ExpenseTrackerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public boolean existsByUsername(String username) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT COUNT(u) FROM User u ");
        queryString.append("WHERE LOWER(u.username) = LOWER(:username)");

        Query query = em.createQuery(queryString.toString());
        query.setParameter("username", username);

        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    @Override
    public List<User> findByRole(String role) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u FROM User u ");
        queryString.append("WHERE u.role = :role ");
        queryString.append("ORDER BY u.username ASC");

        Query query = em.createQuery(queryString.toString());
        query.setParameter("role", role);

        return query.getResultList();
    }

    @Override
    public List<String> findAllUsernames() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT u.username FROM User u ");
        queryString.append("ORDER BY u.username ASC");

        Query query = em.createQuery(queryString.toString());
        return query.getResultList();
    }
    
}
