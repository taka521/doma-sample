package com.example.service;

import com.example.dao.UserDao;
import com.example.domain.CreatedAt;
import com.example.domain.FirstName;
import com.example.domain.LastName;
import com.example.domain.MailAddress;
import com.example.domain.Password;
import com.example.domain.Sex;
import com.example.domain.UpdatedAt;
import com.example.embeddable.FullName;
import com.example.entity.User;
import com.example.domain.ID;
import com.example.form.UserForm;
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
    public User insert(final UserForm userForm){
        User user = new User(
              ID.notAssigned()
            , Password.of(userForm.getPassword()).toHash()
            , new FullName(
                  FirstName.of(userForm.getFirstName())
                , LastName.of(userForm.getLastName())
                )
            , Sex.of(userForm.getSex())
            , MailAddress.of(userForm.getMailAddress()).toOptional()
            , CreatedAt.getCurrent()
            , UpdatedAt.getCurrent()
        );
        return userDao.insert(user).getEntity();
    }

    @Transactional
    public void delete(final long id){
        User deleteUser = new User(ID.of(id), null, null, null, null, null, null);
        userDao.delete(deleteUser);
    }

    @Transactional
    public User update(final UserForm userForm){
        User updateUser = new User(
              ID.of(userForm.getId())
            , Password.of(userForm.getPassword())
            , new FullName(
                  FirstName.of(userForm.getFirstName())
                , LastName.of(userForm.getLastName())
                )
            , Sex.of(userForm.getSex())
            , MailAddress.of(userForm.getMailAddress()).toOptional()
            , CreatedAt.getCurrent()
            , UpdatedAt.getCurrent()
        );
        return userDao.update(updateUser).getEntity();
    }
}
