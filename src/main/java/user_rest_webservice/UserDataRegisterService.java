/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rest_webservice;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import persistence.pojo.Users;
import user_dao.UserDataRegisterDao;

/**
 *
 * @author eslam java
 */
@RestController
public class UserDataRegisterService {

    @Autowired
   private ApplicationContext context;

    public @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    Users register(Users user) {

        UserDataRegisterDao userDao = context.getBean(UserDataRegisterDao.class);
        Users userData = userDao.findByEmail(user.getEmail());

        if (userData!=null) {
            Users userResponse=new Users();
            userResponse.setEmail("Dublicated email");
            return userResponse;
        }

        return userDao.save(user);
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}
