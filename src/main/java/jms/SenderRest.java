package jms;

import javax.jms.CompletionListener;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


/**
 *   JMS no Wildfly:
 *      - http://arthurgregorio.eti.br/blog/java/queue-com-jms-2-no-wildfly-utilizando-javaee-8/
 *
 */
public class SenderRest {


    // Exemplo de Envio Assincrono
    @POST
    @Path("/send")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String send(String msg) {
        Topic topic = jmsContext.createTopic("example/strings");
        JMSProducer producer = jmsContext.createProducer();
        producer.setAsync(new CompletionListener() {
            @Override
            public void onCompletion(Message message) { /* ... */ }
            @Override
            public void onException(Message message, Exception e) { /* ... */ }
        });
        producer.send(topic, msg);
        return "Mensagem Enviada, Ok !";
    }

}
