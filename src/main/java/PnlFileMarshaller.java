import generated.Documents;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class PnlFileMarshaller {

    static JAXBContext jaxbContext;
    static Unmarshaller unmarshaller;

    static {
        try {
            jaxbContext = JAXBContext.newInstance(Documents.class);
            unmarshaller = jaxbContext.createUnmarshaller();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method will return the object represnetation for the current file passed
     * @param currentFileToParse
     * @return
     * @throws JAXBException
     */
    public static Documents getGeneratedDocumets(File currentFileToParse) throws JAXBException {
        //File aa = new File ( this.getClass().getResource("test-file.xml").getFile());
        return  (Documents) unmarshaller.unmarshal(currentFileToParse);

    }
}
