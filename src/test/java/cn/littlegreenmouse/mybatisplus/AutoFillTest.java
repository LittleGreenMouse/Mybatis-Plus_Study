package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.model.po.User;
import cn.littlegreenmouse.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: zhanghao
 * @create: 2019/11/29 14:05:15
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AutoFillTest {

    @Resource
    UserService userServiceImpl;

    @Test
    public void insert() {
        User user = User.builder()
                .name("Little")
                .age(21)
                .email("test6@baomidou.com")
                .superId(2L)
                .build();
        userServiceImpl.save(user);
    }

    @Test
    public void update() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getId, 6L);
        User user = User.builder()
                .name("Mouse")
//                .updateTime(LocalDateTime.of(2020,1,1,12,12,12))
                .build();
        userServiceImpl.update(user, updateWrapper);
    }

}
