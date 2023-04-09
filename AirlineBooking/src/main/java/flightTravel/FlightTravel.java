package flightTravel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "flightTravel")
public class FlightTravel {
	private long id;
	private long sid;
	private String sname;
	private long did;
	private String dname;
	private long aid;
	private String aname;
	private double price;
	public FlightTravel() {}
	public FlightTravel(long sid,String sname,long did,String dname, long aid, String aname,double price) {
		this.sname=sname;
		this.dname=dname;
		this.price=price;
		this.sid=sid;
		this.did=did;
		this.aid=aid;
		this.aname=aname;
	}
	@Id 
	@GeneratedValue
	@Column(name = "ID")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "SOURCE")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Column(name = "DESTINATION")
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Column(name = "PRICE")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name = "SOURCEID")
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	@Column(name = "DESTINATIONID")
	public long getDid() {
		return did;
	}
	public void setDid(long did) {
		this.did = did;
	}
	@Column(name = "AIRLINEID")
	public long getAid() {
		return aid;
	}
	public void setAid(long aid) {
		this.aid = aid;
	}
	@Column(name = "AIRLINENAME")
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
}
