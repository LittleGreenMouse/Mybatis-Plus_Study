package cn.littlegreenmouse.mybatisplus.model.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author: zhanghao
 * @create: 2019/11/27 18:50:31
 * @email: zhanghao@induschain.cn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long superId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Version
    private Integer version;

    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
