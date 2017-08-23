package util.Polygon;

/**
 * Created by ych0112xzz on 2017/5/25.
 */
public class Main {
    double multiply(Point p1, Point p2, Point p0) {
        return (p1.x - p0.x) * (p2.y - p0.y)*1.0 - (p1.y - p0.y) * (p2.x - p0.x)*1.0;
    }
    boolean inConvexPolygon(Point[] Polygon, Point target) {
        int len = Polygon.length;
        if (multiply(target, Polygon[1], Polygon[0]) > 0 && multiply(target, Polygon[len - 1], Polygon[0]) < 0) {
            return false;
        }
        int s = 1, e = len -1;
        int line = -1;
        while (s <= e) {
            int m = s + ((e-s) >> 1);
            if (multiply(target, Polygon[m], Polygon[0]) > 0) { // target在m顺时针方向
                line = m; // line保存的是m逆时针方向后的第一个点
                e = m -1;
            } else { // target在m逆时针方向
                s = m + 1;
            }
        }
        return multiply(Polygon[line], target, Polygon[line -1]) > 0;
    }
}
