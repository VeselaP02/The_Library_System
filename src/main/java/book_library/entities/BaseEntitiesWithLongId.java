package book_library.entities;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntitiesWithLongId)) return false;
        BaseEntitiesWithLongId that = (BaseEntitiesWithLongId) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
