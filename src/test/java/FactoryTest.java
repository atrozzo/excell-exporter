import generated.Documents;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class FactoryTest {


    @Test
    public void testObjectToXmlWorks() throws JAXBException {

        File aa = new File ( this.getClass().getResource("test-file.xml").getFile());
        JAXBContext jaxbContext = JAXBContext.newInstance(Documents.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Documents documents = (Documents) unmarshaller.unmarshal(aa);

        Assertions.assertNotNull(documents);
    }





}
