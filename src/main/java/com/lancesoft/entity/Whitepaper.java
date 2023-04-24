package com.lancesoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Whitepaper {
	@Id
	private String whiteid;
	private String name;
	@Lob
	@JsonIgnore
	private byte[] pdf;
	@OneToOne
	@JoinColumn(name = "induid")
	private Industries induid;
}
