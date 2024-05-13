/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latestassign;

import java.util.Scanner;

import votingSystem.WaitingQueue;
import votingSystem.InvoiceAndPayment;
import votingSystem.Teacher;
import votingSystem.voterdriver;
import votingSystem.inventory;
import votingSystem.receiptHistory;
import entity.Voter;
import entity.Voter_Queue;

import java.util.Scanner;

/**
 *
 * @author ymk
 */
public class LATESTASSIGN {

static boolean exitstatus = false;
    static boolean exitsystem = false;
    static String choose;
    static String Systemchoose;
    static String newVoter;
    static String dequeueName;
    static boolean valid = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //call voterdriver
        voterdriver v = new voterdriver();
        Voter_Queue q1 = new Voter_Queue();
        WaitingQueue wq = new WaitingQueue();
        Teacher t = new Teacher();
        inventory Admin = new inventory();
        receiptHistory admin = new receiptHistory();
        boolean successfulTransaction = false;

        Admin.addInventory();
        v.existingVoterList();

        do {

            System.out.println("\n=========================TARUMT voting System===============================");
            System.out.println("Plaese Select one 1-4");
            System.out.println("1.Voter Registration");
            System.out.println("2.Admin Login");
            System.out.println("3.Waiting System");
            System.out.println("4.Exit TARUMT voting System");
            System.out.println("==============================================================================\n");
            System.out.print("SELECTION:");
            Systemchoose = scan.nextLine();
            switch (Systemchoose) {
                case "1"://register
                    System.out.println("Welcome TARUMT voting system");
                    do {
                        System.out.println("\n=========================Voter Register System===============================");
                        System.out.println("1. Register");
                        System.out.println("2. Exit Voter Registration\n");
                        System.out.print("Voter Register System:");
                        choose = scan.nextLine();
                        Voter Voter1 = new Voter();
                        if (choose.equals("1")) {
                            do {
                                // System.out.println("\nNew Voter Register");
                                System.out.print("New Voter?(Y/N):");
                                newVoter = scan.nextLine();
                                if (newVoter.equals("Y") || newVoter.equals("y")) {
                                    Voter1 = v.addVoterToList();
                                    valid = false;
                                } else if (newVoter.equals("N") || newVoter.equals("n")) {
                                    Voter1 = v.validVoter();
                                    valid = false;
                                } else {
                                    System.out.println("Please Input Y/N only\n");
                                    valid = true;
                                }
                            } while (valid);

                            String userChoosen;
                            System.out.print("\nIs voter ready to be vote? (Y/N):");
                            userChoosen = scan.nextLine();
                            if (userChoosen.equals("Y") || userChoosen.equals("y")) {
                                wq.pushEVoter(Voter1);

                                wq.display();
                                System.out.println(Voter1.getVoterName() + " get ready to vote");

                                dequeueName = wq.popEVoter().getVoterName();
                                boolean emptyVoter = wq.isEmptyVoter();
                                if (emptyVoter != true) {
                                    System.out.println("Proceed to Teacher List");

                                    Admin = t.eTeacherList(Admin);

                                    if (t.getTeacherL().getTopIndex() != -1) {
                                        InvoiceAndPayment p1 = new InvoiceAndPayment(t.getTeacherL(), dequeueName);
                                        successfulTransaction = p1.isSuccessfulTransaction();
                                        if (successfulTransaction == true) {
                                            admin.addReceipt(p1.getInvoice().getVoterName(), p1.getInvoice().getItemList());
                                        }
                                    } else {
                                        System.out.println("Invalid input!");
                                    }

                                } else {
                                }
                            } else if (userChoosen.equals("N") || userChoosen.equals("n")) {
                                boolean exit = false;
                                //enqueue
                                q1.enqueue(Voter1);
                                wq.pushVoter(Voter1);

                            }

                            System.out.println("More Voter need Register?(Y/N)");

                            userChoosen = scan.nextLine();
                            if (userChoosen.equals("Y") || userChoosen.equals("y")) {
                                exitstatus = false;
                            } else if (userChoosen.equals("N") || userChoosen.equals("n")) {
                                exitstatus = true;
                            }

                        } else if (choose.equals("2")) {
                            exitstatus = true;
                        } else {
                            System.out.println("Please key in 1 or 2");
                            exitstatus = false;
                        }
                    } while (!exitstatus);
                    break;

                case "2":
                    do {
                        String userChoosen;

                        System.out.println("\n=========================Admin Site===============================");
                        System.out.println("1. Invertory Management");
                        System.out.println("2. Voter Management");
                        System.out.println("3. Receipt Record");
                        System.out.println("4. Exit Admin Site");
                        System.out.print("\nAdmin Site:");
                        userChoosen = scan.nextLine();
                        switch (userChoosen) {

                            case "1":
                                Scanner Scanner = new Scanner(System.in);

                                boolean choice = false;
                                do {
                                    System.out.println("===================Inventory Management======================");
                                    System.out.println("Use which Function:");
                                    System.out.println("1.display");
                                    System.out.println("2.add");
                                    System.out.println("3.remove");
                                    //System.out.println("4.update");
                                    System.out.println("4.search");
                                    System.out.println("5.clear");
                                    System.out.println("6.Exit");
                                    System.out.print("Selection: ");
                                    int input = Scanner.nextInt();

                                    if (input == 1) {
                                        Admin.displayList();
                                    } else if (input == 2) {
                                        Admin.addNewTeacher();
                                    } else if (input == 3) {
                                        Admin.removeTeacher();
                                    } else if (input == 4) {
                                        Admin.searchTeacher();
                                    } else if (input == 5) {
                                        Admin.clearAllList();
                                    } else if (input == 6) {
                                        choice = true;
                                    }
                                } while (!choice);
                                break;

                            case "2":

                                System.out.println("\n=========================Voter  Management===============================");
                                System.out.println("1.Display Voter List");
                                System.out.println("2.Remove Voter");
                                System.out.println("3.Update Voter Information");
                                System.out.println("4.Clear All Voter");
                                System.out.println("5.Exit Voter Management");
                                System.out.print("\nVoter Management:");
                                userChoosen = scan.nextLine();
                                if (userChoosen.equals("1")) {
                                    if (v.isEmptyVoterL()) {
                                        System.out.println("\n!!! Voter List is empty !!!");
                                    } else {
                                        v.displayVoter();

                                    }
                                    exitsystem = false;
                                } else if (userChoosen.equals("2")) {
                                    System.out.println("Remove Voter");
                                    if (v.isEmptyVoterL()) {
                                        System.out.println("\n!!! Voter List is empty !!!");
                                    } else {
                                        v.removeVoterFromList();

                                    }
                                    exitsystem = false;
                                } else if (userChoosen.equals("3")) {
                                    System.out.println("\nUpdate Voter Information");
                                    v.updateVoterinformation();

                                    exitsystem = false;

                                } else if (userChoosen.equals("4")) {
                                    v.clearVoterList();
                                    System.out.println("All Clear");
                                    // exitsystem=false;
                                } else if (userChoosen.equals("5")) {
                                    exitsystem = false;
                                }
                                break;

                            case "3":
                                Scanner Obj = new Scanner(System.in);
                                boolean select = false;
                                do {
                                    System.out.println("\n=========================Receipt History===============================");
                                    System.out.println("Use which Function:");
                                    System.out.println("1.display history");
                                    System.out.println("2.serch receipt");
                                    System.out.println("3.clear all");
                                    System.out.println("4.Exit");
                                    System.out.print("Selection: ");
                                    int ans = Obj.nextInt();

                                    if (ans == 1) {
                                        admin.displayHistory();
                                    } else if (ans == 2) {
                                        admin.search();
                                    } else if (ans == 3) {
                                        admin.clearAll();
                                    } else if (ans == 4) {
                                        select = true;
                                    }
                                } while (!select);
                                break;
                            case "4":
                                exitstatus = true;
                                break;
                            default:
                                exitstatus = true;
                        }
                    } while (!exitstatus);
                    break;
                case "3"://stack,queue
                    do {
                        q1.display();
                        if (!q1.voterQueue.isEmpty()) {

                            dequeueName = q1.dequeueByDoctor().getVoterName();

                            wq.popVoter().getVoterName();
                            System.out.println(dequeueName);
                            boolean emptyVoter = q1.isEmptyVoter();
                            if (emptyVoter != true) {
                                System.out.println("Proceed to Teacher List");

                                Admin = t.eTeacherList(Admin);

                                if (t.getTeacherL().getTopIndex() != -1) {

                                    InvoiceAndPayment p2 = new InvoiceAndPayment(t.getTeacherL(), dequeueName);
                                    successfulTransaction = p2.isSuccessfulTransaction();
                                    if (successfulTransaction == true) {
                                        admin.addReceipt(p2.getInvoice().getVoterName(), p2.getInvoice().getItemList());
                                    }
                                } else {
                                    System.out.println("Invalid Input!");
                                }

                            }
                        }
                        exitstatus = true;
                    } while (!exitstatus);
                    break;
                default:
                    System.out.println("\nExit System");
                    exitsystem = true;
                //   return;
            }
        } while (!exitsystem);
    }
}
    