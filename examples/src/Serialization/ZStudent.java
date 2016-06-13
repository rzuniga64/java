package Serialization;

import java.io.Serializable;

public class ZStudent implements Serializable {
	private int no; 
	private String first, mid, last;
	private float ave;
	
	public ZStudent(int no, String first, String mid, String last, float ave) {
		super();
		this.no = no;
		this.first = first;
		this.mid = mid;
		this.last = last;
		this.ave = ave;
	}
	
	
	public ZStudent() {
		// TODO Auto-generated constructor stub
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public float getAve() {
		return ave;
	}
	public void setAve(float ave) {
		this.ave = ave;
	}
	
	@Override
	public String toString() {
		return "ZStudent [no=" + no + ", first=" + first + ", mid=" + mid
				+ ", last=" + last + ", ave=" + ave + "]";
	}
 
}
