package book_library.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "librarians")
public class Librarian extends BaseEntitiesWithLongId{

        private String firstName;
        private String lastName;
        private String email;

        @ManyToOne(optional = false)
        private LibraryBranch libraryBranch;

        @OneToMany(mappedBy = "librarian")
        private Set<BorrowRecord> borrowRecords;

        public Librarian() {
        }

        public Librarian(String firstName, String lastName, String email,LibraryBranch libraryBranch) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.email = email;
                this.libraryBranch = libraryBranch;
                this.borrowRecords = new HashSet<>();
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public LibraryBranch getLibraryBranch() {
                return libraryBranch;
        }

        public void setLibraryBranch(LibraryBranch libraryBranch) {
                this.libraryBranch = libraryBranch;
        }

        public Set<BorrowRecord> getBorrowRecords() {
                return borrowRecords;
        }

        public void setBorrowRecords(Set<BorrowRecord> borrowRecords) {
                this.borrowRecords = borrowRecords;
        }
    }
