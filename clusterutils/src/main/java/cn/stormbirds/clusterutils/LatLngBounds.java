package cn.stormbirds.clusterutils;

import java.io.Serializable;
import java.util.Arrays;

public final class LatLngBounds implements Serializable {

    public final LatLng southwest;
    public final LatLng northeast;

    public LatLngBounds(LatLng var1, LatLng var2) {
        this.southwest = var1;
        this.northeast = var2;
    }

    public static LatLngBounds.Builder builder() {
        return new LatLngBounds.Builder();
    }

    public final boolean contains(LatLng var1) {
        double var4 = var1.latitude;
        return this.southwest.latitude <= var4 && var4 <= this.northeast.latitude && this.zzg(var1.longitude);
    }

    public final LatLngBounds including(LatLng var1) {
        double var3 = Math.min(this.southwest.latitude, var1.latitude);
        double var5 = Math.max(this.northeast.latitude, var1.latitude);
        double var7 = this.northeast.longitude;
        double var9 = this.southwest.longitude;
        double var11 = var1.longitude;
        if (!this.zzg(var11)) {
            if (zza(var9, var11) < zzb(var7, var11)) {
                var9 = var11;
            } else {
                var7 = var11;
            }
        }

        return new LatLngBounds(new LatLng(var3, var9), new LatLng(var5, var7));
    }

    public final LatLng getCenter() {
        double var1 = (this.southwest.latitude + this.northeast.latitude) / 2.0D;
        double var3 = this.northeast.longitude;
        double var5 = this.southwest.longitude;
        double var7;
        if (this.southwest.longitude <= var3) {
            var7 = (var3 + var5) / 2.0D;
        } else {
            var7 = (var3 + 360.0D + var5) / 2.0D;
        }

        return new LatLng(var1, var7);
    }

    private static double zza(double var0, double var2) {
        return (var0 - var2 + 360.0D) % 360.0D;
    }

    private static double zzb(double var0, double var2) {
        return (var2 - var0 + 360.0D) % 360.0D;
    }

    private final boolean zzg(double var1) {
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= var1 && var1 <= this.northeast.longitude;
        } else {
            return this.southwest.longitude <= var1 || var1 <= this.northeast.longitude;
        }
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.southwest, this.northeast});
    }

    @Override
    public final boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof LatLngBounds)) {
            return false;
        } else {
            LatLngBounds var2 = (LatLngBounds)var1;
            return this.southwest.equals(var2.southwest) && this.northeast.equals(var2.northeast);
        }
    }

    public static final class Builder {
        private double zzjdp = 1.0D / 0.0;
        private double zzjdq = -1.0D / 0.0;
        private double zzjdr = 0.0D / 0.0;
        private double zzjds = 0.0D / 0.0;

        public Builder() {
        }

        public final LatLngBounds.Builder include(LatLng var1) {
            this.zzjdp = Math.min(this.zzjdp, var1.latitude);
            this.zzjdq = Math.max(this.zzjdq, var1.latitude);
            double var2 = var1.longitude;
            if (Double.isNaN(this.zzjdr)) {
                this.zzjdr = var2;
            } else {
                if (this.zzjdr <= this.zzjds ? this.zzjdr <= var2 && var2 <= this.zzjds : this.zzjdr <= var2 || var2 <= this.zzjds) {
                    return this;
                }

                if (LatLngBounds.zza(this.zzjdr, var2) < LatLngBounds.zzb(this.zzjds, var2)) {
                    this.zzjdr = var2;
                    return this;
                }
            }

            this.zzjds = var2;
            return this;
        }

        public final LatLngBounds build() {
            if(Double.isNaN(this.zzjdr)){
                throw new IllegalStateException("no included points");
            }
            return new LatLngBounds(new LatLng(this.zzjdp, this.zzjdr), new LatLng(this.zzjdq, this.zzjds));
        }
    }
}