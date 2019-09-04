package repositorio;

import model.lob.BookClobBlob;
import model.lob.BookLob;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.SQLException;
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


    public void persistBookCLobBlob() throws SQLException {


        em.getTransaction().begin();

        BookClobBlob b1 = new BookClobBlob();
        b1.setTitle("Opala Rocks - The Best Car of History");
        b1.setCover(BlobProxy.generateProxy(getCover()));
        b1.setContent(ClobProxy.generateProxy("This is a veeeeeerry looong text with almost all the content that you can"));

        em.persist(b1);

        em.getTransaction().commit();


        BookClobBlob b2 = em.find(BookClobBlob.class, b1.getId());


        Reader b2Content_charStream = b2.getContent().getCharacterStream();
        InputStream b2Cover_stream = b2.getCover().getBinaryStream();


        byte[] coverB1 = b1.getCover().getBytes(1, new Long(b1.getCover().length()).intValue());
        byte[] coverB2 = b2.getCover().getBytes(1, new Long(b2.getCover().length()).intValue());

        String contentB1 = b1.getContent().getSubString(1, new Long(b1.getContent().length()).intValue());
        String contentB2 = b2.getContent().getSubString(1, new Long(b2.getContent().length()).intValue());


        if (Arrays.equals(coverB1, coverB2))
            System.out.println("'Cover' iguais");

        if (contentB1 == contentB2)
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
