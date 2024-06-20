package com.ispan.bean.gameOrder;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity @Table(name = "recharge")
public class Recharge {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rechargeId;
	
	private int memId;
	
	private int paymentId;
	
	private int amounts;
	
	private LocalDateTime addAt;
	
	@ManyToOne @JoinColumn(name = "memId")
	private int member;
	
	@ManyToOne
	@JoinColumn(name = "paymentId")
	private Payment payment;
}
