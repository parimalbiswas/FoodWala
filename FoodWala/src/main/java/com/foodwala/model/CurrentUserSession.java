package com.foodwala.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentUserSession
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sessionId;

	private Integer useradminId;

	private String uuid;

	private LocalDateTime localDateTime;

	private String konhai;

	private Integer cartId;

	public CurrentUserSession(Integer user_adminId, String uuid, LocalDateTime localDateTime, String konhai,
			Integer cartId)
	{
		super();
		this.useradminId = user_adminId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
		this.konhai = konhai;
		this.cartId = cartId;
	}

	@Override
	public String toString()
	{
		return "CurrentUserSession [sessionId=" + sessionId + ", user_adminId=" + useradminId + ", uuid=" + uuid
				+ ", localDateTime=" + localDateTime + ", konhai=" + konhai + ", cartId=" + cartId + "]";
	}

}
