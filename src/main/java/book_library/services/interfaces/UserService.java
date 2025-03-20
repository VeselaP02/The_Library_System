package book_library.services.interfaces;

import book_library.entities.User;

public interface UserService {

    User registerUser(User user);

    User findByUsername(String username);

    User updateUserContactInfo(Long id,String newAddress,String newPhoneNumber);

    void deleteUser(Long id);
}
