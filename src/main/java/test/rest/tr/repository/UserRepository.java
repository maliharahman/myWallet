package test.rest.tr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.rest.tr.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}