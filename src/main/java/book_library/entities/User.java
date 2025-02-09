package book_library.entities;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntitiesWithLongId {
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<BorrowRecords> borrowRecords;

    public User() {
        this.borrowRecords = new HashSet<>();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
