package xyz.yuanmo.concrete;

import xyz.yuanmo.base.AbstractMacBookProduct;
import xyz.yuanmo.base.MacBookFactory;
import xyz.yuanmo.util.RandomUtil;

/**
 * @ClassName MacBook13Factory
 * @Description MacBook 13-inch的具体工厂
 * @Author MatthewHan
 * @Date 2019/8/2 09:12
 * @Version 1.0
 **/
public class MacBook13Factory implements MacBookFactory {
    @Override
    public AbstractMacBookProduct createMacBook() {
        MacBook13Product macBook13 = new MacBook13Product();
        macBook13.setSn(RandomUtil.getStr());
        macBook13.setType("MacBook Pro 13-inch");
        macBook13.setDisplay("13-inch");
        macBook13.setKeyboard("new keyboard");
        macBook13.setPrice(999D);
        macBook13.setWeight("88kg");
        /*
         * 游戏大礼包竟然是！
         * 《坦克大战乔碧萝》
         */
        macBook13.setGameGiftBag("《坦克大战乔碧萝》");
        return macBook13;
    }
}
