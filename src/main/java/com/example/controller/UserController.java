package com.example.controller;

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

    /** ユーザ一覧画面へのリダイレクト指定 */
    private static final String REDIRECT_USR_LIST = "redirect:/user/list";

    @Autowired
    private UserService userService;

    @ModelAttribute
    UserForm setUserForm(){
        return new UserForm();
    }

    /**
     * ユーザ一覧取得リクエスト
     *
     * @param model モデル
     * @return 一覧画面用のビュー名。
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
     * @return ユーザ登録用のビュー名
     */
    @GetMapping(path = "/create")
    String create(){
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
                return REDIRECT_USR_LIST;
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
    String insert(@Validated final UserForm userForm, final BindingResult result, final Model model){

        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return create();
        }

        userService.insert(userForm);
        return REDIRECT_USR_LIST;
    }

    /**
     * ユーザ更新リクエスト
     *
     * @param userForm ユーザフォーム
     * @param result 入力チェック結果
     * @param model モデル
     * @return ビュー名。
     */
    @PostMapping(path = "/update")
    String update(@Validated final UserForm userForm, final BindingResult result, final Model model){

        // エラーチェック
        if(result.hasErrors()){
            return getUser(userForm, model);
        }

        try {
            userService.update(userForm);
        }catch (SqlExecutionException e){
            model.addAttribute("errorMsg", "更新に失敗しました。");
            return getUser(userForm, model);
        }

        return REDIRECT_USR_LIST;
    }

    /**
     * ユーザ削除リクエスト
     *
     * @param userForm ユーザフォーム
     * @param model モデル
     * @return ビュー名。
     */
    @PostMapping(path = "/delete")
    String delete(final UserForm userForm, final Model model){

        try {
            userService.delete(userForm.getId());
        }catch (SqlExecutionException e){
            model.addAttribute("errorMsg", "削除に失敗しました");
            return getUser(userForm, model);
        }

        return REDIRECT_USR_LIST;
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
        userForm.setMailAddress(user.mailAddress.map(m -> m.getValue()).orElse(null));
        userForm.setSex(user.sex.getValue());
        userForm.setPassword(user.password.getValue());
        return userForm;
    }
}
