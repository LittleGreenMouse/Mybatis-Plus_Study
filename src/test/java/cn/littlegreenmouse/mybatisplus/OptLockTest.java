package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.model.po.User;
import cn.littlegreenmouse.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: zhanghao
 * @create: 2019/11/29 14:48:49
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OptLockTest {

    @Resource
    UserService userServiceImpl;

    @Test
    public void updateById() {
        User user = userServiceImpl.getById(6L);
        User u = User.builder()
                .name("Mouse")
                .version(user.getVersion())
                .build();
        userServiceImpl.updateById(user);
    }

}
