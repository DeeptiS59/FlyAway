package airline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity  
@Table(name= "airline")
public class Airline {
	private long id;  
	private String name;
	public Airline(){
		
	}
	public Airline( String name) {this.name=name;}
	
	@Id 
	@GeneratedValue
	@Column(name = "ID")
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "AIRLINE_NAME")
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}
