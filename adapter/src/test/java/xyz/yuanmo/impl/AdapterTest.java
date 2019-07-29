package xyz.yuanmo.impl;

import org.junit.Test;
import xyz.yuanmo.service.KunKunService;
import xyz.yuanmo.service.impl.KunKunServiceImpl;

import static org.junit.Assert.assertEquals;


public class AdapterTest {

    @Test
    public void singing() {

        KunKunService og = new KunKunServiceImpl();
        assertEquals(og.singing("鸡你太美..."),"鸡你太美...");
        System.out.println(og.singing("鸡你太美..."));
    }
}