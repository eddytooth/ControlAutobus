package com.eddytooth;

public class Response {
	
	private String busSize;
	
	public Response() {
	}

	public String getBusSize() {
		return busSize;
	}

	public void setBusSize(String busSize) {
		this.busSize = busSize;
	}

	public Response(String busSize) {
		this.busSize = busSize;
	}

	@Override
	public String toString() {
		return "Response [busSize=" + busSize + "]";
	}

}
