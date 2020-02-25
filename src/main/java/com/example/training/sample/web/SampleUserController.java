package com.example.training.sample.web;

import com.example.training.sample.service.SampleUser;
import com.example.training.sample.service.SampleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ユーザ情報のコントローラクラス.
 */
@Controller
@RequestMapping(path = "/sample/users")
public class SampleUserController {

    // インジェクションポイント
    @Autowired
    private SampleUserService service;

    /**
     * ユーザ情報一覧画面を表示する.
     * @param model
     * @return ユーザ情報一覧画面
     */
    @RequestMapping(path = "/showListPage")
    public String showUserListPage(Model model) {

        // サービス呼び出し(ユーザ一覧を取得する)
        List<SampleUser> userList = service.getUsers();

        // modelにユーザ一覧を格納する
        model.addAttribute("userList", userList);

        // 表示する画面のファイル名を指定する(.htmlは省略可)
        return "sample/UserListPage";
    }

    /**
     * ユーザ情報登録画面を表示する.
     * @param model
     * @return ユーザ情報登録画面
     */
    @RequestMapping(path = "/showCreatePage")
    public String showUserCreatePage(Model model) {

        // フォームを生成する
        SampleUserForm userForm = new SampleUserForm();

        // modelにフォームを格納する
        model.addAttribute("userForm", userForm);

        return "sample/UserCreatePage";
    }

    /**
     * ユーザ情報を新規登録する.
     * @param form
     * @return ユーザ情報一覧画面表示にリダイレクトする
     */
    @RequestMapping(path = "/create")
    public String create(SampleUserForm form) {

        // 入力データ(フォーム)を基に、ユーザ情報を生成する
        SampleUser user = new SampleUser(form.getId(), form.getName(), form.getPassword(), form.getEmailAddress());

        // サービス呼び出し
        service.createUser(user);

        // ユーザ一覧画面表示処理を呼び出す
        return "redirect:/sample/users/showListPage";
    }

    /**
     * ユーザ情報を編集する.
     * @param userId ユーザID
     * @param model
     * @return ユーザ情報編集画面
     */
    @RequestMapping(path = "/edit/{userId}")
    public String edit(@PathVariable("userId") Integer userId, Model model) {
        SampleUser user = service.getUser(userId);
        model.addAttribute("userForm",
                new SampleUserForm(userId, user.getName(), user.getPassword(), user.getEmailAddress()));
        return "sample/UserUpdatePage";
    }

    /**
     * ユーザ情報を更新する.
     * @param form
     * @return ユーザ情報一覧画面表示にリダイレクトする
     */
    @RequestMapping(path = "/update")
    public String update(SampleUserForm form) {
        service.updateUser(new SampleUser(form.getId(), form.getName(), form.getPassword(), form.getEmailAddress()));
        return "redirect:/sample/users/showListPage";
    }

    /**
     * ユーザ情報を削除する.
     * @param userId ユーザID
     * @return ユーザ情報一覧画面表示にリダイレクトする
     */
    @RequestMapping(path = "/delete/{userId}")
    public String delete(@PathVariable("userId") Integer userId) {
        service.deleteUser(userId);
        return "redirect:/sample/users/showListPage";
    }
}
