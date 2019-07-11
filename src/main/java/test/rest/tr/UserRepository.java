package test.rest.tr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.rest.tr.types.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User>findById(long id);
    List<User>findAll();
    List<User>findByName(String name);
}