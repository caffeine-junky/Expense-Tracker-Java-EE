/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.Expense;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author moses
 */
@Local
public interface ExpenseFacadeLocal {

    void create(Expense expense);

    void edit(Expense expense);

    void remove(Expense expense);

    Expense find(Object id);

    List<Expense> findAll();

    List<Expense> findRange(int[] range);

    int count();
    
    List<Expense> findByUsername(String username);

    List<Expense> findByUsernameAndDateRange(String username, LocalDate start, LocalDate end);

    List<Expense> findByUsernameAndCategory(String username, Long categoryId);

    Double getTotalExpensesByUsername(String username);

    Double getTotalExpensesByUsernameAndDateRange(String username, LocalDate start, LocalDate end);
    
}
