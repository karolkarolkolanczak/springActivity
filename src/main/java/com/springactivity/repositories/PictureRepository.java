package com.springactivity.repositories;


import com.springactivity.model.Picture;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a on 18/02/2018.
 */
public interface PictureRepository extends CrudRepository<Picture, Long> {
}
