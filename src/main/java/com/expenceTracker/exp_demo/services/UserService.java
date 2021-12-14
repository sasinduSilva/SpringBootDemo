package com.expenceTracker.exp_demo.services;

import com.expenceTracker.exp_demo.domain.User;
import com.expenceTracker.exp_demo.exceptions.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;


}
