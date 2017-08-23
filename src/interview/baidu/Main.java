package interview.baidu;


import java.util.Scanner;


public class Main {
    static class Point {
        String color;
        int x;
        int y;
        int z;

        Point(String color, int x, int y, int z) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            String tmp = sc.nextLine();
            String[] data = tmp.split(" ");
            //points[i] = new Point("", 1, 2, 3);
            points[i] = new Point(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
        }

        double max = 0.0d;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    boolean isE = (points[i].color.equals(points[j].color) && points[i].color.equals(points[k].color));
                    boolean isNot = (!points[i].color.equals(points[j].color)) && (!points[i].color.equals(points[k].color)) && (!points[k].color.equals(points[j].color));
                    if (isE || isNot) {
                        double s = calculate(points[i], points[j], points[k]);
                        max = Math.max(s, max);
                    }
                }
            }
        }
        System.out.println(String.format("%.5f", max));
    }

    public static double calculate(Point p1, Point p2, Point p3) {

        double a = Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) + (p1.z - p2.z) * (p1.z - p2.z));
        double b = Math.sqrt((p1.x - p3.x) * (p1.x - p3.x) + (p1.y - p3.y) * (p1.y - p3.y) + (p1.z - p3.z) * (p1.z - p3.z));
        double c = Math.sqrt((p3.x - p2.x) * (p3.x - p2.x) + (p3.y - p2.y) * (p3.y - p2.y) + (p3.z - p2.z) * (p3.z - p2.z));
        double p = (a + b + c) / 2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int tmp : nums) {
            if (!treeSet.contains(tmp)) {
                treeSet.add(tmp);
            }
        }
        if (treeSet.size() < 3) {
            System.out.println(-1);
        }else {
            System.out.println(treeSet.toArray()[2]);
        }
    }
}*/
