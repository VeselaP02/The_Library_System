package book_library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "library_branches")
public class LibraryBranch extends BaseEntitiesWithLongId{

        @Column(nullable = false, unique = true)
        private String name;

        @Column(nullable = false)
        private String address;

        @OneToMany(mappedBy = "libraryBranch")
        private List<Book> books = new ArrayList<>();

        @OneToMany(mappedBy = "libraryBranch")
        private List<BorrowRecords> borrowRecords = new ArrayList<>();

        @OneToMany(mappedBy = "homeBranch")
        private List<User> users = new ArrayList<>();

        // Конструктори
        public LibraryBranch() {}

        public LibraryBranch(String name, String address) {
            this.name = name;
            this.address = address;
        }


        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public List<Book> getBooks() { return books; }
        public void setBooks(List<Book> books) { this.books = books; }

        public List<BorrowRecords> getBorrowRecords() { return borrowRecords; }
        public void setBorrowRecords(List<BorrowRecords> borrowRecords) { this.borrowRecords = borrowRecords; }

        public List<User> getUsers() { return users; }
        public void setUsers(List<User> users) { this.users = users; }
    }
