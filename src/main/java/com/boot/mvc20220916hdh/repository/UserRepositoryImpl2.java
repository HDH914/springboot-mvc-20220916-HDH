package com.boot.mvc20220916hdh.repository;

import com.boot.mvc20220916hdh.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("b")
public class UserRepositoryImpl2 implements UserRepository{
    private final List<User> userData;

    public UserRepositoryImpl2(){
        userData = new ArrayList<User>();
        for(int i = 0; i < 5; i++) {
            int index = i + 1;

            User user = User.builder()
                    .user_code(index)
                    .user_id("HDH" + index)
                    .user_password("1234")
                    .user_name("DH" + index)
                    .user_email(index + "sfd@gsdg.sdg")
                    .build();

            userData.add(user);
        }
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public User findUserByUserId(String userId) {
        User user = null;

        for(User userObj : userData){
            if(userObj.getUser_id().equals("userId")){
                user = userObj;
            }
        }
        return user;
    }

    @Override
    public User findUserByUserCode(int userCode) {
        User user = null;

        for(User userObj : userData){
            if(userObj.getUser_code() == userCode){
                user = userObj;
            }
        }

        return user;
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int remove(int userCode) {
        return 0;
    }
}
