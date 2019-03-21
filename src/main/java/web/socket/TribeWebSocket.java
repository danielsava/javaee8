package web.socket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *  Fontes:
 *
 *  - https://github.com/tomitribe/secured-websocket/blob/master/src/main/tomee/conf/tomcat-users.xml : WebSocket
 *  - https://www.tomitribe.com/blog/tomee-ssl-tls-secured-websockets/ : WebSocket com SSL/TLS
 *
 *
 *
 */


@ServerEndpoint(value = "/socket")
public class TribeWebSocket {


    @OnOpen
    public void onOpen(final Session session) throws Exception {
        session.getBasicRemote().sendText("Hello " + session.getUserPrincipal().getName());
    }

}
