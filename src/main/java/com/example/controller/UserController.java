package com.example.controller;

import com.example.domain.CreatedAt;
import com.example.domain.FirstName;
import com.example.domain.ID;
import com.example.domain.LastName;
import com.example.domain.MailAddress;
import com.example.domain.Password;
import com.example.domain.Sex;
import com.example.domain.UpdatedAt;
import com.example.embeddable.FullName;
import com.example.entity.User;
import com.example.form.UserForm;
import com.example.service.UserService;
import org.seasar.doma.jdbc.SqlExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute
    UserForm setUserForm(){
        return new UserForm();
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping(path = "/list")
    String getList(Model model){
        List<UserForm> users = userService.findAll().parallelStream().map( u ->
            this.entityToForm(u)
        ).collect(Collectors.toList());

        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * ユーザ登録画面呼び出しメソッド
     *
     * @return ユーザ登録用のView名
     */
    @GetMapping(path = "/create")
    String create(Model model){
        return "user/create";
    }

    /**
     * 編集リクエスト
     *
     * @param userForm ユーザフォーム
     * @param model モデル
     * @return 編集画面のビュー名
     */
    @RequestMapping(path = "/edit")
    String getUser(final UserForm userForm, final Model model){
        return userService.findById(userForm.getId())
            .map( u -> model.addAttribute("user", entityToForm(u)))
            .map( m -> "user/edit")
            .orElseGet( () -> {
                model.addAttribute("errorMsg", "ユーザの取得に失敗しました。");
                return "redirect:user/list";
            });
    }

    /**
     * ユーザ登録メソッド
     *
     * @param userForm ユーザフォーム
     * @param result バインド結果
     * @return リダイレクト先
     */
    @PostMapping(path = "/add")
    String insert(@Validated final UserForm userForm, final BindingResult result){
        userService.insert(formToEntity(userForm));
        return "redirect:user/list";
    }

    /**
     *
     * @param userForm
     * @param result
     * @param model
     * @return
     */
    @PostMapping(path = "/update")
    String update(@Validated final UserForm userForm, final BindingResult result, final Model model){

        // エラーチェック
        if(result.hasErrors()){
            return getUser(userForm, model);
        }

        try {
            userService.update(formToEntity(userForm));
        }catch (SqlExecutionException e){
            model.addAttribute("errorMsg", "更新に失敗しました。");
            return getUser(userForm, model);
        }

        return "redirect:/user/list";
    }

    /**
     *
     * @param userForm
     * @param model
     * @return
     */
    @PostMapping(path = "/delete")
    String delete(final UserForm userForm, final Model model){

        try {
            userService.delete(this.formToEntity(userForm));
        }catch (SqlExecutionException e){
            model.addAttribute("errorMsg", "削除に失敗しました");
            return getUser(userForm, model);
        }

        return "redirect:user/list";
    }

    /**
     * Formオブジェクトから、エンティティオブジェクトへ変換を行います。
     *
     * @param userForm ユーザフォーム
     * @return ユーザエンティティ
     */
    private User formToEntity(final UserForm userForm){
        ID<User> id = userForm.getId() != 0L  ? ID.of(userForm.getId()) : ID.notAssigned();

        User user = new User(
                id,
                Password.of(userForm.getPassword()),
                new FullName(
                    FirstName.of(userForm.getFirstName()),
                    LastName.of(userForm.getLastName())
                ),
                Sex.of(userForm.getSex()),
                MailAddress.of(userForm.getMailAddress()).toOptional(),
                CreatedAt.getCurrent(),
                UpdatedAt.getCurrent()
        );

        return user;
    }

    /**
     * Userエンティティから、UserFormへ変換を行います。
     *
     * @param user Userエンティティ
     * @return UserForm
     */
    private UserForm entityToForm(final User user){
        UserForm userForm = new UserForm();
        userForm.setId(user.id.getValue());
        userForm.setFirstName(user.fullName.getFirstName().getValue());
        userForm.setLastName(user.fullName.getLastName().getValue());
        userForm.setMailAddress(user.mailAddress.map(m -> m.getValue()).orElse(""));
        userForm.setSex(user.sex.getValue());
        userForm.setPassword(user.password.getValue());
        return userForm;
    }
}
