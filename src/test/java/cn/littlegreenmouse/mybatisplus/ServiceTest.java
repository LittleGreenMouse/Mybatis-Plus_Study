package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: zhanghao
 * @create: 2019/11/28 18:44:44
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {

    @Resource
    UserService userServiceImpl;
}
