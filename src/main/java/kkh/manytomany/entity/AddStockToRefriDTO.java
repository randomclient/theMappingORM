package kkh.manytomany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_to_refri")
public class AddStockToRefriDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String refrigeratorId;
	private String stockName;
	private String stockQty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
