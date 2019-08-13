package xyz.yuanmo.base;

/**
 * @ClassName MacBookFactory
 * @Description MacBook的抽象工厂类
 * @Author MatthewHan
 * @Date 2019/8/1 18:01
 * @Version 1.0
 **/
public interface MacBookFactory {

    /**
     * MacBook抽象工厂
     *
     * @return
     */
    AbstractMacBookProduct createMacBook();
}
