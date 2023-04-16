package com.degtu.cowid_19casesdata;

public class User {

    private String name,phone,profileImage;
    private int likes;

    public User(int likes){
        this.likes = likes;
    }

    public User(String name,String phone){
        this.name = name;
        this.phone = phone;
    }

    public User(String name, String phone, String profileImage) {
        this.name = name;
        this.phone = phone;
        this.profileImage = profileImage;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
