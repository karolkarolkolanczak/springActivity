package com.springactivity.services;

import com.springactivity.model.Picture;
import com.springactivity.repositories.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by a on 18/02/2018.
 */
@Service
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;
    private List<Picture>listOFAllPictures;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
    @Override
    public List<Picture> getListOfAllPictures() {
        Iterable<Picture> iterator = pictureRepository.findAll();
        List<Picture> listOFAllPictures = StreamSupport
                .stream(iterator.spliterator(), false)
                .collect(Collectors.toList());
        return listOFAllPictures;
    }

    @Override
    public Picture getPictureById(Long pictureId) {
        Picture picture=new Picture();
        picture=pictureRepository.findOne(pictureId);
        return picture;
    }
}
