/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lost_rest_webservice;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import persistence.pojo.Lost;
import persistence.pojo.Users;
import reporting_dao.LostDao;
import user_dao.UserDataRegisterDao;
import utilities.ImageUpload;

/**
 *
 * @author eslam java
 */
@RestController
public class LostReportingWebService {

    @Autowired
    private ApplicationContext context;
    @Autowired
    ImageUpload imageUpload;

    public @RequestMapping(value = "/lostReport", method = RequestMethod.POST)
    String reportingFound(Lost lost, @RequestParam(value = "email") String email, @RequestParam(value = "image") MultipartFile image) {

        UserDataRegisterDao userDao = context.getBean(UserDataRegisterDao.class);
        LostDao foundDao = context.getBean(LostDao.class);
        Users userData = userDao.findByEmail(email);

        if (userData != null) {

            Date date = new Date();
            lost.setLostUserId(userData);
            String imageUrl = imageUpload.imageUploading(image, email + date.toString() + System.nanoTime(), "lost_images");
            lost.setImageUrl(imageUrl);
            foundDao.save(lost);

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
