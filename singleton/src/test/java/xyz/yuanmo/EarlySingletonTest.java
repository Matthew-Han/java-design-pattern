package xyz.yuanmo;

import org.junit.Test;

import static org.junit.Assert.*;

public class EarlySingletonTest {

    @Test
    public void getInstance() {
        // 向坤坤申请
        EarlySingleton s = EarlySingleton.getInstance();
        assertNotNull(s);
        // 白带异常演出
        System.out.println(s.slipping());
    }
}