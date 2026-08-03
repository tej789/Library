package com.tej.librarymanagement.model;

// public record Member (String MN, int Id ){}

public class Member {
    

        
   private String MN;
   private int Id;

    public Member(String MN,int Id){
 if(MN == null || MN.isEmpty() ){
throw new IllegalArgumentException("Member Name should not be empty");
      }

if (Id<=0){
    throw new IllegalArgumentException("Member ID must be greater than 0");
}

        this.MN=MN;
        this.Id=Id;
    
    }

public String getMN(){
return MN;

}

public int getID(){
    return Id;
}
}
