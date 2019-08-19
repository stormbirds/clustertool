package cn.stormbirds.clusterutils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * <p> 聚合标记点
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:03
 *
 */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final LatLng mCenter;
    private final List<T> mItems = new ArrayList();

    public StaticCluster(LatLng center) {
        this.mCenter = center;
    }

    public boolean add(T t) {
        return this.mItems.add(t);
    }

    @Override
    public LatLng getPosition() {
        return this.mCenter;
    }

    public boolean remove(T t) {
        return this.mItems.remove(t);
    }

    @Override
    public Collection<T> getItems() {
        return this.mItems;
    }

    @Override
    public int getSize() {
        return this.mItems.size();
    }

    @Override
    public String toString() {
        return "StaticCluster{mCenter=" + this.mCenter + ", mItems.size=" + this.mItems.size() + '}';
    }

    @Override
    public int hashCode() {
        return this.mCenter.hashCode() + this.mItems.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StaticCluster)) {
            return false;
        } else {
            return ((StaticCluster)other).mCenter.equals(this.mCenter) && ((StaticCluster)other).mItems.equals(this.mItems);
        }
    }
}
