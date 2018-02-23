package com.sauzny.springboot01testing;

import java.net.URI;
import java.util.concurrent.Future;

import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.WebSocketClient;

//当服务端返回一个超过65535长度的字符串时，使用注解中的参数解决问题
@WebSocket(maxTextMessageSize = 1048576, maxBinaryMessageSize = 1048576)
public class SecureClientSocket {

    public static void main(String[] args) {
        
        String url = "wss://localhost:8443/websocket";

        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setTrustAll(true); // The magic

        WebSocketClient client = new WebSocketClient(sslContextFactory);
        try {
            client.start();
            SecureClientSocket socket = new SecureClientSocket();
            Future<Session> fut = client.connect(socket, URI.create(url));
            Session session = fut.get();
            session.getRemote().sendString("Hello");
            session.getRemote().sendString("155-questions-active");
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    public Session buildSession(String url){
        
        Session session = null;
        
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setTrustAll(true);

        WebSocketClient client = new WebSocketClient(sslContextFactory);
        try {
            client.start();
            client.setStopTimeout(Long.MAX_VALUE);
            SecureClientSocket socket = new SecureClientSocket();
            Future<Session> fut = client.connect(socket, URI.create(url));
            session = fut.get();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        
        return session;
    }

    public void sendWithNewSocket(String url, String message){

        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setTrustAll(true); // The magic

        WebSocketClient client = new WebSocketClient(sslContextFactory);
        try {
            client.start();
            SecureClientSocket socket = new SecureClientSocket();
            Future<Session> fut = client.connect(socket, URI.create(url));
            Session session = fut.get();
            session.getRemote().sendString(message);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        
    }
    
    @OnWebSocketConnect
    public void onConnect(Session sess) {
        System.out.printf("onConnect({})", sess);
        System.out.println();
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("onClose({}, {})", statusCode, reason);
        System.out.println();
    }

    @OnWebSocketError
    public void onError(Throwable cause) {
        System.out.println(cause);
        System.out.println();
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        System.out.printf("onMessage() - {}", msg);
        System.out.println();
    }
}
