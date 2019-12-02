package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.model.po.User;
import cn.littlegreenmouse.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhanghao
 * @create: 2019/11/28 19:37:27
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogicDeleteTest {

    @Resource
    UserService userServiceImpl;

    @Test
    public void deleteById() {
        userServiceImpl.removeById(4L);
    }

    @Test
    public void selectList() {
        List<User> users = userServiceImpl.list();
        users.forEach(System.out::println);
    }
}
