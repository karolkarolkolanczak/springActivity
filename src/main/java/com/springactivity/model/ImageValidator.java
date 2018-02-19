package com.springactivity.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by a on 20/02/2018.
 */
public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {
   public void initialize(Image constraint) {
   }

   public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
      System.out.println("size: "+file.getSize());
      if(file.getSize()>=5245329){
         return false;
      }
      else return true;
   }
}
