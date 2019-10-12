package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestPropertyList {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "frank");
        map.put(2, "frank");
        map.put(3, "bruce");
        for (int i = 0; i < 500; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(1, "frank");
                }
            }).start();

        }
        System.out.println(map);
    }
}
