//*************************
//Greg Norwell & Muraad Khan
//CSCI 470
//Assignment 6
//11/30/23
//************************
public class MileTicket {
  //Instance data
  private String city;
  private int normalMilesReqEcon;
  private int superMilesReqEcon;
  private int addMilesReqFirst;
  //Month 1:Jan - 12:Dec
  private int SSMonthStart;
  private int SSMonthEnd;

  //Constructor to set all data
  MileTicket (String city, int normalMilesReqEcon, int superMilesReqEcon, int addMilesReqFirst, int SSMonthStart, int SSMonthEnd) {
    this.city = city;
    this.normalMilesReqEcon = normalMilesReqEcon;
    this.superMilesReqEcon = superMilesReqEcon;
    this.addMilesReqFirst = addMilesReqFirst;
    this.SSMonthStart = SSMonthStart;
    this.SSMonthEnd = SSMonthEnd;
  }

  //City getter
  String getCity(){
    return city;
  }
  
  //Normal price getter
  int getNormalMilesReqEcon(){
    return normalMilesReqEcon;
  }

  //Super saver price getter
  int getSuperMilesReqEcon(){
    return superMilesReqEcon;
  }

  //Possible upgrade price getter
  int getAddMilesReqFirst(){
    return addMilesReqFirst;
  }

  //Start of period getter
  int getSSMonthStart(){
    return SSMonthStart;
  }

  //End of period getter
  int getSSMonthEnd(){
    return SSMonthEnd;
  }
}
