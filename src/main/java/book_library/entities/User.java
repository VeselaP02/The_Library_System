package book_library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntitiesWithLongId {

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "registration_data")
    private LocalDate registrationDate;

    @Column(name = "last_logged_in")
    private LocalDate lastTimeLoggedIn;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<BorrowRecords> borrowRecords;

    public User() {
        this.borrowRecords = new HashSet<>();
    }

    public User(String username, String password, LocalDate registrationDate, LocalDate lastTimeLoggedIn) {
        this();
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<BorrowRecords> getBorrowRecords() {
        return Collections.unmodifiableSet(borrowRecords);
    }

    public void setBorrowRecords(Set<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDate lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }
}
