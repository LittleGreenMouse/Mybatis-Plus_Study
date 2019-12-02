package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.model.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: zhanghao
 * @create: 2019/11/28 17:55:50
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActiveRecordTest {

    @Test
    public void insert() {
        User user = User.builder()
                .name("mouse")
                .age(21)
                .email("test6@baomidou.com")
                .build();
        boolean ret = user.insert();
        System.out.println(ret);
    }

    @Test
    public void selectById() {
        User user = new User();
        User u = user.selectById(11L);
        System.out.println(u);
    }

    @Test
    public void selectById_() {
        User user = User.builder().id(11L).build();
        User u = user.selectById();
        System.out.println(u);
    }

    @Test
    public void updateById() {
        User user = User.builder().id(11L).name("MOUSE").build();
        boolean ret = user.updateById();
        System.out.println(ret);
    }

    @Test
    public void deleteById() {
        User user = new User();
        boolean ret = user.deleteById(11L);
        System.out.println(ret);
    }

    @Test
    public void deleteById_() {
        User user = User.builder().id(12L).build();
        boolean ret = user.deleteById();
        System.out.println(ret);
    }

}
