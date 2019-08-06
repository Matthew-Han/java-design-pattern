package xyz.yuanmo.concrete;

import xyz.yuanmo.base.AbstractMacBookProduct;
import xyz.yuanmo.base.MacBookFactory;
import xyz.yuanmo.util.RandomUtil;

/**
 * @ClassName MacBook15Factory
 * @Description MacBook 15-inch具体工厂
 * @Author MatthewHan
 * @Date 2019/8/2 09:30
 * @Version 1.0
 **/
public class MacBook15Factory implements MacBookFactory {

    @Override
    public AbstractMacBookProduct createMacBook() {
        MacBook15Product macBook15 = new MacBook15Product();
        macBook15.setSn(RandomUtil.getStr());
        macBook15.setType("MacBook Pro 15-inch");
        macBook15.setDisplay("15-inch");
        macBook15.setKeyboard("new keyboard");
        macBook15.setPrice(1999D);
        macBook15.setWeight("88kg");
        /*
         * 蕴含着神秘力量的密码
         * 带你找回丢失的纯真时光
         */
        macBook15.setCode("magnet:?xt=urn:btih:36AAB086D9AF39A323082CBAD452D6BDC42147D1");
        return macBook15;
    }
}
