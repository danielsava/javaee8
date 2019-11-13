package jms;


import javax.annotation.PostConstruct;
import javax.jms.JMSConsumer;
import javax.jms.JMSException;
import javax.jms.Topic;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ReceiverRest {

    public Queue<String> mensagensRecebidas = new ConcurrentLinkedQueue<>();

    public ReceiverRest() {    }


    @PostConstruct
    private void init() {
        Topic topic = jmsContext.createTopic("example/strings");
        JMSConsumer consumer = jmsContext.createConsumer(topic);
        consumer.setMessageListener((message) -> {
            try {
                String msg = message.getBody(String.class);
                mensagensRecebidas.add(msg);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }

    @POST
    @Path("/receive")
    @Produces("text/plain")
    public String receive() {
        return mensagensRecebidas.poll();
    }

}
