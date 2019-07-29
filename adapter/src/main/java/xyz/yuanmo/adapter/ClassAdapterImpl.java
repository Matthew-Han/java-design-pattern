package xyz.yuanmo.adapter;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;
import xyz.yuanmo.service.KunKunService;
import xyz.yuanmo.service.impl.KrisServiceImpl;

/**
 * @ClassName ClassKunKunAdapter
 * @Description 坤の偷学
 * @Author MatthewHan
 * @Date 2019/7/25 17:02
 * @Version 1.0
 **/
public class ClassAdapterImpl extends KrisServiceImpl implements KunKunService {

    @Override
    public String singing(String lyric) {
        return super.autoTone(lyric);
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
