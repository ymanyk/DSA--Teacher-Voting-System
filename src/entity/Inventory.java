/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 * @author Rinisha
 */
public class Inventory {
    private  int count;
    private String TeacherID;
    private String TeacherName;
    private String TeacherCourse;
    private int Vote;
     
     public Inventory(){
        
        this(0,"     ", "        ",999);
    }

    public Inventory(int count,String TeacherName, String TeacherCourse, int Vote){
        this.count = count;
        this.TeacherID = String.format("T%03d",count);    
        this.TeacherName=TeacherName;
        this.TeacherCourse=TeacherCourse;
        this.Vote=Vote;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

       public String getTeacherID() {
        return TeacherID;
    }
    
     public void setTeacherID(String TeacherID) {
        this.TeacherID = TeacherID;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    public int getVote() {
        return Vote;
    }

    public void setVote(int Vote) {
        this.Vote = Vote;
    }

    public String getTeacherCourse() {
        return TeacherCourse;
    }

    public void setTeacherCourse(String TeacherCourse) {
        this.TeacherCourse = TeacherCourse;
    }


//"%-8s%-26s%-15s%-8s%n"

    @Override
    public String toString() {
      return String.format("%-14s",TeacherID) + String.format("%-26s",TeacherName) + String.format("%-30s",TeacherCourse) + String.format("%-15s",Vote)+ "\n";}
  
}
