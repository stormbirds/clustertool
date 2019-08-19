package cn.stormbirds.clusterutils;

/**
 *
 * <p> 地理区域坐标范围
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:02
 *
 */
public class Bounds {
    public final double minX;
    public final double minY;
    public final double maxX;
    public final double maxY;
    public final double midX;
    public final double midY;

    public Bounds(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        this.midX = (minX + maxX) / 2.0D;
        this.midY = (minY + maxY) / 2.0D;
    }

    public boolean contains(double x, double y) {
        return this.minX <= x && x <= this.maxX && this.minY <= y && y <= this.maxY;
    }

    public boolean contains(Point point) {
        return this.contains(point.x, point.y);
    }

    public boolean intersects(double minX, double maxX, double minY, double maxY) {
        return minX < this.maxX && this.minX < maxX && minY < this.maxY && this.minY < maxY;
    }

    public boolean intersects(Bounds bounds) {
        return this.intersects(bounds.minX, bounds.maxX, bounds.minY, bounds.maxY);
    }

    public boolean contains(Bounds bounds) {
        return bounds.minX >= this.minX && bounds.maxX <= this.maxX && bounds.minY >= this.minY && bounds.maxY <= this.maxY;
    }
}
