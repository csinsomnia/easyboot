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


public class Slf4jMarkerTest extends TestCase {
    @Test
    public void testMaker() {
        Marker fatal = MarkerFactory.getMarker("FATAL");
        Logger logger = LoggerFactory.getLogger("aLogger");

        logger.error(fatal, "maker");
    }


}
