package com.example.training.exercise.service;

/**
 * ユーザ情報を保有するクラス.
 */
public class User {

    /**
     * ユーザID.
     */
    private Integer id;

    /**
     * ユーザ名.
     */
    private String name;

    /**
     * パスワード.
     */
    private String password;

    /**
     * メールアドレス.
     */
    private String emailAddress;

    /**
     * コンストラクタ.
     * @param id ユーザID
     * @param name ユーザ名
     * @param password パスワード
     * @param emailAddress メールアドレス
     */
    public User(Integer id, String name, String password, String emailAddress) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    /**
     * ユーザIDを取得する.
     * @return ユーザID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ユーザIDを設定する.
     * @param id ユーザID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ユーザ名を取得する.
     * @return ユーザ名
     */
    public String getName() {
        return name;
    }

    /**
     * ユーザ名を設定する.
     * @param name ユーザ名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * パスワードを取得する.
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを取得する.
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * メールアドレスを取得する.
     * @return メールアドレス
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * メールアドレスを設定する.
     * @param emailAddress メールアドレス
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * オブジェクトのフィールド値を文字列化して返却する.
     * @return フィールド値の文字列表現
     */
    @Override
    public String toString() {
        return "User [ id=" + id + ", name=" + name + ", password=" + password
                + ", emialAddress=" + emailAddress +" ]";
    }

}
