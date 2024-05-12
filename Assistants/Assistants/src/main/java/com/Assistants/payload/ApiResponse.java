package com.Assistants.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class ApiResponse {
	public ApiResponse(String string, boolean b) {
		// TODO Auto-generated constructor stub
		this.message= string;
		this.success=b;
	}
	private String message;
    private boolean success;
}
