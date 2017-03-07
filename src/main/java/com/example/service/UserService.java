package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.domain.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll(Collectors.toList());
    }

    public Optional<User> findById(final long id){
        return userDao.findById(ID.of(id));
    }

    @Transactional
    public User insert(final User user){
        return userDao.insert(user).getEntity();
    }

    @Transactional
    public void delete(final User user){
        userDao.delete(user);
    }

    @Transactional
    public User update(final User user){
        return userDao.update(user).getEntity();
    }
}
