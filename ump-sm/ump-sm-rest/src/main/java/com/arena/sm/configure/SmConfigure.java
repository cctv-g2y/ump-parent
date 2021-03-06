package com.arena.sm.configure;

import com.arena.sm.configure.mybatis.MybatisConfigure;
import com.arena.sm.configure.security.SecurityConfigure;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * sm 配置信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@AutoConfigureAfter({ SecurityConfigure.class, MybatisConfigure.class })
public class SmConfigure {
}
