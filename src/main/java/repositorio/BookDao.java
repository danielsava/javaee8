package repositorio;

import model.lob.BookClobBlob;
import model.lob.BookLob;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Arrays;

public class BookDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    /**
     *     Segue os exemplos de LOB com a entidade BookLob
     */
    public void persistBookLob() {


        em.getTransaction().begin();

        BookLob b = new BookLob();
        b.setTitle("Opala Rocks - The Best Car of History");
        b.setCover(getCover());
        b.setContent("This is a veeeeeerry looong text with almost all the content that you can");

        em.persist(b);

        em.getTransaction().commit();


        BookLob b2 = em.find(BookLob.class, b.getId());

        if (Arrays.equals(b.getCover(), b2.getCover()))
            System.out.println("'Cover' iguais");

        if (b.getContent() == b2.getContent())
            System.out.println("'Content' iguais");

    }


    public void persistBookCLobBlob() {


        em.getTransaction().begin();

        BookClobBlob b = new BookClobBlob();
        b.setTitle("Opala Rocks - The Best Car of History");
        b.setCover(BlobProxy.generateProxy(getCover()));
        b.setContent(ClobProxy.generateProxy("This is a veeeeeerry looong text with almost all the content that you can"));

        em.persist(b);

        em.getTransaction().commit();


        BookLob b2 = em.find(BookLob.class, b.getId());

        if (Arrays.equals(b.getCover(), b2.getCover()))
            System.out.println("'Cover' iguais");

        if (b.getContent() == b2.getContent())
            System.out.println("'Content' iguais");

    }



    private byte[] getCover() {

        try {
            File file = new File("opala.jpg");
            byte[] conteudoImagemBytes = Files.readAllBytes(file.toPath());
            return conteudoImagemBytes;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }

        /*
        FileInputStream fis = null;
        byte[] bArray = new byte[(int) file.length()];

        try {
            fis = new FileInputStream(file);
            fis.read(bArray);
            fis.close();

            return bArray;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        */

    }




}
