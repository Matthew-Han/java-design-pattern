package xyz.yuanmo;

/**
 * @ClassName Singleton
 * @Description 静态内部类
 * @Author MatthewHan
 * @Date 2019/7/30 16:16
 * @Version 1.0
 **/
public class Singleton {

    /**
     * 把业务交给哥哥孙笑川打理
     */
    private static class SunXiaoChuan{
        private static Singleton suspenders = new Singleton();
    }
    private Singleton(){}

    public static Singleton getInstance(){
        return SunXiaoChuan.suspenders;
    }
}
