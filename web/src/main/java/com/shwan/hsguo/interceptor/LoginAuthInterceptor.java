package com.shwan.hsguo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.shwan.hsguo.utils.IpUtils;
public class LoginAuthInterceptor implements HandlerInterceptor{
	private Logger logger = Logger.getLogger(LoginAuthInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		try{
			if(arg2 !=null){
				String action = arg2.getClass().getSimpleName();
				if(action !=null){
					String ip = IpUtils.getIp(arg0);
					String view = "";
					if(arg3!=null){
						if(arg3.getViewName()!=null){
							view = arg3.getViewName();
						}
					}
					String url = arg0.getRequestURI() == null?"":arg0.getRequestURI();
					String userAgent = arg0.getHeader("User-Agent") == null ?"" :arg0.getHeader("User-Agent");
					//访问地址|展示页面|ip|ua
					String pvInfo = "access_log$"+"|"+url+"|"+view+"|"+ip+"|"+userAgent;
			        logger.info(pvInfo);
				}
			}
		}catch(Exception e){
			logger.error(e);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		return true;
	}

	
	
}
