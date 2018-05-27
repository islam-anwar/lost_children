/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.File;
import javax.inject.Scope;
import javax.servlet.ServletContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author eslam java
 */
@Component

public class ImageUpload {

    public static final String FILE_IS_EMAPTY = "file is empaty";
    public static final String FILE_CAN_NOT_BE_SAVED = "file can not be saved";

    @Autowired
    ServletContext context;

    public String imageUploading(MultipartFile inputFile, String fileName, String fileLocation) {

        if (!inputFile.isEmpty()) {
            try {
                System.out.println("dasdadadadadadadadadadad" + context.getContextPath());
                String filePath = context.getContextPath() + File.separator + fileLocation + File.separator + fileName + "." + getFileExtension(inputFile.getName());
                File destinationFile = new File(filePath);

                inputFile.transferTo(destinationFile);

                return filePath;
            } catch (Exception e) {

                e.printStackTrace();
                return FILE_CAN_NOT_BE_SAVED;
            }
        } else {
            return FILE_IS_EMAPTY;
        }
    }

    public String getFileExtension(String fileName) {

        if (fileName != null) {
           return FilenameUtils.getExtension(fileName);
        }
        return null;
    }

}
