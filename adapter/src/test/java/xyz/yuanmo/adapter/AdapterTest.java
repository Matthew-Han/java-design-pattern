package xyz.yuanmo.adapter;


import org.junit.Test;
import xyz.yuanmo.model.Basketball;
import xyz.yuanmo.service.KrisService;
import xyz.yuanmo.service.KunKunService;
import xyz.yuanmo.service.impl.KrisServiceImpl;


import static org.junit.Assert.*;

public class AdapterTest {

    @Test
    public void singingOfClass() {
        KunKunService c = new ClassAdapterImpl();

        assertEquals(c.singing("鸡你太美!"),"鸡 ⚡ 你 ⚡ 太 ⚡ 美 ⚡ ! ⚡ ");

        System.out.println(c.singing("鸡你太美!"));
    }

    @Test
    public void singingOfObject() {
        KrisService krisService = new KrisServiceImpl();
        KunKunService o = new ObjectAdapterImpl(krisService);

        assertEquals(o.singing("鸡你太美~"),"鸡 ⚡ 你 ⚡ 太 ⚡ 美 ⚡ ~ ⚡ ");

        System.out.println(o.singing("鸡你太美~"));
    }

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
}