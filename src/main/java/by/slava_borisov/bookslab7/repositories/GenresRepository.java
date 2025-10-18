package by.slava_borisov.bookslab7.repositories;

import by.slava_borisov.bookslab7.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenresRepository extends JpaRepository<GenreEntity, Long> {
    Optional<GenreEntity> findByName(String genreType);
}
