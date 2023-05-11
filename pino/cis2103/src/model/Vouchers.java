package model;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Vouchers {
	private int id;
	private String name;
	private String code;
//	private String type;
//	private String discountOpt;
	private float discountRate;
//	private int useCount;
//	private int maxUse;
//	private LocalDateTime expireDate;
	
	public Vouchers(int id, String name, String code, float discountRate) {
		try {
			this.id = Database.getLastVoucherID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setName(name);
		this.setCode(code);
		this.setDiscountRate(discountRate);
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}