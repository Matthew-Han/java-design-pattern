package xyz.yuanmo.util;

import java.util.Random;

/**
 * @ClassName Random
 * @Description TODO
 * @Author MatthewHan
 * @Date 2019/8/5 10:28
 * @Version 1.0
 **/
public class RandomUtil {


    public static String getStr() {

        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }


}
