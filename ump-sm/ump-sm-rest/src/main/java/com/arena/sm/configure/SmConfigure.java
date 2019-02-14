package com.arena.sm.configure;

import com.arena.sm.configure.mybatis.MybatisConfigure;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
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
@AutoConfigureBefore({ MybatisConfigure.class })
public class SmConfigure {
}
