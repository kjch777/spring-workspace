package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageUpload {

	private int id;
	private String file_name;
	private String upload_dir;
}
