package entity;
/**
 * @author Rinisha
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class report {

    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("HH:mm:ss");

    private int count = 1;
    private String receiptID;
    private String VoterName;
    private TeacherItemList itemlist;

    private String date;
    private String Time;

    public report(int count, TeacherItemList itemlist, String VoterName) {
        this.count = count;
        this.receiptID = String.format("R%03d", count);
        this.itemlist = itemlist;
        this.VoterName = VoterName;

        this.date = myDateObj.format(myFormatObj);
        this.Time = myDateObj.format(myFormatObj2);
    }

//"%-8s%-26s%-15s%-8s%n"
    public TeacherItemList getItemlist() {
        return itemlist;
    }

    public void setItemlist(TeacherItemList itemlist) {
        this.itemlist = itemlist;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(String receiptID) {
        this.receiptID = receiptID;
    }

    public String getVoterName() {
        return VoterName;
    }

    public void setVoterName(String voterName) {
        VoterName = voterName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String displayItemList() {
        return "------------------Teacher List-------------------\n" + "ID\tName\t\tCourse\tVote\tTotal\n" + itemlist.toString();
    }

    //"-----------Item List------------\n"+"ID\tName\t\tPrice\tQty\tTotal\n"+ itemlist.toString()
    @Override
    public String toString() {
        return String.format("%-12s", receiptID) + String.format("%-20s", VoterName) + String.format("%-12s", date) + String.format("%-8s", Time)
                + "\n";
    }
}
