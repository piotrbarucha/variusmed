package menuDao;
 
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class MenuItem extends Item{
 
	ArrayList<MenuItem> item =  new ArrayList<MenuItem>();

	ArrayList<BookItem> book =  new ArrayList<BookItem>();
	
	public ArrayList<MenuItem> getItem() {
		return item;
	}
	@XmlElement
	public void setItem(ArrayList<MenuItem> item) {
		this.item = item;
	}
	public ArrayList<BookItem> getBook() {
		return book;
	}
	@XmlElement
	public void setBook(ArrayList<BookItem> book) {
		this.book = book;
	}
	public ArrayList<Item> getItemElement() {
		ArrayList<Item>tmpList = new ArrayList<Item>();
		for (String tmpName : names) {
			for(BookItem tmpBook : book){
				if(tmpName.equals(tmpBook.getPropertyName())){
					tmpList.add(tmpBook);
				}
			}
			for(MenuItem tmpItem : item){
				if(tmpName.equals(tmpItem.getPropertyName())){
					tmpList.add(tmpItem);
				}
			}
		}
		return tmpList;
	}
}