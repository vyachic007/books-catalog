package by.slava_borisov.bookslab7.service;

import by.slava_borisov.bookslab7.dto.Book;
import by.slava_borisov.bookslab7.mapper.BookMapper;
import by.slava_borisov.bookslab7.model.AuthorEntity;
import by.slava_borisov.bookslab7.model.BookEntity;
import by.slava_borisov.bookslab7.model.GenreEntity;
import by.slava_borisov.bookslab7.repositories.AuthorsRepository;
import by.slava_borisov.bookslab7.repositories.BooksRepository;
import by.slava_borisov.bookslab7.repositories.GenresRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {
    private final BooksRepository bookRepository;
    private final AuthorsRepository authorsRepository;
    private final GenresRepository genresRepository;
    private final BookMapper bookMapper;
    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    public void createBook(
            String title,
            String authorFirstName,
            String authorSecondName,
            String authorLastName,
            String genreType,
            int year,
            String location
    ) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be null or blank");
        }
        if (authorFirstName == null || authorFirstName.isBlank()) {
            throw new IllegalArgumentException("Author's first name must not be null or blank");
        }
        if (authorLastName == null || authorLastName.isBlank()) {
            throw new IllegalArgumentException("Author's last name must not be null or blank");
        }
        if (genreType == null || genreType.isBlank()) {
            throw new IllegalArgumentException("Genre type must not be null or blank");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location must not be null or blank");
        }

        int currentYear = java.time.Year.now().getValue();
        if (year < 0 || year > currentYear + 10) {
            throw new IllegalArgumentException("Year must be between 0 and " + (currentYear + 10));
        }

        log.info("Called method createBook with title={}, authorFirstName={}, authorSecondName={}, " +
                        "authorLastName={}, genreType={}, year={}, location={}",
                title, authorFirstName, authorSecondName, authorLastName, genreType, year, location);

        AuthorEntity author = authorsRepository.findByFirstNameAndMiddleNameAndLastName(
                        authorFirstName, authorSecondName, authorLastName)
                .orElseGet(() -> {
                    AuthorEntity newAuthor = new AuthorEntity();
                    newAuthor.setFirstName(authorFirstName);
                    newAuthor.setMiddleName(authorSecondName);
                    newAuthor.setLastName(authorLastName);
                    return authorsRepository.save(newAuthor);
                });

        GenreEntity genre = genresRepository.findByName(genreType)
                .orElseGet(() -> {
                    GenreEntity newGenre = new GenreEntity();
                    newGenre.setName(genreType);
                    return genresRepository.save(newGenre);
                });

        BookEntity book = new BookEntity(title, author, genre, year, location);
        bookRepository.save(book);
    }

        public List<Book> getAllBooks () {
            log.info("Called method getAllBooks");
            return bookRepository.findAll().stream()
                    .map(bookMapper::toDto)
                    .collect(Collectors.toList());
        }

        public void deleteBookById (Long id){
            if (id == null) {
                throw new IllegalArgumentException("Book ID must not be null");
            }
            log.info("Called method deleteBookById with id={}", id);
            bookRepository.deleteById(id);
        }
    }
