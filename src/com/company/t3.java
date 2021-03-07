package com.company;


import java.time.LocalDate;
import java.util.Calendar;

public class t3 {

    public static void main(String[] args) {

        String id= "412724200001015412";
        String age="";

        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH)+1;
        int dayNow = cal.get(Calendar.DATE);

        int year =Integer.parseInt(id.substring(6,10));
     //   int year = Integer.valueOf(id.substring(6, 10));
        int month = Integer.valueOf(id.substring(10,12));
        int day = Integer.valueOf(id.substring(12,14));

        if ((month < monthNow) || (month == monthNow && day<= dayNow) ){
            age = String.valueOf(yearNow - year);
        }else {
            age = String.valueOf(yearNow - year-1);
        }
        int a = Integer.parseInt(age);

//        System.out.println(age);
//        System.out.println(a);

        LocalDate localDate =  LocalDate.now();
       // System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        //System.out.println(localDate);

    }


}


