package com.example.demo.trader.domain;

public class TraderVO {
	private String stock_symbol;
	private String market_date;
	private int open;
	private int high;
	private int low;
	private int close;
	private int volume;

	public TraderVO() {
	}

	/**
	 * @param stock_symbol
	 * @param market_date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 */
	public TraderVO(String stock_symbol, String market_date, int open, int high, int low, int close, int volume) {
		super();
		this.stock_symbol = stock_symbol;
		this.market_date = market_date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	/**
	 * @return the stock_symbol
	 */
	public String getStock_symbol() {
		return stock_symbol;
	}

	/**
	 * @param stock_symbol the stock_symbol to set
	 */
	public void setStock_symbol(String stock_symbol) {
		this.stock_symbol = stock_symbol;
	}

	/**
	 * @return the market_date
	 */
	public String getMarket_date() {
		return market_date;
	}

	/**
	 * @param market_date the market_date to set
	 */
	public void setMarket_date(String market_date) {
		this.market_date = market_date;
	}

	/**
	 * @return the open
	 */
	public int getOpen() {
		return open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(int open) {
		this.open = open;
	}

	/**
	 * @return the high
	 */
	public int getHigh() {
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(int high) {
		this.high = high;
	}

	/**
	 * @return the low
	 */
	public int getLow() {
		return low;
	}

	/**
	 * @param low the low to set
	 */
	public void setLow(int low) {
		this.low = low;
	}

	/**
	 * @return the close
	 */
	public int getClose() {
		return close;
	}

	/**
	 * @param close the close to set
	 */
	public void setClose(int close) {
		this.close = close;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "TraderVO [stock_symbol=" + stock_symbol + ", market_date=" + market_date + ", open=" + open + ", high="
				+ high + ", low=" + low + ", close=" + close + ", volume=" + volume + "]";
	}
}