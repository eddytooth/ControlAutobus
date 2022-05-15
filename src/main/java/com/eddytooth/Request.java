package com.eddytooth;

public class Request {
	
	private String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Request() {
	}

	public Request(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Request [group=" + group + "]";
	}

}
