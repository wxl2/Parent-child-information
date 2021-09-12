package com.example.infantcare.service;

import com.example.infantcare.dao.UserDao;
import com.example.infantcare.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserService {
    @Autowired
    private UserDao userDao;
    public User login(User user){
        User user_ = getUser(user.getUsername());
        if(user_!=null){
            if(user.getPasswd().equals(user_.getPasswd())){
                return user_;
            }else {
                return null;
            }
        }
        return null;
    }

    public int register(User user){
       try {
           userDao.insertUser(user);
           return 0;
       }catch (Exception e){
           e.printStackTrace();
           return -1;
       }
    }

    public User getUser(String username){
        try {
            User userExist = (User) userDao.getUserByUserName(username);
            if(userExist!=null){
                return userExist;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public int setAddrAndPhone(String username,String addr,String phone){
        try{
            userDao.updatePhoneAddr(phone,addr,username);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
