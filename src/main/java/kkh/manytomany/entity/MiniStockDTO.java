package kkh.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mini_stock")
public class MiniStockDTO {
	@Id
	private String stockId;
//	@ManyToMany
//	@JoinTable(name = "stock_refri", joinColumns = @JoinColumn(name = "stock_id"), inverseJoinColumns = @JoinColumn(name = "refri_id"))
//	private List<MiniRefrigeratorDTO> refrigerator = new ArrayList<MiniRefrigeratorDTO>();

	@ManyToMany
	@JoinTable(name = "stock_room", joinColumns = @JoinColumn(name = "stock_id"), inverseJoinColumns = @JoinColumn(name = "room_number"))
	private List<RoomDTO> room = new ArrayList<RoomDTO>();

	private String brandName;
	
	private String supplier;
	private String name;
	private int qty;
	private double price;
	private String status;

	public MiniStockDTO() {
		super();
	}

	public MiniStockDTO(String stockId, String name, int qty, double price, String status) {
		this.stockId = stockId;
		this.name = name;
		this.qty = qty;
		this.price = price;
		this.status = status;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

//	public List<MiniRefrigeratorDTO> getRefrigerator() {
//		return refrigerator;
//	}
//
//	public void setRefrigerator(List<MiniRefrigeratorDTO> refrigerator) {
//		this.refrigerator = refrigerator;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RoomDTO> getRoom() {
		return room;
	}

	public void setRoom(List<RoomDTO> room) {
		this.room = room;
	}

}
