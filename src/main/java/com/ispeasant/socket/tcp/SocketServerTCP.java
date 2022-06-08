package com.ispeasant.socket.tcp;

        import java.io.IOException;
        import java.net.ServerSocket;
        import java.net.Socket;

public class SocketServerTCP {
    public static void main(String[] args) {
        try {
            // 通过ServerSocket类来创建服务端，端口为8888（TCP方式和UDP方式，使用的类是不一样）
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务端启动成功");

            // 创建个Socket对象，可以理解为客户端
            Socket socket = new Socket();

            // 正常情况，我们都是先启动服务端（Server），然后再启动客户端（Client）来连接服务端（Server）
            // 因此，我们需要一直监听客户端（Client）的连接
            while (true) {
                // 连接客户端（Client）
                socket = serverSocket.accept();

                // 我们采用多线程方式，这样就可以同时连接多个客户端
                SocketThreadTCP socketThreadTCP = new SocketThreadTCP(socket);
                socketThreadTCP.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}