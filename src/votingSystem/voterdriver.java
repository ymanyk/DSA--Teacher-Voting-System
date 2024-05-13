/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingSystem;

import adt.ArrayListVoter;
import entity.Voter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Wong Soon Chee
 */
public class voterdriver {

    private ArrayListVoter<Voter> voterL = new ArrayListVoter<Voter>();
    Scanner scan = new Scanner(System.in);

    // default list
    public void existingVoterList() {
        Voter v1 = new Voter("V1", "Wong Soon Chee", "000602101213", "01136973155");
        Voter v2 = new Voter("V2", "Rinisha", "000602101214", "01136973155");
        Voter v3 = new Voter("V3", "Teoh Jia Hao", "11fdfbdf1", "01136973155");
        Voter v4 = new Voter("V4", "Yong Man Kei", "66dsvsdvsd6", "01136973155");
        voterL.addVoter(v1);
        voterL.addVoter(v2);
        voterL.addVoter(v3);
        voterL.addVoter(v4);
        System.out.println("Loaded the Voter data");

    }

    public boolean isEmptyVoterL() {
        // voterL.isEmpty();
        if (voterL.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Voter addVoterToList() {
        String Name, ic, phonenumber;
        Voter V = new Voter();
        System.out.print("Input Voter Name:");
        Name = scan.nextLine();
        System.out.print("Input Voter IC:");
        ic = scan.nextLine();
        System.out.print("Input Voter Phonenumber:");
        phonenumber = scan.nextLine();
        int i = voterL.getLength() + 1;
        String pid = "Voter ID: P" + i;
        System.out.println(pid);
        V = new Voter(pid, Name, ic, phonenumber);
        voterL.addVoter(V);
        // voterL.display();
        return V;

    }

    public void removeVoterFromList() {
        boolean found = false, c = false;
        String pos, exit;

        do {
            displayVoter();
            Iterator<Voter> voterIteroter = voterL.getIterator();
            System.out.println("Please Select a VoterID to delete");
            int pat = 0;
            System.out.print("Voter ID:");
            pos = scan.nextLine();
            while (voterIteroter.hasNext()) {
                Voter voter = voterIteroter.next();
                if (voter.getVoterID().equals(pos)) {
                    pat = voterL.getPosition(voter) + 1;
                    System.out.println(pat);
                    found = true;
                }
            }
            if (found) {
                System.out.println(pat);
                voterL.removeVoter(pat);
                System.out.println("\nVoter already remove from Voter list");
                System.out.println("Remove Done");
                displayVoter();
                c = true;
            } else {
                System.out.println("\nNot found Voter");
                System.out.println("1.Please try again input Voter ID");
                System.out.println("2.Exit");
                System.out.print("\nchoose:");
                exit = scan.nextLine();
                if (exit.equals("1")) {
                    c = false;
                } else if (exit.equals("2")) {
                    c = true;
                }
            }
        } while (!c);
    }

    //clear the list
    public void clearVoterList() {
        voterL.clearVoterList();
        System.out.println("Voter List All clear");
        displayVoter();
        System.out.println("None ");
    }

    //update Voter information
    public void updateVoterinformation() {
        String ic, Name = "", phonenum = "", id = "";
        String exit;
        String choose;
        boolean c = false;
        boolean found = false;
        int vos = 0;
        do {
            System.out.print("Which Voter Need Update(Please input Voter's Ic number):");
            ic = scan.nextLine();
            // System.out.println(VoterL.getIterator());
            Iterator<Voter> voterIteroter = voterL.getIterator();

            while (voterIteroter.hasNext()) {
                Voter voter = voterIteroter.next();
                // if(ic.equals(voter.getIC_No())){
                if (voter.getIC_No().equals(ic)) {
                    vos = voterL.getPosition(voter) + 1;
                    id = voterL.getEntryVoter(vos).getVoterID();
                    Name = voterL.getEntryVoter(vos).getVoterName();
                    ic = voterL.getEntryVoter(vos).getIC_No();
                    phonenum = voterL.getEntryVoter(vos).getPhone_number();
                    c = true;
                    found = true;
                }
            }
            if (!c) {

                System.out.println("\nNot Found");
                System.out.println("1.Please try again input Ic Number");
                System.out.println("2.Exit");
                System.out.print("\nchoose:");
                exit = scan.nextLine();
                if (exit.equals("1")) {
                    c = false;
                } else if (exit.equals("2")) {
                    c = true;
                }
            }
            if (found) {
                String namei;
                String Phonenumi;
                System.out.println("===================================================");
                System.out.println("Found Voter record");
                System.out.println("Voter ID:" + id);
                System.out.println("Voter Name:" + Name);
                System.out.println("Voter IC:" + ic);
                System.out.println("Phone Number:" + phonenum);
                System.out.println("===================================================");

                System.out.println("\nWhich info want to update");
                System.out.println("1.Name");
                System.out.println("2.Phone Number");
                System.out.println("3.Exit update");
                System.out.print("\nchoose:");
                choose = scan.nextLine();

                switch (choose) {
                    case "1":
                        System.out.println("Please Input New Name");
                        namei = scan.nextLine();
                        Voter newv = new Voter(id, namei, ic, phonenum);

                        voterL.replaceVoter(vos, newv);
                        System.out.println("Update Done");
                        voterL.display();
                        break;
                    case "2":
                        System.out.println("Please Input New Phone Number");
                        Phonenumi = scan.nextLine();
                        Voter newphone = new Voter(id, Name, ic, Phonenumi);

                        voterL.replaceVoter(vos, newphone);
                        System.out.println("Update Done");
                        voterL.display();
                        break;
                    case "3":
                        return;
                    default:
                        return;
                }
            }
        } while (!c);
    }

    public Voter validVoter() {
        String ic = "", Name = "", phonenum = "", ID = "";
        int vos = 0;
        String exit;
        Voter V = new Voter();
        boolean found = false, c = false;
        do {
            System.out.println("\nVoter check in");
            System.out.print("Input IC:");
            ic = scan.nextLine();
            Iterator<Voter> voterIteroter = voterL.getIterator();
            while (voterIteroter.hasNext()) {
                Voter voter = voterIteroter.next();
                if (ic.equals(voter.getIC_No())) {
                    vos = voterL.getPosition(voter) + 1;
                    ID = voterL.getEntryVoter(vos).getVoterID();
                    Name = voterL.getEntryVoter(vos).getVoterName();
                    ic = voterL.getEntryVoter(vos).getIC_No();
                    phonenum = voterL.getEntryVoter(vos).getPhone_number();
                    V = voterL.getEntryVoter(vos);
                    if (voterL.contains(V)) {
                        c = true;
                        found = true;
                    }

                }
            }
            if (!c) {
                System.out.println("\nNot Found");
                System.out.println("1.Try again input Ic Number");
                System.out.println("2.Register a voter");
                exit = scan.nextLine();
                if (exit.equals("1")) {
                    c = false;
                } else if (exit.equals("2")) {
                    V = addVoterToList();
                    c = true;
                } else {
                    c = false;
                }
            }
            if (found) {
                System.out.println("===================================================");
                System.out.println("Found Voter record");
                System.out.println("Voter ID:" + ID);
                System.out.println("Voter Name:" + Name);
                System.out.println("Voter IC:" + ic);
                System.out.println("Phone Number:" + phonenum);
                System.out.println("===================================================");
            }
        } while (!c);
        return V;
    }

    //display the list
    public void displayVoter() {
        System.out.println("=====================VoterList=========================================");
        // System.out.println("Voter ID"+"Voter Name"+"IC Number"+"Phone Number");
        System.out.printf("%-15s %-15s %-15s %-15s ", "||Voter ID", "||Voter Name", "||IC Number", "||Phone Number");
        System.out.println(" ");
        voterL.display();
    }

}
