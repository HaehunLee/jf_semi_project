package kr.co.hta.vo;

import java.util.List;

public class Room {
	private int roomNo;
	private int totalSeat;
	List<RoomDetailInfo> roomDetail;
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public List<RoomDetailInfo> getRoomDetail() {
		return roomDetail;
	}
	public void setRoomDetail(List<RoomDetailInfo> roomDetail) {
		this.roomDetail = roomDetail;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	
}
