package com.elyjah._026_09_29springmvc4;


import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 交易账号密码
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public boolean login(String userName, String password, HttpSession session){
        //账号密码为空
        if (!StringUtils.hasText(userName) || !StringUtils.hasText(password)){
            return false;
        }
        //TODO 还未学习数据库, 暂且写死
//        if ("admin".equals(userName) && "123".equals(password)){
//            session.setAttribute("userName",userName);
//            return true;
//        }
//        return false;
        //仅为了演示cookie和session
        if ("admin".equals(password)){
            session.setAttribute("userName",userName);
            return true;
        }

        return false;
    }

    @GetMapping("/getLoginUser")
    public String getLoginUser(HttpSession session){
        String name = (String) session.getAttribute("userName");
        return name;
    }
}