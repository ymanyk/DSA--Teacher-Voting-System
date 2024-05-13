package entity;

import adt.ArrayListVoter;

/**
 * @author Wong Soon Chee
 */
public class Voter {

    private String VoterID;
    private String VoterName;
    private String IC_No;
    private String phone_number;
    private ArrayListVoter<Voter> voterL = new ArrayListVoter<>();

    public Voter() {

        this("V0", "testuser", "0000000000000", "01284sdadas7");
    }

    public Voter(String id, String name, String ic, String phnum) {
        this.VoterID = id;
        this.VoterName = name;
        this.IC_No = ic;
        this.phone_number = phnum;
    }

    public String getVoterID() {
        return VoterID;
    }

    public String getVoterName() {
        return VoterName;
    }

    public void setVoterName(String voterName) {
        VoterName = voterName;
    }

    public String getIC_No() {
        return IC_No;
    }

    public void setIC_No(String iC_No) {
        IC_No = iC_No;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            // System.out.println("Equals Voter");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String msg = String.format("%-16s", "||" + VoterID)
                + String.format("%-16s", "||" + VoterName)
                + String.format("%-16s", "||" + IC_No)
                + String.format("%-1s", "||" + phone_number);
        // return VoterID+" "+VoterName+" "+IC_No+" "+phone_number;
        return msg;
    }

}
