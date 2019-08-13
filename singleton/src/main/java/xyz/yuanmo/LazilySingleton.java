package xyz.yuanmo;

/**
 * @ClassName LazilySingleton
 * @Description 懒汉式单例模式
 * @Author MatthewHan
 * @Date 2019/7/30 15:46
 * @Version 1.0
 **/
public class LazilySingleton {

    /**
     * 同样的避免外部实例化
     */
    private LazilySingleton() {
    }

    private static LazilySingleton suspenders = null;

    /**
     * 线程不安全
     *
     * @return
     */
    public static LazilySingleton getInstance() {
        if (suspenders == null) {
            suspenders = new LazilySingleton();
        }
        return suspenders;
    }
}
