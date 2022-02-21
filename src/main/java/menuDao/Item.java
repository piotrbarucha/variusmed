package menuDao;
 
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Item {
 
	@XmlAttribute
	String name;
	
//	ArrayList<Item>item  = new ArrayList<Item>();
	ArrayList<String>names  = new ArrayList<String>();
	
	public String getPropertyName() {
		return name;
	}
	public void setPropertyName(String name) {
		this.name = name;
		names.add(name);
	}
	public ArrayList<String> getNames() {
		return names;
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
}