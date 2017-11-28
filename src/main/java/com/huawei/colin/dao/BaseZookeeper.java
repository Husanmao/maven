package com.huawei.colin.dao;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/17
 */
public class BaseZookeeper implements Watcher {

    public ZooKeeper zooKeeper;
    private static final int SESSION_TIME_OUT = 2000;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * Create connection to zookeeper
     * @param host The remote zookeeper ip
     * @throws IOException
     * @throws InterruptedException
     */
    public void connectZookeeper(String host) throws IOException, InterruptedException{
        zooKeeper = new ZooKeeper(host, SESSION_TIME_OUT, this);
        countDownLatch.await();
        System.out.println("connect zookeeper ok");
    }

    /**
     * start counting down when receive message
     * @param watchedEvent Event we got when zookeeper is connected
     */
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
            System.out.println("watcher received event");
        }
    }

    /**
     * Create a node according to the path, and setting its data
     * @param path
     * @param data
     * @return
     * @throws InterruptedException
     * @throws KeeperException
     */
    public String createNode(String path, byte[] data) throws InterruptedException, KeeperException{
        return this.zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * Get the child node
     * @param path
     * @return
     * @throws InterruptedException
     * @throws KeeperException
     */
    public List<String> getChildren(String path) throws InterruptedException, KeeperException{
        return this.zooKeeper.getChildren(path, false);
    }

    public Stat setChildren(String path, byte[] data, int version) throws KeeperException, InterruptedException{
        return zooKeeper.setData(path, data, version);
    }

    /**
     * Get node data
     * @param path
     * @return
     * @throws InterruptedException
     * @throws KeeperException
     */
    public byte[] getData(String path) throws InterruptedException, KeeperException{
        return zooKeeper.getData(path, false, null);
    }

    public Stat setData(String path, byte[] data, int version) throws InterruptedException, KeeperException{
        return zooKeeper.setData(path, data, version);
    }

    /**
     * Delete certain node
     * @param path
     * @param version
     * @throws InterruptedException
     * @throws KeeperException
     */
    public void delNode(String path, int version) throws InterruptedException, KeeperException{
        zooKeeper.delete(path, version);
    }

    /**
     * Close the connection
     * @throws InterruptedException
     */
    public void closeConnection() throws InterruptedException{
        zooKeeper.close();
    }
}
