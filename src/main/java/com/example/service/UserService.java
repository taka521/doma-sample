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

/**
 * Userサービスクラス
 */
@Service
public class UserService {

    /** ユーザDao */
    @Autowired
    private UserDao userDao;

    /**
     * 全件検索を行います。
     * <p>
     *     検索結果が0件の場合、空のListが返却されます。
     * </p>
     *
     * @return ユーザリスト
     */
    public List<User> findAll(){
        return userDao.findAll(Collectors.toList());
    }

    /**
     * id検索を行います。
     *
     * @param id 検索id
     * @return Optionalでラップしたユーザ
     */
    public Optional<User> findById(final long id){
        return userDao.findById(ID.of(id));
    }

    /**
     * ユーザ登録を行います。
     *
     * @param userForm ユーザフォーム
     * @return 登録したユーザの、Userインスタンス
     *
     */
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

    /**
     * ユーザの削除を行います。
     *
     * @param id 削除対象ユーザのid
     */
    @Transactional
    public void delete(final long id){
        User deleteUser = new User(ID.of(id), null, null, null, null, null, null);
        userDao.delete(deleteUser);
    }

    /**
     * ユーザの更新を行います。
     *
     * @param userForm ユーザフォーム
     * @return 更新を行ったユーザの、Userインスタンス
     */
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
