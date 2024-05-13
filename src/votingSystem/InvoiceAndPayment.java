package votingSystem;

import entity.TeacherItemList;
import adt.ArrayStack;
import entity.Invoice;
import entity.TeacherList;
import java.util.Scanner;

/**
 *
 * @author Yong Man Kei
 */
public class InvoiceAndPayment {

    Scanner input = new Scanner(System.in);
    TeacherItemList itemList = new TeacherItemList();
    Invoice invoice;
    ArrayStack<TeacherList> teacherL;
    boolean successfulTransaction;

    public TeacherItemList getItemList() {
        return itemList;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setItemList(TeacherItemList itemList) {
        this.itemList = itemList;
    }

    public InvoiceAndPayment(ArrayStack<TeacherList> teacherL, String voterName) {
        this.teacherL = teacherL;
        int topIndex = teacherL.getTopIndex();
        for (int i = 0; i <= topIndex; i++) {
            itemList.addItemList(teacherL.popM());
        }

        invoice = new Invoice(itemList, voterName);

        System.out.println(invoice.toString());

        int userChosen = 0;
        do {
            System.out.println("press 1 proceed to the next step\n"
                    + "Input : ");
            userChosen = input.nextInt();
        } while (userChosen != 0 && userChosen != 1);

        if (userChosen == 1) {
            successfulTransaction = payment(invoice.getTotal());

            if (successfulTransaction == false) {
                System.out.println("Invalid");
            } else {
                char userChosen2 = 0;
                do {
                    System.out.println("\n Press Y to see the receipt?");
                    userChosen2 = input.next().charAt(0);
                    userChosen2 = Character.toUpperCase(userChosen2);

                } while (userChosen2 != 'Y' && userChosen2 != 'N');
                if (userChosen2 == 'Y') {
                    System.out.println(invoice.displayReceipt());
                }
            }

        }
    }

    public String inputItemID() {
        Scanner input = new Scanner(System.in);
        String itemID = input.nextLine();

        return itemID;
    }

    public boolean isSuccessfulTransaction() {
        return successfulTransaction;
    }

    public boolean payment(int total) {
        boolean successfulTranscation = false;
        String cashInterface
                = "See the vote record?(1(yes)/0(no))\n"
                + "Input : ";

        int userChosen = 0;
        do {
            System.out.println(cashInterface);
            userChosen = input.nextInt();

        } while (userChosen != 0 && userChosen != 1);
        if (userChosen == 1) {
            successfulTranscation = true;
        }

        return successfulTranscation;
    }

}
