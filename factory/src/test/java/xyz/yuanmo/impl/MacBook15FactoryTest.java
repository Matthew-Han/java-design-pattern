package xyz.yuanmo.impl;

import org.junit.Test;
import xyz.yuanmo.base.AbstractMacBookProduct;
import xyz.yuanmo.base.MacBookFactory;
import xyz.yuanmo.concrete.MacBook15Factory;
import xyz.yuanmo.concrete.MacBook15Product;

import static org.junit.Assert.*;

public class MacBook15FactoryTest {

    @Test
    public void createMacBook() {

        /*
         * 抽象==================>具体
         */
        MacBookFactory macBook15Factory = new MacBook15Factory();
        /*
         * 15-inch MacBook实例化对象就由MacBook15Factory创建
         */
        AbstractMacBookProduct mac15WithMatthew = macBook15Factory.createMacBook();

        /*
         * 具体工厂生产的对象与具体产品类实例化的产品
         */
        MacBook15Product c = new MacBook15Product();
        assertEquals(c.getClass(), mac15WithMatthew.getClass());


        System.out.println(mac15WithMatthew.getClass());
        System.out.println(mac15WithMatthew.printSlogan());
        System.out.println(mac15WithMatthew);
    }
}