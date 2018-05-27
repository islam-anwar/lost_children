/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rest_webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import persistence.pojo.Users;
import user.dto.LogInDataDto;
import user_dao.UserDataRegisterDao;
import user_dao.UserLogInDao;

/**
 *
 * @author eslam java
 */
@RestController
@Scope(value = "prototype")

public class UserLogInService {

    @Autowired
    private ApplicationContext context;

    public @RequestMapping(value = "/login.json", method = RequestMethod.POST)
    LogInDataDto register(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {

        UserLogInDao userLoginDao = context.getBean(UserLogInDao.class);
        Users userData = userLoginDao.findByEmailAndPassword(email, password);
        LogInDataDto loginData = context.getBean(LogInDataDto.class);
        if (userData == null) {

            loginData.setStatus("FAILED");
            return loginData;
        } else {
            loginData.setStatus("SUCCESS");
            loginData.setUser(userData);
            return loginData;
        }

    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}
