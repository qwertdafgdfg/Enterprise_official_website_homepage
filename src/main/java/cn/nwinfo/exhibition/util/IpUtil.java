package cn.nwinfo.exhibition.util;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {
    private static final String UNKNOWN = "unknown";
    private static final String LOCALHOST = "127.0.0.1";
    private static final String SEPARATOR = ",";

    public static String getIpAddr(HttpServletRequest request) {
        System.out.println(request);
        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (LOCALHOST.equals(ipAddress)) {
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // "***.***.***.***".length()
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(SEPARATOR) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }
    public  static String getDeviceType(HttpServletRequest request){
        String User_Agent = request.getHeader("User-Agent");
        if (User_Agent.contains("Android")||User_Agent.contains("Linux")) {
            System.out.println("Android移动客户端");

            if (User_Agent.contains("MicroMessenger")) {
                System.out.println("微信");
                return "微信";
            }
            return "Android移动客户端";
        } else if (User_Agent.contains("iPhone")) {
            System.out .println("iPhone移动客户端");
            if (User_Agent.contains("MicroMessenger")) {
                System.out.println("微信");
                return "微信";
            }
            return "iPhone移动客户端";
        } else if (User_Agent.contains("iPad")) {
            System.out.println("iPad客户端");
            if (User_Agent.contains("MicroMessenger")) {
                System.out.println("微信");
                return "微信";
            }
            return "iPad客户端";
        } else if(User_Agent.contains("Windows")){
            System.out.println("Windows");
            return "Windows";
        }
        return null;
    }
}