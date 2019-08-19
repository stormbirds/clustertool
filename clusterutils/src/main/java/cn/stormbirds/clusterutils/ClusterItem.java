package cn.stormbirds.clusterutils;

/**
 *
 * <p> 标记点类
 * </p>
 * @author StormBirds Email：xbaojun@gmail.com
 * @since 2019/8/14 18:03
 *
 */
public interface ClusterItem {
    LatLng getPosition();

    String getTitle();

    String getSnippet();
}