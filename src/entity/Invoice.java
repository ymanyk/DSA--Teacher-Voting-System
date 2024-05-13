/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;  // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;  // Import the DateTimeFormatter class

/**
 *
 * @author Yong Man Kei
 */
public class Invoice {
    LocalDateTime myDateObj = LocalDateTime.now();  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("HH:mm:ss"); 
    private TeacherItemList itemList;
    private String voterName;
    private String date;
    private String time;
    private int total;

    

    public Invoice(TeacherItemList itemList, String voterName) {
        
        this.itemList = itemList;
        this.voterName = voterName;
        this.date = myDateObj.format(myFormatObj);
        this.time = myDateObj.format(myFormatObj2);
    }


    public TeacherItemList getItemList() {
        return itemList;
    }

    public String getVoterName() {
        return voterName;
    }


    public int getTotal() {
        return total;
    }
    
    @Override
    public String toString(){
        String string = 
        "\n==============================================\n"+
        "                     Record                     \n"+
        "================================================\n"+
        "Date: "+date+"\n"+
        "Time: "+time+"\n"+
        "Teacher List\n"+
        "-------------\n"+
        "ID\tName\t\t   Course\t   Vote\n"+
        itemList.toString() + "\n" +
        "================================================\n";

        return string;
    }

    public String displayReceipt(){
        String string3 = 
        "\n==============================================\n"+
        "                    Receipt                     \n"+
        "================================================\n"+
        "Date: "+myDateObj.format(myFormatObj)+"\n"+
        "Time: "+myDateObj.format(myFormatObj2)+"\n"+
        "\n"+
        "Voter Name:"+ voterName + "\n"+    
        "\n"+
        "Teacher List\n"+
        "-------------\n"+
        "ID\tName\t\t   Course\t   Vote\n"+
        itemList.toString() + "\n" +
        "================================================\n";
        
        return string3;
    }
    
}