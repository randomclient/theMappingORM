package kkh.manytomany.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="room_type")
public class RoomTypeDTO {
	@Id
	@Column(name = "roomtype_id")
	private String roomtype_id;
	// @Column(name = "roomtype_name", nullable = false, updatable = false)
	private String roomtype_name;
	private String roomtype_desc;
	// @Column(name = "room_price", nullable = false)
	private double room_price;
	// @Column(name = "roomtype_coverimg", nullable = false)
	private String roomtype_coverimg;
	private String roomtype_status;
	private String roomtype_overview;
	private String roomtype_detail;

	private String roomtype_img1;
	private String roomtype_img2;
	private String roomtype_img3;
	private String roomtype_img4;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoomtype_id() {
		return roomtype_id;
	}

	public void setRoomtype_id(String roomtype_id) {
		this.roomtype_id = roomtype_id;
	}

	public String getRoomtype_name() {
		return roomtype_name;
	}

	public void setRoomtype_name(String roomtype_name) {
		this.roomtype_name = roomtype_name;
	}

	public String getRoomtype_desc() {
		return roomtype_desc;
	}

	public void setRoomtype_desc(String roomtype_desc) {
		this.roomtype_desc = roomtype_desc;
	}

	public double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(double room_price) {
		this.room_price = room_price;
	}

	public String getRoomtype_coverimg() {
		return roomtype_coverimg;
	}

	public void setRoomtype_coverimg(String roomtype_coverimg) {
		this.roomtype_coverimg = roomtype_coverimg;
	}

	public String getRoomtype_status() {
		return roomtype_status;
	}

	public void setRoomtype_status(String roomtype_status) {
		this.roomtype_status = roomtype_status;
	}

	public String getRoomtype_overview() {
		return roomtype_overview;
	}

	public void setRoomtype_overview(String roomtype_overview) {
		this.roomtype_overview = roomtype_overview;
	}

	public String getRoomtype_detail() {
		return roomtype_detail;
	}

	public void setRoomtype_detail(String roomtype_detail) {
		this.roomtype_detail = roomtype_detail;
	}

	public String getRoomtype_img1() {
		return roomtype_img1;
	}

	public void setRoomtype_img1(String roomtype_img1) {
		this.roomtype_img1 = roomtype_img1;
	}

	public String getRoomtype_img2() {
		return roomtype_img2;
	}

	public void setRoomtype_img2(String roomtype_img2) {
		this.roomtype_img2 = roomtype_img2;
	}

	public String getRoomtype_img3() {
		return roomtype_img3;
	}

	public void setRoomtype_img3(String roomtype_img3) {
		this.roomtype_img3 = roomtype_img3;
	}

	public String getRoomtype_img4() {
		return roomtype_img4;
	}

	public void setRoomtype_img4(String roomtype_img4) {
		this.roomtype_img4 = roomtype_img4;
	}

	public RoomTypeDTO(String roomtype_id, String roomtype_name, String roomtype_desc, double room_price,
			String roomtype_coverimg, String roomtype_status, String roomtype_overview, String roomtype_detail,
			String roomtype_img1, String roomtype_img2, String roomtype_img3, String roomtype_img4) {
		super();
		this.roomtype_id = roomtype_id;
		this.roomtype_name = roomtype_name;
		this.roomtype_desc = roomtype_desc;
		this.room_price = room_price;
		this.roomtype_coverimg = roomtype_coverimg;
		this.roomtype_status = roomtype_status;
		this.roomtype_overview = roomtype_overview;
		this.roomtype_detail = roomtype_detail;
		this.roomtype_img1 = roomtype_img1;
		this.roomtype_img2 = roomtype_img2;
		this.roomtype_img3 = roomtype_img3;
		this.roomtype_img4 = roomtype_img4;
	}

	public RoomTypeDTO() {
		super();
	}
}
