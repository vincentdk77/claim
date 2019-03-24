package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * �Զ���"�渶��Ϣ��д����"���ݴ������
 * <p>Title: ��ǿ�ջ�������渶DTO</p>
 * <p>Description: ��ǿ�ջ�������渶����</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class AdvanceUpdateResponseDto {
	/** ���󷵻ع�����Ϣ*/
	private CompePlatFormRetrunParam compePlatFormRetrunParam =null;
	/** ȫ�𷽵渶��Ϣ*/
	private AdvanceInfoDto fullDutyAdvanceInfoDto = null;
	/** ���𷽵渶��Ϣ*/
	private AdvanceInfoDto noDutyAdvanceInfoDto = null;
	/** Ӱ��������Ϣ�б�*/
	private List imageInfoDtoList = new ArrayList();
	/**
     * ��ȡ���󷵻ع�����Ϣ
     * @return ���󷵻ع�����Ϣ
     */
	public CompePlatFormRetrunParam getCompePlatFormRetrunParam() {
		return compePlatFormRetrunParam;
	}
	/**
     * �������󷵻ع�����Ϣ
     * @param ���󷵻ع�����Ϣ
     */
	public void setCompePlatFormRetrunParam(
			CompePlatFormRetrunParam compePlatFormRetrunParam) {
		this.compePlatFormRetrunParam = compePlatFormRetrunParam;
	}
	/**
     * ��ȡӰ��������Ϣ�б�
     * @return Ӱ��������Ϣ�б�
     */
	public List getImageInfoDtoList() {
		return imageInfoDtoList;
	}
	/**
     * ����Ӱ��������Ϣ�б�
     * @param Ӱ��������Ϣ�б�
     */
	public void setImageInfoDtoList(List imageInfoDtoList) {
		this.imageInfoDtoList = imageInfoDtoList;
	}
	/**
     * ���Ӱ��������Ϣ�б�Ԫ��
     * @param Ӱ��������Ϣ
     */
	public void addImageInfoDto(ImageInfoDto imageInfoDto){
		this.imageInfoDtoList.add(imageInfoDto);
	}
	/**
     * ��ȡȫ�𷽵渶��Ϣ
     * @return fullDutyPrepayInfoDto
     */
	public AdvanceInfoDto getFullDutyAdvanceInfoDto() {
		return fullDutyAdvanceInfoDto;
	}
	/**
     * ����ȫ�𷽵渶��Ϣ
     * @param fullDutyPrepayInfoDto
     */
	public void setFullDutyAdvanceInfoDto(AdvanceInfoDto fullDutyPrepayInfoDto) {
		this.fullDutyAdvanceInfoDto = fullDutyPrepayInfoDto;
	}
	/**
     * ��ȡ���𷽵渶��Ϣ
     * @return noDutyPrepayInfoDto
     */
	public AdvanceInfoDto getNoDutyAdvanceInfoDto() {
		return noDutyAdvanceInfoDto;
	}
	/**
     * �������𷽵渶��Ϣ
     * @param noDutyPrepayInfoDto
     */
	public void setNoDutyAdvanceInfoDto(AdvanceInfoDto noDutyPrepayInfoDto) {
		this.noDutyAdvanceInfoDto = noDutyPrepayInfoDto;
	}
	
}
