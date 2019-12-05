package io.keyell.slf4j;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 * @author huangke 创建于 2019-12-04
 */


public class Slf4jTests {

    public static void suite() {
        TestSuite testSuite = new TestSuite();
        junit.framework.Test t1  = TestSuite.createTest(Slf4jLoggerTests.class, "testMaker");

        testSuite.addTest(t1);

        testSuite.addTestSuite(Slf4jMarkerTest.class);

        testSuite.run( new TestResult());

    }

}
