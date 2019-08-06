package xyz.yuanmo.concrete;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import xyz.yuanmo.base.AbstractMacBookProduct;

/**
 * @ClassName MacBook15Product
 * @Description MacBook 15-inch具体产品类
 * @Author MatthewHan
 * @Date 2019/8/2 09:37
 * @Version 1.0
 **/
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@ToString
public class MacBook15Product extends AbstractMacBookProduct {

    /**
     * 15-inch MacBook附赠的神秘代♂码
     */
    private String code;

    @Override
    public String printSlogan() {
        return "This is your new MacBook 15-inch.";
    }
}
