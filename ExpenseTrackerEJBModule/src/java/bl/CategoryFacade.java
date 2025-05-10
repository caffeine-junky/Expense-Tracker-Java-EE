/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.Category;
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
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {

    @PersistenceContext(unitName = "ExpenseTrackerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    @Override
    public List<Category> findGlobalCategories() {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT c FROM Category c");
        queryString.append("WHERE c.isGlobal = true");
        queryString.append("ORDER BY c.name ASC");
        
        Query query = em.createQuery(queryString.toString());
        List<Category> categories = query.getResultList();
        
        return categories;
    }

    @Override
    public List<Category> findUserDefinedCategories(String username) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT c FROM Category c");
        queryString.append("WHERE c.isGlobal = false");
        queryString.append("AND EXISTS (SELECT e FROM Expense e");
        queryString.append("WHERE e.category = c AND e.user.username = :username)");
        queryString.append("ORDER BY c.name ASC");
        
        Query query = em.createQuery(queryString.toString());
        query.setParameter("username", username);
        List<Category> categories = query.getResultList();
        
        return categories;
    }

    @Override
    public boolean existsByName(String name) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT COUNT(c) FROM Category c");
        
        queryString.append("WHERE LOWER(c.name) = LOWER(:name)");
        Query query = em.createQuery(queryString.toString());
        query.setParameter("name", name);
        int count = (int) query.getSingleResult();

        return count > 0;
    }
    
}
