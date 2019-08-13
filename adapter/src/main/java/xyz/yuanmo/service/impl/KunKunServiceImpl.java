package xyz.yuanmo.service.impl;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;
import xyz.yuanmo.service.KunKunService;

/**
 * @ClassName KunKunServiceImpl
 * @Description 坤坤练习生业务能力的展现
 * @Author MatthewHan
 * @Date 2019/7/25 15:58
 * @Version 1.0
 **/
public class KunKunServiceImpl implements KunKunService {

    @Override
    public String singing(String lyric) {

        return lyric;
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }

    /**
     * 坤坤皮球还是给个赞👍
     *
     * @return
     */
    @Override
    public boolean playBall(Basketball basketball) {
        return true;
    }

}
