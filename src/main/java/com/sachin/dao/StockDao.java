package com.sachin.dao;
import java.util.ArrayList;
import java.util.List;

import com.sachin.model.Stock;

public interface StockDao {
	public List<Stock> listValues(String id);
	public ArrayList<String> listNames();
	public Stock listCurrent(String id);
	public Stock listGoogle();
}
