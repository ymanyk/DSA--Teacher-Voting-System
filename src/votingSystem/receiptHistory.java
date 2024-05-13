package votingSystem;
/**
 * @author Rinisha
 */
import adt.LinkedListForInventory;
import entity.TeacherItemList;
import entity.report;
import java.util.Scanner;

public class receiptHistory {

    LinkedListForInventory<report> ReceiptList = new LinkedListForInventory<report>();
    Scanner Scanner = new Scanner(System.in);

    public void addReceipt(String name, TeacherItemList itemlist) {

        report RList[] = {
            new report(ReceiptList.getTotalLength() + 1, itemlist, name)
        };
        ReceiptList.addReceipt(RList[0]);

    }

    public void displayHistory() {
        if (!ReceiptList.isEmpty()) {
            System.out.printf("%-12s%-20s%-10s%-12s%-8s%n", "ReceiptID", "VoterName", "TotlPay", "Date", "Time");
            ReceiptList.displayReverse();
        } else {
            System.out.println("Your history is empty");
        }
    }

    public void search() {
        String receiptID = "";
        System.out.print("Input Receipt ID:");
        receiptID = Scanner.next();

        boolean found = false;
        int position = 0;
        for (int i = 1; i <= ReceiptList.getTotalLength(); i++) {

            if (receiptID.equals(ReceiptList.findVariable(i).getReceiptID())) {
                found = true;
                position = i;
            }

        }
        System.out.printf("%-12s%-20s%-10s%-12s%-8s%n", "ReceiptID", "VoterName", "TotlPay", "Date", "Time");
        ReceiptList.displayReverse();
        if (!found) {
            System.out.println("not founded in list");
        } else {
            System.out.println("founded, which position at " + position);
            System.out.println(ReceiptList.findVariable(position).displayItemList());
        }
    }

    public void clearAll() {
        ReceiptList.clear();
        System.out.println("You History is clear!");
    }

}
