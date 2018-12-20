package com.example.suthayakumar.testapputhaya.data;

public enum SummaryInfo {
	code(0),
	time(1),
	name(2),
	type(3),
	address(4),
	tel1(5),
	tel2(6),
	time_display(7),
	coordGprs(8),
	points(9),
	billNum(10),
	productNbr(11),
	total(12),
	date(10);

	private int value;

	SummaryInfo(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}