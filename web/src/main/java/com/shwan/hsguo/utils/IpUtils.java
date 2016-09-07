package com.shwan.hsguo.utils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
public class IpUtils{
  private IpUtils(){
  }
  public static Logger logger = Logger.getLogger(IpUtils.class);
  /**
   * 获取客户端真实IP
   * 
   * @param request
   */
  public static String getIp(HttpServletRequest request){
	  
    String ip = request.getHeader("x-forwarded-for");
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
        ip = request.getHeader("X-Real-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
      ip = request.getHeader("Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
      ip = request.getRemoteAddr();
      if(ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")){  
          //根据网卡取本机配置的IP  
          InetAddress inet=null;  
          try {  
              inet = InetAddress.getLocalHost();  
          } catch (UnknownHostException e) {  
              e.printStackTrace();  
          }  
          ip = inet.getHostAddress();  
      } 
    }
    // 多级反向代理检测
    if(ip != null && ip.indexOf(",") > 0){
      ip = ip.trim().split(",")[0];
    }
    return ip;
  }

}
