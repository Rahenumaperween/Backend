package com.portfolio.portfolio.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long user_id;
	private BigDecimal amount;
	private String currency;
	private String transaction_id;
	private String status;
	private String payment_method;
	private LocalDateTime timestamp;
}
