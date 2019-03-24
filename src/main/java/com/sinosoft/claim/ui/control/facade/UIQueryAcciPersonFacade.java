package com.sinosoft.claim.ui.control.facade;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;


import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplaccidangerclaimsdFacade;
import com.sinosoft.claim.bl.facade.BLPrplaccidangersdFacade;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.common_claim.bl.action.custom.TransDataHelperSdAcci;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class UIQueryAcciPersonFacade extends Action {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String editType = request.getParameter("editType");
		String forward = "";
		String registNo = request.getParameter("registNo");
		ResultSet resultSet = null;
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		try{
			if("queryAcciPerson".equals(editType)){//山东意外险风险预警对接，客户信息页面查询展示
				String lossDate = "";
				String areaFlag = "";
				String comCode = "";
				String credentialType = "";
				String identifytype = "";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				BLPrpLaccipersonFacade blPrpLaccipersonFacade = new BLPrpLaccipersonFacade();
				BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
				Collection<PrpLacciPersonDto> prpLacciPersonDtoList = null;
				PrpLregistDto prpLregistDto = new PrpLregistDto();
				BLPrpCmain blPrpCmain = new BLPrpCmain();
				prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
				if(prpLregistDto!=null && prpLregistDto.getDamageStartDate()!=null && 
						prpLregistDto.getDamageStartHour()!=null &&prpLregistDto.getDamageStartHour().length()>2){
					lossDate = sdf.format(prpLregistDto.getDamageStartDate());
					lossDate = lossDate.replaceAll("-", "");
					lossDate = lossDate+prpLregistDto.getDamageStartHour().substring(0, 2);
					comCode = prpLregistDto.getComCode();
					blPrpCmain.getData(prpLregistDto.getPolicyNo());
					if("01".equals(blPrpCmain.getArr(0).getPolicyType())){//个险
						String strSql = "SELECT identifytype from prpcinsured  WHERE policyno='"+prpLregistDto.getPolicyNo()+"' AND insuredflag='1'";
						resultSet = dbManager.executeQuery(strSql);
						while(resultSet.next()){
							identifytype = resultSet.getString(1);
						}
						credentialType = new TransDataHelperSdAcci().transIdentifyType(identifytype);
						prpLacciPersonDtoList = blPrpLaccipersonFacade.findByConditionsOfSDacci(registNo, credentialType);
					}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){//团险
						credentialType = "01";//默认身份证
						prpLacciPersonDtoList = blPrpLaccipersonFacade.findByConditionsOfSDacci(registNo, credentialType);
					}
				}
				areaFlag = new BLPrpDcompanyFacade().findByPrimaryKey(comCode).getCityCode();//保单归属地
				request.setAttribute("prpLacciPersonDtoList",prpLacciPersonDtoList);
				request.setAttribute("LossDate",lossDate);
				request.setAttribute("registNo",registNo);
				request.setAttribute("AreaFlag", areaFlag);
				forward = "PersonList";
			}else if("queryDangerInfo".equals(editType)){//山东意外险风险预警对接，客户风险信息查询平台交互
				String[] checkFlag      = request.getParameterValues("checkFlag");
				String[] InsuredName    = request.getParameterValues("acciName");
				String[] Gender         = request.getParameterValues("sex");
				String[] Birthday       = request.getParameterValues("Birthday");
				String[] CredentialType = request.getParameterValues("identifyType");
				String[] CredentialNo   = request.getParameterValues("identifyNumber");
				String LossDate       = request.getParameter("LossDate");
				String AreaFlag       = request.getParameter("AreaFlag");
				QueryAcciDangerSDRequestDto requestDto = null;
				QueryAcciDangerSDResponseDto responseDto = null;
				List<QueryAcciDangerSDResponseDto> responseDtoList = new ArrayList<QueryAcciDangerSDResponseDto>();
				for(int i=1;i<checkFlag.length;i++){
					if(checkFlag[i]!=null && !"".equals(checkFlag[i])){
						requestDto = new QueryAcciDangerSDRequestDto();
						responseDto = new QueryAcciDangerSDResponseDto();
						requestDto.setRequestType("L03");
						//TODO
						requestDto.setUserCode(AppConfig.get("sysconst.SDACCIRISK_USER"));
						requestDto.setPassWord(AppConfig.get("sysconst.SDACCIRISK_PASSWORD"));
						requestDto.setInsuredName   (InsuredName   [i]);
						requestDto.setGender        (Gender        [i]);
						requestDto.setBirthday      (Birthday      [i]);
						requestDto.setCredentialNo  (CredentialNo  [i]);
						if(CredentialNo[i]!=null && !"".equals(CredentialNo[i]) && 
								(CredentialType[i]==null || "".equals(CredentialType[i]))){
							requestDto.setCredentialType("01");
						}
						requestDto.setCredentialType(CredentialType[i]);
						requestDto.setLossDate      (LossDate      );
						requestDto.setAreaFlag(AreaFlag);
						requestDto.setRegistNo      (registNo      );
						String reqXML = this.getQueryXML(requestDto);
						String resXML = "";
						//通过平台接口调用风险预警系统接口
						//TODO 开启连接 daaplatform接口地址
						//http://88.37.0.103:9001/sinoairwService/interfaceServer
						String url =  AppConfig.get("sysconst.ACCIDANGERSD");
						URL uploadServlet = new URL(url);
						URLConnection servletConnection = uploadServlet.openConnection();
						//设置连接参数
						servletConnection.setUseCaches(false);
						servletConnection.setDoOutput(true);
						servletConnection.setDoInput(true);
						//开启流，写入XML数据
						BufferedOutputStream output2 = new BufferedOutputStream(servletConnection.getOutputStream());
						output2.write(reqXML.getBytes());
						//发送数据完毕
						output2.close();
						//接收返回参数
						DataInputStream input = null;
						input = new DataInputStream(servletConnection.getInputStream());
						ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
						byte[] data = null;
						byte[] b = new byte[1024];
						int read = 0;
						while((read = input.read(b)) > 0){
							byteOut.write(b, 0, read);
						}
						input.close();
						data = byteOut.toByteArray();
						resXML = new String(data);
						System.out.println(resXML);
						responseDto = getPushResponseDtoFromXML(resXML);
						//返参报文转化
						PrplaccidangersdDto prplaccidangersdDto = new PrplaccidangersdDto();
						PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = new PrplaccidangerclaimsdDto();
						List<PrplaccidangersdDto> prplaccidangersdDtoList = new ArrayList<PrplaccidangersdDto>();
						List<PrplaccidangerclaimsdDto> prplaccidangerclaimsdDtoList = new ArrayList<PrplaccidangerclaimsdDto>();
						BLPrplaccidangersdFacade blPrplaccidangersdFacade = new BLPrplaccidangersdFacade();
						BLPrplaccidangerclaimsdFacade blPrplaccidangerclaimsdFacade = new BLPrplaccidangerclaimsdFacade();
						int serialNo = 1;
						String conditions = "";
						String isRisk = "";
						if(responseDto!=null){
							prplaccidangersdDto.setInsuredName(responseDto.getInsuredName());
							prplaccidangersdDto.setGender(responseDto.getGender());
							prplaccidangersdDto.setBirthday(responseDto.getBirthday());
							prplaccidangersdDto.setCredentialType(responseDto.getCredentialType());
							prplaccidangersdDto.setCredentialNo(responseDto.getCredentialNo());
							if(prplaccidangersdDto.getCredentialType()!=null&&!"".equals(prplaccidangersdDto.getCredentialType()) && 
									prplaccidangersdDto.getCredentialNo()!=null&&!"".equals(prplaccidangersdDto.getCredentialNo())){
								conditions = "Insuredname='"+prplaccidangersdDto.getInsuredName()+
										"' and Credentialtype='"+prplaccidangersdDto.getCredentialType()+
										"' and Credentialno='"+prplaccidangersdDto.getCredentialNo()+
										"' order by serialno desc ";
							}else if(prplaccidangersdDto.getGender()!=null&&!"".equals(prplaccidangersdDto.getGender()) && 
									prplaccidangersdDto.getBirthday()!=null&&!"".equals(prplaccidangersdDto.getBirthday())){
								conditions = "Insuredname='"+prplaccidangersdDto.getInsuredName()+
										"' and Gender='"+prplaccidangersdDto.getGender()+
										"' and Birthday='"+prplaccidangersdDto.getBirthday()+
										"' order by serialno desc ";
							}
							prplaccidangersdDtoList = (ArrayList<PrplaccidangersdDto>)blPrplaccidangersdFacade.findByConditions(conditions);
							if(prplaccidangersdDtoList!=null&&prplaccidangersdDtoList.size()>0){
								serialNo = prplaccidangersdDtoList.get(0).getSerialNo();
							}
							prplaccidangersdDto.setSerialNo(serialNo);
							if("1".equals(responseDto.getIsRisk())){
								isRisk = "是";
							}else if("0".equals(responseDto.getIsRisk())){
								isRisk = "否";
							}
							prplaccidangersdDto.setIsRisk(isRisk);
							prplaccidangersdDto.setLossTimes(Integer.parseInt(responseDto.getLossTimes()));
							prplaccidangersdDto.setSumClaimAmount(Double.parseDouble(responseDto.getSumClaimAmount()));
							prplaccidangersdDto.setRefuseClaimTimes(Integer.parseInt(responseDto.getRefuseClaimTimes()));
							//先删后插
							blPrplaccidangersdFacade.delete(prplaccidangersdDto.getInsuredName(), serialNo);
							blPrplaccidangersdFacade.insert(prplaccidangersdDto);
						}
						if(responseDto.getClaimInfoDtoList()!=null && responseDto.getClaimInfoDtoList().size()>0){
							for(AcciDangerSDClaimInfoDto acciDangerSDClaimInfoDto:responseDto.getClaimInfoDtoList()){
								prplaccidangerclaimsdDto.setInsuredname(responseDto.getInsuredName());
								prplaccidangerclaimsdDto.setSerialno(serialNo);
								prplaccidangerclaimsdDto.setCompanycode(acciDangerSDClaimInfoDto.getCompanyCode());
								prplaccidangerclaimsdDto.setLossdate(acciDangerSDClaimInfoDto.getLossDate());
								prplaccidangerclaimsdDto.setLossresult(acciDangerSDClaimInfoDto.getLossResult());
								prplaccidangerclaimsdDto.setClaimamount(Double.parseDouble(acciDangerSDClaimInfoDto.getClaimAmount()));
								blPrplaccidangerclaimsdFacade.delete(prplaccidangerclaimsdDto.getInsuredname(), 
										prplaccidangerclaimsdDto.getSerialno(), 
										prplaccidangerclaimsdDto.getCompanycode(), 
										prplaccidangerclaimsdDto.getLossdate());
								blPrplaccidangerclaimsdFacade.insert(prplaccidangerclaimsdDto);
								prplaccidangerclaimsdDtoList.add(prplaccidangerclaimsdDto);
							}
						}
						responseDtoList.add(responseDto);
						request.setAttribute("prplaccidangersdDto", prplaccidangersdDto);
					}
				}
				request.setAttribute("responseDtoList", responseDtoList);
				forward = "DangerList";
			}
		
		}catch(Exception e){
			e.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.compensateBeforeEdit.titleName");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			request.setAttribute("errorMessage", e.getMessage());
			saveErrors(request, msgs);
			forward = "error";
		}finally{
			dbManager.close();
			if(resultSet!=null){
				resultSet.close();
			}
		}
		return actionMapping.findForward(forward);
	}
	/**
	 * 理赔风险信息查询接口传参对象转化xml报文
	 * @param regist
	 * @return
	 * @throws Exception 
	 */
	public String getQueryXML(QueryAcciDangerSDRequestDto requestDto) throws Exception{
		Document document = getQueryDocument(requestDto);
		if(document!=null){
			document.setXMLEncoding("GBK");
			return document.asXML();
		}
		return null;
	}
	/**
	 * 事故信息查询接口返参报文转化Document
	 * @param responseDto
	 * @return
	 * @throws Exception
	 */
	private Document getQueryDocument(QueryAcciDangerSDRequestDto requestDto) throws Exception{
		Document document = DocumentHelper.createDocument();
		Element packetElement = document.addElement("Packet").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		Element headElement = packetElement.addElement("Head");
		headElement.addElement("RequestType").setText(parseString(requestDto.getRequestType()));
		headElement.addElement("UserCode").setText(parseString(requestDto.getUserCode()));
		headElement.addElement("PassWord").setText(parseString(requestDto.getPassWord()));
		Element bodyElement=packetElement.addElement("Body");
		if(requestDto!=null){
			Element resElement=bodyElement.addElement("BaseInfo");
			resElement.addElement("InsuredName").setText(parseString(requestDto.getInsuredName()));
			if("1".equals(requestDto.getGender())){
				resElement.addElement("Gender").setText(parseString("0"));//男性
			}else if("2".equals(requestDto.getGender())){
				resElement.addElement("Gender").setText(parseString("1"));//女性
			}else{
				resElement.addElement("Gender").setText(parseString("2"));//不详
			}
			resElement.addElement("Birthday").setText(parseString(requestDto.getBirthday()));
			resElement.addElement("CredentialType").setText(parseString(requestDto.getCredentialType()));
			resElement.addElement("CredentialNo").setText(parseString(requestDto.getCredentialNo()));
			resElement.addElement("LossDate").setText(parseString(requestDto.getLossDate()));
			resElement.addElement("AreaFlag").setText(parseString(requestDto.getAreaFlag()));
		}
		return document;
	}
	/**
	 * 事故信息推送接口返参报文转化dto
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static QueryAcciDangerSDResponseDto getPushResponseDtoFromXML(String xmlStr) throws Exception{
		//1、xml转换成schema
		QueryAcciDangerSDResponseDto responseDto = new QueryAcciDangerSDResponseDto();
		System.out.println("返回报文-----------\n"+xmlStr);
		Document document = DocumentHelper.parseText(xmlStr);
		//得到根节点PACKET 
		Element packet = document.getRootElement();
		//Element packet = document.addElement("Packet").addAttribute("type", "REQUEST").addAttribute("version", "1.0");
		for (Iterator it=packet.elementIterator("Head"); it.hasNext();){
			Element head=(Element)it.next();
			responseDto.setRequestType (parseNode(head.selectSingleNode("RequestType")));
			responseDto.setResponseCode(parseNode(head.selectSingleNode("ResponseCode")));
			responseDto.setErrorCode   (parseNode(head.selectSingleNode("ErrorCode")));
			responseDto.setErrorMessage(parseNode(head.selectSingleNode("ErrorMessage")));
		}
		//得到BODY节点
		for (Iterator bit=packet.elementIterator("Body"); bit.hasNext();){
			if("L03".equals(responseDto.getRequestType())){
				AcciDangerSDClaimInfoDto claimInfoDto = null;
				List<AcciDangerSDClaimInfoDto> claimInfoDtoList = new ArrayList<AcciDangerSDClaimInfoDto>();
				Element body=(Element)bit.next();
				for (Iterator rit=body.elementIterator("RiskInfo"); rit.hasNext();){
					Element risk=(Element)rit.next();
					responseDto.setInsuredName     (parseNode(risk.selectSingleNode("InsuredName")));
					responseDto.setGender          (parseNode(risk.selectSingleNode("Gender")));
					responseDto.setBirthday        (parseNode(risk.selectSingleNode("Birthday")));
					responseDto.setCredentialType  (parseNode(risk.selectSingleNode("CredentialType")));
					responseDto.setCredentialNo    (parseNode(risk.selectSingleNode("CredentialNo")));
					responseDto.setIsRisk          (parseNode(risk.selectSingleNode("IsRisk")));
					responseDto.setLossTimes       (parseNode(risk.selectSingleNode("LossTimes")));
					responseDto.setSumClaimAmount  (parseNode(risk.selectSingleNode("SumClaimAmount")));
					responseDto.setRefuseClaimTimes(parseNode(risk.selectSingleNode("RefuseClaimTimes")));
					for(Iterator cit=risk.elementIterator("ClaimInfo"); cit.hasNext();){
						Element claim=(Element)cit.next();
						claimInfoDto = new AcciDangerSDClaimInfoDto();
						claimInfoDto.setCompanyCode(parseNode(claim.selectSingleNode("CompanyCode")));
						claimInfoDto.setLossDate   (parseNode(claim.selectSingleNode("LossDate")));
						claimInfoDto.setLossResult (parseNode(claim.selectSingleNode("LossResult")));
						claimInfoDto.setClaimAmount(parseNode(claim.selectSingleNode("ClaimAmount")));
						claimInfoDtoList.add(claimInfoDto);
					}
				}
				responseDto.setClaimInfoDtoList(claimInfoDtoList);
			}
		}
		return responseDto;
	}
	private static String parseNode(Node node){
		if (node==null){
			return "";
		}
		return node.getText();
	}
	private static String parseString(String str){
		if (str==null){
			return "";
		}
		return str;
	}
}
