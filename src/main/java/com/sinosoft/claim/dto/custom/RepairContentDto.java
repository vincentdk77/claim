package com.sinosoft.claim.dto.custom;


/**
 * ����RepairContentDto�����ݴ��������
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>@createdate 2006-03-29</p>
 * @author miaowenjun
 * @version 1.0
 */

public class RepairContentDto {
	/** �Ƿ���������*/
	private boolean isType;
	/** ��������*/
	private String repairType;
	/** ���*/
	private int no;
	/** ������Ŀ����*/
	private String repairName;
	/** ��ʱ*/
	private double repairHour;
	/** ��ʱ��*/
	private double repairHourFee;
	/** �����������*/
	private String changeName;
	/** �����������*/
	private double changeCount;
	/** ��������۸�*/
	private double changeFee;
	
	
	public RepairContentDto(){
		this.isType = false;
	}
	
	/**�õ���������۸�
	   * @return ��������۸�
	   */
	public double getChangeFee(){
		return changeFee;
	}
	/**���ø�������۸�
	   * @return ��������۸�
	   */
	public void setChangeFee(double changeFee){
		this.changeFee = changeFee;
	}
	
	/**�õ������������
	   * @return �����������
	   */
	public double getChangeCount(){
		return changeCount;
	}
	/**���ø����������
	   * @return �����������
	   */
	public void setChangeCount(double changeCount){
		this.changeCount = changeCount;
	}
	
	/**�õ������������
	   * @return �����������
	   */
	public String getChangeName(){
		return changeName;
	}
	/**���ø����������
	   * @return �����������
	   */
	public void setChangeName(String changeName){
		this.changeName = changeName;
	}
	
	/**�õ��Ƿ���������
	   * @return �Ƿ���������
	   */
	public boolean getIsType(){
		return isType;
	}
	/**�����Ƿ���������
	   * @return �Ƿ���������
	   */
	public void setIsType(boolean isType){
		this.isType = isType;
	}
	/**�õ���������
	   * @return ��������
	   */
	public String getRepairType(){
		return repairType;
	}
	/**������������
	   * @return ��������
	   */
	public void setRepairType(String repairType){
		this.repairType = repairType;
	}
	/**�õ����
	   * @return ���
	   */
	public int getNo(){
		return no;
	}
	/**�������
	   * @return ���
	   */
	public void setNo(int no){
		this.no = no;
	}
	/**�õ�������Ŀ����
	   * @return ���
	   */
	public String getRepairName(){
		return repairName;
	}
	/**����������Ŀ����
	   * @return ������Ŀ����
	   */
	public void setRepairName(String repairName){
		this.repairName = repairName;
	}
	/**�õ���ʱ
	   * @return ��ʱ
	   */
	public double getRepairHour(){
		return repairHour;
	}
	/**���ù�ʱ
	   * @return ��ʱ
	   */
	public void setRepairHour(double repairHour){
		this.repairHour = repairHour;
	}
	/**�õ���ʱ��
	   * @return ��ʱ��
	   */
	public double getRepairHourFee(){
		return repairHourFee;
	}
	/**���ù�ʱ��
	   * @return ��ʱ��
	   */
	public void setRepairHourFee(double repairHourFee){
		this.repairHourFee = repairHourFee;
	}
}
