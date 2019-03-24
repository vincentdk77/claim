package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义"垫付信息回写返回"数据传输对象
 * <p>Title: 交强险互碰理赔垫付DTO</p>
 * <p>Description: 交强险互碰理赔垫付程序</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class AdvanceUpdateResponseDto {
	/** 请求返回公共信息*/
	private CompePlatFormRetrunParam compePlatFormRetrunParam =null;
	/** 全责方垫付信息*/
	private AdvanceInfoDto fullDutyAdvanceInfoDto = null;
	/** 无责方垫付信息*/
	private AdvanceInfoDto noDutyAdvanceInfoDto = null;
	/** 影像资料信息列表*/
	private List imageInfoDtoList = new ArrayList();
	/**
     * 获取请求返回公共信息
     * @return 请求返回公共信息
     */
	public CompePlatFormRetrunParam getCompePlatFormRetrunParam() {
		return compePlatFormRetrunParam;
	}
	/**
     * 设置请求返回公共信息
     * @param 请求返回公共信息
     */
	public void setCompePlatFormRetrunParam(
			CompePlatFormRetrunParam compePlatFormRetrunParam) {
		this.compePlatFormRetrunParam = compePlatFormRetrunParam;
	}
	/**
     * 获取影像资料信息列表
     * @return 影像资料信息列表
     */
	public List getImageInfoDtoList() {
		return imageInfoDtoList;
	}
	/**
     * 设置影像资料信息列表
     * @param 影像资料信息列表
     */
	public void setImageInfoDtoList(List imageInfoDtoList) {
		this.imageInfoDtoList = imageInfoDtoList;
	}
	/**
     * 添加影像资料信息列表元素
     * @param 影像资料信息
     */
	public void addImageInfoDto(ImageInfoDto imageInfoDto){
		this.imageInfoDtoList.add(imageInfoDto);
	}
	/**
     * 获取全责方垫付信息
     * @return fullDutyPrepayInfoDto
     */
	public AdvanceInfoDto getFullDutyAdvanceInfoDto() {
		return fullDutyAdvanceInfoDto;
	}
	/**
     * 设置全责方垫付信息
     * @param fullDutyPrepayInfoDto
     */
	public void setFullDutyAdvanceInfoDto(AdvanceInfoDto fullDutyPrepayInfoDto) {
		this.fullDutyAdvanceInfoDto = fullDutyPrepayInfoDto;
	}
	/**
     * 获取无责方垫付信息
     * @return noDutyPrepayInfoDto
     */
	public AdvanceInfoDto getNoDutyAdvanceInfoDto() {
		return noDutyAdvanceInfoDto;
	}
	/**
     * 设置无责方垫付信息
     * @param noDutyPrepayInfoDto
     */
	public void setNoDutyAdvanceInfoDto(AdvanceInfoDto noDutyPrepayInfoDto) {
		this.noDutyAdvanceInfoDto = noDutyPrepayInfoDto;
	}
	
}
