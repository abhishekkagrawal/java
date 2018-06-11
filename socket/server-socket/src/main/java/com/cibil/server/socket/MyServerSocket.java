/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibil.server.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author abhagraw
 */
public class MyServerSocket {

    private static ServerSocket server;

    public MyServerSocket(String ipAddress) throws Exception {
        if (ipAddress != null && !ipAddress.isEmpty()) {
            this.server = new ServerSocket(63100, 1, InetAddress.getByName(ipAddress));
        } else {
            this.server = new ServerSocket(63100, 1, InetAddress.getLocalHost());
        }
    }

    private void listen() throws Exception {
        String data = null;
        Socket client = this.server.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\r\nNew connection from " + clientAddress);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        while ((data = in.readLine()) != null) {
            System.out.println("\r\nMessage from " + clientAddress + ": " + data);
        }
        try ( // Get a communication stream associated with the socket
                OutputStream s1out = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(s1out)) {
            // Send a string!
            dos.writeUTF("Acknowledge: Received Request");
            // Close the connection, but not the server socket
        }

    }

    public InetAddress getSocketAddress() {
        return this.server.getInetAddress();
    }

    public int getPort() {
        return this.server.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        MyServerSocket app = new MyServerSocket(args[0]);
        System.out.println("\r\nRunning Server: "
                + "Host=" + app.getSocketAddress().getHostAddress()
                + " Port=" + app.getPort());

//        app.listen();
        Socket client = MyServerSocket.server.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\r\nNew connection from " + clientAddress);
        InputStream inputStream = client.getInputStream();
        System.out.println(IOUtils.toString(inputStream));
        OutputStream outputStream = client.getOutputStream();
        StringBuilder tuefRequest = new StringBuilder();
        tuefRequest.append("Acknowledge: Request Received");
        IOUtils.write(String.valueOf(tuefRequest), outputStream);
        outputStream.flush();

    }
}
