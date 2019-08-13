package xyz.yuanmo.service.impl;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.service.KrisService;

/**
 * @ClassName KrisServiceImpl
 * @Description U R so bad girl !
 * @Author MatthewHan
 * @Date 2019/7/25 16:11
 * @Version 1.0
 **/
public class KrisServiceImpl implements KrisService {

    /**
     * auto tone ⑧用麦克风就天然打开
     *
     * @return
     */
    @Override
    public String autoTone(String lyric) {

        StringBuilder freestyle = new StringBuilder();
        String[] str = lyric.split("");
        for (String c : str) {
            freestyle.append(c);
            freestyle.append(" ⚡ ");
        }

        return String.valueOf(freestyle);
    }

    @Override
    public boolean repay(long id) {
        return true;
    }

    @Override
    public boolean eatNoodles(long size) {
        return true;
    }

    @Override
    public boolean playBasketball(Basketball basketball) {
        return true;
    }

}
