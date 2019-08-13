> 模式千万条，生命就一条，可以下班了。

<br />

# 设计模式的思想


什么是设计模式？放在两年前的我，不但不了解它，也不会去重视它。我只在乎能够猥琐实现，程序运行不报错。但是在版本快速迭代、需求明天就改、框架稳定升级的现在，自己也写了不少代码，积累了一些经验和知识，在快速成长的过程中，愈发觉得优秀的开发工程师就是会比平庸的开发工程师在设计、建模的过程中去花更多时间去思考、去推理。~~其实我觉得我也算是考虑问题比较全面、比较细致的人了（大雾~~）。

这里又可以引申出面向对象和面向过程，优秀的开发工程师可以把面向过程的程序写得非常内聚、可扩展性好、具备一定的复用性；而平庸的程序员用面向对象的语言一样也能把程序写得松散随意、毫无抽象与建模、模块耦合严重、维护性差。而设计模式也是考究程序员对业务的建模能力，以及对架构的宏观掌握能力，面向对象来说，以对象模型为核心，丰富模型的内涵，扩展模型的外延，通过模型的行为组合去共同解决某一力问题，抽象的能力必不可少。

啥是面向对象？总结就是四大特性：封装、继承、多态、抽象。这里不细讲了，留到之后在总结一篇post吧。


# 工厂模式

## 抽象类的解释

一般我们需要对象时候，通常的做法是`new`一个对象，工厂模式则是强调由具体的工厂来生产一个对象给你使用。

首先最好解释一下`抽象类`，我当初就是一直不太能理解，可能对于很多初学者来说也是。简单来说，抽象类像是一个模板，比如说Apple的MacBook Pro产品线，基本上历年迭代一次。而最新2019年MacBook Pro产品线中，包含着几款配置不同的产品。这些产品的屏幕、键盘、CPU、内存、金属一体外壳是抽象出来的共同特征，每一款具体的产品都离不开这些属性。而不同型号的产品又存在差异化和卖点，比如15inch和13inch的屏幕，低中高配的CPU、显卡、存储，特有的touch bar和触控ID等等。

![2019 MacBook Pro](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/factory1-3.png/wm)

为了方便举例，我们理想化的认为这些不同型号产品的诞生都是由一个MacBook Pro`模具`从抽象到具体的过程，针对不同需求的人群差异化的结果。抽象类也是如此，它通过类的继承可以有不同版本的实现，不同版本都会做相应的增删改。

## 具体实现

什么时候用工厂模式比较好？它能解决什么问题？

> **其实我觉得就一句话，降低耦合度和批量化生产。**

因为工厂模式是针对单一产品簇的对象，比如一类膨化食品、一类手机、一类blazer。这些产品不去麻烦客户而交给工厂去处理，之后产品大面积出现问题返厂或者迭代更新也都是各个工厂的事。

这里有4个关于工厂模式的角色概念，我用下图表示了他们之间的关系。

- **抽象工厂(Abstract Factory)角色**：是工厂方法模式的核心，与应用程序无关。任何在模式中创建的对象的工厂类必须实现这个接口。
- **具体工厂(Concrete Factory)角色**：这是实现抽象工厂接口的具体工厂类，包含与应用程序密切相关的逻辑，并且受到应用程序调用以创建某一种产品对象。
- **抽象产品(AbstractProduct)角色**：工厂方法模式所创建的对象的超类型，也就是产品对象的共同父类或共同拥有的接口。
- **具体产品(Concrete Product)角色**：这个角色实现了抽象产品角色所定义的接口。某具体产品有专门的具体工厂创建，它们之间往往一一对应。

![本文实例](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/factory1-2.png/wm)

```java
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
     * @return
     */
    AbstractMacBookProduct createMacBook();
}
```
<center>MacBook的抽象工厂类，用于描述所有具体型号生产的MacBook工厂的抽象基类。</center>

```java
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
```

<center>一类MacBook产品的抽象产品，差异化的产品配置。</center>

抽象二兄弟的实现比较简单，其中抽象工厂接口定义的是`生产MacBook`的方法，就像是和各个工厂之间签了一份略有差别的合同，那么在具体生产的工厂中需要严格按照这份合同执行。抽象产品类则是体现`is-a`关系，更像是把这类产品的雏形给雕琢出来的模具，是具体产品的爹，具体工厂按照合同去生产合规的产品。

```java
/**
 * @ClassName MacBook13Factory
 * @Description MacBook 13-inch的具体工厂
 * @Author MatthewHan
 * @Date 2019/8/2 09:12
 * @Version 1.0
 **/
public class MacBook13Factory implements MacBookFactory {
    @Override
    public AbstractMacBookProduct createMacBook() {
        MacBook13Product macBook13 = new MacBook13Product();
        macBook13.setSn(RandomUtil.getStr());
        macBook13.setType("MacBook Pro 13-inch");
        macBook13.setDisplay("13-inch");
        macBook13.setKeyboard("new keyboard");
        macBook13.setPrice(999D);
        macBook13.setWeight("88kg");
        /*
         * 游戏大礼包竟然是！
         * 《坦克大战乔碧萝》
         */
        macBook13.setGameGiftBag("《坦克大战乔碧萝》");
        return macBook13;
    }
}
```

```java
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
```

<center>13-inch MacBook的具体工厂和他生产的具体产品13-inch MacBook</center>

13-inch MacBook具体工厂也按照`合同`和`模具`对MacBook进行批量生产组装加工，`MacBook13Product`通过`extend`的方式，完全继承了模具的属性和行为，其中《坦克大战乔碧萝》这个游戏礼包是该产品的特有属性。

```java
/**
 * @ClassName MacBook15Factory
 * @Description MacBook 15-inch具体工厂
 * @Author MatthewHan
 * @Date 2019/8/2 09:30
 * @Version 1.0
 **/
public class MacBook15Factory implements MacBookFactory {
    
    @Override
    public AbstractMacBookProduct createMacBook() {
        MacBook15Product macBook15 = new MacBook15Product();
        macBook15.setSn(RandomUtil.getStr());
        macBook15.setType("MacBook Pro 15-inch");
        macBook15.setDisplay("15-inch");
        macBook15.setKeyboard("new keyboard");
        macBook15.setPrice(1999D);
        macBook15.setWeight("88kg");
        /*
         * 蕴含着神秘力量的密码
         * 带你找回丢失的纯真时光
         */
        macBook15.setCode("magnet:?xt=urn:btih:36AAB086D9AF39A323082CBAD452D6BDC42147D1");
        return macBook15;
    }
}

```

```java
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

```

<center>15-inch MacBook的具体工厂和他生产的具体产品15-inch MacBook</center>

15-inch MacBook具体工厂也按照`合同`和`模具`对MacBook进行批量生产组装加工，`MacBook13Product`通过`extend`的方式，完全继承了模具的属性和行为，其中神秘代码是该产品的特有属性。

来测试一下这些代工厂996生产的产品到底合不合规：

```java
@Test
public void createMacBook() {
    /*
     * 抽象==================>具体
     */
    MacBookFactory macBook13Factory = new MacBook13Factory();
    /*
     * 13-inch MacBook实例化对象就由MacBook13Factory创建
     */
    AbstractMacBookProduct mac13WithMatthew = macBook13Factory.createMacBook();
     
    /*
     * 具体工厂生产的对象与具体产品类实例化的产品
     */
    MacBook13Product c = new MacBook13Product();
    assertEquals(c.getClass(), mac13WithMatthew.getClass());
    
    System.out.println(mac13WithMatthew.getClass());
    System.out.println(mac13WithMatthew.printSlogan());
    System.out.println(mac13WithMatthew);
}
```

```java
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
```
![单元测试](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/factory1-5.png/wm)
![单元测试](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/factory1-6.png/wm)

`System.out.println(mac13WithMatthew)`打印的结果只有`gameGiftBag`是因为子类重写父类的`toString()`方法，如果把子类（`MacBook13Product`）的`@ToString`注解去掉的话，就是默认继承的父类（`AbstractMacBookProduct`）的`toString()`方法了。


# 避免滥用

事实上，SpringBoot中已经用到了不少设计模式，在[单例模式](http://www.yuanmo.xyz/post/fae94450-bd9c-11e9-bafd-2904b28e3726/)那章讲过的`Bean`就用到了单例模式和今天讲的工厂模式（很怀念第一次使用Spring框架手写第一个Bean的时候），模板方法(Template Method)，`Jdbctempldate`、`Redistemplate`等等。模式本身是对编程思想的扩展，我们在编写代码的时候还是要专注于业务本身，模式本身就是为了追求更高效率而诞生，保护需要加班的你。最靠谱的还是实践中慢慢总结，踩过的坑怎么去优化。
