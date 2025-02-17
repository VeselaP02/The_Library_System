package book_library.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "towns")
public class Town extends BaseEntitiesWithLongId{

   @Column(nullable = false)
   private String name;

   @OneToMany(mappedBy = "town")
   private Set<User> users;

   public Town() {
      this.users = new HashSet<>();
   }

   public Town(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Set<User> getUsers() {
      return users;
   }

   public void setUsers(Set<User> users) {
      this.users = users;
   }
}
