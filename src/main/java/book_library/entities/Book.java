package book_library.entities;

import book_library.enums.Genre;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntitiesWithLongId {

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @Column (name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @ManyToOne(optional = false)
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<BorrowRecords> borrowRecords;

    @ManyToOne(optional = false)
    private LibraryBranch libraryBranch;

    public Book() {
        this.borrowRecords = new HashSet<>();
    }

    public Book(String title, Genre genre, LocalDate releaseDate, Author author) {
        this();

        this.title = title;
        this.genre = genre;
        this.isAvailable = true;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Set<BorrowRecords> getBorrowRecords() {
        return Collections.unmodifiableSet(borrowRecords);
    }

    public void setBorrowRecords(Set<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LibraryBranch getLibraryBranch() {
        return libraryBranch;
    }

    public void setLibraryBranch(LibraryBranch libraryBranch) {
        this.libraryBranch = libraryBranch;
    }
}
