package test.rest.tr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.rest.tr.types.User;
import test.rest.tr.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserController {

@Autowired
UserRepository repository;

@RequestMapping("/createMany")
public String createMany() {
    List<User> userList = new ArrayList<>();

    User user1 = new User();
    user1.setName("DEF");
    user1.setEmail("DEF@gmail.com");
    userList.add(user1);

    User user2 = new User();
    user2.setName("XYZ");
    user2.setEmail("XYZ@gmail.com");
    userList.add(user2);

    repository.saveAll(userList);
    return "Created users";
}


@RequestMapping("/create")
public String create() {
    User user = new User();
    user.setName("ABC");
    user.setEmail("abc@gmail.com");

    repository.save(user);
    return "Created user";
}

@RequestMapping("/findAll")
public List<User>findAll() {
    List<User> users = repository.findAll();
    return users;
}


@RequestMapping("/findById")
public List<User> findById(Long id){
   //String users=repository.findById(6);
   //return users;

  List<User>users=repository.findById(6);
    for (Iterator<User> itr = users.iterator(); itr.hasNext(); )
        if (itr.next().equals(6))
            return users;

    return users;
}


@RequestMapping("/findByName")
public List<User>findByName(String name){
    List<User>users=repository.findByName("Alice");
            return users;
}

}
