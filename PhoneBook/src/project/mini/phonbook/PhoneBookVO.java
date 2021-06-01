package project.mini.phonbook;

public class PhoneBookVO {

	// 필드
	private Long id; // PK
	private String uname;
	private String uhp;
	private String utel;

	// 기본 생성자(반드시 존재)
	public PhoneBookVO() {

	}

	// db 필수 필드
	public PhoneBookVO(Long id, String uname, String uhp, String utel) {
		this.id = id;
		this.uname = uname;
		this.uhp = uhp;
		this.utel = utel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUhp() {
		return uhp;
	}

	public void setUhp(String uhp) {
		this.uhp = uhp;
	}

	public String getUtel() {
		return utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	@Override
	public String toString() {
		return "PhoneBookVO [id=" + id + ", uname=" + uname + ", uhp=" + uhp + ", utel=" + utel + "]";
	}
}
