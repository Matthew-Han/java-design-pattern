package xyz.yuanmo.adapter;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;
import xyz.yuanmo.service.KrisService;
import xyz.yuanmo.service.KunKunService;

/**
 * @ClassName ObjectAdapterImpl
 * @Description 对象适配器
 * @Author MatthewHan
 * @Date 2019/7/26 09:53
 * @Version 1.0
 **/
public class ObjectAdapterImpl implements KunKunService {

    private KrisService krisService;

    public ObjectAdapterImpl(KrisService krisService) {
        this.krisService = krisService;
    }

    @Override
    public String singing(String lyric) {
        return krisService.autoTone(lyric);
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
