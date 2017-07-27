package com.eeit95.her.model.font;

import java.sql.Blob;

public class FontBean {
	private int fontId;
	private String fontNo;
	private String fontName;
	private int fontPrice;
	private int writerNo;
	private Blob fontCover;
	private int fontViewCount;
	private int fontSalesCount;
	private boolean fontStatus;
	
	public int getFontId() {
		return fontId;
	}
	public void setFontId(int fontId) {
		this.fontId = fontId;
	}
	public String getFontNo() {
		return fontNo;
	}
	public void setFontNo(String fontNo) {
		this.fontNo = fontNo;
	}
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public int getFontPrice() {
		return fontPrice;
	}
	public void setFontPrice(int fontPrice) {
		this.fontPrice = fontPrice;
	}
	public int getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}
	
	public Blob getFontCover() {
		return fontCover;
	}
	public void setFontCover(Blob fontCover) {
		this.fontCover = fontCover;
	}
	public int getFontViewCount() {
		return fontViewCount;
	}
	public void setFontViewCount(int fontViewCount) {
		this.fontViewCount = fontViewCount;
	}
	public int getFontSalesCount() {
		return fontSalesCount;
	}
	public void setFontSalesCount(int fontSalesCount) {
		this.fontSalesCount = fontSalesCount;
	}
	public boolean isFontStatus() {
		return fontStatus;
	}
	public void setFontStatus(boolean fontStatus) {
		this.fontStatus = fontStatus;
	}
	
}
