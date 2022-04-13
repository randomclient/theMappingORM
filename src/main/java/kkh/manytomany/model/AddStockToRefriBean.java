package kkh.manytomany.model;

import javax.validation.constraints.NotEmpty;

public class AddStockToRefriBean {
	
	@NotEmpty(message="Id must be filled.")
	private String refrigeratorId;
	
	@NotEmpty(message="Stock's name must be filled.")
	private String stockName;
	
	@NotEmpty(message="Stock Quantity must be filled.")
	private String stockQty;
	
	public String getRefrigeratorId() {
		return refrigeratorId;
	}
	public void setRefrigeratorId(String refrigeratorId) {
		this.refrigeratorId = refrigeratorId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockQty() {
		return stockQty;
	}
	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}
	
	
}
