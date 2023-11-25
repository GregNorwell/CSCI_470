public class MileTicket {
  private String city;
  private int normalMilesReqEcon;
  private int superMilesReqEcon;
  private int addMilesReqFirst;
  //Month 1:Jan - 12:Dec
  private int SSMonthStart;
  private int SSMonthEnd;

  MileTicket (String city, int normalMilesReqEcon, int superMilesReqEcon, int addMilesReqFirst, int SSMonthStart, int SSMonthEnd) {
    
  }

  String getCity(){
    return city;
  }
  int getNormalMilesReqEcon(){
    return normalMilesReqEcon;
  }
  int getSuperMilesReqEcon(){
    return superMilesReqEcon;
  }
  int getAddMilesReqFirst(){
    return addMilesReqFirst;
  }
  int getSSMonthStart(){
    return SSMonthStart;
  }
  int getSSMonthEnd(){
    return SSMonthEnd;
  }
}
