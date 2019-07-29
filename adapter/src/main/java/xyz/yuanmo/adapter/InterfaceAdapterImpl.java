package xyz.yuanmo.adapter;


import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.model.Music;

/**
 * @ClassName InterfaceAdapterImpl
 * @Description 坤の学习
 * @Author MatthewHan
 * @Date 2019/7/26 16:30
 * @Version 1.0
 **/
public class InterfaceAdapterImpl extends AbstractAdapter {

    @Override
    public String singing(String lyric) {
        return super.singing(lyric);
    }


    @Override
    public boolean playBall(Basketball basketball) {
        return super.playBall(basketball);
    }
}
