package com.sinosoft.ciplatform.dto.custom;

/**
 * �Զ���"Ӱ��������Ϣ"���ݴ������
 * <p>Title: ��ǿ�ջ�������渶DTO</p>
 * <p>Description: ��ǿ�ջ�������渶����</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sinosoft&&Dbic</p>
 * @author zhangwei
 * @version 1.0
 */

public class ImageInfoDto {
	/** �������*/
	private String attachType = "";
	/** �ļ�����*/
	private String fileType = "";
	/** �ļ�����*/
	private String fileName = "";
	/** �ļ�URL*/
	private String fileUrl = "";
	/**
     * ��ȡ�������
     * @return �������
     */
	public String getAttachType() {
		return attachType;
	}
	/**
     * �����������
     * @param �������
     */
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	/**
     * ��ȡ�ļ�����
     * @return �ļ�����
     */
	public String getFileName() {
		return fileName;
	}
	/**
     * �����ļ�����
     * @param �ļ�����
     */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
     * ��ȡ�ļ�����
     * @return �ļ�����
     */
	public String getFileType() {
		return fileType;
	}
	/**
     * �����ļ�����
     * @param �ļ�����
     */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
     * ��ȡ�ļ�URL
     * @return �ļ�URL
     */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
     * �����ļ�URL
     * @param �ļ�URL
     */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	

}
