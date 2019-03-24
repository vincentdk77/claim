package com.sinosoft.ciplatform.dto.custom;

/**
 * 自定义"影像资料信息"数据传输对象
 * <p>Title: 交强险互碰理赔垫付DTO</p>
 * <p>Description: 交强险互碰理赔垫付程序</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class ImageInfoDto {
	/** 资料类别*/
	private String attachType = "";
	/** 文件类型*/
	private String fileType = "";
	/** 文件名称*/
	private String fileName = "";
	/** 文件URL*/
	private String fileUrl = "";
	/**
     * 获取资料类别
     * @return 资料类别
     */
	public String getAttachType() {
		return attachType;
	}
	/**
     * 设置资料类别
     * @param 资料类别
     */
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	/**
     * 获取文件名称
     * @return 文件名称
     */
	public String getFileName() {
		return fileName;
	}
	/**
     * 设置文件名称
     * @param 文件名称
     */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
     * 获取文件类型
     * @return 文件类型
     */
	public String getFileType() {
		return fileType;
	}
	/**
     * 设置文件类型
     * @param 文件类型
     */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
     * 获取文件URL
     * @return 文件URL
     */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
     * 设置文件URL
     * @param 文件URL
     */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	

}
