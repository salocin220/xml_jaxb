package xml_jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "xml_jaxb")
public class Radshop {

	
	private String name;
	private String addresse;
	
	@XmlElementWrapper(name = "radliste")
	ArrayList<Fahrrad> radliste = new ArrayList<Fahrrad>();

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public ArrayList getRadliste() {
		return radliste;
	}

	public void setRadliste(ArrayList radliste) {
		this.radliste = radliste;
	}
	
}
