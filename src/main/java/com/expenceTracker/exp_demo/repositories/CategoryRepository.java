package com.expenceTracker.exp_demo.repositories;

import com.expenceTracker.exp_demo.domain.Category;
import com.expenceTracker.exp_demo.exceptions.EtBadRequestException;
import com.expenceTracker.exp_demo.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws EtBadRequestException;

    
}
