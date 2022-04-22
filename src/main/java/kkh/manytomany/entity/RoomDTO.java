package kkh.manytomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class RoomDTO {	
	@Id
	private String room_number;

	private String room_status;
	private String room_desc;
	private String room_cleanstatus;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "roomtype_id", referencedColumnName = "roomtype_id")
	private RoomTypeDTO roomType;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "room")
	private List<MiniStockDTO> ministock = new ArrayList<>();

	

	public RoomDTO() {}

	public RoomDTO(String room_number, String room_status, String room_desc, String room_cleanstatus, String status,
			RoomTypeDTO roomType) {
		super();
		this.room_number = room_number;
		this.room_status = room_status;
		this.room_desc = room_desc;
		this.room_cleanstatus = room_cleanstatus;
		this.status = status;
		this.roomType = roomType;
	}
	
	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getRoom_status() {
		return room_status;
	}

	public void setRoom_status(String room_status) {
		this.room_status = room_status;
	}

	public String getRoom_desc() {
		return room_desc;
	}

	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}

	public String getRoom_cleanstatus() {
		return room_cleanstatus;
	}

	public void setRoom_cleanstatus(String room_cleanstatus) {
		this.room_cleanstatus = room_cleanstatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<MiniStockDTO> getMinistock() {
		return ministock;
	}

	public void setMinistock(List<MiniStockDTO> ministock) {
		this.ministock = ministock;
	}

	public RoomTypeDTO getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeDTO roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "RoomDTO [room_number=" + room_number + ", room_status=" + room_status + ", room_desc=" + room_desc
				+ ", room_cleanstatus=" + room_cleanstatus + ", status=" + status + ", roomType=" + roomType + "]";
	}




}
