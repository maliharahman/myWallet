package test.rest.tr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.rest.tr.domain.User;
import test.rest.tr.exception.ResourceNotFoundException;
import test.rest.tr.repository.UserRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

@Autowired
private UserRepository userRepository;

@GetMapping("/users")
public Page<User> getUsers(Pageable pageable){
    return userRepository.findAll(pageable);
}

@GetMapping("/users/{userId}")
public User getUser(@PathVariable Long userId){
    return userRepository.findById(userId)
            .orElseThrow(()-> new ResourceNotFoundException("User not found" + userId));
}

@PostMapping("/users")
public User createUser(@Valid @RequestBody User user){
    return userRepository.save(user);
}

@PutMapping("/users/{userId}")
public User updateUser(@PathVariable Long userId,
                       @Valid @RequestBody User userRequest){
    return userRepository.findById(userId)
            .map(user-> {
                user.setName(userRequest.getName());
                user.setEmail(userRequest.getEmail());
                return userRepository.save(user);
            }).orElseThrow(()-> new ResourceNotFoundException("User not found" + userId));
}


@DeleteMapping("/users/{userId}")
public ResponseEntity deleteUser(@PathVariable Long userId) {
    return userRepository.findById(userId)
            .map(user -> {
                userRepository.delete(user);
                return ResponseEntity.ok().build();
            }).orElseThrow( ()-> new ResourceNotFoundException("User not found" + userId));
}

/*
@RequestMapping("/createMany")
public String createMany() {
    List<User> userList = new ArrayList<>();

    User user1 = new User();
    user1.setName("BBB");
    user1.setEmail("BBB@gmail.com");
    List<Expense>expenseList = new ArrayList<>();
    user1.setExpenses(expenseList);
    userList.add(user1);

    User user2 = new User();
    user2.setName("FFF");
    user2.setEmail("FFF@gmail.com");
    userList.add(user2);

    userRepository.saveAll(userList);
    return "Created users";
}


@RequestMapping("/create")
public String create() {
    User user = new User();
    user.setName("ABC");
    user.setEmail("abc@gmail.com");

    userRepository.save(user);
    return "Created user";
}

@RequestMapping("/findAll")
public List<User>findAll() {
    List<User> users = userRepository.findAll();
    return users;
}

@RequestMapping("/findById")
public List<User> findById(Long id){
   //String users=userRepository.findById(6);
   //return users;

  List<User>users= userRepository.findById(6);
    for (Iterator<User> itr = users.iterator(); itr.hasNext(); )
        if (itr.next().equals(6))
            return users;

    return users;
}


@RequestMapping("/findByName")
public List<User>findByName(String name){
    List<User>users= userRepository.findByName("Alice");
            return users;
}

@RequestMapping(value="/1")
public String method0(){
    return "method0";
}

@GetMapping(value="/")
public String index(){
    return "This is home page";
}*/

}
