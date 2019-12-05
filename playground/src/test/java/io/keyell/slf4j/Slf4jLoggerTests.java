package io.keyell.slf4j;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author huangke 创建于 2019-12-04
 */


public class Slf4jLoggerTests extends TestCase {
    @Test
    public void testMaker() {
        Marker fatal = MarkerFactory.getMarker("FATAL");
        Logger logger = LoggerFactory.getLogger("aLogger");

        logger.error(fatal, "MKT");

//        try {
//        } catch (JDBException e) {
//            logger.error(fatal, "Failed to obtain JDBC connection", e);
//        }
    }

    /**
     * 测试 Logger中的 format 和 String.format
     */
    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger("aLogger");

//        logger.error("Failed to obtain JDBC connection {} ", "1x", new Exception("mock"));
        logger.error("Failed to obtain {}  JDBC connection {} {}", "c", "d", "b");

        System.out.println(String.format("d{1} %s", "1xt"));

    }

}
