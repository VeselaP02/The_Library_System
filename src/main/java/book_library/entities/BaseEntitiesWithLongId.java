package book_library.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntitiesWithLongId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
