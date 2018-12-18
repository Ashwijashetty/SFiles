package com.cg.TDS.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tdsdetail")
public class TdsDetail {
	@Id
	private int uniqueId;
	@Field(value = "deductor_name")
	private String deductorName;
	@Field(value = "deductor_pan")
	private String deductorPan;
	@Field(value = "tds_deposited")
	private int tdsDeposited;
	
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getDeductorName() {
		return deductorName;
	}
	public void setDeductorName(String deductorName) {
		this.deductorName = deductorName;
	}
	public String getDeductorPan() {
		return deductorPan;
	}
	public void setDeductorPan(String deductorPan) {
		this.deductorPan = deductorPan;
	}
	public int getTdsDeposited() {
		return tdsDeposited;
	}
	public void setTdsDeposited(int tdsDeposited) {
		this.tdsDeposited = tdsDeposited;
	}
	public TdsDetail(int uniqueId, String deductorName, String deductorPan,
			int tdsDeposited) {
		super();
		this.uniqueId = uniqueId;
		this.deductorName = deductorName;
		this.deductorPan = deductorPan;
		this.tdsDeposited = tdsDeposited;
	}
	public TdsDetail() {
		super();
		
	}
	@Override
	public String toString() {
		return "TdsDetail [uniqueId=" + uniqueId + ", deductorName="
				+ deductorName + ", deductorPan=" + deductorPan
				+ ", tdsDeposited=" + tdsDeposited + "]";
	}
	
}
