package com.shwan.hsguo.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *@author  hsguo@youku.com 
 *@date 创建时间：2016-8-11 下午5:07:46 
 *@version 1.0 
 *@parameter 
 *@return
 */
@Controller
public class IndexController{
	private Logger log = Logger.getLogger(IndexController.class);
//	@Autowired
//	private ModuleManager moduleManager;
	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request, HttpServletResponse response){
		log.info("index");
		return "index";
	}
	
}
