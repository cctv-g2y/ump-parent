package com.arena.sm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * sm rest 启动类，sm单独部署时使用
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootApplication
public class SmApplication {

	public static void main(String[] args) {
		//写入PID
		ConfigurableApplicationContext context = new SpringApplicationBuilder(SmApplication.class).run(args);
		context.addApplicationListener(new ApplicationPidFileWriter());
	}
}
