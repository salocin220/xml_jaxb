package xml_jaxb;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Testklasse {

	 private static final String BIKESTORE_XML = "./bikestore.xml";
	 
	public static void main(String[] args) throws JAXBException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Fahrrad> radliste = new ArrayList<Fahrrad>();
		
		Fahrrad f1 = new Fahrrad();
		f1.setBezeichnung("Rennrad");
		f1.setMarke("votec");
		f1.setFarbe("Schwarz");
		f1.setPreis(620);
		
		Fahrrad f2 = new Fahrrad();
		f2.setBezeichnung("BMX");
		f2.setMarke("Felt");
		f2.setFarbe("Grün");
		f2.setPreis(480);
		
		Radshop rs = new Radshop();
		rs.setName("BikeBox");
		rs.setAddresse("Nussgasse 11");
		rs.setRadliste(radliste);
		
		 
        JAXBContext context = JAXBContext.newInstance(Radshop.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
       
        m.marshal(rs, System.out);
        m.marshal(rs, new File(BIKESTORE_XML));
        
        //Ausgabe des XML Files auf der Console!
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Radshop rshop = (Radshop) um.unmarshal(new FileReader(BIKESTORE_XML));
        ArrayList<Fahrrad> list = rshop.getRadliste();
        for (Fahrrad fahrrad : list) {
          System.out.println("Fahrrad"+"/n" + "Bezeichnung: " + fahrrad.getBezeichnung() + " ,Marke:  "
              + fahrrad.getMarke() + " ,Preis:  " + fahrrad.getPreis() + " ,Farbe:  " + fahrrad.getFarbe());
        }
	}

}
