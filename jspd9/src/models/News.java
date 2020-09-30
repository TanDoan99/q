package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
	private int id;
	private String name;
	private String description;
	private String image;
	private String detail;
	private String created_at;
	private int cat_id;
}
