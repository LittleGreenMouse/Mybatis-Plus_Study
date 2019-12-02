package cn.littlegreenmouse.mybatisplus.service.impl;

import cn.littlegreenmouse.mybatisplus.dal.mapper.UserMapper;
import cn.littlegreenmouse.mybatisplus.model.po.User;
import cn.littlegreenmouse.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: zhanghao
 * @create: 2019/11/28 18:42:30
 * @email: zhanghao@induschain.cn
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
