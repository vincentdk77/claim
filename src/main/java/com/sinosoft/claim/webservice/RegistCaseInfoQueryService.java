package com.sinosoft.claim.webservice;

import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.webservice.dto.AgriRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.HealthRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.PropRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.RegistCaseDtoInfo;
import com.sinosoft.claim.webservice.dto.RegistCaseQuery;
import com.sinosoft.claim.webservice.dto.RespRegistCaseDetailInfo;
import com.sinosoft.claim.webservice.dto.TransportRegistCaseDetailInfo;

/**
 * �������Ľӿ�  ʮһ��������ѯ��ؽӿ�
 * @author Administrator
 *
 */
public class RegistCaseInfoQueryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	
	/**
	 * ���������ѯ
	 * @param registCaseQuery��ѯ��ζ���
	 * @return ���ذ����б���ҳ����
	 */
	public RegistCaseDtoInfo getRegistCaseList(RegistCaseQuery registCaseQuery){
		long serial = System.currentTimeMillis();
		logger.log("������ѯ��ؽӿ�_���������ѯ", 1, serial, registCaseQuery);
		RegistCaseDtoInfo registCaseDtoInfo = null;
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			registCaseDtoInfo = registCaseInfoQueryServiceHelp.getRegistCaseList(registCaseQuery);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_���������ѯ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_���������ѯ", 0, serial, registCaseDtoInfo);
		return registCaseDtoInfo;
	}
	/**
	 * ũ�հ�����ϸ��Ϣ
	 * @param registNo
	 * @return
	 */
	public AgriRegistCaseDetailInfo getAgriRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		logger.log("������ѯ��ؽӿ�_ũ�հ�����ϸ��Ϣ", 1, serial, "[registNo:"+registNo+"]");
		AgriRegistCaseDetailInfo agriRegistCaseDetailInfo = null;
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			agriRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getAgriRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_ũ�հ�����ϸ��Ϣ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_ũ�հ�����ϸ��Ϣ", 0, serial, agriRegistCaseDetailInfo);
		return agriRegistCaseDetailInfo;
	}
	/**
	 * ���˱��հ�����ϸ��Ϣ
	 * @param registNo
	 * @return
	 */
	public TransportRegistCaseDetailInfo getTransportRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		TransportRegistCaseDetailInfo transportRegistCaseDetailInfo = null;
		logger.log("������ѯ��ؽӿ�_���˱��հ�����ϸ��Ϣ", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			transportRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getTransportRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_���˱��հ�����ϸ��Ϣ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_���˱��հ�����ϸ��Ϣ", 0, serial, transportRegistCaseDetailInfo);
		return transportRegistCaseDetailInfo;
	}
	/**
	 * �Ʋ��հ�����ϸ��Ϣ
	 * @param registNo
	 * @return
	 */
	public PropRegistCaseDetailInfo getPropRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		PropRegistCaseDetailInfo propRegistCaseDetailInfo = null;
		logger.log("������ѯ��ؽӿ�_�Ʋ��հ�����ϸ��Ϣ", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			propRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getPropRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_�Ʋ��հ�����ϸ��Ϣ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_�Ʋ��հ�����ϸ��Ϣ", 0, serial, propRegistCaseDetailInfo);
		return propRegistCaseDetailInfo;
	}
	/**
	 * �⽡�հ�����ϸ��Ϣ
	 * @param registNo
	 * @return
	 */
	public HealthRegistCaseDetailInfo getHealthRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		HealthRegistCaseDetailInfo healthRegistCaseDetailInfo = null;
		logger.log("������ѯ��ؽӿ�_�⽡�հ�����ϸ��Ϣ", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			healthRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getHealthRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_�⽡�հ�����ϸ��Ϣ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_�⽡�հ�����ϸ��Ϣ", 0, serial, healthRegistCaseDetailInfo);
		return healthRegistCaseDetailInfo;
	}
	/**
	 * �����հ�����ϸ��Ϣ
	 * @param registNo
	 * @return
	 */
	public RespRegistCaseDetailInfo getRespRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		RespRegistCaseDetailInfo respRegistCaseDetailInfo = null;
		logger.log("������ѯ��ؽӿ�_�����հ�����ϸ��Ϣ", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			respRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getRespRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("������ѯ��ؽӿ�_�����հ�����ϸ��Ϣ", serial, e);
		}
		logger.log("������ѯ��ؽӿ�_�����հ�����ϸ��Ϣ", 0, serial, respRegistCaseDetailInfo);
		return respRegistCaseDetailInfo;
	}
}
