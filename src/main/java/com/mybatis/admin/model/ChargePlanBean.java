package com.mybatis.admin.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@TableName("chargePlan")
public class ChargePlanBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
	private Integer price;
	private Integer gratisMinute;
	private String networkTraffic;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Timestamp activationDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Timestamp expirationDate;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getGratisMinute() {
		return gratisMinute;
	}

	public void setGratisMinute(Integer gratisMinute) {
		this.gratisMinute = gratisMinute;
	}

	public String getNetworkTraffic() {
		return networkTraffic;
	}

	public void setNetworkTraffic(String networkTraffic) {
		this.networkTraffic = networkTraffic;
	}

	public Timestamp getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Timestamp activationDate) {
		this.activationDate = activationDate;
	}

	public Timestamp getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
