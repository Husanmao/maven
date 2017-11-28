package com.huawei.colin;

import com.huawei.colin.util.PropertiesUtil;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @since 1.8+
 */
public class ClientStart {

    private static Logger logger = Logger.getLogger(ClientStart.class);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
//        final ITest service = (ITest) context.getBean("springservice");
//        String resp = service.sayHi();
//        System.out.println(resp);
//        try {
//            System.in.read();
//        } catch (IOException e) {
//
//        }
//        String host = "127.0.0.1:2181";
//        BaseZookeeper baseZookeeper = new BaseZookeeper();
//        baseZookeeper.connectZookeeper(host);
//        System.out.println("Connect Zookeeper OK");
//
//        byte[] data = {1, 2, 3, 4, 5};
//        String result = baseZookeeper.createNode("/test", data);
//        System.out.println(result);
//        System.out.println("Create Node OK");
//
//        List<String> children = baseZookeeper.getChildren("/");
//        children.forEach(System.out::println);
//
//        byte[] nodeData = baseZookeeper.getData("/test");
//        System.out.println(Arrays.toString(nodeData));
//        System.out.println("Get Node Data Ok");
//
//        data = "test data".getBytes();
//        baseZookeeper.setData("/test", data, 0);
//        System.out.println("update data succeed");
//
//
//        nodeData = baseZookeeper.getData("/test");
//        System.out.println(Arrays.toString(nodeData));
//        System.out.println("Get new data ok");
//
//        baseZookeeper.closeConnection();

        String path = ClientStart.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
        System.out.println(PropertiesUtil.getParsing_time());
    }
}
