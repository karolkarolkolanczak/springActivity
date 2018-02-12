package com.springactivity.services;

import com.springactivity.model.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 13/02/2018.
 */
@Service
public class GenderServiceImpl implements GenderService {
    @Override
    public List<Gender> getListOfGenders() {
        List<Gender> listOfGenders=new ArrayList<>();
        listOfGenders.add(Gender.MALE);
        listOfGenders.add(Gender.FEMALE);
        listOfGenders.add(Gender.UNISEX);
        return listOfGenders;
    }
}
