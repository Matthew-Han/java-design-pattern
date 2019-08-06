package xyz.yuanmo.concrete;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.yuanmo.base.AbstractMacBookProduct;

/**
 * @ClassName MacBook13Product
 * @Description MacBook 13-inch具体产品类
 * @Author MatthewHan
 * @Date 2019/8/2 09:37
 * @Version 1.0
 **/
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@ToString
public class MacBook13Product extends AbstractMacBookProduct {

    /**
     * 13-inch MacBook附赠游♂戏大礼包
     */
    private String gameGiftBag;

    @Override
    public String printSlogan() {
        return "This is your new MacBook 13-inch.";
    }
}
