package io.keyell.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Suite;

/**
 * JUnit 4 的注解使用
 *
 * @author huangke 创建于 2019-12-05
 */

@Suite.SuiteClasses(TestFixtureTest.class)
public class TestFixtureTest {

    private int i;
    private int j;
    private int k;

    @Before
    public void init() {
        i = 1;
        j = 2;
        k = 3;
        System.out.println("========= 每个@Test之前都会执行@Before ========");
    }

    /**
     * 1. @BeforeClass 必须使用在静态方法之上
     * 2. 只执行一次
     */
    @BeforeClass
    public static void initClass() {
        System.out.println("========= 仅仅执行一次 @BeforeClass ========");
    }

    @Test(expected = ArithmeticException.class)
    public void test1() {
        int m = i / 0;

        Assert.assertEquals(m, 0);
    }

    @Test
    public void test2() {
        int m = j / 2;

        Assert.assertEquals(m, 1);
    }


}
