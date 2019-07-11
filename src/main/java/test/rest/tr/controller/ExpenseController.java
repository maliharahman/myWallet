package test.rest.tr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.rest.tr.types.Expense;
import test.rest.tr.ExpenseRepository;
import test.rest.tr.types.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExpenseController{

@Autowired
ExpenseRepository expenseRepository;

@RequestMapping("/createExpense")
public String createExpense()
{
    Date dt=new Date();
    List<Expense>expenseList = new ArrayList<>();

    Expense ex1=new Expense();
    ex1.setAmount(5);
    ex1.setDescription("Food");
    ex1.setTimestamp(dt);
    User user=new User();
    ex1.setUser(user);
    expenseList.add(ex1);

    expenseRepository.saveAll(expenseList);
    return "created expense";
}

/*
@RequestMapping("/findAllExpense")
public List<Expense>findAllExpense() {
    List<Expense> expenses = ExpenseRepository.findAllExpense();
    return expenses;
}
*/

}