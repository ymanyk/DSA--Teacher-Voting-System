package votingSystem;

import adt.ArrayStack;
import entity.TeacherList;
import java.util.Scanner;

/**
 *
 * @author Yong Man Kei
 */
public class Teacher {

    ArrayStack<TeacherList> teacherL = new ArrayStack<>();
    boolean proceedToInvoice = false;

    public String inputString() {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine().toUpperCase();
        return string;
    }

    public inventory eTeacherList(inventory Admin) {

        String ok = "N";
        String t1;
        int index = 0;
        int quan = 0;
        int choice = 0;
        int Subtotal = 0;
        int Total = 0;
        boolean available = false;

        Scanner sc = new Scanner(System.in);

        do {
            do {
                do {
                    Admin.displayList();
                    System.out.print("Please enter teacher ID that you want to vote: ");
                    t1 = inputString();
                    System.out.print("Are you sure?(1(yes)/0(no)): ");
                    quan = sc.nextInt();

                    for (int i = 1; i <= Admin.getList().getTotalLength(); i++) {

                        if (t1.equalsIgnoreCase(Admin.getList().findVariable(i).getTeacherID())) {
                            available = Admin.checkQuantity(t1, quan);
                            index = i;
                            Subtotal += quan;
                            Total += Subtotal;
                            break;
                        } else if (i == Admin.getList().getTotalLength()) {
                            System.out.println("Wrong id");
                            available = false;

                        }

                    }

                } while (available != true);
                    //id name course vote subtotal
                TeacherList tL = new TeacherList( Admin.getList().findVariable(index).getTeacherName(),t1,
                        Admin.getList().findVariable(index).getTeacherCourse(), quan, Total);
                Admin.updateQuantity(t1, quan);
                teacherL.pushM(tL);

                //System.out.println("Add more?(1:yes/0:no)");
                //choice = sc.nextInt();

            } while (quan == 0);

            System.out.println("TeacherID " + "TeacherName" + "\tTeacherCourse   " + " Vote");

            teacherL.peekA();

            //System.out.println("Subtotal Vote of the Teacher: " + Total);

            do {
                System.out.print("Do you want to continue (Y/N)");
                ok = inputString();

                if (ok.equalsIgnoreCase("N")) {
                    teacherL.popM();
                    if (teacherL.isEmpty() != true) {
                        System.out.println("TeacherID " + "TeacherName" + "\tTeacherCourse   " + " Vote");
                        teacherL.peekA();

                    } else {
                        System.out.println("This list is empty now!!!");
                        ok = "Y";
                    }
                }
                if (ok.equalsIgnoreCase("Y")) {
                    System.out.print("Confirm for the vote?(Y/N)");
                    char in = sc.next().charAt(0);
                    in = Character.toUpperCase(in);

                    if (in == 'Y') {
                        System.out.println("Thanks for voting!");
                        proceedToInvoice = true;

                    }
                    if (in == 'N') {
                        proceedToInvoice = false;

                    }
                }
            } while ("N".equalsIgnoreCase(ok));
        } while (proceedToInvoice != true);

        return Admin;

    }

    public boolean isProceedToInvoice() {
        return proceedToInvoice;
    }

    public ArrayStack<TeacherList> getTeacherL() {
        return teacherL;
    }

}
