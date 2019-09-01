package io.keyell.easyboot;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.keyell.easyboot.domain.Customer;
import io.keyell.easyboot.mapper.CustomerMapper;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * @author huangke 创建于 2019/2/26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MybatisTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Customer> userList = customerMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);

        Page<Customer> page =new Page<>(0,2);
        QueryWrapper<Customer> entityWrapper = new QueryWrapper<>();
        entityWrapper.gt("id", 20);


        System.out.println("-------");
        IPage<Customer> p = customerMapper.selectPage(page, entityWrapper);
        System.out.println(p.getCurrent());
        System.out.println(p.getPages());
        System.out.println(p.getSize());
        System.out.println(p.getTotal());

        p.getRecords().forEach(System.out::println);

    }

}