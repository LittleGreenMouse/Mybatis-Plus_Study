package cn.littlegreenmouse.mybatisplus.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: zhanghao
 * @create: 2019/11/28 20:00:52
 * @email: zhanghao@induschain.cn
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasSetter("createTime")) {
            setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(getFieldValByName("updateTime", metaObject) == null) {
            setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
