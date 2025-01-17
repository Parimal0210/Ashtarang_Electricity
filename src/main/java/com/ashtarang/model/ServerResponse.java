package com.ashtarang.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServerResponse<T> {
	private int statusCode;
	private String statusMessage;
	private T response;
}
