
package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("userController")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询list集合
     * @return
     */
    @RequestMapping("selectUserList")
    @ResponseBody
    public List<User> selectUserList(){
        List<User> list=userService.selectUser();
        return list;
    }


}