package entity;

/**
 *
 * @author Yong Man Kei
 */
public class EachTeacherList {

    private String teacherID;
    private String teacherName;
    private String teacherCourse;
    private int vote;
    private int subtotal;

    public EachTeacherList(String teacherID, String teacherName, String teacherCourse, int vote, int subtotal) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherCourse = teacherCourse;
        this.vote = vote;
        this.subtotal = subtotal;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(String teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
    
    public void calSubtotal(){
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        String string = String.format("%-8s%-18s%-20s%8s", teacherID, teacherName,teacherCourse, vote);
        return string;
    }

}
