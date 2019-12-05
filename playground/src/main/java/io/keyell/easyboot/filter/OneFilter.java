package io.keyell.easyboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author huangke 创建于 2019-12-03
 */
public class OneFilter implements Filter {

    Logger logger = LoggerFactory.getLogger(OneFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String p1 = filterConfig.getInitParameter("p1");
        logger.warn("[OneFilter] getInitParameter p1: {}", p1);

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
