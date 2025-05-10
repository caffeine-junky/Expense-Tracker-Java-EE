/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.Expense;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;
import java.time.LocalDate;

/**
 *
 * @author moses
 */
@Stateless
public class ExpenseFacade extends AbstractFacade<Expense> implements ExpenseFacadeLocal {

    @PersistenceContext(unitName = "ExpenseTrackerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpenseFacade() {
        super(Expense.class);
    }
    
    @Override
    public List<Expense> findByUsername(String username) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT e FROM Expense e");
        queryString.append("WHERE e.user.username = :username");
        queryString.append("ORDER BY e.date DESC");
        Query query =  em.createQuery(queryString.toString());
        query.setParameter("username", username);
        
        return query.getResultList();
    }

    @Override
    public List<Expense> findByUsernameAndDateRange(String username, LocalDate start, LocalDate end) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT e FROM Expense e");
        queryString.append("WHERE e.user.username = :username");
        queryString.append("AND e.date BETWEEN :start AND :end");
        queryString.append("ORDER BY e.date DESC");
        
        Query query = em.createQuery(queryString.toString());
        query.setParameter("username", username);
        query.setParameter("start", start);
        query.setParameter("end", end);
        
        return query.getResultList();
    }

    @Override
    public List<Expense> findByUsernameAndCategory(String username, Long categoryId) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT e FROM Expense e");
        queryString.append("WHERE e.user.username = :username");
        queryString.append("AND e.category.id = :categoryId");
        queryString.append("ORDER BY e.date DESC");
        Query query = em.createQuery(queryString.toString());
        
        query.setParameter("username", username);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public Double getTotalExpensesByUsername(String username) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT SUM(e.amount) FROM Expense e");
        queryString.append("WHERE e.user.username = :username");
        
        Query query = em.createQuery(queryString.toString());
        query.setParameter("username", username);
        
        Double total = (Double) query.getSingleResult();

        return total != null ? total : 0.0;
    }

    @Override
    public Double getTotalExpensesByUsernameAndDateRange(String username, LocalDate start, LocalDate end) {
        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT SUM(e.amount) FROM Expense e");
        queryString.append("WHERE e.user.username = :username");
        queryString.append("AND e.date BETWEEN :start AND :end");
        Query query = em.createQuery(queryString.toString());
        
        query.setParameter("username", username);
        query.setParameter("start", start);
        query.setParameter("end", end);
        Double total = (Double) query.getSingleResult();

        return total != null ? total : 0.0;
    }
    
}
