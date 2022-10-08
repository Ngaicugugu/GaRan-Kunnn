/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
    static SimpleDateFormat fomater = new SimpleDateFormat();
    public static Date todaDate(String date , String pattern)
    {
        try {
           fomater.applyPattern(pattern);
           return fomater.parse(date);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    public static String toString(Date date , String pattern)
    {
        fomater.applyPattern(pattern);
        return fomater.format(date);
    }
    public static Date addDays(Date date , long days)
    {
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }

    public static Date now() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
