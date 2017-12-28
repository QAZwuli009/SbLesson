package cn.et.lesson01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//必须添加SpringBootApplication  启用spring的自动配置功能
@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		//启动会加载自动配置
		SpringApplication.run(Main.class);

	}
}
