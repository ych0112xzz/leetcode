package interview.weizhong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static boolean helper(long one, long two) {
        if (two == 0) {
            return (one & 1) == 1;
        }
        if (one == 0) {
            return (two & 1) == 1;
        }
        return !(helper(one - 1, two) || helper(one, two - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long count = Long.parseLong(sc.nextLine());
            long one = 0;
            long two = 0;
            for (long i = 0; i < count; i++) {
                String[] array = sc.nextLine().split(" ");
                long n = Long.parseLong(array[0]);
                long m = Long.parseLong(array[1]);
                if (n == 1) {
                    one += 1;
                    two += m - 1;
                } else {
                    two += m;
                }
            }
            if (helper(one, two)) {
                System.out.println("first");
            } else {
                System.out.print("second");
            }
        }
    }
}

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
    ArrayList<Line> linesArray; //
    public int[] result;  // 判断结果

    public void entry(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int number = 1;
            int[][][] lines = new int[number][4][4];  // 线段坐标
            result = new int[number];
            // input
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        lines[i][j][k] = sc.nextInt();
                    }
                }
            }
            // judge
            for (int i = 0; i < number; i++) {
                // 判读是否是4个点
                if (pointsJudge(i, 4, lines[i]) == false) {
                    continue;
                }
                // 判断线段平行或垂直
                linesJudge(i, linesArray);
            }
            // output
            for (int i = 0; i < number; i++) {
                if (result[i] == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    //  判断是否是 4 Points
    public boolean pointsJudge(int rectangleNumber, int lineNumber, int[][] lines){
        linesArray = new ArrayList<Line>();  // 线段数组
        HashMap<String, Point> pointsMap = new HashMap<String, Point>();  // 点Map
        for( int i=0; i<lineNumber; i++ ){
            Line line = new Line(lines[i]);
            linesArray.add(line);
            Point point1 = line.getPoint1();  // p1
            String key1 = point1.getKey();
            pointsMap.put(key1, point1);
            Point point2 = line.getPoint2();  // p2
            String key2 = point2.getKey();
            pointsMap.put(key2, point2);
        }
        if( pointsMap.size() != 4 ){  // 不是4个点
            result[rectangleNumber] = 0;
            return false;
        }
        return true;
    }
    // 线段平行，垂直判断
    public int linesJudge(int rectangleNumber, ArrayList<Line> linesArray){
        int x1 = linesArray.get(0).x1;
        int y1 = linesArray.get(0).y1;
        int x2 = linesArray.get(0).x2;
        int y2 = linesArray.get(0).y2;
        int verticalNum = 0;  // 垂直的线段数量
        int parallelNum = 0;  // 平行的线段数量

        for( int i=1; i<linesArray.size(); i++ ){
            int x3 = linesArray.get(i).x1;
            int y3 = linesArray.get(i).y1;
            int x4 = linesArray.get(i).x2;
            int y4 = linesArray.get(i).y2;
            // 判断垂直
            if( (y1-y2)*(y3-y4) == -1*(x1-x2)*(x3-x4) ){
                // 垂直了，还得有一个点重复
                if( (x1==x3)&&(y1==y3) || (x1==x4)&&(y1==y4) || (x2==x3)&&(y2==y3) || (x2==x4)&&(y2==y4) ){
                    verticalNum++;
                    continue;
                }else{
                    result[rectangleNumber] = 0;
                    return 0;
                }
            }
            // 判断平行
            if( (y1-y2)*(x3-x4) == (y3-y4)*(x1-x2) ){
                // 平行了，还得不能有点重复
                if( (x1==x3)&&(y1==y3) || (x1==x4)&&(y1==y4) || (x2==x3)&&(y2==y3) || (x2==x4)&&(y2==y4) ){
                    result[rectangleNumber] = 0;
                    return 0;
                }else{
                    parallelNum++;
                    continue;
                }
            }
            // 既不平行也不垂直
            result[rectangleNumber] = 0;
        }
        if( verticalNum==2 && parallelNum==1 ){  // 两垂直一平行
            result[rectangleNumber] = 1;
        }
        return 1;
    }

    public static void main(String[] args){
        Main m = new Main();
        m.entry();
    }

    //
    class Line{
        int x1, y1, x2, y2;
        Line(int[] line){
            this.x1 = line[0];
            this.y1 = line[1];
            this.x2 = line[2];
            this.y2 = line[3];
        }
        Point getPoint1(){
            return new Point(this.x1, this.y1);
        }
        Point getPoint2(){
            return new Point(this.x2, this.y2);
        }
        String getKey(){
            return this.x1+","+this.y1+","+this.x2+","+this.y2;
        }
    }
    //
    class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return this.x;
        }
        int getY(){
            return this.y;
        }
        String getKey(){
            return this.x+","+this.y;
        }
    }
}
*/
