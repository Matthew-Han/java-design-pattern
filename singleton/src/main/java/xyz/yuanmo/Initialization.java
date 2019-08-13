package xyz.yuanmo;

/**
 * @ClassName Initialization
 * @Description 类的初始化顺序
 * @Author MatthewHan
 * @Date 2019/7/30 10:02
 * @Version 1.0
 **/
public class Initialization {

    private static IKun iKun = new IKun();

    public static void out() {
        System.out.println("out");
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块");
    }

    private Initialization() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        out();
        System.out.println("top-静态函数");
        new Initialization();
        System.out.println("bottom-静态函数");
        EarlySingleton s = EarlySingleton.getInstance();
        System.out.println(s.slipping());
    }
}

class IKun {

    IKun() {
        System.out.println("静态变量");
    }

}