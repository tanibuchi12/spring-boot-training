package com.example.training.sample.service;

import com.example.training.sample.mapper.SampleUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ユーザ情報のサービスクラス
 */
@Service
public class SampleUserService {

    @Autowired
    private SampleUserMapper mapper;

    /**
     * ユーザ情報を取得する.
     * @param userId ユーザID
     * @return ユーザ情報
     */
    public SampleUser getUser(Integer userId) {
        return mapper.select(userId);
    }

    /**
     * 全ユーザ情報を取得する.
     * @return ユーザ一覧
     */
    public List<SampleUser> getUsers() {
        return mapper.selectAll();
    }

    /**
     * ユーザ情報を登録する.
     * @param user ユーザ情報
     * @return 登録済みユーザ情報
     */
    public SampleUser createUser(SampleUser user) {
        int maxUserId = mapper.selectMaxUserId();
        user.setId(maxUserId + 1);
        mapper.insert(user);
        return user;
    }

    /**
     * ユーザ情報を更新する.
     * @param user
     */
    public void updateUser(SampleUser user) {
        int result = mapper.update(user);
    }

    /**
     * ユーザ情報を削除する.
     * @param userId ユーザID
     */
    public void deleteUser(Integer userId) {
        int result = mapper.delete(userId);
    }
}
