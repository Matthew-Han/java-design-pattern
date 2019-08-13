package xyz.yuanmo.adapter;

import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;
import xyz.yuanmo.service.KunKunService;

/**
 * @ClassName AbstractAdapter
 * @Description 抽象圣经
 * @Author MatthewHan
 * @Date 2019/7/26 16:18
 * @Version 1.0
 **/
public abstract class AbstractAdapter implements KunKunService {

    @Override
    public String singing(String lyric) {
        StringBuilder freestyle = new StringBuilder();
        String[] str = lyric.split("");
        for (String c : str) {
            freestyle.append(c);
            // 2.0 电力加强了
            freestyle.append(" ⚡⚡ ");
        }
        return String.valueOf(freestyle);
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }

    @Override
    public boolean playBall(Basketball basketball) {
        return true;
    }

}
