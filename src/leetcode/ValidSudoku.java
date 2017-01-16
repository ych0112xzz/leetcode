package leetcode;

import java.util.BitSet;
import java.util.HashSet;

/**
 * Created by ych0112xzz on 2016/10/20.
 */
public class ValidSudoku {


    public static void main(String[] args){
        char[][] data={{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},
            {'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},
            {'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},
            {'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};
        System.out.println(new ValidSudoku().isValidSudoku(data));
    }


    /*
    * 用二维布尔变量遍历一次
    * */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    //check if number already exists for current row
                    //use num-1 to access index 0 to 8
                    if (rowCheck[r][num - 1]) {
                        return false;
                    } else {
                        rowCheck[r][num - 1] = true;
                    }
                    //check if number already exists for current column
                    if (colCheck[c][num - 1]) {
                        return false;
                    } else {
                        colCheck[c][num - 1] = true;
                    }
                    //check if number already exists for current square
                    //square are numbered 0 - 8 from top left to bottom right
                    if (boxCheck[3 * (r / 3) + c / 3][num - 1]) {
                        return false;
                    } else {
                        boxCheck[3 * (r / 3) + c / 3][num - 1] = true;
                    }
                }
            }
        }
        return true;
    }

   /* public boolean isValidSudoku(char[][] board) {
        HashSet seen = new HashSet();
        for (int i=0; i<9; i++) {
            System.out.println(i);
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }*/

    /*
    * 三次循环判断
    * */
    /*public boolean isValidSudoku(char[][] board) {
        boolean result = false;
        for(int i=0;i<9;i++){
            HashSet<Character> hashSet = new HashSet<>();
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[i][j])){
                    if(hashSet.contains(board[i][j])){
                        // System.out.println(i+"1false"+j);
                        return false;
                    }else{
                        hashSet.add(board[i][j]);
                    }
                }
            }

        }

        for(int i=0;i<9;i++){
            HashSet<Character> hashSet = new HashSet<>();
            for(int j=0;j<9;j++){
                if(Character.isDigit(board[j][i])){
                    if(hashSet.contains(board[j][i])){
                        //System.out.println(i+"2false"+j);
                        return false;
                    }else{
                        hashSet.add(board[j][i]);
                    }
                }
            }
        }
        int i=0;
        int j = 0;
        int iIndex=3;
        int jIndex = 3;
        while(iIndex<=9) {
            while (jIndex <= 9) {
                HashSet<Character> hashSet = new HashSet<>();
                while (i < iIndex) {
                    while (j < jIndex) {
                        if (Character.isDigit(board[i][j])) {

                            if (hashSet.contains(board[i][j])) {
                                // System.out.println(board[i][j]);
                                // System.out.println(i+"3false"+j);
                                return false;
                            } else {
                                hashSet.add(board[i][j]);
                            }
                        }
                        j++;
                    }
                    j=j-3;
                    i++;
                }
                i = i-3;
                j =j +3;
                jIndex += 3;
            }
            i=i+3;
            j=0;
            iIndex += 3;
            jIndex = 3;
        }

        return true;
    }*/

}
