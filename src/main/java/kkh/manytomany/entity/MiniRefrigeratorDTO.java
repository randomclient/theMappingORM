package kkh.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mini_refrigerator")
public class MiniRefrigeratorDTO {
	@Id
	private String miniRefrigeratorId;
	private String status;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "refrigerator")
	private List<MiniStockDTO> miniStock = new ArrayList<>();

	public MiniRefrigeratorDTO() {
	}

	public MiniRefrigeratorDTO(String miniRefrigeratorId, String status) {
		this.miniRefrigeratorId = miniRefrigeratorId;
		this.status = status;
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

	public List<MiniStockDTO> getMiniStock() {
		return miniStock;
	}

	public void setMiniStock(List<MiniStockDTO> miniStock) {
		this.miniStock = miniStock;
	}

}
