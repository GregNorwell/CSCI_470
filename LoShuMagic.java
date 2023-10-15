public class LoShuMagic {
  
public static boolean test(int[][] input) {
    int sum = 0, rowcoltotal = -1;

    //check rows (right/left)
    for(int i = 0; i < 4; i++){
      sum = 0;
      for(int j = 0; j < 4; j++){
        sum += input[i][j];
      }
      if(rowcoltotal == -1) //set inital total to match if this is the first sum
        rowcoltotal = sum;
      if(rowcoltotal != sum)
        return false;
    }
    sum = 0;
    system.out.println("rows checked");
    //check columns (up/down)
    for(int i = 0; i < 4; i++){
      sum = 0;
      for(int j = 0; j < 4; j++){
        sum += input[j][i];
      }
      if(rowcoltotal != sum)
          return false;
    }
    system.out.println("cols checked");

    //check diagonals (corner to corner)
    if((input[0][0] + input[1][1] + input[2][2] + input[3][3]) != rowcoltotal)
      return false;
    if((input[0][3] + input[1][2] + input[2][1] + input[3][0]) != rowcoltotal)
      return false;

    return true;
  }
  
}
