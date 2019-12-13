package com.ibm.microservices.currencyconversionfactorservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyFactor {
	@Override
	public String toString() {
		return "CurrencyFactor [id=" + id + ", fromCtry=" + fromCtry + ", toCtry=" + toCtry + ", conversionFactor="
				+ conversionFactor + ", port=" + port + "]";
	}

	public Long getId() {
		return id;
	}
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="from_ctry")
	private String fromCtry;
	@Column(name="to_ctry")
	private String toCtry;
	private BigDecimal conversionFactor;
	private String port;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public CurrencyFactor()
	{
		
	}
	
	public CurrencyFactor(String fromCtry, String toCtry, BigDecimal conversionFactor) {
		super();
		this.fromCtry = fromCtry;
		this.toCtry = toCtry;
		this.conversionFactor = conversionFactor;
	}

	public String getFromCtry() {
		return fromCtry;
	}
	public void setFromCtry(String fromCtry) {
		this.fromCtry = fromCtry;
	}
	public String getToCtry() {
		return toCtry;
	}
	public void setToCtry(String toCtry) {
		this.toCtry = toCtry;
	}
	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
}
