package book_library.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntitiesWithLongId {


    private Long id;

    protected BaseEntitiesWithLongId() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
