package cn.stormbirds.clusterutils;

import java.util.Collection;

public interface Cluster<T extends ClusterItem> {
    LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}