package com.lancesoft.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="casestudy")
public class CaseStudy {
	@Id
private String caseid;
private String name;
@Lob
@JsonIgnore
private byte[] pdf;
@OneToOne
@JoinColumn(name="induid")
private Industries induid;
}
