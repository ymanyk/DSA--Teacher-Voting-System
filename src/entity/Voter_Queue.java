package entity;

import adt.CircularArrayQueue;
import java.util.Scanner;

/**
 * @author Teoh Jia Hao
 */
public class Voter_Queue {

    private static int totalNumber = 0;
    private int Tracking_Number = 0;
    private String VoterName;
    private String VoterID;
    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    public CircularArrayQueue<Voter_Queue> voterQueue = new CircularArrayQueue<>();
    public boolean emptyVoter = false;
    public String waitingSystem
            = "\n========================================\n"
            + "           Waiting System  \n"
            + "========================================\n";

    //contructor
    public Voter_Queue() {
    }

    public Voter_Queue(String VoterName) {
        Voter_Queue.totalNumber++;
        this.Tracking_Number = totalNumber;
        this.VoterName = VoterName;
        this.VoterID = VoterID;

    }

    //getter
    public int getTracking_Number() {
        return Tracking_Number;
    }

    public String getVoterName() {
        return VoterName;
    }

    public String getVoterID() {
        return VoterName;
    }

    @Override
    public String toString() {
        return String.format("%03d\t%s", Tracking_Number, VoterName);
    }

    public void enqueue(Voter p) {

        Voter_Queue voter = new Voter_Queue(p.getVoterName());
        voterQueue.enqueue(voter);  //enqueue
    }

    public void display() {
        //Display four front index information.
        if (!voterQueue.isEmpty()) {
            System.out.println("TNo\tName\n" + waitingSystem + voterQueue.getFront() + "\tPlease enter now!!!");

            for (int i = 1; i < 5; i++) {
                if (voterQueue.getSpecificData(i) == null) {
                    System.out.println(" ");
                } else {
                    System.out.println(voterQueue.getSpecificData(i));
                }

            }

            System.out.println("========================================\n");
        } else {
            System.out.println(waitingSystem + "No Voter in queue!!!");
            for (int i = 1; i < 5; i++) {
                System.out.println(" ");
            }
            System.out.println("========================================\n");

        }
    }

    public Voter_Queue dequeueByDoctor() { //make the decision of dequence based on doctor side.
        Voter_Queue voter = null;
        char waitingChosen = 0;
        String waitingSide
                = "========================================\n"
                + "             Waiting Side  \n"
                + "========================================\n"
                + "Is the voter " + voterQueue.getFront().getVoterName() + " come in or not ?(Y/N)"
                + "Chosen: ";

        String voterDoneSide
                = "\nDo the Voter done?(Y/N)"
                + "Chosen: ";

        do {
            System.out.println(waitingSide);
            waitingChosen = input.next().charAt(0);

            if (waitingChosen != 'Y' && waitingChosen != 'y' && waitingChosen != 'N' && waitingChosen != 'n') {
                System.out.println("Invalid Input! Please input again !!!");
            }

        } while (waitingChosen != 'Y' && waitingChosen != 'y' && waitingChosen != 'N' && waitingChosen != 'n');

        if (waitingChosen == 'N' || waitingChosen == 'n') {
            int count = 0;
            do {
                System.out.println(
                        "Is the voter " + voterQueue.getFront().getVoterName() + " done vote?(Y/N)\n"
                        + "Chosen: ");
                waitingChosen = input.next().charAt(0);
                waitingChosen = Character.toUpperCase(waitingChosen);
                count++;
            } while (waitingChosen == 'N' && count < 2);

            if (waitingChosen == 'N') {
                emptyVoter = true;
                voter = voterQueue.dequeue();
                display();
            } else if (waitingChosen == 'Y') {
                char doneChosen = 0;
                do {
                    do {
                        System.out.println(voterDoneSide);
                        doneChosen = input.next().charAt(0);

                        if (doneChosen != 'Y' && doneChosen != 'y' && doneChosen != 'N' && doneChosen != 'n') {
                            System.out.println("Invalid Input! Please input again !!!");
                        }

                    } while (doneChosen != 'Y' && doneChosen != 'y' && doneChosen != 'N' && doneChosen != 'n');

                    if (doneChosen == 'Y' || doneChosen == 'y') {
                        emptyVoter = false;
                        voter = voterQueue.dequeue();
                        display();
                    }

                } while (doneChosen != 'Y' && doneChosen != 'y');

            }

        } else if (waitingChosen == 'Y' || waitingChosen == 'y') {
            char doneChosen = 0;
            do {
                do {
                    System.out.println(voterDoneSide);
                    doneChosen = input.next().charAt(0);

                    if (doneChosen != 'Y' && doneChosen != 'y' && doneChosen != 'N' && doneChosen != 'n') {
                        System.out.println("Invalid Input! Please input again !!!");
                    }

                } while (doneChosen != 'Y' && doneChosen != 'y' && doneChosen != 'N' && doneChosen != 'n');

                if (doneChosen == 'Y' || doneChosen == 'y') {
                    emptyVoter = false;
                    voter = voterQueue.dequeue();
                    display();
                }
            } while (doneChosen != 'Y' && doneChosen != 'y');

        }

        return voter;
    }

    public boolean isEmptyVoter() {
        return emptyVoter;
    }

}
