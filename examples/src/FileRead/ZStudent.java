package FileRead;

public class ZStudent {
    private int no;
    private String fname;
    private String mi;
    private String lname;
    private float ave;

    ZStudent() {
        this.no = 0;
        this.fname = null;
        this.mi = null;
        this.lname = null;
        this.ave = 0;
    }
    void setNo(int no) { this.no = no; }
    void setFirst(String fname) { this.fname = fname; }
    void setMid(String mi) { this.mi = mi; }
    void setLast(String lname) { this.lname = lname; }
    void setAve(float ave) { this.ave = ave; }
}
