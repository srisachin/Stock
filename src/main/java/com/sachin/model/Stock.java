package com.sachin.model;

public class Stock {
	String name;
	float open;
	float high;
	float low;
	float close;
	int volume;
	String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Stock(String name, float open, float high, float low, float close, int volume)
	{
		this.name=name;
		this.open=open;
		this.high=high;
		this.low=low;
		this.close=close;
		this.volume=volume;
	}
}
