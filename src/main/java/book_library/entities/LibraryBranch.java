package book_library.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "library_branches")
public class LibraryBranch extends BaseEntitiesWithLongId{

        @Column(nullable = false, unique = true)
        private String name;

        @Column(nullable = false)
        private String location;

        @OneToMany(mappedBy = "libraryBranch",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        private Set<Book> books = new HashSet<>();

        @OneToMany(mappedBy = "libraryBranch")
        private Set<BorrowRecords> borrowRecords;

        @OneToMany(mappedBy = "libraryBranch")
        private Set<User> users;

        @OneToMany(mappedBy = "libraryBranch")
        private Set<Librarian> librarians;

        public LibraryBranch() {}

        public LibraryBranch(String name, String location) {
            this.name = name;
            this.location = location;
            this.books = new HashSet<>();
            this.borrowRecords = new HashSet<>();
            this.users = new HashSet<>();
            this.librarians = new HashSet<>();
        }


        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public Set<Book> getBooks() { return books; }
        public void setBooks(Set<Book> books) { this.books = books; }

        public Set<BorrowRecords> getBorrowRecords() { return borrowRecords; }
        public void setBorrowRecords(Set<BorrowRecords> borrowRecords) { this.borrowRecords = borrowRecords; }

        public Set<User> getUsers() { return users; }
        public void setUsers(Set<User> users) { this.users = users; }

        public Set<Librarian> getLibrarians() {
                return librarians;
        }

        public void setLibrarians(Set<Librarian> librarians) {
                this.librarians = librarians;
        }
}
