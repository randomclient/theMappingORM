package kkh.manytomany.model;

import java.util.List;

import kkh.manytomany.entity.MiniRefrigeratorDTO;

public class MiniStockBean {
	private String stockId;
	private String name;
	private int qty;
	private double price;
	private String status;
	private List<MiniRefrigeratorDTO> miniRefrigerator;
	

	public List<MiniRefrigeratorDTO> getMiniRefrigerator() {
		return miniRefrigerator;
	}

	public void setMiniRefrigerator(List<MiniRefrigeratorDTO> miniRefrigerator) {
		this.miniRefrigerator = miniRefrigerator;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
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

}
