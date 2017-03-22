package com.example.shivanshu.alumniconnect;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by shivanshu on 3/1/2017.
 */

public class ChatDataHandleClass {
   static List<String> list=new ArrayList<>();
    static List<String> date=new ArrayList<>();

    public static void setList(String s) {


        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        String date1 = df.format(Calendar.getInstance().getTime());
        date.add(date1);
          list.add(s);
    }

    public static List<String> getList() {
        return list;
    }
    public static int chatListLength()
    {
        return list.size();
    }

    public static List<String> getDate() {
        return date;
    }
}
