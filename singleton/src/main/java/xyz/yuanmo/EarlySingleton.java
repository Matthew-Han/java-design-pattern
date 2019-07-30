package xyz.yuanmo;

import lombok.*;

/**
 * @ClassName EarlySingleton
 * @Description 饿汉式单例模式
 * @Author MatthewHan
 * @Date 2019/7/30 10:50
 * @Version 1.0
 **/
public class EarlySingleton {

    /**
     * 独享的moment
     */
    private EarlySingleton(){}

    /**
     * 内部实例化一个白带对象
     */
    private static EarlySingleton suspenders = new EarlySingleton();

    /**
     * 全局入口点
     * @return
     */
    public static EarlySingleton getInstance(){
        return suspenders;
    }

    /**
     * 白带异常的演出
     * @return
     */
    public Suspenders slipping(){
        return new Suspenders("white","白带异常");
    }


}

/**
 * 坤坤申请专利了嗷
 */
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
class Suspenders{

    private String color;
    private String action;

}