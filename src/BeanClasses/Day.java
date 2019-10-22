/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

/**
 *
 * @author ali.ashique
 */
public class Day {
    private DAYS dayName;
    private String time;
    public enum DAYS{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};

    public Day() {
    }
    
    public Day(DAYS dayName, String time) {
        this.dayName = dayName;
        this.time = time;
    }
    
    public DAYS getDayName() {
        return dayName;
    }

    public void setDayName(DAYS dayName) {
        this.dayName = dayName;
    }
    
    public void setDayName(String dayName) {
        for(DAYS d:DAYS.values()){
            if(d.toString().equals(dayName)){
                this.dayName = d;
                break;
            }
        }
    }
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
