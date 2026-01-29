package com.portfolio.portfolio.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name="chat_message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat_Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String session_id;
	private long user_id;
	@Column(length=3000)
	private String message_content;
	private String sender_type;
	private LocalDateTime timestamp;
	private Boolean is_read;
	
}
