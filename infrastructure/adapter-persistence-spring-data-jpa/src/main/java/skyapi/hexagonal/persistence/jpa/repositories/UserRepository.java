package skyapi.hexagonal.persistence.jpa.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import skyapi.hexagonal.persistence.jpa.entities.UserEntity;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}