package com.example.training.sample.mapper;

import com.example.training.sample.service.SampleUser;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ユーザ情報のリポジトリクラス.
 */
@Component
public class SampleUserMapper {

    /**
     * ユーザ情報を取得する.
     * @param userId ユーザID
     * @return ユーザ情報
     */
    public SampleUser select(Integer userId) {
        for (SampleUser user : userList) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 全ユーザ情報を取得する.
     * @return ユーザ一覧
     */
    public List<SampleUser> selectAll() {
        Collections.sort(userList, new UserIdComparator());
        return userList;
    }

    /**
     * ユーザIDの最大値を取得する.
     * @return ユーザIDの最大値
     */
    public int selectMaxUserId() {
        int maxUserId = 0;
        for (SampleUser user : userList) {
            if (maxUserId < user.getId()) {
                maxUserId = user.getId();
            }
        }
        return maxUserId;
    }

    /**
     * ユーザ情報を登録する.
     * @param user ユーザ情報
     */
    public void insert(SampleUser user) {
        userList.add(user);
    }

    /**
     * ユーザ情報を更新する.
     * @param user ユーザ情報
     * @return 更新件数
     */
    public int update(SampleUser user) {
        for (SampleUser u : userList) {
            if (u.getId().equals(user.getId())) {
                userList.remove(u);
                userList.add(user);
                return 1;
            }
        }
        return 0;
    }

    /**
     * ユーザ情報を削除する.
     * @param userId ユーザID
     * @return 更新件数
     */
    public int delete(Integer userId) {
        for (SampleUser user : userList) {
            if (user.getId().equals(userId)) {
                userList.remove(user);
                return 1;
            }
        }
        return 0;
    }

    // ユーザ情報
    private static List<SampleUser> userList = new CopyOnWriteArrayList<>();

    static {
        // Alice
        SampleUser user1 = new SampleUser(1, "Alice", "1234", "alice@example.com");
        userList.add(user1);
        // Bob
        SampleUser user2 = new SampleUser(2, "Bob", "2345", "bob@example.com");
        userList.add(user2);
        // Carol
        SampleUser user3 = new SampleUser(3 , "Carol", "3456", "carol@example.com");
        userList.add(user3);
    }

    static class UserIdComparator implements Comparator<SampleUser> {
        @Override
        public int compare(SampleUser u1, SampleUser u2) {
            return u1.getId() - u2.getId();
        }
    }
}
