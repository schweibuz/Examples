package com.company.horstmannBP.socket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by iMac on 08.02.17.
 */
class InetAddressTest {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {      //если через консоль были введены аргументы
            String host = args[0];      //то записать в хост первый эдемент массива
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses)
                System.out.println(a);
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
