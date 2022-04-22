package kkh.manytomany.model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import kkh.manytomany.entity.MiniStockDTO;
import kkh.manytomany.entity.RoomTypeDTO;

public class RoomBean {
	private String room_number;
	@NotEmpty(message = "Please Choose One")

	private String room_status;
	@Size(min = 10, max = 200, message = "Room Type Overview must be between 10 and 200 characters")

	private String room_desc;
	@NotEmpty(message = "Please Choose one")

	private String room_cleanstatus;
	private String status;
	
	private List<MiniStockDTO> ministock;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoom_cleanstatus() {
		return room_cleanstatus;
	}

	public void setRoom_cleanstatus(String room_cleanstatus) {
		this.room_cleanstatus = room_cleanstatus;
	}

	@ManyToOne
	@JoinColumn(name = "roomtype_id", referencedColumnName = "roomtype_id")

	private RoomTypeDTO roomType;

	public RoomTypeDTO getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeDTO roomType) {
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

	public List<MiniStockDTO> getMinistock() {
		return ministock;
	}

	public void setMinistock(List<MiniStockDTO> ministock) {
		this.ministock = ministock;
	}
	
	
}
