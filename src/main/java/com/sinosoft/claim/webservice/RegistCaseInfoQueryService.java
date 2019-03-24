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
 * 呼叫中心接口  十一、报案查询相关接口
 * @author Administrator
 *
 */
public class RegistCaseInfoQueryService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	
	/**
	 * 报案任务查询
	 * @param registCaseQuery查询入参对象
	 * @return 返回案件列表，分页返回
	 */
	public RegistCaseDtoInfo getRegistCaseList(RegistCaseQuery registCaseQuery){
		long serial = System.currentTimeMillis();
		logger.log("报案查询相关接口_报案任务查询", 1, serial, registCaseQuery);
		RegistCaseDtoInfo registCaseDtoInfo = null;
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			registCaseDtoInfo = registCaseInfoQueryServiceHelp.getRegistCaseList(registCaseQuery);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_报案任务查询", serial, e);
		}
		logger.log("报案查询相关接口_报案任务查询", 0, serial, registCaseDtoInfo);
		return registCaseDtoInfo;
	}
	/**
	 * 农险案件详细信息
	 * @param registNo
	 * @return
	 */
	public AgriRegistCaseDetailInfo getAgriRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		logger.log("报案查询相关接口_农险案件详细信息", 1, serial, "[registNo:"+registNo+"]");
		AgriRegistCaseDetailInfo agriRegistCaseDetailInfo = null;
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			agriRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getAgriRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_农险案件详细信息", serial, e);
		}
		logger.log("报案查询相关接口_农险案件详细信息", 0, serial, agriRegistCaseDetailInfo);
		return agriRegistCaseDetailInfo;
	}
	/**
	 * 货运保险案件详细信息
	 * @param registNo
	 * @return
	 */
	public TransportRegistCaseDetailInfo getTransportRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		TransportRegistCaseDetailInfo transportRegistCaseDetailInfo = null;
		logger.log("报案查询相关接口_货运保险案件详细信息", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			transportRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getTransportRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_货运保险案件详细信息", serial, e);
		}
		logger.log("报案查询相关接口_货运保险案件详细信息", 0, serial, transportRegistCaseDetailInfo);
		return transportRegistCaseDetailInfo;
	}
	/**
	 * 财产险案件详细信息
	 * @param registNo
	 * @return
	 */
	public PropRegistCaseDetailInfo getPropRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		PropRegistCaseDetailInfo propRegistCaseDetailInfo = null;
		logger.log("报案查询相关接口_财产险案件详细信息", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			propRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getPropRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_财产险案件详细信息", serial, e);
		}
		logger.log("报案查询相关接口_财产险案件详细信息", 0, serial, propRegistCaseDetailInfo);
		return propRegistCaseDetailInfo;
	}
	/**
	 * 意健险案件详细信息
	 * @param registNo
	 * @return
	 */
	public HealthRegistCaseDetailInfo getHealthRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		HealthRegistCaseDetailInfo healthRegistCaseDetailInfo = null;
		logger.log("报案查询相关接口_意健险案件详细信息", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			healthRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getHealthRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_意健险案件详细信息", serial, e);
		}
		logger.log("报案查询相关接口_意健险案件详细信息", 0, serial, healthRegistCaseDetailInfo);
		return healthRegistCaseDetailInfo;
	}
	/**
	 * 责任险案件详细信息
	 * @param registNo
	 * @return
	 */
	public RespRegistCaseDetailInfo getRespRegistCaseDetailInfo(String registNo){
		long serial = System.currentTimeMillis();
		RespRegistCaseDetailInfo respRegistCaseDetailInfo = null;
		logger.log("报案查询相关接口_责任险案件详细信息", 1, serial, "[registNo:"+registNo+"]");
		try {
			RegistCaseInfoQueryServiceHelp registCaseInfoQueryServiceHelp = new RegistCaseInfoQueryServiceHelp();
			respRegistCaseDetailInfo = registCaseInfoQueryServiceHelp.getRespRegistCaseDetailInfo(registNo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("报案查询相关接口_责任险案件详细信息", serial, e);
		}
		logger.log("报案查询相关接口_责任险案件详细信息", 0, serial, respRegistCaseDetailInfo);
		return respRegistCaseDetailInfo;
	}
}
