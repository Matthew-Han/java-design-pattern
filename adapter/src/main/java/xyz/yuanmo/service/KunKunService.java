package xyz.yuanmo.service;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;

/**
 * @ClassName KunKunService
 * @Description 坤坤业务的能力
 * @Author MatthewHan
 * @Date 2019/7/25 15:42
 * @Version 1.0
 **/
public interface KunKunService {

    /**
     * 唱
     *
     * @param lyric
     * @return
     */
    String singing(String lyric);

    /**
     * 跳
     *
     * @param music
     * @return
     */
    boolean dance(Music music);

    /**
     * rap
     *
     * @return
     */
    boolean rap();

    /**
     * 虚假的篮球🏀
     *
     * @param basketball
     * @return
     */
    boolean playBall(Basketball basketball);
}
