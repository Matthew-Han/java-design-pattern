> 模式千万条，生命就一条，可以下班了。

<br />

# 设计模式的思想


什么是设计模式？放在两年前的我，不但不了解它，也不会去重视它。我只在乎能够猥琐实现，程序运行不报错。但是在版本快速迭代、需求明天就改、框架稳定升级的现在，自己也写了不少代码，积累了一些经验和知识，在快速成长的过程中，愈发觉得优秀的开发工程师就是会比平庸的开发工程师在设计、建模的过程中去花更多时间去思考、去推理。~~其实我觉得我也算是考虑问题比较全面、比较细致的人了（大雾~~）。

这里又可以引申出面向对象和面向过程，优秀的开发工程师可以把面向过程的程序写得非常内聚、可扩展性好、具备一定的复用性；而平庸的程序员用面向对象的语言一样也能把程序写得松散随意、毫无抽象与建模、模块耦合严重、维护性差。而设计模式也是考究程序员对业务的建模能力，以及对架构的宏观掌握能力，面向对象来说，以对象模型为核心，丰富模型的内涵，扩展模型的外延，通过模型的行为组合去共同解决某一力问题，抽象的能力必不可少。

啥是面向对象？总结就是四大特性：封装、继承、多态、抽象。这里不细讲了，留到之后在总结一篇post吧。

# 单例模式介绍

我们先不谈什么是单例模式，我想其实很多人其实最关心的是什么时候需要用到单例模式？使用单例模式之后有什么提升与益处？

首先我们知道单例单例，可以简单理解为单个实例，而实例化是指在面向对象的编程中，把用类创建对象的过程称为实例化。是将一个抽象的概念类，具体到该类实物的过程。

那么什么情况下会优先、或者强制使用单例模式创建实例呢：

- 数据库连接池，**注意：** 这里的单例指的是数据库连接池对象，而不是单个连接对象，这点一定要分清。
- `Spring`中的`Bean`，获取实例的时候都是默认单例模式，所以多线程是要注意（~~面试题警告⚠~~）。
- `API`接口中的`token`、`id`的获取，比如百度AI文字识别的`accessToken`中的获取，一般该`token`有一定的有效期，需要自行管理，当失效时需重新获取的方式，采用单例模式就可以很好的节约资源。
- 多个子类想共享一个父类的线程池的业务场景，频繁创建`ThreadPool`应该是不合适的，其实这个时候`static`单例化`ThreadPool`，注入是比较好的选择（这个例子比较特殊，可能是设计问题高耦合，可以不看）。

单例模式确保某个类只有一个实例，而且是自身创建唯一实例，提供一个全局访问的入口。网上的单例模式的写法大致就是3种：懒汉式单例模式、饿汉式单例模式、登记式单例模式：

-   懒汉式单例模式：在类加载时不初始化。
-   饿汉式单例模式：在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。
-   登记式单例模式：它的单例在类被装载的时候就被实例化了，内部也算是饿汉式单例模式。

登记式单例模式由于本人不太熟悉，所以在本文中只讲述前两种。

# Java类加载顺序

为什么要叫饿汉式、懒汉式呢？饿汉式则可以想象成因为太饿了，在类加载时就迫不及待完成了实例化，但是如果从初始化到线程结束都没有使用过的，就是变成了资源浪费。这里需要拓展下Java类的加载机制：

```java
/**
 * @ClassName Initialization
 * @Description 类的初始化顺序
 * @Author MatthewHan
 * @Date 2019/7/30 10:02
 * @Version 1.0
 **/
public class Initialization {

    private static IKun iKun = new IKun();

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块");
    }

    private Initialization(){
        System.out.println("构造器");
    }

    public static void main(String[] args){
        System.out.println("top-静态函数");
        new Initialization();
        System.out.println("bottom-静态函数");
    }
}
class IKun{

    IKun(){ System.out.println("静态变量"); }

}
```

![Java类加载顺序](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/singleton1.png)

从打印的结果可以看到Java类的加载顺序大致是：
    
    静态成员/静态代码块 --> main方法 --> 非静态成员/非静态代码块 --> 构造器

# 饿汉式单例模式

上面讲到了，饿汉式单例是在类加载就是内部实例化对象，并且不允许外部创建实例。饿汉式单例模式的实现也比较简单，记住无参构造器私有化，内部实例化对象，外部通过`static`方法获取对象。

我们都知道坤坤是一个对细节把控很有追求的人，从那段舞蹈的诸多细节就能够看出来。尤其是最后的白带滑落，堪称经典之举，坤坤通过有意的小失误将前面表演精心铺垫的「舞王」设定迅速推翻，营造了一种反差萌拉近与粉丝的距离，白带异常的表现也让粉丝们感同身受。

![白带异常](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/singleton1.gif)

坤坤自从白带表演大火🔥之后，淘宝厂商为了恰烂钱💰纷纷效仿推出「坤坤同款异常白带」、「坤坤潮流异常背带」的爆款产品。谁知道厂商还没开始恰烂钱💰的时候，坤坤就机智的把「坤式白带」和「白带异常」申请了发明专利、外观设计专利、实用专利，将「坤式白带」这个`商品`和「白带异常」这个`艺术作品`的所有权把握在了自己手里。「白带异常」的表演不允许外界直接模仿、抄袭，必须先向坤坤申请，支付一定费用才购买了「坤式白带」`对象`的`licence`后才可以表演「白带异常」，**并且使用完后要进行归还**，这样就能确保只有一个白带在外部商演能够很好的锁定。孙哥烂钱💰都恰得没这么6嗷~

```java
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
```

```java
@Test
public void getInstance() {
    // 向坤坤申请
    EarlySingleton s = EarlySingleton.getInstance();
    assertNotNull(s);
    // 白带异常演出
    System.out.println(s.slipping());
}
```

![共享白带√](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/singleton2.png)

**优点：**
- 线程安全

**缺点：**
- 类初始化实例化对象后未被调用则是浪费资源的表现


# 懒汉式单例模式

坤坤虽然唱跳俱佳，但也耐不住是条懒狗🐶，只有等到电话、message、inbox连环催，他才开始发货。

```java
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
     * @return
     */
    public static LazilySingleton getInstance() {
        if (suspenders == null) {
            suspenders = new LazilySingleton();
        }
        return suspenders;
    }
}
```

**优点：**
- 单例实例在第一次被使用时构建

**缺点：**
- 不加锁的话，存在线程安全问题，即使加了锁，对性能也产生了影响。

**注：** 为什么说饿汉式单例模式是线程不安全的呢，假如有两个客户`线程`准备购买「坤式白带」和「白带异常」进行商演，第一位客户提出申请，坤坤刚回复马上发货，另一位客户的聊天窗口弹了出来问能马上发货吗？坤坤一急立马回复马上发货，并把「白带」和「白带异常」的`licence`的包裹立马邮寄第二位客户，邮寄完之后坤坤想到第一位客户也在等待，于是又把新的「白带」和「使用权说明」邮寄给了第一位客户。然而现在已经有两个`对象`游离在外了，坤坤表示头很大。

坤坤发现自己的智商不适合做销售，亲自处理不但没牌面，而且容易出事情，但是交给经纪人又不放心，思来想去坤坤还是决定把这项业务交给哥哥孙笑川打理，自己则脱离去做更纯粹的音乐去了。

```java
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
```

**优点：**
- 线程安全
- 单例实例在第一次被使用时构建

**缺点：**
- 暂无


还是孙哥办事靠谱嗷，毕竟恰烂钱💰带师~