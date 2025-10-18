package by.slava_borisov.bookslab7.repositories;

import by.slava_borisov.bookslab7.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findByFirstNameAndMiddleNameAndLastName(
            String firstName, String secondName, String lastName);
}
