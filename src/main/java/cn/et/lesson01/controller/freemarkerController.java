package cn.et.lesson01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class freemarkerController {
	/**
	 * 访问freemarker 用(@Controller)注解
	 */
	@RequestMapping("/index")
	public void freemarker() {
		//return "index";
	}
}
