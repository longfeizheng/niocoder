package com.niocoder.niocoder.provider.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2018/6/1.
 *
 * @author zlf
 * @since 1.0
 */
public class RpcProvider {

    private static List<Object> serviceList;

    public static void export(int port, Object... services) throws IOException {
        serviceList = Arrays.asList(services);
        ServerSocket serverSocket = new ServerSocket(port);
        Socket client =null;
        while (true){
            client = serverSocket.accept();
            new Thread(new ServerThread(client,serviceList)).start();
        }
    }
}
