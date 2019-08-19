package cn.stormbirds.clusterutils;

import java.io.Serializable;

/**
 *
 * <p> 经纬度包装类
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:08
 *
 */
public final class LatLng implements Serializable {

    public final double latitude;
    public final double longitude;

    public LatLng(double var1, double var3) {
        if (-180.0D <= var3 && var3 < 180.0D) {
            this.longitude = var3;
        } else {
            this.longitude = ((var3 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
        }

        this.latitude = Math.max(-90.0D, Math.min(90.0D, var1));
    }


    @Override
    public final int hashCode() {
        long var2 = Double.doubleToLongBits(this.latitude);
        int var1 = 31 + (int)(var2 ^ var2 >>> 32);
        var2 = Double.doubleToLongBits(this.longitude);
        return var1 * 31 + (int)(var2 ^ var2 >>> 32);
    }

    @Override
    public final boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof LatLng)) {
            return false;
        } else {
            LatLng var2 = (LatLng)var1;
            return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(var2.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(var2.longitude);
        }
    }

    @Override
    public final String toString() {
        double var1 = this.latitude;
        double var3 = this.longitude;
        return (new StringBuilder(60)).append("lat/lng: (").append(var1).append(",").append(var3).append(")").toString();
    }
}