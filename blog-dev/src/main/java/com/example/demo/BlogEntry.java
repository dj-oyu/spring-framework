package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="blogEntry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BlogEntry {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="create_time")
	private LocalDateTime create_time;

	@Column(name="update_time")
	private LocalDateTime update_time;

	@Column(name="title")
	private String title;

	@Column(name="body")
	private String body;
}
