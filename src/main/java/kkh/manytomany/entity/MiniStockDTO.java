package kkh.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	@ManyToMany
	@JoinTable(name = "stock_refri", joinColumns = @JoinColumn(name = "stock_id"), inverseJoinColumns = @JoinColumn(name = "refri_id"))
	private List<MiniRefrigeratorDTO> refrigerator = new ArrayList<MiniRefrigeratorDTO>();

	private String name;
	private int qty;
	private double price;
	private String status;

	public MiniStockDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<MiniRefrigeratorDTO> getRefrigerator() {
		return refrigerator;
	}

	public void setRefrigerator(List<MiniRefrigeratorDTO> refrigerator) {
		this.refrigerator = refrigerator;
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
