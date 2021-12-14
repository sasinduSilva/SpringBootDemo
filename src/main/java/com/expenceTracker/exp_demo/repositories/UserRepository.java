package com.expenceTracker.exp_demo.repositories;

import com.expenceTracker.exp_demo.domain.User;
import com.expenceTracker.exp_demo.exceptions.EtAuthException;

public interface UserRepository {

    Integer create(String firstName,String lastName, String email, String password) throws EtAuthException;

    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
