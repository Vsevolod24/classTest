package by.overone.project.Service;

import by.overone.project.Repository.UserRepository;
import by.overone.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    // for delete statement
    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    // for edition statement
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("user id not found"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
