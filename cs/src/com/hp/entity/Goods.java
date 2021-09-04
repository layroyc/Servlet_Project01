package com.hp.entity;

public class Goods {
	private int goodsId;
	private String goodsType;
	private String goodsName;
	private float goodsRent;
	private int goodsCount;
	private String supplier;
	private String telphone;
	private int goodsState;
	public int getGoodsId() {
		return goodsId;
	}
	public Goods(String goodsType, String goodsName, float goodsRent,
			int goodsCount, String supplier, String telphone) {
		super();
		this.goodsType = goodsType;
		this.goodsName = goodsName;
		this.goodsRent = goodsRent;
		this.goodsCount = goodsCount;
		this.supplier = supplier;
		this.telphone = telphone;
	}
	public Goods(String goodsType, String goodsName, float goodsRent,
			int goodsCount, String supplier, String telphone, int goodsState) {
		super();
		this.goodsType = goodsType;
		this.goodsName = goodsName;
		this.goodsRent = goodsRent;
		this.goodsCount = goodsCount;
		this.supplier = supplier;
		this.telphone = telphone;
		this.goodsState = goodsState;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getGoodsRent() {
		return goodsRent;
	}
	public void setGoodsRent(float goodsRent) {
		this.goodsRent = goodsRent;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getGoodsState() {
		return goodsState;
	}
	public void setGoodsState(int goodsState) {
		this.goodsState = goodsState;
	}
	public Goods(int goodsId, String goodsType, String goodsName,
			float goodsRent, int goodsCount, String supplier, String telphone,
			int goodsState) {
		super();
		this.goodsId = goodsId;
		this.goodsType = goodsType;
		this.goodsName = goodsName;
		this.goodsRent = goodsRent;
		this.goodsCount = goodsCount;
		this.supplier = supplier;
		this.telphone = telphone;
		this.goodsState = goodsState;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsType=" + goodsType
				+ ", goodsName=" + goodsName + ", goodsRent=" + goodsRent
				+ ", goodsCount=" + goodsCount + ", supplier=" + supplier
				+ ", telphone=" + telphone + ", goodsState=" + goodsState + "]";
	}
	

}
