package com.example.votepam.Models;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("MemberofParl1")
public class DepModel extends ParseObject {
    public static final String KEY_FIRSTNAME = "firstname";
    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "profileImage";
    public static final String KEY_USER = "user";
    public static final String KEY_ID = "password";
    public static final String KEY_BIRTHPLACE = "birthplace";
    public static final String KEY_BIRTHDATE = "birthdate";


    public  String getFirstname() {
        return getString(KEY_FIRSTNAME);
    }

    public void  setFirstname(String value) {
        put(KEY_FIRSTNAME,value);
    }

    public  String getName() {
        return getString(KEY_NAME);
    }

    public void  setName(String value) {
        put(KEY_NAME,value);
    }

    public  String getKeyid() {
        return getString(KEY_ID);
    }

    public void  setKey(String value) {
        put(KEY_ID,value);
    }

    public  String getBirhplace() {
        return getString(KEY_BIRTHPLACE);
    }

    public void  setBirthplace(String value) {
        put(KEY_BIRTHPLACE,value);
    }

    public  String getBirtdate() {
        return getString(KEY_BIRTHDATE);
    }

    public void  setBirthdate(String value) {
        put(KEY_BIRTHDATE,value);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE,parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser parseUser){
        put(KEY_USER,parseUser);
    }
}
