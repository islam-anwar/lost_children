/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package found_rest_webservice;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import persistence.pojo.Found;
import persistence.pojo.Users;
import reporting_dao.FoundDao;
import user_dao.UserDataRegisterDao;
import utilities.ImageUpload;

/**
 *
 * @author eslam java
 */
@RestController
public class FoundRetrieveWebService {
    
    @Autowired
    private ApplicationContext context;
    
    public @RequestMapping(value = "/foundRetrieve.json", method = RequestMethod.GET)
    List<Found> retrievingFound() {
        
        FoundDao foundDao = context.getBean(FoundDao.class);
        
        return foundDao.findByReturned("no");
    }
    
    public ApplicationContext getContext() {
        return context;
    }
    
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    
}
