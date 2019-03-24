package com.sinosoft.claim.dto.custom;


/**
 * 定义RepairContentDto的数据传输对象类
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>@createdate 2006-03-29</p>
 * @author miaowenjun
 * @version 1.0
 */

public class RepairContentDto {
	/** 是否修理类型*/
	private boolean isType;
	/** 修理类型*/
	private String repairType;
	/** 序号*/
	private int no;
	/** 修理项目名称*/
	private String repairName;
	/** 工时*/
	private double repairHour;
	/** 工时费*/
	private double repairHourFee;
	/** 更换配件名称*/
	private String changeName;
	/** 更换配件数量*/
	private double changeCount;
	/** 更换配件价格*/
	private double changeFee;
	
	
	public RepairContentDto(){
		this.isType = false;
	}
	
	/**得到更换配件价格
	   * @return 更换配件价格
	   */
	public double getChangeFee(){
		return changeFee;
	}
	/**设置更换配件价格
	   * @return 更换配件价格
	   */
	public void setChangeFee(double changeFee){
		this.changeFee = changeFee;
	}
	
	/**得到更换配件数量
	   * @return 更换配件数量
	   */
	public double getChangeCount(){
		return changeCount;
	}
	/**设置更换配件数量
	   * @return 更换配件数量
	   */
	public void setChangeCount(double changeCount){
		this.changeCount = changeCount;
	}
	
	/**得到更换配件名称
	   * @return 更换配件名称
	   */
	public String getChangeName(){
		return changeName;
	}
	/**设置更换配件名称
	   * @return 更换配件名称
	   */
	public void setChangeName(String changeName){
		this.changeName = changeName;
	}
	
	/**得到是否修理类型
	   * @return 是否修理类型
	   */
	public boolean getIsType(){
		return isType;
	}
	/**设置是否修理类型
	   * @return 是否修理类型
	   */
	public void setIsType(boolean isType){
		this.isType = isType;
	}
	/**得到修理类型
	   * @return 修理类型
	   */
	public String getRepairType(){
		return repairType;
	}
	/**设置修理类型
	   * @return 修理类型
	   */
	public void setRepairType(String repairType){
		this.repairType = repairType;
	}
	/**得到序号
	   * @return 序号
	   */
	public int getNo(){
		return no;
	}
	/**设置序号
	   * @return 序号
	   */
	public void setNo(int no){
		this.no = no;
	}
	/**得到修理项目名称
	   * @return 序号
	   */
	public String getRepairName(){
		return repairName;
	}
	/**设置修理项目名称
	   * @return 修理项目名称
	   */
	public void setRepairName(String repairName){
		this.repairName = repairName;
	}
	/**得到工时
	   * @return 工时
	   */
	public double getRepairHour(){
		return repairHour;
	}
	/**设置工时
	   * @return 工时
	   */
	public void setRepairHour(double repairHour){
		this.repairHour = repairHour;
	}
	/**得到工时费
	   * @return 工时费
	   */
	public double getRepairHourFee(){
		return repairHourFee;
	}
	/**设置工时费
	   * @return 工时费
	   */
	public void setRepairHourFee(double repairHourFee){
		this.repairHourFee = repairHourFee;
	}
}
