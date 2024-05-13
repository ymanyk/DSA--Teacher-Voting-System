package entity;

/**
 * @author Teoh Jia Hao
 */
public class Voter_Stack{
    private static int totalNumber = 0;
    private int Tracking_Number = 0;
    private String VoterName;
    private String VoterID;
    
    //contructor
    public Voter_Stack(){
    }

    public Voter_Stack(String VoterName) {
       Voter_Stack.totalNumber ++;
        this.Tracking_Number = totalNumber;
        this.VoterName = VoterName;
        this.VoterID=VoterID;
        
    }
    
    //getter
    public int getTracking_Number(){
        return Tracking_Number;
    }
    
    public String getVoterName(){
        return VoterName;
    }
    
    public String getVoterID(){
        return VoterName;
    }
    

    @Override
    public String toString(){
        return String.format("%03d\t%s",Tracking_Number,VoterName);
    }
    
}
