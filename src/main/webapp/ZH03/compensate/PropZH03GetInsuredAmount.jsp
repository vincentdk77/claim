<%--
****************************************************************************
* DESC       ���⸶�����Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-10-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        ���������ձ��ĵ��ж�
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainCasualtySchema"%>
<%@page import="com.gyic.claim.bl.facade.BLZh03PolicyListFacade"%>
<%@page import="com.gyic.claim.dto.domain.Zh03PolicyListDto"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpPheadDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIEndorseAction"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.UserException"%>
<%@page import="com.sinosoft.nyx.blsvr.BLInsuremainEndorHead"%>
<%@page import="com.sinosoft.nyx.blsvr.BLZH03PPolicyList"%>
<%@page import="com.sinosoft.nyx.schema.ZH03PPolicyListSchema"%>
<%@page import="org.dom4j.Document"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="org.dom4j.Element"%>


<%@page contentType="text/xml;charset=GBK"%>
<%
	double itemAmount= 0.00;
	String itemAmountDisplay= "";
	double itemAmountPolicy = 0.00;
	String policyNo = request.getParameter("policyNo");
	String itemCode = request.getParameter("itemCode");
	String kindCode = request.getParameter("kindCode");
	String familyNo = request.getParameter("familyNo");
	String familyName = request.getParameter("familyName");
	String damageTime = request.getParameter("damageTime");
	BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
	blPrpCmainCasualty.getData(policyNo);
	Document dom = DocumentHelper.createDocument();
	if(null!=familyNo && !"".equals(familyNo)){
		//while(familyNo.length()<7)
		//	familyNo = "0" + familyNo;
	}
	//dom.setXMLEncoding("GBK");
	Element root = dom.addElement("sumAmount");
	if(null!= blPrpCmainCasualty && blPrpCmainCasualty.getSize()>0){
			for(int k=0;k<blPrpCmainCasualty.getSize();k++){
	 	   PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(k);
	 	   String insureListCode = prpCmainCasualtySchema.getRemark();
	 	   insureListCode.trim();
	 	   if(null != insureListCode && !"".equals(insureListCode)){
	 	   		String sqlCondition = "familyNo = '"+familyNo+"' And itemCode = '"+itemCode+"' And kindCode = '"+kindCode+"' "
	 	   								+" And inusreListCode = '"+insureListCode+"' ";
	 	   		if(null!= familyName && !"".equals(familyName)){
	 	   			sqlCondition += " And name = '"+familyName+"'";
	 	   		}
	 	   		BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	 	   		Collection collectionZH03PolicyList = blZH03PolicyListFacade.findByConditions(sqlCondition);
	 	   		if(null != collectionZH03PolicyList && collectionZH03PolicyList.size()>0){
	 	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)collectionZH03PolicyList.toArray()[0];
	 	   			itemAmountPolicy = zh03PolicyListDto.getSumAmount();
	 	   			//zh03PolicyListDto = findForEndorZH03PolicylistBefore(zh03PolicyListDto,policyNo,damageTime);
	 	   			//itemAmount = zh03PolicyListDto.getSumAmount();
	 	   			//if(itemAmount > itemAmountPolicy)
	 	   				itemAmount = itemAmountPolicy;
	 	   		}
	 	   }
	  }
	 }
	 
	 root.addText(""+itemAmount);
	 //response.getWriter().write(dom.asXML());
	 out.clearBuffer();
	 //out.print(dom.asXML());
	 out.print(""+itemAmount);
	 
%>

<%!

     //STUB-ONLY����Գ��ձ����Ļص�
     //@param     �������ڻ�������������
     //@return    ����ʱ��Ч���嵥��Ϣ
     //@throws UserException
     //@throws Exception
    
     private Zh03PolicyListDto findForEndorZH03PolicylistBefore(Zh03PolicyListDto zh03PolicyListDtoOrigin,String policyNo,String damageTime) 
     throws Exception{
     	Zh03PolicyListDto zh03PolicyListDto = zh03PolicyListDtoOrigin;
       //���ַ���ת��������
       int theDamageHour = 0;
       String strDamageDate = "";
       String strDamageHour = "";
       if(null!=damageTime && damageTime.length()>0){
       		if(damageTime.indexOf("��")>-1){
       			strDamageDate = damageTime.substring(0,damageTime.indexOf("��"));
       			if(damageTime.indexOf("ʱ")>-1){
       				strDamageHour = damageTime.substring(damageTime.indexOf("��")+1,damageTime.indexOf("ʱ"));
       			}
       		}
       }
       if(strDamageHour!=null&&strDamageHour.length()>0){
           theDamageHour = Integer.parseInt(strDamageHour.trim());
       }
       //modify by qinyongli start 2005-8-5 
       //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
       if(strDamageDate!=null&&strDamageDate.length()>9){
    	   strDamageDate = strDamageDate.substring(0,10);
       }     
       //modify by qinyongli end 2005-8-5
      
       PrpPheadDto  prpPheadDto = new PrpPheadDto();
       //ȡ��������Ϣ����Ϣ
       UIEndorseAction uiEndorseAction = new UIEndorseAction();
       String iWherePart = "PolicyNo = '"+policyNo+"'"
 				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
 						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>="+theDamageHour +"))"
 				        + " AND UnderWriteFlag in ('1', '3') "
 				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
       ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
       //û���ҵ����������������򷵻ص�ǰ�嵥
       if (listTemp == null || listTemp.size() == 0){
    	   	return zh03PolicyListDto;
       }
       for (int i = 0; i < listTemp.size(); i++) {
			prpPheadDto = (PrpPheadDto)listTemp.get(i);
	    	//�ҵ����𼶻ع��嵥��Ϣ
			//��ʼ����ͷ��
			BLInsuremainEndorHead blInsuremainEndorHead = new BLInsuremainEndorHead();
			blInsuremainEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' ");//and ENDORFLAG ='29'
			if (blInsuremainEndorHead == null || blInsuremainEndorHead.getSize() == 0){
				continue;
			}
			if (blInsuremainEndorHead.getSize() > 1){
				throw new UserException(1,3,"������:" + blInsuremainEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
			}
			//��ʼ���ı仯����
			BLZH03PPolicyList blZH03PPolicyList = new BLZH03PPolicyList();
			blZH03PPolicyList.query("ENDORSENO = '" + blInsuremainEndorHead.getArr(0).getEndorseNo() +
			"' and FAMILYNO = '" + zh03PolicyListDtoOrigin.getFamilyNo() +
			"' and NAME ='" + zh03PolicyListDtoOrigin.getName() +
			"' and KINDCODE ='" + zh03PolicyListDtoOrigin.getKindCode() +
			"' and ITEMCODE ='" + zh03PolicyListDtoOrigin.getItemCode() +
			"' and INUSRELISTCODE ='" + zh03PolicyListDtoOrigin.getInusreListCode() +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
			if (blZH03PPolicyList == null || blZH03PPolicyList.getSize() == 0){
				continue;
			}
			if (blZH03PPolicyList.getSize() > 1){
				throw new UserException(1,3,"������:" + blZH03PPolicyList.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
			}
			backWard(blZH03PPolicyList.getArr(0),zh03PolicyListDto);
       }
       return zh03PolicyListDto;
     }
     
      //STUB-ONLY��
      
      //@param  �ص��嵥,ֻ�ع����
      //@return ��
      //@throws UserException
      //@throws Exception
      
      private void backWard(ZH03PPolicyListSchema zh03PPolicyListSchema, Zh03PolicyListDto zh03PolicyListDto) throws Exception
      {
    	  if("D".equals(zh03PPolicyListSchema.getFlag()))//ɾ�������������˽����Ϊ��Ч
		  {
    		  zh03PolicyListDto.setSumAmount(zh03PolicyListDto.getSumAmount()+Double.valueOf(zh03PPolicyListSchema.getChgSumAmount()));
    		  zh03PolicyListDto.setFlag("1");
		  }
    	  else if("I".equals(zh03PPolicyListSchema.getFlag()))//���������������˽����Ϊ��Ч
    	  {
    		  zh03PolicyListDto.setSumAmount(zh03PolicyListDto.getSumAmount()+Double.valueOf(zh03PPolicyListSchema.getChgSumAmount()));
    		  zh03PolicyListDto.setFlag("0");
		  }
    	  else if("U".equals(zh03PPolicyListSchema.getFlag()))//�޸Ĳ��������˽�
    	  {
    		  zh03PolicyListDto.setSumAmount(zh03PolicyListDto.getSumAmount()+Double.valueOf(zh03PPolicyListSchema.getChgSumAmount()));
    	  }
    	  else
    		  throw new UserException(1,-1007,this.getClass().getName());
      }
%>




