package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
	private String name;
	private int phone;
	private String web;
	private String gender;
	private String picture;
	private String content;
}
