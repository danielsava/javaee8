package cdi.producer.properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


/**
 *
 *  Neste caso, basta colocar a anotação @FileExampleProperties
 *  com o nome da propriedade do arquivo de properties
 *
 *  @FileExampleProperties("dbuser")
 *  private String usuario;
 *
 *
 */

@ApplicationScoped
public class FileExamplePropertiesProducer implements Serializable {

    private static Properties props;

    static {
        props = new Properties();
        try {
            props.load(FileExampleProperties.class.getResourceAsStream("fileExample.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Produces
    @FileExampleProperties
    public static String producerFileExampleProperties(InjectionPoint injectionPoint) {
        String chave = injectionPoint.getAnnotated().getAnnotation(FileExampleProperties.class).value();
        return props.getProperty(chave);
    }

}
