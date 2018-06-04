/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package found_rest_webservice;

import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class FoundReportWebService {

    @Autowired
    private ApplicationContext context;
    @Autowired
    ImageUpload imageUpload;

    public @RequestMapping(value = "/foundReport", method = RequestMethod.POST)
    String reportingFound(Found found,@RequestParam(value="email")String email,@RequestParam(value = "image")MultipartFile image){

        UserDataRegisterDao userDao = context.getBean(UserDataRegisterDao.class);
        FoundDao foundDao = context.getBean(FoundDao.class);
        Users userData = userDao.findByEmail(email);
       

        if (userData != null) {
            
           Date date=new Date();
            found.setFoundUserId(userData);
            String imageUrl = imageUpload.imageUploading(image, email+date.toString()+System.nanoTime(), "found_images");
            found.setImageUrl(imageUrl);
            foundDao.save(found);
            
            
            
            
            return "SUCCESS";
        }

        return "FAILED";
    }



    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ImageUpload getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;
    }
}
