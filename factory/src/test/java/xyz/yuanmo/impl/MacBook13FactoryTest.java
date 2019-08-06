package xyz.yuanmo.impl;

import org.junit.Test;
import xyz.yuanmo.base.AbstractMacBookProduct;
import xyz.yuanmo.base.MacBookFactory;
import xyz.yuanmo.concrete.MacBook13Factory;
import xyz.yuanmo.concrete.MacBook13Product;
import xyz.yuanmo.concrete.MacBook15Product;
import xyz.yuanmo.util.RandomUtil;

import static org.junit.Assert.*;

public class MacBook13FactoryTest {

    @Test
    public void createMacBook() {
        /*
         * 抽象==================>具体
         */
        MacBookFactory macBook13Factory = new MacBook13Factory();
        /*
         * 13-inch MacBook实例化对象就由MacBook13Factory创建
         */
        AbstractMacBookProduct mac13WithMatthew = macBook13Factory.createMacBook();

        /*
         * 具体工厂生产的对象与具体产品类实例化的产品
         */
        MacBook13Product c = new MacBook13Product();
        assertEquals(c.getClass(), mac13WithMatthew.getClass());

        System.out.println(mac13WithMatthew.getClass());
        System.out.println(mac13WithMatthew.printSlogan());
        System.out.println(mac13WithMatthew);
    }
}