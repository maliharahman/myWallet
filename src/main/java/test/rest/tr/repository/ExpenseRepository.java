package test.rest.tr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.rest.tr.domain.Expense;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
   List<Expense> findByUserId(Long userId);
}
