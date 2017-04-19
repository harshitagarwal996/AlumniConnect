package com.example.shivanshu.alumniconnect;

/**
 * Created by shivanshu on 4/6/2017.
 */

public class CompanyServerListHandle {
        String Id;
        String Title;
        String Contact;
    String image;
        public static int TotalItem=0;
        CompanyServerListHandle(String CompanyName,String Durration,String imageurl)
        {
            Id=CompanyName;
            Title=Durration;
            image=imageurl;
        }

        public  String getImage() {
            return image;
        }

        public String getTitle() {
            return Title;
        }

        public String getId() {
            return Id;
        }
    }

