package by.slava_borisov.bookslab7.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genreEntity;

    private Integer year;

    private String location;

    public BookEntity() {
    }

    public BookEntity(String title, AuthorEntity authorEntity, GenreEntity genreEntity, Integer year, String location) {
        this.title = title;
        this.authorEntity = authorEntity;
        this.genreEntity = genreEntity;
        this.year = year;
        this.location = location;
    }
}
