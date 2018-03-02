package com.springactivity.controllers;

import com.springactivity.model.Picture;
import com.springactivity.model.Product;
import com.springactivity.repositories.PictureRepository;
import com.springactivity.services.PictureService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by a on 18/02/2018.
 */
@Controller
public class AdminAreaController {

    private PictureService pictureService;

    @Autowired
    public AdminAreaController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @RequestMapping("/adminArea")
    String adminArea(Model model){
        model.addAttribute("listOfAllPictures",pictureService.getListOfAllPictures());
        return "adminArea";
    }

    @GetMapping("picture/{id}/image")
    @Transactional
    public void getImageFromDataBase(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Picture picture=new Picture();
        picture=pictureService.getPictureById(id);

        if (picture.getImage() != null) {
            byte[] byteArray = new byte[picture.getImage().length];
            int i = 0;

            for (Byte wrappedByte : picture.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }
            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
