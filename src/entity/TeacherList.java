/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yong Man Kei
 */
public class TeacherList {

    private String TeacherId;
    private String TeacherName;
    private String TeacherCourse;
    private int Vote;
    private int Subtotal;

    public TeacherList(String TeacherName, String TeacherId, String TeacherCourse, int Vote, int Subtotal) {
        this.TeacherName = TeacherName;
        this.TeacherId = TeacherId;
        this.TeacherCourse = TeacherCourse;
        this.Vote = Vote;
        this.Subtotal = Subtotal;
    }

    public TeacherList() {

    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public int getVote() {
        return Vote;
    }

    public int getSubtotal() {
        return Subtotal;
    }

    public void setTeacherId(String TeacherId) {
        this.TeacherId = TeacherId;
    }

    public void setVote(int Vote) {
        this.Vote = Vote;
    }

    public void setSubtotal(int Subtotal) {
        this.Subtotal = Subtotal;
    }

    public String getTeacherCourse() {
        return TeacherCourse;
    }

    public void setTeacherCourse(String TeacherCourse) {
        this.TeacherCourse = TeacherCourse;
    }

    @Override
    public String toString() {

        return String.format("%-10s%-18s%-15s%-15s", TeacherId, TeacherName,TeacherCourse, Vote);
    }
    
    
}
