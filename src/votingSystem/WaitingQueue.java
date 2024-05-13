package votingSystem;

import entity.Voter;
import entity.Voter_Stack;
import adt.ArrayStackVoter;
import java.util.Scanner;

/**
 * @author Teoh Jia Hao
 */
public class WaitingQueue {

    public Scanner input = new Scanner(System.in);  // Create a Scanner object
    public boolean emptyVoter = false;

    public WaitingQueue() {
    }
    public ArrayStackVoter<Voter_Stack> voterStack = new ArrayStackVoter<>();

    public String waitingSystem
            = "\n========================================\n"
            + "           Waiting System  \n"
            + "========================================\n"
            + "TNo\tName\n";

    public void display() {
        System.out.println(waitingSystem);
        voterStack.checkAllVoter();
        System.out.println("========================================\n");
    }
    //Display four front index information.

    public void pushVoter(Voter v) {
        Voter_Stack Evoter = new Voter_Stack(v.getVoterName());
        voterStack.addVoter(Evoter);

    }

    public void pushEVoter(Voter v) {
        Voter_Stack Evoter = new Voter_Stack(v.getVoterName());
        voterStack.addVoter(Evoter);


    }

    public ArrayStackVoter<Voter_Stack> getVoterStack() {
        return voterStack;
    }

    public Voter_Stack popVoter() {
        Voter_Stack Evoter = voterStack.removeFirstVoter();
        return Evoter;
    }


    public Voter_Stack popEVoter() {
        Voter_Stack Evoter = null;
        char waitingChosen = 0;
        String doctorWaitingSide
                = "========================================\n"
                + "           Waiting Side  \n"
                + "========================================\n"
                + "Is the voter " + voterStack.checkLastVoter().getVoterName() + " ready ?(Y/N)\n"
                + "Chosen: ";

        String voterDoneSide
                = "\nWaiting to be process press Y to continue\n"
                + "Chosen: ";

        do {
            System.out.println(doctorWaitingSide);
            waitingChosen = input.next().charAt(0);

            if (waitingChosen != 'Y' && waitingChosen != 'y' && waitingChosen != 'N' && waitingChosen != 'n') {
                System.out.println("Invalid Input! Please input again !!!");
            }

        } while (waitingChosen != 'Y' && waitingChosen != 'y' && waitingChosen != 'N' && waitingChosen != 'n');

        if (waitingChosen == 'N' || waitingChosen == 'n') {
            int count = 0;
            do {
                System.out.println(
                        "Is the voter " + voterStack.checkLastVoter().getVoterName() + " done?(Y/N)\n"
                        + "Chosen: ");
                waitingChosen = input.next().charAt(0);
                waitingChosen = Character.toUpperCase(waitingChosen);
                count++;
            } while (waitingChosen == 'N' && count < 2);

            if (waitingChosen == 'N') {
                emptyVoter = true;
                Evoter = voterStack.removeLastVoter();
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
                        Evoter = voterStack.removeLastVoter();
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
                    Evoter = voterStack.removeLastVoter();
                    display();
                }
            } while (doneChosen != 'Y' && doneChosen != 'y');

        }

        return Evoter;
    }

    public boolean isEmptyVoter() {
        return emptyVoter;
    }

}
