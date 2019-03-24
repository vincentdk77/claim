<%--
****************************************************************************
* DESC       ����ҽ�Ʊ����Զ����ɵ�����֧���´���ҳ��
* AUTHOR     �� Pao
* CREATEDATE �� 2014-09-22
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  <title>��ҽ���Զ�����֧����Ϣ</title>
  <%-- ҳ����ʽ  --%>
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
	//ֱ�Ӱ�autoflag��Ϊ1��ֹ�ظ�ִ��
	dbManagerTop.open(AppConfig.get("sysconst.DBJNDI"));
     dbManagerTop.beginTransaction();
     //���¼�¼
     String sqlTop = "update PrpLinterPayRequest set autoflag='1' where"+ condition;
     dbManagerTop.executeUpdate(sqlTop);
     dbManagerTop.commitTransaction();//�����ύ�Ƿ�ֹ������ĳ�������
     
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
					//����֧��
					prpLinterPayRequestDto = new UIMedicalAutoPaySubViewHelper().autoPay(prpLinterPayRequestDto);
					 
					//�ύ˫������
					prpLinterPayRequestDto = new UIMedicalPayVericSubViewHelper().autoPayVeric(prpLinterPayRequestDto);
					
					paymentNo = prpLinterPayRequestDto.getPaymentNo();
					String businessNo = paymentNo;
					
					//���������ո��ӿڿ�ʼ 2016/12/23 xxk
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
	        			prpqPayMainDto.setRoutenum(prpLpaymainDto.getRouteNum());//֧���к�
	        			prpqPayMainDto.setPayPurpose(prpLpaymainDto.getPayPurpose());//��;˵��
	        			prpqPayMainDto.setVisaserialno(prpLpaymainDto.getPaymentNo());//���㵥��
	        			if("1".equals(prpLpaymainDto.getInterType())){
	        				prpqPayMainDto.setSettleType("M");
	        			}else{
	        				prpqPayMainDto.setSettleType("C");
	        			}
	            		prpqPayMainDto.setReceiverfullname(prpLpaymainDto.getReceiverFullName());//������
	            		prpqPayMainDto.setBankaccount(prpLpaymainDto.getBankAccount());//�����˺�
	            		prpqPayMainDto.setBanktype(prpLpaymainDto.getBankType());
	            		prpqPayMainDto.setBank(prpLpaymainDto.getBank());
	            		prpqPayMainDto.setBankprov(prpLpaymainDto.getProvinceCode());//����ʡ��
	            		prpqPayMainDto.setBankcity(prpLpaymainDto.getCityCode());//��������
	            		prpqPayMainDto.setAccounttype(prpLpaymainDto.getAccountType());//�˻�����
	            		if(nameMap.containsKey(prpLpaymainDto.getOperatorCode())){
	            			prpqPayMainDto.setOperatename(nameMap.get(prpLpaymainDto.getOperatorCode()));//����������
	                		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//�����˴���
	            		} else {
	            			com.sinosoft.claim.dto.domain.PrpDuserDto userDto = facade.findByPrimaryKey(prpLpaymainDto.getOperatorCode());
	            			if(userDto!=null){
	            				prpqPayMainDto.setOperatename(userDto.getUserName());//����������
	                    		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//�����˴���
	                    		nameMap.put(prpLpaymainDto.getOperatorCode(), userDto.getUserName());
	            			}
	            		}
	            		prpqPayMainDto.setComcode(prpLpaymainDto.getComCode());//��������
	            		prpqPayMainDto.setAccountflag(prpLpaymainDto.getAccountFlag());
	            		prpqPayMainDto.setCertifyno(prpLpaymainDto.getCertifNo());//֤��
	            		prpqPayMainDto.setCertifytype(prpLpaymainDto.getCertifType());//֤������
	            		prpqPayMainDto.setReceivertype(prpLpaymainDto.getReceiverTypeOther());//���������
	            		prpqPayMainDto.setOfficephone(prpLpaymainDto.getOfficePhone());//�칫�ҵ绰
	            		prpqPayMainDto.setMobilephone(prpLpaymainDto.getMobilePhone());//�ֻ�����
	            		prpqPayMainDto.setFamilyphone(prpLpaymainDto.getFamilyPhone());//�̻�
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
	            		prpqPayMainDto.setOperatedate(time1);//����ʱ��
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
	            		LogFile.log(logPath, fileName, new Date().getTime(), "���ͱ��ģ�"+xmlreq);
	            		String respxml = SavePaymentInfoUtil.savePaymentInfo(xmlreq);
	            		LogFile.log(logPath, fileName, new Date().getTime(), "���ر��ģ�"+respxml);
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
                            //���¼�¼
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
                //���ͽ���
            } catch (Exception ee) {
            	String fileName = "C-Medical-ERROR"+new SimpleDateFormat("yyyyMMdd").format(new Date())+".log"; 
            	LogFile.log(logPath, fileName, new Date().getTime(), "���ýӿ��쳣��"+ee);
            	ee.printStackTrace();
            }
            }
			//���������ո�����
				}else{//���У�鲻ͨ������Ҫ��autoflag��Ϊ�ա�
					String sqlId= "update PrpLinterPayRequest set autoflag='' where id='"+ id+"'";
					dbManagerTop.beginTransaction();
					dbManagerTop.executeUpdate(sqlId);
					dbManagerTop.commitTransaction();
				}
				
				returnStr=returnStr+"��"+ id+"-"+paymentNo+returnStr3+"����";
				
			}catch(Exception e ){
			//����ʧ���˱����autoflag��Ϊ�գ�������Ҫ�ύ
				String sqlId= "update PrpLinterPayRequest set autoflag='' where id='"+ id+"'";
				dbManagerTop.beginTransaction();
				dbManagerTop.executeUpdate(sqlId);
				dbManagerTop.commitTransaction();
				e.printStackTrace();
				returnStr2=returnStr2+"��"+id+"��,";
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
    <tr><td colspan=2 class="formtitle">��ҽ�Ƶ�����֧����Ϣ�Զ���</td></tr>
        <tr>
        <td class='button' colspan=2>
          ֧����ţ�<%=returnStr %>�� �����ɹ�
        </td>
      </tr>
      <tr>
        <td class='button' colspan=2>
          id��<%=returnStr2 %> ��ͬ��ʧ��
        </td>
      </tr>
    </table>
  </form>
</body>
</html:html>



