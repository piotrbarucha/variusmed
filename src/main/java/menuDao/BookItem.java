package menuDao;
 
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class BookItem extends Item{

	String path;
	
	public String getPath() {
		return path;
	}
	@XmlElement
	public void setPath(String path) {
		this.path = path;
	}
}