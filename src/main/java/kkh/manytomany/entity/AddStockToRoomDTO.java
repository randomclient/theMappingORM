package kkh.manytomany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_to_room")
public class AddStockToRoomDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String roomNumber;
//	private String stockName;
	private String brandName;
	private String stockQty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

//	public String getStockName() {
//		return stockName;
//	}
//
//	public void setStockName(String stockName) {
//		this.stockName = stockName;
//	}

	public String getStockQty() {
		return stockQty;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

}
