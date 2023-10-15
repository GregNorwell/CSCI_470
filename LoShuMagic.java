public class LoShuMagic {
  
public static boolean test(int[][] input) {
    int sum = -1, rowcoltotal = 0;

    //check columns (up/down)
    for(int i = 0; i < 4; i++){
      if(sum == -1){ //set inital total to match if this is the first sum
        rowcoltotal = sum;
        sum = 0;
      }
      else{
        if(rowcoltotal != sum)
          return false;
        sum = 0;
      }
      for(int j = 0; j < 4; j++){
        sum += input[i][j];
      }
    }
    sum = 0;
    //check rows (right/left)
    for(int i = 0; i < 4; i++){
      if(rowcoltotal != sum)
          return false;
      sum = 0;
      for(int j = 0; j < 4; j++){
        sum += input[j][i];
      }
    }

    //check diagonals (corner to corner)
    if((input[0][0] + input[1][1] + input[2][2] + input[3][3]) != rowcoltotal)
      return false;
    if((input[0][3] + input[1][2] + input[2][1] + input[3][0]) != rowcoltotal)
      return false;

    return true;
  }
  
}
