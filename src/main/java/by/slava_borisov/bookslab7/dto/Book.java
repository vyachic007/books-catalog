package by.slava_borisov.bookslab7.dto;

public record Book(
        Long id,
        String title,
        Author author,
        Genre genre,
        Integer year,
        String location
) {
}
