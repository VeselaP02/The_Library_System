package book_library.services;

import book_library.entities.User;
import book_library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public void registerUser(User user) {

        User foundUser = this.userRepository.findByUsername(user.getUsername());

        if (foundUser == null){
            userRepository.save(user);
        } else {
            throw  new RuntimeException("User is not found");
        }
    }
}
