package xyz.yuanmo.base;

import lombok.*;

/**
 * @ClassName AbstractMacBookProduct
 * @Description 所有MacBook抽象产品类，可以理解成各种型号的MacBook笔记本
 * @Author MatthewHan
 * @Date 2019/8/1 18:02
 * @Version 1.0
 **/
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMacBookProduct {
    private String sn;
    private String type;
    private String display;
    private String keyboard;
    private String weight;
    private Double price;

    /**
     * 打印结账语
     * @return
     */
    public abstract String printSlogan();
}
