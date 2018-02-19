package com.springactivity.services;

import com.springactivity.model.Picture;
import com.springactivity.model.Product;

import java.util.List;

/**
 * Created by a on 18/02/2018.
 */
public interface PictureService {

    List<Picture> getListOfAllPictures();

    Picture getPictureById(Long pictureId);
}
