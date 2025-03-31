package book_library.services;

import book_library.DTO.RegisterDTO;
import book_library.entities.User;
import book_library.exceptions.registration.NotUserFoundException;
import book_library.exceptions.registration.UserAlreadyExistsException;
import book_library.repositories.UserRepository;
import book_library.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static book_library.enums.ExceptionMessages.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

        User userByUsername = this.userRepository.findByUsername(user.getUsername());
        if (userByUsername != null) {
            throw new UserAlreadyExistsException(USER_EXISTS_EXCEPTION);
        }

           return userRepository.save(user);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUserContactInfo(Long userId, String newAddress, String newPhoneNumber) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotUserFoundException(NOT_USER_FOUND_EXCEPTION));

        user.setAddress(newAddress);
        user.setPhoneNumber(newPhoneNumber);

       return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }

}
