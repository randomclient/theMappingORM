package kkh.manytomany.model;

import java.util.List;

//import kkh.manytomany.entity.MiniRefrigeratorDTO;
import kkh.manytomany.entity.RoomDTO;

public class MiniStockBean {
	private String stockId;
	private String brandName;
	private String supplier;
	private String name;
	private int qty;
	private double price;
	private String status;
//	private List<MiniRefrigeratorDTO> miniRefrigerator;
	private List<RoomDTO> room;

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

//	public List<MiniRefrigeratorDTO> getMiniRefrigerator() {
//		return miniRefrigerator;
//	}
//
//	public void setMiniRefrigerator(List<MiniRefrigeratorDTO> miniRefrigerator) {
//		this.miniRefrigerator = miniRefrigerator;
//	}

	public List<RoomDTO> getRoom() {
		return room;
	}

	public void setRoom(List<RoomDTO> room) {
		this.room = room;
	}
	
	

}
