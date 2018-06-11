/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibil.datavault.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author abhagraw
 */
public class MyClientSocket {

    private static Socket socket;
    private Scanner scanner;

    private MyClientSocket(InetAddress serverAddress, int serverPort) throws Exception {
//        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }

    private void start() throws IOException {
        String input;
//        while (true) {
        input = scanner.nextLine();
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        out.println(input);
        out.flush();
        try (InputStream s1In = this.socket.getInputStream();
                // Get an input file handle from the socket and read the input
                DataInputStream dis = new DataInputStream(s1In)) {
            String st = dis.readUTF();
            System.out.println(st);
            // When done, just close the connection and exit
        }
//        }

    }

    private static OutputStream getOutputStream(Socket socket) {
        OutputStream outputStream = null;
        try {
            if (socket != null && !socket.isClosed()) {
                outputStream = socket.getOutputStream();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return outputStream;
    }

    private static InputStream getInputStream(Socket socket) {
        InputStream inputStream = null;
        try {
            if (socket != null && !socket.isClosed()) {
                inputStream = socket.getInputStream();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return inputStream;
    }

    public static void main(String[] args) throws Exception {
        MyClientSocket client = new MyClientSocket(
                InetAddress.getByName(args[0]),
                Integer.parseInt("63100"));

        //client.start();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket(InetAddress.getByName(args[0]),
                    Integer.parseInt("63100"));
            System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
            if (!socket.isClosed()) {
                outputStream = socket.getOutputStream();
                StringBuilder tuefRequest = new StringBuilder();
                tuefRequest.append("Test Message");
                IOUtils.write(String.valueOf(tuefRequest), outputStream);
                outputStream.flush();
                inputStream = socket.getInputStream();
                System.out.println(IOUtils.toString(inputStream));
            } else {
                System.out.println("No Response");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
