package com.springactivity.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by a on 18/02/2018.
 */
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long pictureId;
    private String nameOfPicture;
    @Lob
    private Byte[] image;
    @Transient
    private MultipartFile file;

    public Picture() {
    }

    public Picture(String nameOfPicture, Byte[] image) {
        this.nameOfPicture = nameOfPicture;
        this.image = image;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getNameOfPicture() {
        return nameOfPicture;
    }

    public void setNameOfPicture(String nameOfPicture) {
        this.nameOfPicture = nameOfPicture;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}