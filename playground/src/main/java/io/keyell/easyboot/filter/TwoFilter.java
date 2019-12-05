package io.keyell.easyboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author huangke 创建于 2019-12-03
 */
public class TwoFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(TwoFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String p2 = filterConfig.getInitParameter("p2");
        logger.warn("[TwoFilter] getInitParameter p2: {}", p2);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        logger.warn("filterChain {}", filterChain);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
