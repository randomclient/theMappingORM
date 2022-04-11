package kkh.manytomany.model;

import java.util.List;

import kkh.manytomany.entity.MiniStockDTO;

public class MiniRefrigeratorBean {
	private String miniRefrigeratorId;
	private String status;
	private List<MiniStockDTO> miniStock;
	

	public List<MiniStockDTO> getMiniStock() {
		return miniStock;
	}

	public void setMiniStock(List<MiniStockDTO> miniStock) {
		this.miniStock = miniStock;
	}

	public String getMiniRefrigeratorId() {
		return miniRefrigeratorId;
	}

	public void setMiniRefrigeratorId(String miniRefrigeratorId) {
		this.miniRefrigeratorId = miniRefrigeratorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
