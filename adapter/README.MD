> 模式千万条，生命就一条，可以下班了。

<br />

*最初只是为了做个人笔记，参考了前人的笔记和博客，在这里我用更接潮流、更接地气的例子来帮助加深理解记忆。*

*由于本人技术水平也有限，着重点在于思想的理解，若出现任何错误、不恰当内容，欢迎各位前来[issues](https://github.com/Matthew-Han/java-design-pattern/issues)指正。*

*感谢任何分享、开源学习教程的前辈，正是有你们这一群乐于奉献的人才让整个生态变得生机勃勃、让这个行业日新月异。*


# 设计模式的思想


什么是设计模式？放在两年前的我，不但不了解它，也不会去重视它。我只在乎能够猥琐实现，程序运行不报错。但是在版本快速迭代、需求明天就改、框架稳定升级的现在，自己也写了不少代码，积累了一些经验和知识，在快速成长的过程中，愈发觉得优秀的开发工程师就是会比平庸的开发工程师在设计、建模的过程中去花更多时间去思考、去推理。~~其实我觉得我也算是考虑问题比较全面、比较细致的人了（大雾~~）。

这里又可以引申出面向对象和面向过程，优秀的开发工程师可以把面向过程的程序写得非常内聚、可扩展性好、具备一定的复用性；而平庸的程序员用面向对象的语言一样也能把程序写得松散随意、毫无抽象与建模、模块耦合严重、维护性差。而设计模式也是考究程序员对业务的建模能力，以及对架构的宏观掌握能力，面向对象来说，以对象模型为核心，丰富模型的内涵，扩展模型的外延，通过模型的行为组合去共同解决某一力问题，抽象的能力必不可少。

啥是面向对象？总结就是四大特性：封装、继承、多态、抽象。这里不细讲了，留到之后在总结一篇post吧。

# 适配器模式

适配器模式简而言之就是一个类的转接口转换成客户希望的另外一个接口，主要作用就是兼容。举个例子：中国标准220伏特的电压，日本是110伏特的电压，iPhone的充电头是5伏1安（~~万年没有快充，iPhone 4也是5伏1安~~），220伏特的电压没法直接给iPhone充电，就需要一个电源适配器来连接两者，所以适配器模式就是讲`一个类的转接口转换成客户希望的另一个接口`。

在`Spring`的体现：`Spring AOP`模块`BeforeAdvice`、`AfterAdvice`、`ThrowsAdvice`三种通知类型的支持实际上是借助适配器模式来实现的， 这样的好处是使得框架允许用户向框架中加入自己想要支持的任何一种通知类型， 上述三种通知类型是`Spring AOP`模块定义的， 它们是`AOP`联盟定义的`Advice`的子类型。在`Spring`中 基本`adapter`结尾都是适配器~

# 适配器的分类

- 类适配器 (通过引用适配者进行组合实现)
- 对象适配器 (通过继承适配者进行实现)
- 接口适配器 （通过抽象类来实现适配）

前二者在实现上有些许区别，作用一样，第三个接口适配器差别较大。

## 类适配器模式

> 原理：通过`继承`来实现适配器功能。

在这里我就是拿两位德艺双馨的人民艺术家老师：坤坤和凡凡的业务能力用代码来解释类适配器模式。

大家都知道坤坤是一位练习时长2年半的个人练习生，喜欢唱跳rap篮球：

```java
/**
 * @ClassName KunKunService
 * @Description 坤坤业务的能力
 * @Author MatthewHan
 * @Date 2019/7/25 15:42
 * @Version 1.0
 **/
public interface KunKunService {

    /**
     * 唱
     * @param lyric
     * @return
     */
    String singing(String lyric);

    /**
     * 跳
     * @param music
     * @return
     */
    boolean dance(Music music);

    /**
     * rap
     * @return
     */
    boolean rap();

    /**
     * 虚假的篮球🏀
     * @param basketball
     * @return
     */
    boolean playBall(Basketball basketball);
}
```
```java
/**
 * @ClassName KunKunServiceImpl
 * @Description 坤坤练习生业务能力的展现
 * @Author MatthewHan
 * @Date 2019/7/25 15:58
 * @Version 1.0
 **/
public class KunKunServiceImpl implements KunKunService {

    @Override
    public String singing(String lyric) {

        return lyric;
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }

    /**
     * 坤坤皮球还是给个赞👍
     * @return
     */
    @Override
    public boolean playBall(Basketball basketball) {
        return true;
    }

}
```

当然我们的加拿带🇨🇦电鳗凡凡业务能力也⑧差。自带auto tone放电的男人，每次看完他的Live，手机电就满了（~~据说凡凡打算成立凡电科技公司，主营移动充电业务~~）。恰面🍜水平也很高，而且恰面一定要大碗的。当然了，这么优秀的蓝人还是有个弱点的，就是怕苏韵锦像个石头一样欠的钱不还。

```java
/**
 * @ClassName KrisService
 * @Description 加拿带电鳗的业务水平
 * @Author MatthewHan
 * @Date 2019/7/25 16:02
 * @Version 1.0
 **/
public interface KrisService {

    /**
     * 凡凡的充电计划√
     * @return
     */
    String autoTone(String lyric);

    /**
     * 苏⚡️韵⚡️锦⚡️，你⚡️这⚡️里⚡️欠⚡️我⚡️的⚡️用⚡️什⚡️么⚡️还⚡️？
     * @param id
     * @return
     */
    boolean repay(long id);

    /**
     * size一定要大，因为是大碗宽面!
     * @param size
     * @return
     */
    boolean eatNoodles(long size);

    /**
     * 真正的篮球🏀 vs 虚假的篮球🏀
     * @param basketball
     * @return
     */
    boolean playBasketball(Basketball basketball);
}
```
```java
/**
 * @ClassName KrisServiceImpl
 * @Description U R so bad girl !
 * @Author MatthewHan
 * @Date 2019/7/25 16:11
 * @Version 1.0
 **/
public class KrisServiceImpl implements KrisService {

    /**
     * auto tone ⑧用麦克风就天然打开
     * @return
     */
    @Override
    public String autoTone(String lyric) {

        StringBuilder freestyle = new StringBuilder();
        String[] str = lyric.split("");
        for(String c : str){
            freestyle.append(c);
            freestyle.append(" ⚡ ");
        }

        return String.valueOf(freestyle);
    }

    @Override
    public boolean repay(long id) {
        return true;
    }

    @Override
    public boolean eatNoodles(long size) {
        return true;
    }

    @Override
    public boolean playBasketball(Basketball basketball){
        return true;
    }

}
```

有一天坤坤觉得自己的成名作《鸡你太美》虽然灵幻动听，但是还是少了点什么味道。为了充电的他打开了pilipili看了凡凡的Live后恍然大悟，原来是少了auto tone！但是坤坤自身根本没有这种天赋，于是身为带明星的坤坤就打算偷学凡凡的绝技，打算在以后的唱歌中都加入这种带电的感觉。

```java
/**
 * @ClassName ClassKunKunAdapter
 * @Description 坤の偷学
 * @Author MatthewHan
 * @Date 2019/7/25 17:02
 * @Version 1.0
 **/
public class ClassAdapterImpl extends KrisServiceImpl implements KunKunService {

    @Override
    public String singing(String lyric) {
        return super.autoTone(lyric);
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }

    @Override
    public boolean playBall(Basketball basketball) {
        return true;
    }

}
```

![类适配器](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter1-1.png)

```java
@Test
public void singingOfClass() {
    KunKunService c = new ClassAdapterImpl();

    assertEquals(c.singing("鸡你太美!"),"鸡 ⚡ 你 ⚡ 太 ⚡ 美 ⚡ ! ⚡ ");

    System.out.println(c.singing("鸡你太美!"));
}
```

我们来测试下结果，坤坤`师承`凡凡，通过偷学凡凡的绝技成功的让自己的唱歌技巧上了几个鹿晗的level，成为young OG就是这么简单。

但是我们也可以看到这种实现方式，需要将坤坤的所有业务能力全部覆写一遍，实属⑧够灵活，其实我们还有接口适配器模式。

![坤坤发电了吗](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter1-2.png)

## 对象适配器模式

通过将凡凡业务员初始化，`new`一个对象凡凡，让凡凡来帮忙使用auto tone，坤凡合体演绎鸡🐔你太美！

```java
/**
 * @ClassName ObjectAdapterImpl
 * @Description 对象适配器
 * @Author MatthewHan
 * @Date 2019/7/26 09:53
 * @Version 1.0
 **/
public class ObjectAdapterImpl implements KunKunService {

    private KrisService krisService;

    public ObjectAdapterImpl(KrisService krisService) {
        this.krisService = krisService;
    }

    @Override
    public String singing(String lyric) {
        return krisService.autoTone(lyric);
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }

    @Override
    public boolean playBall(Basketball basketball) {
        return true;
    }
}
```

同样的，坤坤在更♂衣室也来测试下效果
```java
@Test
public void singingOfObject() {
    KrisService krisService = new KrisServiceImpl();
    KunKunService o = new ObjectAdapterImpl(krisService);

    assertEquals(o.singing("鸡你太美~"),"鸡 ⚡ 你 ⚡ 太 ⚡ 美 ⚡ ~ ⚡ ");

    System.out.println(o.singing("鸡你太美~"));
}
```

![对象适配器](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter2-1.png)

![坤坤假唱实锤](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter2-2.png)

虽然是坤坤的舞台，但是却有加拿带🇨🇦电流声？假唱实锤！

## 接口适配器模式

上面两种实现方式，毫无例外的都覆写了坤坤的所有业务能力，略显笨重，那么适配器模式可以只将坤坤的一种或多种技能进行适配强化。

自从坤坤唱歌也能发电之后，坤坤成功的选上了NBA篮球带使，但是却被广大直男们怒喷。坤坤很抑郁啊，于是就去找了当年美国校队啦啦队的队长Chaoyue Yang，希望能够从幸运光环一身的她找到点帮助。Chaoyue妹妹耐心地和坤坤说，你现在被直男们喷还是因为把篮球🏀玩出皮球的感觉，实属弟弟，篮球技术还是要偷学凡凡嗷~

于是坤坤在一个与杰伦超话流量争顶的晚上，专门虚心去请教凡凡关于篮球技巧，顺便把auto tone升级到2.0。

凡凡见到坤坤没有丝毫以外，缓缓说道：你想要的一切，我都放在了抽象圣经`《AbstractAdapter》`里面了，自己去取需要的吧，别再来打扰我了，U R so bad girl！

```java
/**
 * @ClassName AbstractAdapter
 * @Description 抽象圣经
 * @Author MatthewHan
 * @Date 2019/7/26 16:18
 * @Version 1.0
 **/
public abstract class AbstractAdapter implements KunKunService {

    @Override
    public String singing(String lyric) {
        StringBuilder freestyle = new StringBuilder();
        String[] str = lyric.split("");
        for(String c : str){
            freestyle.append(c);
            // 2.0 电力加强了
            freestyle.append(" ⚡⚡ ");
        }
        return String.valueOf(freestyle);
    }

    @Override
    public boolean playBall(Basketball basketball) { return true; }

}
```
```java
/**
 * @ClassName InterfaceAdapterImpl
 * @Description 坤の学习
 * @Author MatthewHan
 * @Date 2019/7/26 16:30
 * @Version 1.0
 **/
public class InterfaceAdapterImpl extends AbstractAdapter {

    @Override
    public String singing(String lyric) {
        return super.singing(lyric);
    }

    @Override
    public boolean dance(Music music) {
        return false;
    }

    @Override
    public boolean rap() {
        return false;
    }
    
    @Override
    public boolean playBall(Basketball basketball) { 
        return super.playBall(basketball); 
    }
}
```

![接口适配器](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter3-1.png)

```java
@Test
public void singingOfInterface() {
    KunKunService i = new InterfaceAdapterImpl();

    assertEquals(i.singing("鸡你太美..."),"鸡 ⚡⚡ 你 ⚡⚡ 太 ⚡⚡ 美 ⚡⚡ . ⚡⚡ . ⚡⚡ . ⚡⚡ ");

    System.out.println(i.singing("鸡你太美..."));
}

@Test
public void playBallOfInterface() {
    KunKunService i = new InterfaceAdapterImpl();

    assertTrue(i.playBall(new Basketball()));
}
```

![2.0的auto tone 电力翻倍！](https://hexo-espada.oss-cn-hangzhou.aliyuncs.com/Espada/blog_pictures/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/adapter3-2.png)

坤坤通过研读抽象圣经`《AbstractAdapter》`后，不但学到了真正的篮球，还把auto tone成功升级到2.0，电力翻倍。