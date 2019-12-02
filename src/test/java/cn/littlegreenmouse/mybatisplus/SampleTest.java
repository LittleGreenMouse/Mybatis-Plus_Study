package cn.littlegreenmouse.mybatisplus;

import cn.littlegreenmouse.mybatisplus.dal.mapper.UserMapper;
import cn.littlegreenmouse.mybatisplus.model.po.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhanghao
 * @create: 2019/11/27 18:52:36
 * @email: zhanghao@induschain.cn
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = User.builder()
                .name("mouse")
                .age(21)
                .email("test6@baomidou.com")
                .build();
        int ret = userMapper.insert(user);
        Assert.assertEquals(1, ret);
        System.out.println(ret);
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }

    @Test
    public void selectIds() {
        List<Long> ids = Arrays.asList(1L, 3L, 6L);
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    @Test
    public void selectMap() {
        Map<String, Object> condition = new HashMap<>();
        condition.put("id", 6L);
        condition.put("name", "mouse");
        List<User> users = userMapper.selectByMap(condition);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.select(User.class, info -> !info.getColumn().equals("name") && !info.getColumn().equals("email"))
                .like("email", "test_@")
                .le("age", 21)
                .orderByDesc("age")
                .orderByAsc("name");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectByWrapperMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age")
                .like("email", "test_@")
                .le("age", 21)
                .orderByDesc("age")
                .orderByAsc("name");
        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectObjs() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.select("name", "age")
                .le("age", 21);
        List<Object> names = userMapper.selectObjs(queryWrapper);
        names.forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.le("age", 21);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }

    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = Wrappers.query();
        queryWrapper.eq("id", 6L);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void selectLambda() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.le(User::getAge, 21)
                .orderByDesc(User::getAge)
                .orderByAsc(User::getName);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void selectLambdaChain() {
        List<User> users = new LambdaQueryChainWrapper<User>(userMapper)
                .le(User::getAge, 21)
                .orderByDesc(User::getAge)
                .orderByAsc(User::getName)
                .list();
        users.forEach(System.out::println);
    }

    @Test
    public void selectPage() {
        Page<User> page = new Page<>(1, 4);
        IPage<User> iPage = userMapper.selectPage(page, null);
        iPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void selectMapPage() {
        Page<User> page = new Page<>(2, 4);
        IPage<Map<String, Object>> iPage = userMapper.selectMapsPage(page, null);
        iPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void updateById() {
        User user = User.builder().id(6L).name("Mouse").build();
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void updateByWrapper() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getName, "Mouse").eq(User::getAge, 21);
        User user = User.builder().name("mouse").build();
        int count = userMapper.update(user, updateWrapper);
        System.out.println(count);
    }

    @Test
    public void updateByWrapperNoEntity() {
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(User::getName, "Mouse").eq(User::getAge, 21).set(User::getName, "mouse");
        int count = userMapper.update(null, updateWrapper);
        System.out.println(count);
    }

    @Test
    public void deleteById() {
        int count = userMapper.deleteById(6L);
        System.out.println(count);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "mouse");
        map.put("age", 21);
        int count = userMapper.deleteByMap(map);
        System.out.println(count);
    }

    @Test
    public void deleteIds() {
        int count = userMapper.deleteBatchIds(Arrays.asList(8L, 9L));
        System.out.println(count);
    }

    @Test
    public void deleteByWrapper() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(User::getName, "mouse");
        int count = userMapper.delete(queryWrapper);
        System.out.println(count);
    }
}
