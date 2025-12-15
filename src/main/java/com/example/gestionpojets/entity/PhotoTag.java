package com.example.gestionpojets.entity;

public class PhotoTag {
    private int photoId;
    private int tagId;

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public PhotoTag(int photoId, int tagId) {
        this.photoId = photoId;
        this.tagId = tagId;
    }
}
