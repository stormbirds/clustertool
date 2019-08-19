package cn.stormbirds.clusterutils;

import java.util.Collection;
import java.util.Set;

/**
 *
 * <p> Algorithm.java
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:04
 *
 */
public interface Algorithm<T extends ClusterItem> {
    void addItem(T var1);

    void addItems(Collection<T> var1);

    void clearItems();

    void removeItem(T var1);

    Set<? extends Cluster<T>> getClusters(double var1);

    Collection<T> getItems();
}