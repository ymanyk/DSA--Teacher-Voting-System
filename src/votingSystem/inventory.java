package votingSystem;
/**
 * @author Rinisha
 */

import adt.LinkedListForInventory;
import entity.Inventory;
import java.util.Scanner;

public class inventory {

    Scanner Scanner = new Scanner(System.in);
    Scanner Obj = new Scanner(System.in);
    LinkedListForInventory<Inventory> InventoryList = new LinkedListForInventory<Inventory>();

    public void addInventory() {
        Inventory IList[] = {
            new Inventory(001, "Thamarai", "Data Structure and Algorithms", 0),
            new Inventory(002, "Chong Voon Nian", "Advanced Decrete Maths", 0),
            new Inventory(003, "Kaw Kai Xiang", "Pendidikan Moral", 0),
            new Inventory(004, "Chong Yun Long", "Database Management", 0),
            new Inventory(005, "Teoh Jia Hao", "Pendidikan Sivic", 0),};
        for (int i = 0; i < IList.length; i++) {
            InventoryList.addNewItem(IList[i]);
        }
    }

    public LinkedListForInventory<Inventory> getList() {
        return InventoryList;
    }

    public void reverse() {
        InventoryList.displayReverse();
    }

    public void displayList() {
        if (!InventoryList.isEmpty()) {
            System.out.printf("%-14s%-26s%-30s%-20s%n", "TeacherID", "TeacherName", "TeacherCourse", "Vote");
            InventoryList.display();
            //System.out.println("Total vote numbers:" + InventoryList.getTotalLength());
        } else {
            System.out.println("List is empty");
        }
    }

    public void addNewTeacher() {
        String name = "";
        String choose;
        int position = 0;
        String course = "";
        int vote = 0;
        double itemprice = 0.00;
        System.out.print("Input Teacher Name: ");
        name = Scanner.nextLine();
        System.out.print("Input Teacher Course: ");
        course = Scanner.nextLine();

        Inventory List[] = {
            new Inventory(InventoryList.getTotalLength() + 1, name, course, vote)
        };
        System.out.print("choose position?(Y/N)");
        choose = Scanner.next();
        if (choose.toUpperCase().equals("N")) {

            InventoryList.addNewItem(List[0]);
        } else {
           System.out.print("input position (previous number: " + InventoryList.getTotalLength() +")" +"[Key in the next number]: ");
            position = Scanner.nextInt();

            InventoryList.add(position, List[0]);

        }
        System.out.printf("%-14s%-26s%-30s%-20s%n", "TeacherID", "TeacherName", "TeacherCourse", "Vote");
        InventoryList.display();
    }

    public void removeTeacher() {
        int position = 0;
       System.out.print("Remove which position?(current number: " + InventoryList.getTotalLength() +"): ");
        position = Scanner.nextInt();
        InventoryList.removeItem(position);
        System.out.printf("%-14s%-26s%-30s%-20s%n", "TeacherID", "TeacherName", "TeacherCourse", "Vote");
        InventoryList.display();
    }

  
    public void searchTeacher() {
        String TeacherName = "";
        System.out.println("Input Name:");
        TeacherName = Scanner.next();
        boolean found = false;
        int position = 0;
        for (int i = 1; i <= InventoryList.getTotalLength(); i++) {

            if (TeacherName.equals(InventoryList.findVariable(i).getTeacherName())) {
                found = true;
                position = i;
            }

        }
        System.out.printf("%-8s%-26s%-15s%-8s%n", "TeacherID", "TeacherName", "TeacherCourse", "Vote");
        InventoryList.display();
        if (!found) {
            System.out.println("not founded in list");
        } else {
            System.out.println("founded, which position at " + position);
        }
    }

    public void clearAllList() {
        InventoryList.clear();
        System.out.println("You Inventory now is clear!");
    }

    //this function is for shuhan part, once medecine list done,can use this function minus inventory's quanity
    public void updateQuantity(String teacherid, int vote) {

        for (int i = 1; i <= InventoryList.getTotalLength(); i++) {
            if (teacherid.equals(InventoryList.findVariable(i).getTeacherID())) {

                int id = InventoryList.findVariable(i).getCount();
                String Name = InventoryList.findVariable(i).getTeacherName();
                String Course = InventoryList.findVariable(i).getTeacherCourse();
                int Vote = InventoryList.findVariable(i).getVote();

                Vote = Vote + vote;
                if (Vote < 0) {
                    System.out.println("Vote not enough.");
                } else {
                    Inventory RList[] = {
                        new Inventory(id, Name, Course, Vote)
                    };
                    InventoryList.update(i, RList[0]);
                }
            }
        }
    }

    public void addBackQuantity(String teacherid, int vote) {

        for (int i = 1; i <= InventoryList.getTotalLength(); i++) {
            if (teacherid.equals(InventoryList.findVariable(i).getTeacherID())) {

                int id = InventoryList.findVariable(i).getCount();
                String Name = InventoryList.findVariable(i).getTeacherName();
                String Course = InventoryList.findVariable(i).getTeacherCourse();
                int Vote = InventoryList.findVariable(i).getVote();

                Vote = Vote - vote;

                Inventory RList[] = {
                    new Inventory(id, Name, Course, Vote)
                };
                InventoryList.update(i, RList[0]);

            }
        }
    }

    public boolean checkQuantity(String teacherid, int vote) {
        boolean check = false;
        for (int i = 1; i <= InventoryList.getTotalLength(); i++) {
            if (teacherid.equals(InventoryList.findVariable(i).getTeacherID())) {
                int Vote = InventoryList.findVariable(i).getVote();

                Vote = Vote + vote;
                if (Vote < 0) {
                    System.out.println("Vote not enough.");
                    check = false;
                    break;
                } else {
                    check = true;
                    break;
                }

            }
        }
        return check;
    }
}
