package BasicSocket;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author wukai
 * @date 2019/5/30
 */
public class InetAddressExample {
    public static void main(String[] args) {
        try {
            //
            Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (interfaceEnumeration.hasMoreElements()) {
                NetworkInterface iface = interfaceEnumeration.nextElement();
                System.out.println(iface.getName());

                Enumeration<InetAddress> addressEnumeration = iface.getInetAddresses();
                while (addressEnumeration.hasMoreElements()) {
                    InetAddress address = addressEnumeration.nextElement();
                    System.out.println("hostAddress= "+address.getHostAddress()+", hostName"+address.getHostName());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
