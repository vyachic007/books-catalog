package by.slava_borisov.bookslab7.repositories;

import by.slava_borisov.bookslab7.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BookEntity, Long> {

}
