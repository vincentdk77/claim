<%--
****************************************************************************
* DESC       ：大病医疗保险自动生成第三方支付新触发页面
* AUTHOR     ： Pao
* CREATEDATE ： 2014-09-22
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.daaplatform.util.SysConfig"%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="java.util.*" %>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.webservice.newpayment.*" %>
<%@page import="com.sinosoft.sysframework.reference.DBManager" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.lang.*" %>
<%@page import="com.sinosoft.undwrt.bl.facade.BLPrpCmainFacade" %>
<%@page import="com.sinosoft.prpall.dto.domain.PrpCmainDto" %>
<%@page import ="com.sinosoft.prpall.blsvr.jf.BLPrpJpayRefRec" %>
<%@page import ="com.sinosoft.sysframework.reference.DBManager" %>
<%@page import = "com.sinosoft.sysframework.reference.AppConfig" %>
<%@page import = "java.text.SimpleDateFormat" %>
<%@page import = "com.sinosoft.webservice.newpayment.req.*"%>
<%@page import = "java.sql.ResultSet" %>
<%@page import = "com.sinosoft.webservice.newpayment.cli.*" %>
<%@page import = "com.sinosoft.webservice.newpayment.res.*" %>
<%@page import = "com.sinosoft.prpall.blsvr.jf.BLPrpJpayRefRecCoins" %>
<%@page import = "com.sinosoft.sff.blsvr.BLPrpJcommissionFlog" %>
<%@page import = "com.thoughtworks.xstream.XStream" %>
<%@page import = "com.sinosoft.claim.util.LogFile" %>
<html:html locale="true">
<head>
  <title>大病医疗自动生成支付信息</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<%


Collection prpLinterRequestList = new ArrayList();
Collection prpLinterPayRequestList = new ArrayList();
BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
UIMedicalAutoClaimViewHelper uiMedicalAutoClaimViewHelper = new UIMedicalAutoClaimViewHelper();
UIMedicalAutoRegistSubViewHelper uiMedicalAutoRegistSubViewHelper = new UIMedicalAutoRegistSubViewHelper();
UIMedicalAutoSchedSubViewHelper uiMedicalAutoSchedSubViewHelper = new UIMedicalAutoSchedSubViewHelper();
UIMedicalAutoCheckSubViewHelper uiMedicalAutoCheckSubViewHelper = new UIMedicalAutoCheckSubViewHelper();
UIMedicalAutoClaimSubViewHelper uiMedicalAutoClaimSubViewHelper = new UIMedicalAutoClaimSubViewHelper();
UIMedicalAutoCertiSubViewHelper uiMedicalAutoCertiSubViewHelper = new UIMedicalAutoCertiSubViewHelper();
UIMedicalAutoCompeSubViewHelper uiMedicalAutoCompeSubViewHelper = new UIMedicalAutoCompeSubViewHelper();
UIMedicalAutoVericSubViewHelper uiMedicalAutoVericSubViewHelper = new UIMedicalAutoVericSubViewHelper();
UIMedicalAutoEndcaSubViewHelper uiMedicalAutoEndcaSubViewHelper = new UIMedicalAutoEndcaSubViewHelper();
BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
String returnStr = "";
String returnStr2 = "";
String returnStr3 = ""; 
String paymentNo = "";
DBManager dbManagerTop = new DBManager();
try {
	String condition = " autoflag is null";
	System.err.println("condition =="+condition);
	prpLinterPayRequestList = blPrpLinterPayRequestFacade.findByConditionsWithChild(condition);
	//直接把autoflag置为1防止重复执行
	dbManagerTop.open(AppConfig.get("sysconst.DBJNDI"));
     dbManagerTop.beginTransaction();
     //更新记录
     String sqlTop = "update PrpLinterPayRequest set autoflag='1' where"+ condition;
     dbManagerTop.executeUpdate(sqlTop);
     dbManagerTop.commitTransaction();//这里提交是防止后面更改出现锁死
     
	if(prpLinterPayRequestList!=null&&!prpLinterPayRequestList.isEmpty()&&prpLinterPayRequestList.size()>0){
		Iterator it = prpLinterPayRequestList.iterator();
		while (it.hasNext()){
			PrpLinterPayRequestDto prpLinterPayRequestDto = (PrpLinterPayRequestDto)it.next();  
			String id = prpLinterPayRequestDto.getId();
			try{
				
			
				boolean startWithZero = false;
				UIMedicalCheckBeforeAutoPayViewHelper checkBeforeAutoPayViewHelper = new UIMedicalCheckBeforeAutoPayViewHelper();
				returnStr3 = checkBeforeAutoPayViewHelper.checkRelationOutIdByAuto(prpLinterPayRequestDto);
				if("".equals(returnStr3)){
					//新增支付
					prpLinterPayRequestDto = new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
					 
					//提交双核审批
					prpLinterPayRequestDto = new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
					
					paymentNo = prpLinterPayRequestDto.getPaymentNo();
					String businessNo = paymentNo;
					
					//理赔送新收付接口开始 2016/12/23 xxk
			if("1".equals(AppConfig.get("sysconst.NEWPAYMENT"))){	
			String logPath = AppConfig.get("sysconst.PAYMENTPLATFORMLOGPATH");
			try{
        		BLPrpLpaymainFacade blPrpLpaymainFacade = new BLPrpLpaymainFacade();
        		BLPrplpayFacade blPrpLpayFacade = new BLPrplpayFacade();
        		List<PrpLpaymainDto> mainList = new ArrayList<PrpLpaymainDto>();
        		if(businessNo.startsWith("H")){
        			mainList = (ArrayList<PrpLpaymainDto>)blPrpLpaymainFacade.findByConditions("paymentno in (select paymentno from prplpaybill b where b.businessno='"+businessNo+"')");
        		} else {
        			mainList = (ArrayList<PrpLpaymainDto>)blPrpLpaymainFacade.findByConditions("paymentno = '"+businessNo+"'");
        		}
        		PrpqPayMainDto prpqPayMainDto = null;
        		BLPrpDuserFacade facade = new BLPrpDuserFacade();
        		HashMap<String, String> nameMap = new HashMap<String, String>();
        		for(PrpLpaymainDto prpLpaymainDto : mainList){
        			prpqPayMainDto = new PrpqPayMainDto();
	        		if(prpLpaymainDto.getPayAmount()>0&&"1".equals(prpLpaymainDto.getPayWay())){
	        			prpqPayMainDto.setRoutenum(prpLpaymainDto.getRouteNum());//支付行号
	        			prpqPayMainDto.setPayPurpose(prpLpaymainDto.getPayPurpose());//用途说明
	        			prpqPayMainDto.setVisaserialno(prpLpaymainDto.getPaymentNo());//结算单号
	        			if("1".equals(prpLpaymainDto.getInterType())){
	        				prpqPayMainDto.setSettleType("M");
	        			}else{
	        				prpqPayMainDto.setSettleType("C");
	        			}
	            		prpqPayMainDto.setReceiverfullname(prpLpaymainDto.getReceiverFullName());//出款人
	            		prpqPayMainDto.setBankaccount(prpLpaymainDto.getBankAccount());//银行账号
	            		prpqPayMainDto.setBanktype(prpLpaymainDto.getBankType());
	            		prpqPayMainDto.setBank(prpLpaymainDto.getBank());
	            		prpqPayMainDto.setBankprov(prpLpaymainDto.getProvinceCode());//开户省份
	            		prpqPayMainDto.setBankcity(prpLpaymainDto.getCityCode());//开户城市
	            		prpqPayMainDto.setAccounttype(prpLpaymainDto.getAccountType());//账户属性
	            		if(nameMap.containsKey(prpLpaymainDto.getOperatorCode())){
	            			prpqPayMainDto.setOperatename(nameMap.get(prpLpaymainDto.getOperatorCode()));//操作人名称
	                		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//操作人代码
	            		} else {
	            			com.sinosoft.claim.dto.domain.PrpDuserDto userDto = facade.findByPrimaryKey(prpLpaymainDto.getOperatorCode());
	            			if(userDto!=null){
	            				prpqPayMainDto.setOperatename(userDto.getUserName());//操作人名称
	                    		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//操作人代码
	                    		nameMap.put(prpLpaymainDto.getOperatorCode(), userDto.getUserName());
	            			}
	            		}
	            		prpqPayMainDto.setComcode(prpLpaymainDto.getComCode());//操作机构
	            		prpqPayMainDto.setAccountflag(prpLpaymainDto.getAccountFlag());
	            		prpqPayMainDto.setCertifyno(prpLpaymainDto.getCertifNo());//证件
	            		prpqPayMainDto.setCertifytype(prpLpaymainDto.getCertifType());//证件类型
	            		prpqPayMainDto.setReceivertype(prpLpaymainDto.getReceiverTypeOther());//赔款人类型
	            		prpqPayMainDto.setOfficephone(prpLpaymainDto.getOfficePhone());//办公室电话
	            		prpqPayMainDto.setMobilephone(prpLpaymainDto.getMobilePhone());//手机号码
	            		prpqPayMainDto.setFamilyphone(prpLpaymainDto.getFamilyPhone());//固话
	            		prpqPayMainDto.setAddress(prpLpaymainDto.getAddress());
	            		prpqPayMainDto.setQqnumber(prpLpaymainDto.getQqNumber());
	            		prpqPayMainDto.setEmail(prpLpaymainDto.getEmail());
	            		prpqPayMainDto.setUnitlink(prpLpaymainDto.getUnitLink());
	            		prpqPayMainDto.setPostcode(prpLpaymainDto.getPostCode());
	            		prpqPayMainDto.setUrgenttype(prpLpaymainDto.getUrgentType());
	            		prpqPayMainDto.setPayamount(String.valueOf(prpLpaymainDto.getPayAmount()));
	            		prpqPayMainDto.setThridpayflag(prpLpaymainDto.getPayWay());
	            		prpqPayMainDto.setFlag("3");
	            		prpqPayMainDto.setBusinessno1("");
	            		prpqPayMainDto.setBusinessno2("");
	            		prpqPayMainDto.setBusinessno3("");
	            		prpqPayMainDto.setBusinessno4("");
	            		prpqPayMainDto.setBusinessno5("");
	            		String time1 = new SimpleDateFormat("yyyyMMddHHmmss").format(prpLpaymainDto.getInputDate());
	            		prpqPayMainDto.setOperatedate(time1);//操作时间
	            		List<PrplpayDto> prplpayDtos = (ArrayList<PrplpayDto>)blPrpLpayFacade.findByConditions("serialno = '"+prpLpaymainDto.getPaymentNo()+"'");
	            		PrpqPayDto prpqPayDto = null;
	            		List<PrpqPayDto> list = new ArrayList<PrpqPayDto>();
	            		for(PrplpayDto prpLpayDto : prplpayDtos){
	            			prpqPayDto = new PrpqPayDto();
	            			if(businessNo.startsWith("H")){
	            				prpqPayDto.setPayBillNo(businessNo);
	                		} 
	            			prpqPayDto.setCertino(prpLpayDto.getCompensateno());//COMPENSATENO
	                		prpqPayDto.setCertitype("C");
	                		prpqPayDto.setPayno("1");
	                		prpqPayDto.setPolicyno(prpLpayDto.getPolicyno());
	                		prpqPayDto.setPayreason(prpLpayDto.getPaymenttype());
	                		prpqPayDto.setAmount(String.valueOf(prpLpayDto.getPayamount()));
	                		prpqPayDto.setFlag1("");
	                		prpqPayDto.setFlag2("");
	                		prpqPayDto.setFlag3("");
	                		prpqPayDto.setFlag4("");
	                		prpqPayDto.setFlag5("");
	            			if("GS60".equals(prpLpayDto.getPaymenttype())){
	                			BLPrpJpayRefRecCoins blPrpJpayRefRecCoins = new BLPrpJpayRefRecCoins();
	                			blPrpJpayRefRecCoins.query("CERTINO='"+prpLpayDto.getCompensateno()+"' and CERTITYPE in ('C','Y','Z') and payrefreason='"+prpLpayDto.getPaymenttype()+"' and CoinsCode='"+prpLpayDto.getCoinsCode()+"'");
	                			prpqPayDto.setComcode(blPrpJpayRefRecCoins.getArr(0).getComCode());
	                			prpqPayDto.setArticleCode28(blPrpJpayRefRecCoins.getArr(0).getComCode());
	                			prpqPayDto.setArticleCode05(blPrpJpayRefRecCoins.getArr(0).getRiskCode());
	                    		prpqPayDto.setArticleCode24(blPrpJpayRefRecCoins.getArr(0).getCoinsCode());
	                    		if(prpqPayMainDto.getUppercomcode()==null || "".equals(prpqPayMainDto.getUppercomcode())){
	                    			BLPrpJcommissionFlog blPrpJcommissionFlog = new BLPrpJcommissionFlog();
	                    			blPrpJcommissionFlog.query("flowid='"+blPrpJpayRefRecCoins.getArr(0).getVisaSerialNo()+"' and flowstatus='1'");
	                    			if(blPrpJcommissionFlog.getSize()>0){
	                    				prpqPayMainDto.setUppercomcode(blPrpJcommissionFlog.getArr(0).getDeptCode());
	                    			}
	                    		}
	                		} else {
	                			BLPrpJpayRefRec blprpJpayRefRec = new BLPrpJpayRefRec();
	            				blprpJpayRefRec.query("CERTINO='"+prpLpayDto.getCompensateno()+"' and CERTITYPE in ('Y','C','Z') and payrefreason='"+prpLpayDto.getPaymenttype()+"'");
	            				prpqPayDto.setComcode(blprpJpayRefRec.getArr(0).getComCode());
	            				prpqPayDto.setArticleCode05(blprpJpayRefRec.getArr(0).getRiskCode());
	            				prpqPayDto.setArticleCode28(blprpJpayRefRec.getArr(0).getComCode());
	            				if(prpqPayMainDto.getUppercomcode()==null || "".equals(prpqPayMainDto.getUppercomcode())){
	            					BLPrpJcommissionFlog blPrpJcommissionFlog = new BLPrpJcommissionFlog();
	                    			blPrpJcommissionFlog.query("flowid='"+blprpJpayRefRec.getArr(0).getVisaSerialNo()+"' and flowstatus='1'");
	                    			if(blPrpJcommissionFlog.getSize()>0){
	                    				prpqPayMainDto.setUppercomcode(blPrpJcommissionFlog.getArr(0).getDeptCode());
	                    			}
	            				}
	                		}
	            			list.add(prpqPayDto);
	            		}
	            		PrpqBaseDto request1 = new PrpqBaseDto();
	            		PrpqBaseBodyDto body = new PrpqBaseBodyDto();
	            		PrpqBaseHeadDto head = new PrpqBaseHeadDto();
	            		Date date = new Date();
	            		SimpleDateFormat mat = new SimpleDateFormat("yyyyMMddHHmmss");
	            		String time = mat.format(date);
	            		head.setChannelCode("Sinosoft");
	            		head.setUserCode(AppConfig.get("sysconst.PAYMENTPLATFORMUSERCODE"));
	            		head.setTransID(time);//time
	            		head.setPassword(AppConfig.get("sysconst.PAYMENTPLATFORMPASSWORD"));
	            		head.setTransType("S");
	            		body.setBasePart(prpqPayMainDto);
	            		body.setDetailInfoList(list);
	            		request1.setBody(body);
	            		request1.setHead(head);
	            		XStreamDto2XmlUtil xStreamDto2XmlUtil = new XStreamDto2XmlUtil();
	            		String xmlreq = xStreamDto2XmlUtil.Dto2Xml(request1);
	            		String fileName = "C-Medical"+new SimpleDateFormat("yyyyMMdd").format(new Date())+".log"; 
	            		LogFile.log(logPath, fileName, new Date().getTime(), "发送报文："+xmlreq);
	            		String respxml = SavePaymentInfoUtil.savePaymentInfo(xmlreq);
	            		LogFile.log(logPath, fileName, new Date().getTime(), "返回报文："+respxml);
	            		System.out.println(respxml);
	            		PrpqRepBaseDto prpqRepBaseDto = new PrpqRepBaseDto();
	            		PrpqRepBaseDto dto = (PrpqRepBaseDto)xStreamDto2XmlUtil.Xml2Dto(prpqRepBaseDto, respxml);
	            		String messagecode = dto.getHead().getErrorCode();
	            		System.out.println(messagecode);
	            		String sendflag = "1";
	            		if("9999".equals(messagecode)){
	            			sendflag = "0";
	            		}
	            		DBManager dbManager = new DBManager();
            			try {
            				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
                            dbManager.beginTransaction();
                            //更新记录
                            String sql = "update prplpaymain set sendflag='"+sendflag+"' where paymentno='"+prpLpaymainDto.getPaymentNo()+"'";
                            dbManager.executeUpdate(sql);
                            dbManager.commitTransaction();
            			} catch (Exception e){
            				e.printStackTrace();
            				dbManager.rollbackTransaction();
            			} finally {
            				dbManager.close();
            			}
	            	}
        		}
                //发送结束
            } catch (Exception ee) {
            	String fileName = "C-Medical-ERROR"+new SimpleDateFormat("yyyyMMdd").format(new Date())+".log"; 
            	LogFile.log(logPath, fileName, new Date().getTime(), "调用接口异常："+ee);
            	ee.printStackTrace();
            }
            }
			//理赔送新收付结束
				}else{//如果校验不通过则需要把autoflag置为空。
					String sqlId= "update PrpLinterPayRequest set autoflag='' where id='"+ id+"'";
					dbManagerTop.beginTransaction();
					dbManagerTop.executeUpdate(sqlId);
					dbManagerTop.commitTransaction();
				}
				
				returnStr=returnStr+"“"+ id+"-"+paymentNo+returnStr3+"”，";
				
			}catch(Exception e ){
			//若果失败了必须把autoflag置为空，所以需要提交
				String sqlId= "update PrpLinterPayRequest set autoflag='' where id='"+ id+"'";
				dbManagerTop.beginTransaction();
				dbManagerTop.executeUpdate(sqlId);
				dbManagerTop.commitTransaction();
				e.printStackTrace();
				returnStr2=returnStr2+"“"+id+"“,";
			}
		}
	}
} catch (Exception e) {
    dbManagerTop.rollbackTransaction();
	e.printStackTrace();
} finally {
	dbManagerTop.close();
}

%>

<body  >
<form name="fm" action=""  method="post"  target ="sub">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=2 class="formtitle">大病医疗第三方支付信息自动化</td></tr>
        <tr>
        <td class='button' colspan=2>
          支付编号（<%=returnStr %>） 交互成功
        </td>
      </tr>
      <tr>
        <td class='button' colspan=2>
          id（<%=returnStr2 %> ）同步失败
        </td>
      </tr>
    </table>
  </form>
</body>
</html:html>



