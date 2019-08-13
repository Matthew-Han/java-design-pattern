package xyz.yuanmo.service;

import xyz.yuanmo.model.Basketball;

/**
 * @ClassName KrisService
 * @Description 加拿带电鳗的业务水平
 * @Author MatthewHan
 * @Date 2019/7/25 16:02
 * @Version 1.0
 **/
public interface KrisService {

    /**
     * 凡凡的充电计划√
     *
     * @param lyric
     * @return
     */
    String autoTone(String lyric);

    /**
     * 苏⚡️韵⚡️锦⚡️，你⚡️这⚡️里⚡️欠⚡️我⚡️的⚡️用⚡️什⚡️么⚡️还⚡️？
     *
     * @param id
     * @return
     */
    boolean repay(long id);

    /**
     * size一定要大，因为是大碗宽面!
     *
     * @param size
     * @return
     */
    boolean eatNoodles(long size);

    /**
     * 真正的篮球🏀 vs 虚假的篮球🏀
     *
     * @param basketball
     * @return
     */
    boolean playBasketball(Basketball basketball);
}
