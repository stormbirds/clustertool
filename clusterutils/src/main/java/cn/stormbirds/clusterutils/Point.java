package cn.stormbirds.clusterutils;

/**
 *
 * <p> 点坐标封装
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:08
 *
 */
public class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{x=" + this.x + ", y=" + this.y + '}';
    }
}
