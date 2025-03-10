package book_library.services;

import book_library.entities.User;
import book_library.repositories.UserRepository;
import book_library.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {

           return userRepository.save(user);

    }
}
