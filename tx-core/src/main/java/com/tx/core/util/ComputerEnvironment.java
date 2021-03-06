/*
 * 描          述:  <描述>
 * 修  改   人:  brady
 * 修改时间:  2013-5-21
 * <修改描述:>
 */
package com.tx.core.util;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tx.core.TxConstants;

/**
 * 计算机运行环境辅助类<br/>
 * <功能详细描述>
 * 
 * @author  brady
 * @version  [版本号, 2013-5-21]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ComputerEnvironment {
    
    //日志记录器<br/>
    private static Logger logger = LoggerFactory.getLogger(ComputerEnvironment.class);
    
    private Set<String> hostAddressSet = new HashSet<String>();
    
    private Set<String> macAddressSet = new HashSet<String>();
    
    private List<IpConfigInfo> ipConfigInfoList = new ArrayList<ComputerEnvironment.IpConfigInfo>();
    
    /** <默认构造函数> */
    public ComputerEnvironment() {
        super();
        
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            while(nis.hasMoreElements()){
                NetworkInterface networkInterface = nis.nextElement();

                //获取当前机器的mac地址
                String macAddress = "";
                if(networkInterface.getHardwareAddress() != null){
                    StringBuilder sb = new StringBuilder(TxConstants.INITIAL_STR_LENGTH);
                    
                    byte[] macByte = networkInterface.getHardwareAddress();
                    int m = 0; 
                    for(int i=0;i<macByte.length;i++){  
                        //byte表示范围-128~127，//因此>127的数被表示成负数形式，这里+256转换成正数  
                        m = macByte[i]<0?(macByte[i]+256):macByte[i];
                        sb.append(Integer.toHexString(m).toUpperCase());
                    }
                    macAddress = sb.toString();
                }
                
                //获取当前机器的ip相关信息
                List<InterfaceAddress> iaList = networkInterface.getInterfaceAddresses();
                List<String> hostNameList = new ArrayList<String>();
                List<String> hostAddressList = new ArrayList<String>();
                for(InterfaceAddress iat : iaList){
                    hostNameList.add(iat.getAddress().getHostName());
                    hostAddressList.add(iat.getAddress().getHostAddress());
                }
                
                ipConfigInfoList.add(new IpConfigInfo(macAddress, hostNameList, hostAddressList));
            }
        } catch (SocketException e) {
            logger.error(e.toString(),e);
        }
        
        for(IpConfigInfo ipConfigInfoTemp : ipConfigInfoList){
            macAddressSet.add(ipConfigInfoTemp.getMacAddress());
            hostAddressSet.addAll(ipConfigInfoTemp.getHostAddressList());
        }
    }

    /**
      * ipConfig相关信息
      * <功能详细描述>
      * 
      * @author  brady
      * @version  [版本号, 2013-5-21]
      * @see  [相关类/方法]
      * @since  [产品/模块版本]
     */
    public static class IpConfigInfo{
        
        private String macAddress;
        
        private List<String> hostNameList;
        
        private List<String> hostAddressList;
        
        /** <默认构造函数> */
        private IpConfigInfo(String macAddress, List<String> hostNameList,
                List<String> hostAddressList) {
            super();
            this.macAddress = macAddress;
            this.hostNameList = hostNameList;
            this.hostAddressList = hostAddressList;
        }

        /**
         * @return 返回 macAddress
         */
        public String getMacAddress() {
            return macAddress;
        }

        /**
         * @param 对macAddress进行赋值
         */
        public void setMacAddress(String macAddress) {
            this.macAddress = macAddress;
        }

        /**
         * @return 返回 hostNameList
         */
        public List<String> getHostNameList() {
            return hostNameList;
        }

        /**
         * @param 对hostNameList进行赋值
         */
        public void setHostNameList(List<String> hostNameList) {
            this.hostNameList = hostNameList;
        }

        /**
         * @return 返回 hostAddressList
         */
        public List<String> getHostAddressList() {
            return hostAddressList;
        }

        /**
         * @param 对hostAddressList进行赋值
         */
        public void setHostAddressList(List<String> hostAddressList) {
            this.hostAddressList = hostAddressList;
        }

    }
    
    /**
     * @return 返回 hostAddressSet
     */
    public Set<String> getHostAddressSet() {
        return hostAddressSet;
    }



    /**
     * @param 对hostAddressSet进行赋值
     */
    public void setHostAddressSet(Set<String> hostAddressSet) {
        this.hostAddressSet = hostAddressSet;
    }



    /**
     * @return 返回 macAddressSet
     */
    public Set<String> getMacAddressSet() {
        return macAddressSet;
    }



    /**
     * @param 对macAddressSet进行赋值
     */
    public void setMacAddressSet(Set<String> macAddressSet) {
        this.macAddressSet = macAddressSet;
    }



    /**
     * @return 返回 ipConfigInfoList
     */
    public List<IpConfigInfo> getIpConfigInfoList() {
        return ipConfigInfoList;
    }



    /**
     * @param 对ipConfigInfoList进行赋值
     */
    public void setIpConfigInfoList(List<IpConfigInfo> ipConfigInfoList) {
        this.ipConfigInfoList = ipConfigInfoList;
    }



    public static void main(String[] args) throws Exception{
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        
        while(nis.hasMoreElements()){
            NetworkInterface networkInterface = nis.nextElement();
            
            System.out.println("mac:");
            if(networkInterface.getHardwareAddress() != null){
                //String macAddress = new String(networkInterface.getHardwareAddress());
                System.out.println(networkInterface.getHardwareAddress());
                byte[] mac = networkInterface.getHardwareAddress();
                int m = 0; 
                System.out.println(mac.length);
                for(int i=0;i<mac.length;i++){  
                    //byte表示范围-128~127，因此>127的数被表示成负数形式，这里+256转换成正数  
                    m = mac[i]<0?(mac[i]+256):mac[i];  
                    System.out.print(Integer.toHexString(m).toUpperCase()+"\t"); 
                    
                }  
                System.out.println("");
            }
            
            
            Enumeration<InetAddress> niTemp = networkInterface.getInetAddresses();
            while(niTemp.hasMoreElements()){
                InetAddress ia = niTemp.nextElement();
                
                System.out.println(ia.getHostName());
                System.out.println(ia.getHostAddress());
            }
            
            List<InterfaceAddress> iaList = networkInterface.getInterfaceAddresses();
            for(InterfaceAddress iat : iaList){
                System.out.println(iat.getAddress().getHostName());
                System.out.println(iat.getAddress().getHostAddress());
            }
            
        }
    }
}
