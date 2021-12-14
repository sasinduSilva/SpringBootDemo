package com.expenceTracker.exp_demo.services.ServiceImpl;

import com.expenceTracker.exp_demo.domain.User;
import com.expenceTracker.exp_demo.exceptions.EtAuthException;
import com.expenceTracker.exp_demo.repositories.UserRepository;
import com.expenceTracker.exp_demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if (email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email,password);

    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new EtAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email already in user");
        Integer userId = userRepository.create(firstName,lastName,email,password);
        return userRepository.findById(userId);
    }
}
