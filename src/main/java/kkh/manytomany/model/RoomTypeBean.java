package kkh.manytomany.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class RoomTypeBean {
	private String roomtype_id;
	@NotEmpty(message = "Name cannot be null")

	private String roomtype_name;
	@Size(min = 10, max = 200, message = "Room Type description must be between 10 and 200 characters")

	private String roomtype_desc;
	// @Range(min = 1, max = 100, message = "Only number")
	private double room_price;
	private MultipartFile roomtype_coverimg;
	@NotEmpty(message = "Room Type Status cannot be null")
	private String roomtype_status;
	@Size(min = 10, max = 200, message = "Room Type Overview must be between 10 and 200 characters")

	private String roomtype_overview;
	@Size(min = 10, max = 200, message = "Room Type Detail must be between 10 and 200 characters")

	private String roomtype_detail;
	private MultipartFile roomtype_img1;
	private MultipartFile roomtype_img2;
	private MultipartFile roomtype_img3;
	private MultipartFile roomtype_img4;
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

	public MultipartFile getRoomtype_coverimg() {
		return roomtype_coverimg;
	}

	public void setRoomtype_coverimg(MultipartFile roomtype_coverimg) {
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

	public MultipartFile getRoomtype_img1() {
		return roomtype_img1;
	}

	public void setRoomtype_img1(MultipartFile roomtype_img1) {
		this.roomtype_img1 = roomtype_img1;
	}

	public MultipartFile getRoomtype_img2() {
		return roomtype_img2;
	}

	public void setRoomtype_img2(MultipartFile roomtype_img2) {
		this.roomtype_img2 = roomtype_img2;
	}

	public MultipartFile getRoomtype_img3() {
		return roomtype_img3;
	}

	public void setRoomtype_img3(MultipartFile roomtype_img3) {
		this.roomtype_img3 = roomtype_img3;
	}

	public MultipartFile getRoomtype_img4() {
		return roomtype_img4;
	}

	public void setRoomtype_img4(MultipartFile roomtype_img4) {
		this.roomtype_img4 = roomtype_img4;
	}
}
