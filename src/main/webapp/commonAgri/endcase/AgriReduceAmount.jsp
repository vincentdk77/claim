<%--
****************************************************************************
* DESC       ��ũ������������Ĵ���
* Author     : ������Ŀ��
* CREATEDATE ��2006-11-24
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- ����bean�ಿ�� --%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLEndorse"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>
<%@page import="com.sinosoft.prpall.pubfun.Bill"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.dto.custom.EndorDto"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLendorFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLendorDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIEndorAction"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<%@page import="com.sinosoft.nyx.schema.*"%>
<%@page import="com.sinosoft.nyx.blsvr.*"%>
<%@page import="com.gyic.claim.bl.facade.BLHerdsettlelistFacade"%>
<%@page import="com.gyic.claim.bl.facade.BLSettlemainlistFacade"%>
<%@page import="com.gyic.claim.bl.facade.BLInsuremainlistFacade"%>
<%@page import="com.gyic.claim.bl.facade.*"%>
<%@page import="com.gyic.claim.dto.domain.HerdsettlelistDto"%>
<%@page import="com.gyic.claim.dto.domain.SettlemainlistDto"%>
<%@page import="com.gyic.claim.dto.domain.InsuremainlistDto"%>
<%@page import="com.gyic.claim.dto.domain.*"%>
<%@page import="com.sinosoft.utility.error.UserException"%>
<%@page import="com.sinosoft.undwrt.ui.control.viewhelper.AgriReduceAmountViewHelper"%>
<%@page import="com.sinosoft.utility.database.DbPool"%>
<%@page import="com.sinosoft.sysframework.reference.DBManager"%>
<%@page import="com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog" %>
<%@page import="com.sinosoft.platform.dto.domain.PrpDuserDto" %>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss" %>
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLcompensate" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLlossDto"%>
<%@page import="java.io.*"%>


<%
String strClaimNo = request.getParameter("ClaimNo");
System.out.println("strClaimNo" + strClaimNo);
%>
<%@page import="com.gyic.claim.bl.facade.BLPlantingsettlelistFacade"%>
<%@page import="com.gyic.claim.dto.domain.PlantingsettlelistDto"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lowagie.text.pdf.codec.postscript.ParseException"%> 
<%@page import="com.gyic.claim.bl.facade.BLNyxpolicylistFacade;"%>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 <body onload="loadForm()" class="interface">
 <form name="fm" method="post" action="/claim/endor.do">
 <input name="EndorType" type="hidden"  >
 <input type="hidden" name = "editType" value="SAVEENDORSE">
 <input type="hidden" name = "ClaimNo" value="<%=strClaimNo%>">
 <table class=common align=center style="width:80%">
   <tr>
      <td class="formtitle">
             �� �� �� �� �� ��
     </td>
   </tr>
   <tr>
      <td class="input">
          <textarea class=inputtext wrap="hard" name="oldPtext" rows="15" cols="70"></textarea>
      </td>
   </tr>
</table>
<table class=common align=center style="width:80%">
<tr>
  <td class=button >
    <input type="button"  name="buttonSubmit" class="button"  value="����" 
		   onclick="submitForm();">
  </td>
</tr>    
</table>
</form>
</body> 


<%! public PrpLendorDto findCertainLendor(ArrayList prpLendorDtoList, PrpLlossDto prpLlossDto){
	if(null!= prpLendorDtoList && prpLendorDtoList.size()>0){
		for(int i = 0;i<prpLendorDtoList.size();i++){
			PrpLendorDto prpLendorDtoTemp = (PrpLendorDto)prpLendorDtoList.get(i);
			if(prpLendorDtoTemp.getKindCode().equals(prpLlossDto.getKindCode()) && prpLendorDtoTemp.getItemCode().equals(prpLlossDto.getItemCode()) && prpLendorDtoTemp.getItemKindNo()==prpLlossDto.getItemKindNo())
				return prpLendorDtoTemp;
		}
	}
	return null;
} %>

<%! public String endorseGenerateObjectForNyx11(HttpServletRequest httpServletRequest,
			DbPool dbPool,DbPool dbPool1,DBManager dbManager,String businessNo,String RiskCode,String PolicyNo,PrpDuserDto prpDuserDto,HttpSession session) throws Exception
	{
	    System.out.println("111");
		String conditions = " CompensateNo = '"+businessNo+"'";
		DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
		BLPrpLcompensate  bLPrpLcompensate = new BLPrpLcompensate();
		ArrayList agriLossList = (ArrayList)dbPrpLloss.findByConditions(conditions);
		System.out.println("112");
		bLPrpLcompensate.query(dbPool, conditions);
		double EndorAmount=0;
		double EndorGrossQuantity=0;
		double SettleArea=0;
		PrpLlossDto prpLlossDtoTemp = null;
		ArrayList prpLendorList = new ArrayList();
		EndorDto endorDto = new EndorDto();
        for (int index = 0; index < agriLossList.size(); index++) {
        	prpLlossDtoTemp = (PrpLlossDto)agriLossList.get(index);
        	double lossRate=prpLlossDtoTemp.getLossrate();
            if(lossRate>=100){
              SettleArea=prpLlossDtoTemp.getSettleArea();
            }else{
          	  SettleArea=0;
            }
        	EndorAmount += -prpLlossDtoTemp.getSumRealPay();
        	EndorGrossQuantity += -SettleArea;

        	PrpLendorDto prpLendorDto = new PrpLendorDto();
        	if(null != findCertainLendor(prpLendorList, prpLlossDtoTemp)){
        		prpLendorDto = findCertainLendor(prpLendorList, prpLlossDtoTemp);
        		prpLendorDto.setEndorAmount(prpLendorDto.getEndorAmount()-prpLlossDtoTemp.getSumRealPay());
	            prpLendorDto.setEndorGrossQuantity(prpLendorDto.getEndorGrossQuantity()-SettleArea);
        	}else{
	            prpLendorDto.setClaimNo(bLPrpLcompensate.getArr(0).getClaimNo());
	            prpLendorDto.setCompensateNo(businessNo);
	            prpLendorDto.setPolicyNo(prpLlossDtoTemp.getPolicyNo());
	            prpLendorDto.setItemKindNo(prpLlossDtoTemp.getItemKindNo());
	            prpLendorDto.setItemCode(prpLlossDtoTemp.getItemCode());
	            prpLendorDto.setItemName(prpLlossDtoTemp.getLossName());
	            prpLendorDto.setKindCode(prpLlossDtoTemp.getKindCode());
	            prpLendorDto.setKindName(prpLlossDtoTemp.getKindName());
	            prpLendorDto.setCurrency(prpLlossDtoTemp.getCurrency());
	            prpLendorDto.setEndorAmount(-prpLlossDtoTemp.getSumRealPay());
	
	            prpLendorDto.setInputDate(new DateTime(DateTime.current()
	                    .toString(), DateTime.YEAR_TO_DAY));
	            prpLendorDto.setFlag("1");
	            prpLendorDto.setEndorType("14");
	            prpLendorDto.setEndorGrossQuantity(-SettleArea);
	            prpLendorList.add(prpLendorDto);
        	}
        }
        
        System.out.println("size:"+prpLendorList.size());
        
        endorDto.setPrpLendorList(prpLendorList);
        
        
        String  strValidDate = new DateTime().current().addDay(1).toString();
        int i = 0;
        int icurr = 0;
        int iEndorsetimes = 0;
        String strItemKindNo = "";
        String strCurrency   = "";
        String strFlag       = "";
        double dblAmount     = 0;
        double dblGrossQuantity = 0;
        double dblSumAmount  = 0;
        double dblSumArea  = 0;
        double dblSumGrossQuantity = 0;
        String strPtext      = "";
        String strPolicyCurrency = "";
        String strEndorType     = "14";
        String strOperatorCode  = prpDuserDto.getUserCode();
        String strMakeCom       = prpDuserDto.getComCode();

        String strInputDate     = new ChgDate().getCurrentTime("yyyy/MM/dd");  
        String strInputDate1     = new ChgDate().getCurrentTime("yyyy-MM-dd");
        BLPolicy    blPolicy    = new BLPolicy();
        BLPolicy    blPolicyOld = new BLPolicy();
        BLEndorse   blEndorse   = new BLEndorse();

        PrpCitemKindSchema   prpCitemKindSchema = new PrpCitemKindSchema();
        PrpPheadSchema       prpPheadSchema     = new PrpPheadSchema();
        BLPrpCitemKindAgri blPrpCitemKindAgri=new BLPrpCitemKindAgri();
        PrpCfeeSchema   prpCfeeSchema = new PrpCfeeSchema();
        PrpCitemKindAgriSchema prpCitemKindAgriSchema=null;
        PubTools pubTools = new PubTools();

        BLNyxsettlelistFacade blNyxSettleListFacade=new BLNyxsettlelistFacade();
        String inusrelistcode = "";
        
        System.out.println("113");
    
        // ԭʼ����
        blPolicyOld.getData(PolicyNo);
        System.out.println("114");
        
        // ����������ĺ�ı�������ʼ״̬��"ԭʼ����"һ�£�����Ļ��ڸ���prplendor�е���Ϣ�޸�"����������ĺ�ı���"��
        blPolicy.getData(PolicyNo);    
        
        System.out.println("115");
        String strRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
        String conditionsOfFatchSettleMainList = " compensateNo='" + businessNo + "' and VALIDITY = '2' ";
        BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
        System.out.println("116");
        ArrayList settleMainList = (ArrayList)blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
        System.out.println("117");
        if(null!=settleMainList && settleMainList.size()>0){
          Object[] settleMainListDtoArray = settleMainList.toArray();
          SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainListDtoArray[0];
          inusrelistcode = settleMainListDto.getInusrelistcode();
          System.out.println("inusrelistcode:"+inusrelistcode);
        }
        
        
        BLNyxEndorHead blNyxEndorHead=new BLNyxEndorHead();
        NyxEndorHeadSchema nyxEndorHeadSchema =new NyxEndorHeadSchema();
        NyxPolicyListSchema nyxPolicyListSchema=new NyxPolicyListSchema();
        //���ɷֻ����ĵ�ͷ����Ϣ��
        Bill bill = new Bill();
        String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
        httpServletRequest.setAttribute("EndorseNo", strBizNo);
        nyxEndorHeadSchema.setInusreListCode(inusrelistcode);
        nyxEndorHeadSchema.setEndorseNo(strBizNo);
        nyxEndorHeadSchema.setRiskCode(strRiskCode);
        nyxEndorHeadSchema.setPolicyNo(PolicyNo);
        nyxEndorHeadSchema.setEndorFlag(strEndorType);
        blNyxEndorHead.setArr(nyxEndorHeadSchema);
        blEndorse.setBLNyxEndorHead(blNyxEndorHead);
        
        System.out.println("119");
        

        BLPrpCmainAgri blPrpCmainAgri = new BLPrpCmainAgri();
        blPrpCmainAgri.query(" policyNo = '"+PolicyNo+"'");
        if(blPrpCmainAgri.getSize()>0){
        	 System.out.println("150");
        	String strInsureListCode = ((PrpCmainAgriSchema)blPrpCmainAgri.getArr(0)).getRelationListNo();
            String conditionsOfFatchInsureMainList = " INUSRELISTCODE = '"+strInsureListCode+"' and validity = '2' ";
	        BLInsuremainlistFacade  blInsuremainlistFacade= new BLInsuremainlistFacade();
	        Collection blInsureMainListCollection = blInsuremainlistFacade.findByConditions(conditionsOfFatchInsureMainList);
	        if(null != blInsureMainListCollection && blInsureMainListCollection.size() > 0){
	        	 System.out.println("160");
	             Iterator iteratorBLInsureMainList  = blInsureMainListCollection.iterator();
	             while(iteratorBLInsureMainList.hasNext()){
	              InsuremainlistDto insureMainListDto = (InsuremainlistDto)iteratorBLInsureMainList.next();
	             
	              String conditionsOfPolicyList = " inusreListCode = '"+strInsureListCode+"' and validity = '1'"; 
	              System.out.println("conditionsOfPolicyList:"+conditionsOfPolicyList);
	              BLNyxPolicyList blNyxPolicyList = new BLNyxPolicyList();
	              
	              blNyxPolicyList.query(conditionsOfPolicyList);
	              System.out.println("SIZE6:"+ blNyxPolicyList.getSize());
	              if(null!=blNyxPolicyList && blNyxPolicyList.getSize()>0){
	            	  System.out.println("170");
		              for(int index = 0; index < blNyxPolicyList.getSize(); index++){
		            	  nyxPolicyListSchema=blNyxPolicyList.getArr(index);
		                  blPolicy.getbLNyxPolicyList().setArr(nyxPolicyListSchema);
		              }
	              }
	            }
	       }else{
	    	   throw new UserException(-3,200,"AgriReduceAmountViewHelper.java","û���ҵ�������Ӧ���嵥�������嵥��");
	       }
        }
        
        System.out.println("120");
        System.out.println("size3:"+blPolicy.getbLNyxPolicyList().getSize());
        
       if(null!=settleMainList && settleMainList.size()>0){
    	   
            int nyxPolicyListSize = blPolicy.getbLNyxPolicyList().getSize();
            System.out.println("nyxPolicyListSize:"+nyxPolicyListSize);
            SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainList.get(0);
            String settleListCode = settleMainListDto.getSettlelistcode();
            String conditionsOfFatchSettleList = " SETTLELISTCODE = '" + settleListCode +"' and nodetype='compe'";
            ArrayList planting31SettleList = (ArrayList)blNyxSettleListFacade.findByConditions(conditionsOfFatchSettleList);
            ArrayList planting31SettleList2 = planting31SettleList;
            ArrayList planting31SettleList3 = planting31SettleList;
            ArrayList planting31SettleList4 = planting31SettleList;
            ArrayList planting31SettleList5 = new ArrayList();
            Map map = new HashMap();
            Map map1 = new HashMap();
            Map map2 = new HashMap();
            if(null!=planting31SettleList2 && planting31SettleList2.size()>0){
            	 for(int j=0;j<planting31SettleList2.size();j++){
            		 NyxsettlelistDto  nyxsettlelistDto1= (NyxsettlelistDto)planting31SettleList2.get(j);
            		 String fidcard = nyxsettlelistDto1.getFidcard();
            		 if(map.get(fidcard) != null)
            		 {
            			 double settleSum =  Double.valueOf(map.get(fidcard).toString());
            			 settleSum = settleSum+nyxsettlelistDto1.getSettlesum();
            			 map.put(fidcard, settleSum); 
            		 }
            		 else
            		 {
            			 map.put(fidcard, nyxsettlelistDto1.getSettlesum()); 
            		 }
            		            		 
            	 }	
            }
            
            if(null!=planting31SettleList3 && planting31SettleList3.size()>0){
            	for(int j=0;j<planting31SettleList3.size();j++){
            		NyxsettlelistDto  nyxsettlelistDto1= (NyxsettlelistDto)planting31SettleList3.get(j);
            		String kindcode = nyxsettlelistDto1.getKindcode();
            		String fidcard = nyxsettlelistDto1.getFidcard();
            		if(!"001".equals(kindcode))
            		{
            			if(map1.get(fidcard) != null)
            			{
            				
            			}
            			else
            			{
            				map1.put(fidcard, fidcard);
            			}
            			
            		}
            			
            	}
            	for(int j=0;j<planting31SettleList4.size();j++){
            		NyxsettlelistDto  nyxsettlelistDto1= (NyxsettlelistDto)planting31SettleList4.get(j);
            		String kindcode = nyxsettlelistDto1.getKindcode();
            		String fidcard = nyxsettlelistDto1.getFidcard();
            		if("001".equals(kindcode))
            		{
            			if(map1.get(fidcard) != null)
            			{
            				
            				map1.remove(fidcard);
            			}
            			
            		}
            	}
            	
            	if(map1.size() != 0)
            	{
            		NyxsettlelistDto nyxsettlelistDto3 = null;
            		Set keys = map1.keySet();
            		Iterator ite = keys.iterator();
            		while(ite.hasNext())
            		{
            			String fidcard = ite.next().toString();
            			nyxsettlelistDto3 = new NyxsettlelistDto();
            			nyxsettlelistDto3.setFidcard(fidcard);
            			nyxsettlelistDto3.setKindcode("001");
            			nyxsettlelistDto3.setItemcode("d210");
            			planting31SettleList.add(nyxsettlelistDto3);
            		}
            		
            	}
            	
            }
             //System.err.println("policysize:"+nyxPolicyListSize);
             
            // System.err.println("settlesize:"+planting31SettleList.size());
            if(null!=planting31SettleList && planting31SettleList.size()>0){
              for(int j=0;j<planting31SettleList.size();j++){
            	  NyxsettlelistDto planting31SettleListDtoTemp = (NyxsettlelistDto)planting31SettleList.get(j);
                String fIdCard = planting31SettleListDtoTemp.getFidcard();
                String kindCode = planting31SettleListDtoTemp.getKindcode();
                String itemCode = planting31SettleListDtoTemp.getItemcode();
                for(int index = 0; index < nyxPolicyListSize; index ++){
             	   NyxPolicyListSchema planting31PolicyListSchemaTemp= blPolicy.getbLNyxPolicyList().getArr(index);
             	   if("null".equals(planting31PolicyListSchemaTemp.getFieldSource())){
             		  planting31PolicyListSchemaTemp.setFieldSource("");
             	   }
             	 
                    if(!"".equals(fIdCard)&&null!= fIdCard && fIdCard.equals(planting31PolicyListSchemaTemp.getFIdCard()) &&
                    		!"".equals(kindCode)&&null!= kindCode && kindCode.equals(planting31PolicyListSchemaTemp.getKindCode()) &&
                    		!"".equals(itemCode)&&null!= itemCode && itemCode.equals(planting31PolicyListSchemaTemp.getItemCode())){
                    	
                    	double iPlantingAmount = 0;
                    	double iPlantingArea = 0;
                    	if("001".equals(planting31PolicyListSchemaTemp.getKindCode()))
                    	{
                    		System.err.println("FIDCARD:"+planting31PolicyListSchemaTemp.getFIdCard());
                    		double totalSettleSum = Double.valueOf(map.get(planting31PolicyListSchemaTemp.getFIdCard()).toString());
                    		System.err.println("totalSettleSum:"+totalSettleSum);
                    		System.err.println("SumamoutMAIN:"+planting31PolicyListSchemaTemp.getSumAmount());
                    		iPlantingAmount = planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-totalSettleSum;
                    		System.err.println("iPlantingAmount:"+iPlantingAmount);
                    	}
                    	else
                    	{
                    		System.err.println("SettleSumSUB:"+planting31SettleListDtoTemp.getSettlesum());
                    		System.err.println("SumamoutSUB:"+planting31PolicyListSchemaTemp.getSumAmount());
                    		iPlantingAmount=planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-planting31SettleListDtoTemp.getSettlesum();
                    		
                    	}
                    
                      iPlantingArea=planting31PolicyListSchemaTemp.getAreaNumber().doubleValue()-planting31SettleListDtoTemp.getSettlearea();
                      System.err.println("iPlantingArea:"+iPlantingArea);
                      if(iPlantingAmount>=0&&iPlantingArea>=0){
                    	  System.err.println("3333");
                        if(planting31SettleListDtoTemp.getLossrate()>=100){
                        	if("001".equals(planting31PolicyListSchemaTemp.getKindCode()))
                        	{
                        		double totalSettleSum2 = Double.valueOf(map.get(planting31PolicyListSchemaTemp.getFIdCard()).toString());
                        		System.err.println("totalSettleSum2:"+totalSettleSum2);
                        		planting31PolicyListSchemaTemp.setSumAmount(new BigDecimal(planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-totalSettleSum2));
                        	}
                        	else
                        	{
                        		System.err.println("SettleSum2:"+planting31SettleListDtoTemp.getSettlesum());
                        		planting31PolicyListSchemaTemp.setSumAmount(new BigDecimal(planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-planting31SettleListDtoTemp.getSettlesum()));
                        	}
                          planting31PolicyListSchemaTemp.setAreaNumber(new BigDecimal(planting31PolicyListSchemaTemp.getAreaNumber().doubleValue()-planting31SettleListDtoTemp.getSettlearea()));
                          planting31PolicyListSchemaTemp.setFlag("U");
//                          blPolicy.getbLPlanting31PolicyList().setArr(planting31PolicyListSchemaTemp);
                        }else{
                        	if("001".equals(planting31PolicyListSchemaTemp.getKindCode()))
                        	{
                        		double totalSettleSum3 = Double.valueOf(map.get(planting31PolicyListSchemaTemp.getFIdCard()).toString());
                        		System.err.println("totalSettleSum3:"+totalSettleSum3);
                        		planting31PolicyListSchemaTemp.setSumAmount(new BigDecimal(planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-totalSettleSum3));
                        	}
                        	else
                        	{
                        		System.err.println("SettleSum3:"+planting31SettleListDtoTemp.getSettlesum());
                        		planting31PolicyListSchemaTemp.setSumAmount(new BigDecimal(planting31PolicyListSchemaTemp.getSumAmount().doubleValue()-planting31SettleListDtoTemp.getSettlesum()));
                        	}
                          
                          planting31PolicyListSchemaTemp.setFlag("U");
//                          blPolicy.getbLPlanting31PolicyList().setArr(planting31PolicyListSchemaTemp);
                        }
                      }else{
                         throw new Exception("������ͨ�������������δ�ɹ���������ܴ��ڱ�������,����������ܴ��ڳа��������");
                      }
                    }
                }
              }
              
              
              
          }
           //throw new Exception("����"); 
       }
       
       System.out.println("size4:"+blPolicy.getbLNyxPolicyList().getSize());
       
       System.out.println("122");
       
        
        // ����prpLendorList��Ϣ���prpcitemkind
       if(null!=prpLendorList && prpLendorList.size()>0){
    	   for(int indexLendor = 0; indexLendor < prpLendorList.size(); indexLendor ++){
    		PrpLendorDto prpLendorDto = (PrpLendorDto)prpLendorList.get(indexLendor);
	        strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
	        strCurrency   = prpLendorDto.getCurrency();
	        icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
	        // ����itemkindNo���������
	        if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
	           prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
	           prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
	           if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
	             throw new Exception("���ұ���Ͷ���ұ�һ��,���Ȼ���ɱ����ұ�");
	           }
	   
	           // �������
	           //dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
	           //prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
	             
	           strFlag = prpCitemKindSchema.getFlag();
	           if (strFlag.length()==0){
	             strFlag = "U";}
	           else{
	             strFlag = "U"+strFlag.substring(1,strFlag.length());
	           }
	           prpCitemKindSchema.setFlag(strFlag);
	           prpCitemKindAgriSchema.setFlag(strFlag);
	           blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
	           blPolicy.getBlPrpCitemKindAgri().setArr(blPolicy.getBlPrpCitemKindAgri().search(prpCitemKindAgriSchema.getItemKindNo(),prpCitemKindAgriSchema.getKindCode(),prpCitemKindAgriSchema.getTimes()),prpCitemKindAgriSchema);            
	        }
    	   }
       }else  throw new Exception("prpLendorList Ϊ�գ��޷����prpcitemkind");
        
        
       System.out.println("123");
         
          //�ֻ����ķ�����Ϣ����
          //���ݷֻ��ۼӼ����ܱ���
          dblSumAmount=0;
          dblSumArea=0;
          
          //��ĵı�������,���嵥�л��ܱ�ı��ѣ����
          if(null!=blPolicy.getBLPrpCitemKind() && blPolicy.getBLPrpCitemKind().getSize()>0){
        	  BLNyxPolicyList blNyxPolicyListTemp = new BLNyxPolicyList();
        	  for(int index =0; index < blPolicy.getBLPrpCitemKind().getSize(); index++){
        		  PrpCitemKindSchema prpCitemKindSchemaTemp = (PrpCitemKindSchema)blPolicy.getBLPrpCitemKind().getArr(index);
        		  String strItemCode = prpCitemKindSchemaTemp.getItemCode();
        		  String strKindCode = prpCitemKindSchemaTemp.getKindCode();
        		  double  sumAmount = 0.0;
//        		  double  sumArea = 0.0;
        		  for(int indexOfPolicyList = 0; indexOfPolicyList < blPolicy.getbLNyxPolicyList().getSize(); indexOfPolicyList ++){
        			  NyxPolicyListSchema planting31PolicyListSchemaTemp= blPolicy.getbLNyxPolicyList().getArr(indexOfPolicyList);
        			  if(strItemCode.equals(planting31PolicyListSchemaTemp.getItemCode())&& strKindCode.equals(planting31PolicyListSchemaTemp.getKindCode())){
        				  sumAmount += planting31PolicyListSchemaTemp.getSumAmount().doubleValue();
//        				  sumArea += planting31PolicyListSchemaTemp.getInsureArea().doubleValue();
        			  }
        		  }
        		  ((PrpCitemKindSchema)blPolicy.getBLPrpCitemKind().getArr(index)).setAmount(String.valueOf(sumAmount));
        		  //������������
//        		  ((PrpCitemKindSchema)blPolicy.getBLPrpCitemKind().getArr(index)).setQuantity(String.valueOf(sumArea));
//        		  if(null!=blPolicy.getBlPrpCitemKindAgri() && blPolicy.getBlPrpCitemKindAgri().getSize()>0){
//        			  String itemKindNo = prpCitemKindSchemaTemp.getItemKindNo();
//        			  for(int indexOfAgri =0; indexOfAgri < blPolicy.getBLPrpCitemKind().getSize(); indexOfAgri++){
//                		  PrpCitemKindAgriSchema prpCitemKindAgriSchemaTemp = (PrpCitemKindAgriSchema)blPolicy.getBlPrpCitemKindAgri().getArr(indexOfAgri);
//                		  String times = prpCitemKindAgriSchemaTemp.getTimes();
//                		  if(!"0".equals(times) && null!= strKindCode && strKindCode.equals(prpCitemKindAgriSchemaTemp.getKindCode()) && null!= itemKindNo && itemKindNo.equals(prpCitemKindAgriSchemaTemp.getItemKindNo())){
//                			  ((PrpCitemKindAgriSchema)blPolicy.getBlPrpCitemKindAgri().getArr(indexOfAgri)).setGrossQuantity(String.valueOf(sumArea));
//                		  }        				  
//        			  }
//        		  }
        	  }
          }
          
          System.out.println("124");
          for(int index=0;index<blPolicy.getBLPrpCitemKind().getSize();index++){
        	  if("Y".equals(blPolicy.getBLPrpCitemKind().getArr(index).getCalculateFlag()))//���ܼ��뱣����ձ��ġ�
               dblSumAmount += Double.parseDouble(blPolicy.getBLPrpCitemKind().getArr(index).getAmount());
          }
          for(int index=0;index<blPolicy.getBLPrpCitemKind().getSize();index++){
        	  if("Y".equals(blPolicy.getBLPrpCitemKind().getArr(index).getCalculateFlag())){//ȡ���뱣����ձ��������������Ϊ�������
        		  double insuredAreaTemp = Double.parseDouble(blPolicy.getBLPrpCitemKind().getArr(index).getQuantity());
        		  if(dblSumArea < insuredAreaTemp)
        			  dblSumArea = insuredAreaTemp;
        	  }
          }
          //����cmain����
          blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
        //������������
//          blPolicy.getBLPrpCmain().getArr(0).setStatQuantity(String.valueOf(dblSumArea));
           // ����phead��¼
         prpPheadSchema.setEndorseNo(strBizNo);
         prpPheadSchema.setPolicyNo(PolicyNo);
         prpPheadSchema.setMakeCom(strMakeCom);
         System.out.println("125");
         //����������ʱ�������Ѿ����ڣ�������������Ч����Ϊ������ֹ�գ���������Ϊ������ֹ��-1��
         try{
         DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
         GregorianCalendar cal=new GregorianCalendar(); 
         java.util.Date date=format.parse(blPolicy.getBLPrpCmain().getArr(0).getEndDate());
         cal.setTime(date);
         cal.add(Calendar.DAY_OF_MONTH,-1);
         date=cal.getTime();
         if(java.sql.Date.valueOf(format.format(format.parse(blPolicy.getBLPrpCmain().getArr(0).getEndDate()))).before(java.sql.Date.valueOf(format.format(format.parse(strInputDate1))))){
	         prpPheadSchema.setEndorDate(format.format(date));
	         prpPheadSchema.setValidDate(blPolicy.getBLPrpCmain().getArr(0).getEndDate());
         }else{
	         prpPheadSchema.setEndorDate(strInputDate);
	         prpPheadSchema.setValidDate(strValidDate);  
         }
         }catch(ParseException e){
           e.printStackTrace();
         }
         prpPheadSchema.setValidHour("0");
         prpPheadSchema.setOperatorCode(strOperatorCode);
         prpPheadSchema.setInputDate(strInputDate);
         prpPheadSchema.setInputHour("0");
         prpPheadSchema.setValidCountDate("9999-12-31");
         prpPheadSchema.setIsSeeFeeFlag("0");
         prpPheadSchema.setEndorType(strEndorType);
         prpPheadSchema.setCompensateNo(businessNo);
         blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
         System.out.println("126");

          //�ܱ��ѵı仯
          prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
          prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setFlag("U");
          //�洢ũ��������Ϣ�仯prpcitemkindagri
//          if(null!=blPolicy.getBlPrpCitemKindAgri() && blPolicy.getBlPrpCitemKindAgri().getSize()>0){
//        	  for(int indexItemKindAgri = 0;indexItemKindAgri < blPolicy.getBlPrpCitemKindAgri().getSize(); indexItemKindAgri ++){
//        		  if("0".equals(blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getTimes()))
//        				  blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getFlag().substring(1,blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getFlag().length()));
//        	  }
//          }
          //�洢ũ��������Ϣ�仯prpcmainagri
          //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
          //11��������������
          
           //blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
        
            System.out.println("127");
          blPolicy = blEndorse.generateSpecial(blPolicy);
          System.out.println("128");
          //��ȡԭʼ�����ֻ���Ϣ
          BLPolicy blPolicyOld1=null;
          System.out.println("SIZE2:"+blPolicy.getbLNyxPolicyList().getSize());
          System.out.println("inusrelistcode:"+inusrelistcode);
          if(blPolicy.getbLNyxPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
        	  System.out.println("129");
              blPolicyOld1 = new BLPolicy(); //ԭʼ����
              blPolicyOld1.getNyxPolicyData(PolicyNo);
          }
          
          
          System.out.println("130");
      try{
         //�������±����嵥��¼����������¼
          blEndorse.evaluateNyxFromPolicyToEndor(blPolicyOld1,blPolicy);
          System.out.println("131");
         //����cmain,pmain
         blEndorse.webAfterCal(blPolicy); 
         System.out.println("132");
         //����������Ч���ڡ���������
         //Ĭ����Ч����Ϊ����������ڵĵ�2��
       
         iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
         iEndorsetimes = iEndorsetimes + 1;
         blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
         
         // ��дprplEndor�е���������Ϣ
         
         ArrayList endorList = endorDto.getPrpLendorList();
         ArrayList endorNewList = new ArrayList();
         
         Iterator endorLists = endorList.iterator();
         while(endorLists.hasNext()){
            PrpLendorDto prpLendorDto1 = (PrpLendorDto) endorLists.next();
            prpLendorDto1.setEndorseNo(strBizNo);
            endorNewList.add(prpLendorDto1);
         }
         endorDto.setPrpLendorList(endorNewList);
       
         UIEndorAction uiEndorAction = new UIEndorAction();
	     uiEndorAction.save(endorDto);
	     System.out.println("133");
         //���ɳ����������
         blEndorse.generatePtext(blPolicy);
         System.out.println("134");
         //��ʾ����
         strPtext=blEndorse.getBLPrpPtext().getEndorseText();
         
         session.putValue("Policy",blPolicy);
         session.putValue("Endorse",blEndorse);
         session.setAttribute("endorDto",endorDto);
        
   
         //���ĸ�ֵ
	 	 //PrpPtextSchema prpPtextSchema = new PrpPtextSchema();
	 	 //prpPtextSchema.setEndorseNo(blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
	 	 //prpPtextSchema.setPolicyNo(blEndorse.getBLPrpPhead().getArr(0).getPolicyNo());
	 	 //prpPtextSchema.setLineNo("1");
	 	 //prpPtextSchema.setEndorseText(strPtext);
	 	 //prpPtextSchema.setFlag("");
	 	 //blEndorse.setBLPrpPtext(new BLPrpPtext());
	 	 //blEndorse.getBLPrpPtext().setArr(prpPtextSchema);
	 	 //blEndorse.settleBeforeSave(blPolicy);
	 	   
 	   //��������
       
       //if(blEndorse.getbLPlanting31EndorChgDetail().getSize()<=0){
       //  String strMessage = "�ֻ���Ϣû�б䶯�����ܱ��棡";
       //  throw new Exception(strMessage);
      // }
       //blEndorse.saveReduceAmount(dbPool, blPolicy);
      // blEndorse.saveNyxInsureList(dbPool1, blPolicy);
      }catch(Exception e){
    	  //System.out.println("140");
    	  //System.out.println("exception:"+e.toString());
    	  //System.out.println("exception1:"+e.getMessage());
    	  //e.printStackTrace();
    	  StringWriter sw = new StringWriter();
    	  e.printStackTrace(new PrintWriter(sw,true));
    	  String str =sw.toString();
    	  System.out.println(str);

          bill.putNo(SysConfig.getProperty("ENDORSRE_TABLE"),blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
          throw e;
      }
      
      return strPtext;
	}%>
<%
   //�������
   System.out.println("45454554");
   String strCompensateNo = request.getParameter("CompensateNo");
   String  strValidDate = new DateTime().current().addDay(1).toString();
   int i = 0;
   int icurr = 0;
   int iEndorsetimes = 0;
   String strItemKindNo = "";
   String strCurrency   = "";
   String strFlag       = "";
   double dblAmount     = 0;
   double dblGrossQuantity = 0;
   double dblSumAmount  = 0;
   double dblSumArea  = 0;
   double dblSumGrossQuantity = 0;
   String strPtext      = "";
   String strPolicyCurrency = "";
   String strEndorType     = "14";
   UserDto   userDto     = (UserDto)session.getAttribute("user");
   String strOperatorCode  = userDto.getUserCode();
   String strMakeCom       = userDto.getComCode();

   String strInputDate     = new ChgDate().getCurrentTime("yyyy/MM/dd");  
   String strInputDate1     = new ChgDate().getCurrentTime("yyyy-MM-dd");
   BLPolicy             blPolicy    = new BLPolicy();
   BLPolicy             blPolicyOld = new BLPolicy();
   BLEndorse            blEndorse   = new BLEndorse();

   PrpCitemKindSchema   prpCitemKindSchema = new PrpCitemKindSchema();
   PrpPheadSchema       prpPheadSchema     = new PrpPheadSchema();
   BLPrpCitemKindAgri blPrpCitemKindAgri=new BLPrpCitemKindAgri();
   PrpCfeeSchema   prpCfeeSchema = new PrpCfeeSchema();
   PrpCitemKindAgriSchema prpCitemKindAgriSchema=null;
   PubTools    pubTools = new PubTools();
   
   BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
   ArrayList prpLendorDtoList = new ArrayList();
   prpLendorDtoList = (ArrayList)blPrpLendorFacade.findByConditions("CompensateNo = '" + strCompensateNo + "'");

   boolean hasHeadInsureList = false;//�ж���ֳ���Ƿ���Ͷ���嵥�����嵥�����³�����ѷ��������嵥���ϳ�����ѷ�����
   String breedingFarmerListFlag = SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
   String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG");
   String riskCode = request.getParameter("RiskCode");
   //�ȶ�Ӧ�����嵥����ֳ�����жϡ�
   if((null!=breedingFarmerListFlag && !"".equals(breedingFarmerListFlag) && breedingFarmerListFlag.indexOf(riskCode)>-1)||("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3185,3166,3184,3165,3186,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){
	   System.out.println("4666");
   		String conditionsOfFatchInsureMainList = " policyNo = '"+((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo()+"' and validity = '2' ";
   		BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
   	 System.err.println(conditionsOfFatchInsureMainList);
      	Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
        System.out.println("4777");
      	if(null!=blInsureMainListCollection && blInsureMainListCollection.size()>0){
      		hasHeadInsureList = true;
      	}
   }
   System.out.println("5555");
   // ��ֳ���嵥������ѣ�ԭ�еĲ��䡣
   if(null!=breedingFarmerListFlag && !"".equals(breedingFarmerListFlag) && breedingFarmerListFlag.indexOf(riskCode)>-1 && hasHeadInsureList && !"3224".equals(riskCode) &&!("3201,3204,3238,3228,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){
   		
   		BLHerdsettlelistFacade blHerdSettleListFacade = new BLHerdsettlelistFacade();
   		BLPlantingsettlelistFacade blPlantingSettleListFacade = new BLPlantingsettlelistFacade();
   		String inusrelistcode = "";
   		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
   		// ԭʼ����
	   	blPolicyOld.getData(strPolicyNo);
	   	// ����������ĺ�ı�������ʼ״̬��"ԭʼ����"һ�£�����Ļ��ڸ���prplendor�е���Ϣ�޸�"����������ĺ�ı���"��
	   	blPolicy.getData(strPolicyNo);	   	
   		String strRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
		String conditionsOfFatchSettleMainList = " compensateNo='" + strCompensateNo + "' and VALIDITY = '2' ";
		BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
   		Collection settleMainList = blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
   		if(null!=settleMainList && settleMainList.size()>0){
   			Object[] settleMainListDtoArray = settleMainList.toArray();
   			SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainListDtoArray[0];
			inusrelistcode = settleMainListDto.getInusrelistcode();
   		}
		
	    BLHerdEndorHead blHerdEndorHead=new BLHerdEndorHead();
	    HerdEndorHeadSchema herdEndorHeadSchema =new HerdEndorHeadSchema();
	    HerdPolicyListSchema herdPolicyListSchema=new HerdPolicyListSchema();
	    //���ɷֻ����ĵ�ͷ����Ϣ��
		Bill bill = new Bill();
	   	String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
		herdEndorHeadSchema.setInusreListCode(inusrelistcode);
		herdEndorHeadSchema.setEndorseNo(strBizNo);
		herdEndorHeadSchema.setPolicyNo(strPolicyNo);
		herdEndorHeadSchema.setRiskCode(strRiskCode);
		herdEndorHeadSchema.setEndorFlag(strEndorType);
		blHerdEndorHead.setArr(herdEndorHeadSchema);
		blEndorse.setBlHerdEndorHead(blHerdEndorHead);
		
      
      	//���ݱ����Ž����еı��������嵥�ֻ�����BLPolicy��BlHerdPolicyList��
      	String conditionsOfFatchInsureMainList = " policyNo = '"+strPolicyNo+"' and validity = '2' ";
      	BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
      	Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
      	if(null != blInsureMainListCollection && blInsureMainListCollection.size() > 0){
      		Iterator iteratorBLInsureMainList  = blInsureMainListCollection.iterator();
      		while(iteratorBLInsureMainList.hasNext()){
      			InsuremainlistDto insureMainListDto = (InsuremainlistDto)iteratorBLInsureMainList.next();
      			String strInsureListCode = insureMainListDto.getInusrelistcode();
      			String conditionsOfFatchHerdPolicyList = " inusreListCode = '"+strInsureListCode+"' and validity = '1'"; 
      			BLHerdPolicyList blHerdPolicyList = new BLHerdPolicyList();
   				blHerdPolicyList.query(conditionsOfFatchHerdPolicyList);
   				if(null!=blHerdPolicyList && blHerdPolicyList.getSize()>0){
   					for(int index = 0; index < blHerdPolicyList.getSize(); index++){
   						herdPolicyListSchema=blHerdPolicyList.getArr(index);
			        	blPolicy.getBlHerdPolicyList().setArr(herdPolicyListSchema);
   					}
		        }
      		}
      	}else throw new UserException(-3,200,"AgriReduceAmount.jsp","û���ҵ�������Ӧ���嵥�������嵥��");
      	BLHerdPolicyList bLHerdPolicyList = new BLHerdPolicyList();
      	//���������嵥�еĶ������Ϣ��BLPolicy��BLHerdPolicyList���ҵ���Ӧ�ı��������嵥�ֻ����ѱ������㡣
      	if(null!=settleMainList && settleMainList.size()>0){
      		int herdPolicyListSize = blPolicy.getBlHerdPolicyList().getSize();
   			Iterator iteratorSettleMainList = settleMainList.iterator();
   			while(iteratorSettleMainList.hasNext()){
   				SettlemainlistDto settleMainListDto = (SettlemainlistDto)iteratorSettleMainList.next();
   				String settleListCode = settleMainListDto.getSettlelistcode();
   				String inusreListCodeTemp = settleMainListDto.getInusrelistcode();
   				String conditionsOfFatchHerdSettleList = " SETTLELISTCODE = '" + settleListCode +"' and insureListCode = '"+inusrelistcode+"' ";
   				Collection herdSettleList = blHerdSettleListFacade.findByConditions(conditionsOfFatchHerdSettleList);
   				if("3228".equals(riskCode))
   				{
   					
   					//conditionsOfFatchHerdSettleList = " SETTLELISTCODE = '" + settleListCode +"' and inusreListCode = '"+inusrelistcode+"' and nodetype='compe'";
   					//System.err.println(conditionsOfFatchHerdSettleList);
   					//Collection platingSettleList = blPlantingSettleListFacade.findByConditions(conditionsOfFatchHerdSettleList);
   					//System.err.println(platingSettleList.size());
	   				//if(null!=platingSettleList && platingSettleList.size()>0){
	   				//	Iterator iteratorPlantingSettleList = platingSettleList.iterator();
	   				//	while(iteratorPlantingSettleList.hasNext()){
	   				//		PlantingsettlelistDto plantingSettleListDtoTemp = (PlantingsettlelistDto)iteratorPlantingSettleList.next();
	   				//		String fidCard = plantingSettleListDtoTemp.getFidcard();
	   				//		System.err.println("11:"+herdPolicyListSize);
					//		for(int index = 0; index < herdPolicyListSize; index ++){
					//	        HerdPolicyListSchema herdPolicyListSchemaTemp = blPolicy.getBlHerdPolicyList().getArr(index);
					//	        System.err.println(herdPolicyListSchemaTemp.getFIdCard());
					//	        if(null!= fidCard && fidCard.equals(herdPolicyListSchemaTemp.getFIdCard())){
					//	        	if(null!=herdPolicyListSchemaTemp.getSumAmount() && !"".equals(herdPolicyListSchemaTemp.getSumAmount()) && 0!=Double.parseDouble(herdPolicyListSchemaTemp.getSumAmount())){
					 //       			//blPolicy.getBlHerdPolicyList().remove(index);
					 //                      if(plantingSettleListDtoTemp.getLossrate()>=100){
					 //                   	   herdPolicyListSchemaTemp.setSumAmount((new BigDecimal(herdPolicyListSchemaTemp.getSumAmount()).doubleValue()-plantingSettleListDtoTemp.getSettlesum())+"");
					 //                   	   herdPolicyListSchemaTemp.setAreaNumber((new BigDecimal(herdPolicyListSchemaTemp.getAreaNumber()).doubleValue()-plantingSettleListDtoTemp.getSettlearea())+"");
					 //                          herdPolicyListSchemaTemp.setFlag("U");
					 //                        }else{
					 //                       	 herdPolicyListSchemaTemp.setSumAmount((new BigDecimal(herdPolicyListSchemaTemp.getSumAmount()).doubleValue()-plantingSettleListDtoTemp.getSettlesum())+"");
					 //                       	 herdPolicyListSchemaTemp.setFlag("U");
					 //                        }
					//        			//bLHerdPolicyList.setArr(herdPolicyListSchemaTemp);
					 //       			break;
					//	        	}
					//	        	else throw new UserException(-98,-2,"AgriReduceAmount.jsp","���֤"+fidCard+"����Ϊ0�����ɳ����");
					//	        	
					//	        }
					//		}
	   				//	}
	   				//}
   				}
   				else
   				{
	   				if(null!=herdSettleList && herdSettleList.size()>0){
	   					Iterator iteratorHerdSettleList = herdSettleList.iterator();
	   					while(iteratorHerdSettleList.hasNext()){
	   						HerdsettlelistDto herdSettleListDtoTemp = (HerdsettlelistDto)iteratorHerdSettleList.next();
	   						String earLabel = herdSettleListDtoTemp.getEarlabel();
							for(int index = 0; index < herdPolicyListSize; index ++){
						        HerdPolicyListSchema herdPolicyListSchemaTemp = blPolicy.getBlHerdPolicyList().getArr(index);
						        if(null!= earLabel && earLabel.equals(herdPolicyListSchemaTemp.getEarLabel())){
						        	if(null!=herdPolicyListSchemaTemp.getSumAmount() && !"".equals(herdPolicyListSchemaTemp.getSumAmount()) && 0!=Double.parseDouble(herdPolicyListSchemaTemp.getSumAmount())){
					        			//blPolicy.getBlHerdPolicyList().remove(index);
					        			herdPolicyListSchemaTemp.setSumAmount("0");
					        			herdPolicyListSchemaTemp.setFlag("U");
					        			//bLHerdPolicyList.setArr(herdPolicyListSchemaTemp);
					        			break;
						        	}
						        	else throw new UserException(-98,-2,"AgriReduceAmount.jsp","�����"+earLabel+"����Ϊ0�����ɳ����");
						        	
						        }
							}
	   					}
	   				}
   			}
   			}//blPolicy.setBlHerdPolicyList(bLHerdPolicyList);
   		}
   		
	   	// �������ʱ��Ҫ������漸���ֵ���Ϣ��prpcitemkind��prpcitemkindargi��prpcmain��prpcfee
	   	
	   	 // ����prplendor��Ϣ���prpcitemkind
		   for (i=0;i<prpLendorDtoList.size();i++){
			   
		      PrpLendorDto prpLendorDto = new PrpLendorDto();
		      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
		      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
		      strCurrency   = prpLendorDto.getCurrency();
		 
		      
		      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
		      // ����itemkindNo���������
		      if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
		         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
		         prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
		         if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
		           throw new Exception("���ұ���Ͷ���ұ�һ��,���Ȼ���ɱ����ұ�");
		         }
		 
		         // �������
		         //dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
		         //prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
		         	 
		         strFlag = prpCitemKindSchema.getFlag();
		         if (strFlag.length()==0){
		        	 strFlag = "U";}
		         else{
		           strFlag = "U"+strFlag.substring(1,strFlag.length());
		         }
		         prpCitemKindSchema.setFlag(strFlag);
		         prpCitemKindAgriSchema.setFlag(strFlag);
		         blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
		         blPolicy.getBlPrpCitemKindAgri().setArr(icurr,prpCitemKindAgriSchema);		         
		      }
		   }
	      //�ֻ����ķ�����Ϣ����
	      //���ݷֻ��ۼӼ����ܱ���
	      for(int index=0;index<blPolicy.getBlHerdPolicyList().getSize();index++){
	          dblSumAmount += Double.parseDouble(blPolicy.getBlHerdPolicyList().getArr(index).getSumAmount());
	      }
	      
	      //����cmain����
	      blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
	      //��ĵı�������
	      blPolicy.getBLPrpCitemKind().getArr(0).setAmount(String.valueOf(dblSumAmount));
	       // ����phead��¼
		   prpPheadSchema.setEndorseNo(strBizNo);
		   prpPheadSchema.setPolicyNo(strPolicyNo);
		   prpPheadSchema.setMakeCom(strMakeCom);
		   prpPheadSchema.setEndorDate(strInputDate);
		   prpPheadSchema.setValidDate(strValidDate);
		   prpPheadSchema.setValidHour("0");
		   prpPheadSchema.setOperatorCode(strOperatorCode);
		   prpPheadSchema.setInputDate(strInputDate);
		   prpPheadSchema.setInputHour("0");
		   prpPheadSchema.setEndorType(strEndorType);
		   prpPheadSchema.setValidCountDate("9999-12-31");
		   prpPheadSchema.setCompensateNo(strCompensateNo);
		   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);

	      //�ܱ��ѵı仯
	      prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
	      prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
	      prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
	      prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
		  prpCfeeSchema.setFlag("U");
	      //�洢ũ��������Ϣ�仯prpcitemkindagri
	      //blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
	      //�洢ũ��������Ϣ�仯prpcmainagri
	      //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
		    //11��������������
		    //xiaojian_leave����֮ǰ��Ҫ�����Fee�������
		    
		    blPolicy = blEndorse.generateSpecial(blPolicy);
		    //��ȡԭʼ�����ֻ���Ϣ
		    BLPolicy blPolicyOld1=null;
		    if(blPolicy.getBlHerdPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
		        blPolicyOld1 = new BLPolicy(); //ԭʼ����
		        String conditions1=" inusrelistcode='"+inusrelistcode+"' ";
		        blPolicyOld1.getInsureListData(conditions1);
		    }
		    
		try{
		   //�������±����嵥��¼����������¼
		    blEndorse.evaluateInsureListFromPolicyToEndor(blPolicyOld1,blPolicy);
		    //���μ��㸳ֵ
    	    blPolicy.getBlHerdPolicyList().cancelCP(inusrelistcode);
		   //����cmain,pmain
		   blEndorse.webAfterCal(blPolicy); 
		   //����������Ч���ڡ���������
		   //Ĭ����Ч����Ϊ����������ڵĵ�2��
		   prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
		   prpPheadSchema.setCompensateNo(strCompensateNo);
		   blEndorse.getBLPrpPhead().initArr();
		   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
		   iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
		   iEndorsetimes = iEndorsetimes + 1;
		   blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
		   
		   // ��дprplEndor�е���������Ϣ
		   EndorDto endorDto =(EndorDto)request.getAttribute("endorDto");
		   ArrayList endorList = endorDto.getPrpLendorList();
		   ArrayList endorNewList = new ArrayList();
		   Iterator endorLists = endorList.iterator();
		   while(endorLists.hasNext()){
		      PrpLendorDto prpLendorDto = (PrpLendorDto) endorLists.next();
		      prpLendorDto.setEndorseNo(strBizNo);
		      endorNewList.add(prpLendorDto);
		   }
		   endorDto.setPrpLendorList(endorNewList);
		   UIEndorAction uiEndorAction = new UIEndorAction();
		   uiEndorAction.save(endorDto);
		   //���ɳ����������
		   blEndorse.generatePtext(blPolicy);
		   //��ʾ����
		   strPtext=blEndorse.getBLPrpPtext().getEndorseText();
		   session.putValue("Policy",blPolicy);
		   session.putValue("Endorse",blEndorse);
		   session.setAttribute("endorDto",endorDto);
	   	}catch(Exception e){
		   e.printStackTrace();
		   throw e;
		 }
   }else if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3176,3179".indexOf(riskCode) > -1)&&hasHeadInsureList){
       BLPlantingsettlelistFacade blPlantingsettlelistFacade=new BLPlantingsettlelistFacade();
       String inusrelistcode = "";
       String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
       // ԭʼ����
       blPolicyOld.getData(strPolicyNo);
       // ����������ĺ�ı�������ʼ״̬��"ԭʼ����"һ�£�����Ļ��ڸ���prplendor�е���Ϣ�޸�"����������ĺ�ı���"��
       blPolicy.getData(strPolicyNo);      
       String strRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
       String conditionsOfFatchSettleMainList = " compensateNo='" + strCompensateNo + "' and VALIDITY = '2' ";
       BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
       ArrayList settleMainList = (ArrayList)blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
  		System.err.println("settleMainList "+settleMainList);
   		System.err.println("settleMainLists "+settleMainList.size());
       if(null!=settleMainList && settleMainList.size()>0){
         Object[] settleMainListDtoArray = settleMainList.toArray();
         SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainListDtoArray[0];
         inusrelistcode = settleMainListDto.getInusrelistcode();
       }
       BLPlantingEndorHead blPlantingEndorHead=new BLPlantingEndorHead();
       PlantingEndorHeadSchema plantingEndorHeadSchema =new PlantingEndorHeadSchema();
       PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
       //���ɷֻ����ĵ�ͷ����Ϣ��
       Bill bill = new Bill();
       String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
       plantingEndorHeadSchema.setInusreListCode(inusrelistcode);
       plantingEndorHeadSchema.setEndorseNo(strBizNo);
       plantingEndorHeadSchema.setRiskCode(strRiskCode);
       plantingEndorHeadSchema.setPolicyNo(strPolicyNo);
       plantingEndorHeadSchema.setEndorFlag(strEndorType);
       blPlantingEndorHead.setArr(plantingEndorHeadSchema);
       blEndorse.setBLPlantingEndorHead(blPlantingEndorHead);
       //���ݱ����Ž����еı��������嵥�ֻ�����BLPolicy��BlHerdPolicyList��
       String conditionsOfFatchInsureMainList = " policyNo = '"+strPolicyNo+"' and validity = '2' ";
       BLInsuremainlistFacade  blInsuremainlistFacade= new BLInsuremainlistFacade();
       Collection blInsureMainListCollection = blInsuremainlistFacade.findByConditions(conditionsOfFatchInsureMainList);
         if(null != blInsureMainListCollection && blInsureMainListCollection.size() > 0){
            Iterator iteratorBLInsureMainList  = blInsureMainListCollection.iterator();
            while(iteratorBLInsureMainList.hasNext()){
             InsuremainlistDto insureMainListDto = (InsuremainlistDto)iteratorBLInsureMainList.next();
             String strInsureListCode = insureMainListDto.getInusrelistcode();
             String conditionsOfFatchHerdPolicyList = " inusreListCode = '"+strInsureListCode+"' and validity = '1'"; 
             BLPlantingPolicyList blPlantingPolicyList = new BLPlantingPolicyList();
             blPlantingPolicyList.query(conditionsOfFatchHerdPolicyList);
             if(null!=blPlantingPolicyList && blPlantingPolicyList.getSize()>0){
             for(int index = 0; index < blPlantingPolicyList.getSize(); index++){
               plantingPolicyListSchema=blPlantingPolicyList.getArr(index);
                 blPolicy.getBLPlantingPolicyList().setArr(plantingPolicyListSchema);
             }
             }
           }
         }else throw new UserException(-3,200,"AgriReduceAmount.jsp","û���ҵ�������Ӧ���嵥�������嵥��");
         if(null!=settleMainList && settleMainList.size()>0){
           int PlantingPolicyListSize = blPolicy.getBLPlantingPolicyList().getSize();
           int iteratorSettleMainList = settleMainList.size();
           SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainList.get(0);
           String settleListCode = settleMainListDto.getSettlelistcode();
           String conditionsOfFatchHerdSettleList = " SETTLELISTCODE = '" + settleListCode +"' and nodetype='compe'";
           ArrayList plantingSettleList = (ArrayList)blPlantingsettlelistFacade.findByConditions(conditionsOfFatchHerdSettleList);
           if(null!=plantingSettleList && plantingSettleList.size()>0){
             for(int j=0;j<plantingSettleList.size();j++){
               PlantingsettlelistDto plantingSettleListDtoTemp = (PlantingsettlelistDto)plantingSettleList.get(j);
               String Fcode = plantingSettleListDtoTemp.getFcode();
               for(int index = 0; index < PlantingPolicyListSize; index ++){
            	   PlantingPolicyListSchema plantingPolicyListSchemaTemp= blPolicy.getBLPlantingPolicyList().getArr(index);
            	   if("null".equals(plantingPolicyListSchemaTemp.getFieldSource())){
            		   plantingPolicyListSchemaTemp.setFieldSource("");
            	   }          
                   if(!"".equals(Fcode)&&null!= Fcode && Fcode.equals(plantingPolicyListSchemaTemp.getFCode())){
                     double iPlantingAmount=plantingPolicyListSchemaTemp.getSumAmount().doubleValue()-plantingSettleListDtoTemp.getSettlesum();
                     double iPlantingArea=plantingPolicyListSchemaTemp.getInsureArea().doubleValue()-plantingSettleListDtoTemp.getSettlearea();
                     if(iPlantingAmount>=0&&iPlantingArea>=0){
                       // 3177��������ֻ�������
                       if(riskCode.equals("3177")) {
                    	   plantingPolicyListSchemaTemp.setSumAmount(new BigDecimal(plantingPolicyListSchemaTemp.getSumAmount().doubleValue()-plantingSettleListDtoTemp.getSettlesum()));
                    	   plantingPolicyListSchemaTemp.setFlag("U");
                       } else {
                    	   if(plantingSettleListDtoTemp.getLossrate()>=80){
                               plantingPolicyListSchemaTemp.setSumAmount(new BigDecimal(plantingPolicyListSchemaTemp.getSumAmount().doubleValue()-plantingSettleListDtoTemp.getSettlesum()));
                               plantingPolicyListSchemaTemp.setInsureArea(new BigDecimal(plantingPolicyListSchemaTemp.getInsureArea().doubleValue()-plantingSettleListDtoTemp.getSettlearea()));
                               plantingPolicyListSchemaTemp.setFlag("U");
                             }else{
                               plantingPolicyListSchemaTemp.setSumAmount(new BigDecimal(plantingPolicyListSchemaTemp.getSumAmount().doubleValue()-plantingSettleListDtoTemp.getSettlesum()));
                               plantingPolicyListSchemaTemp.setFlag("U");
                             }
                       }
                     }else{
                        throw new Exception("������ܴ��ڱ�������,����������ܴ��ڳа������");
                     }
                   }
               }
             }
         }//blPolicy.setBlHerdPolicyList(bLHerdPolicyList);
       }
       // �������ʱ��Ҫ������漸���ֵ���Ϣ��prpcitemkind��prpcitemkindargi��prpcmain��prpcfee
       
        // ����prplendor��Ϣ���prpcitemkind
        for (i=0;i<prpLendorDtoList.size();i++){
          
           PrpLendorDto prpLendorDto = new PrpLendorDto();
           prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
           strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
           strCurrency   = prpLendorDto.getCurrency();
      
           
           icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
           // ����itemkindNo���������
           if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
              prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
              prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
              if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
                throw new Exception("���ұ���Ͷ���ұ�һ��,���Ȼ���ɱ����ұ�");
              }
      
              // �������
              //dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
              //prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
                
              strFlag = prpCitemKindSchema.getFlag();
              if (strFlag.length()==0){
                strFlag = "U";}
              else{
                strFlag = "U"+strFlag.substring(1,strFlag.length());
              }
              prpCitemKindSchema.setFlag(strFlag);
              prpCitemKindAgriSchema.setFlag(strFlag);
              blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
              blPolicy.getBlPrpCitemKindAgri().setArr(icurr,prpCitemKindAgriSchema);            
           }
        }
         //�ֻ����ķ�����Ϣ����
         //���ݷֻ��ۼӼ����ܱ���
         dblSumAmount=0;
         dblSumArea=0;
         for(int index=0;index<blPolicy.getBLPlantingPolicyList().getSize();index++){
              dblSumAmount += blPolicy.getBLPlantingPolicyList().getArr(index).getSumAmount().doubleValue();
         }
         for(int index=0;index<blPolicy.getBLPlantingPolicyList().getSize();index++){
             dblSumArea += blPolicy.getBLPlantingPolicyList().getArr(index).getInsureArea().doubleValue();
         }
         //����cmain����
         blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
         //��ĵı�������
         blPolicy.getBLPrpCitemKind().getArr(0).setAmount(String.valueOf(dblSumAmount));
         //blPolicy.getBLPrpCitemKind().getArr(0).setQuantity(String.valueOf(dblSumArea));
         //blPolicy.getBlPrpCitemKindAgri().getArr(0).setGrossQuantity(String.valueOf(dblSumArea));
          // ����phead��¼
        prpPheadSchema.setEndorseNo(strBizNo);
        prpPheadSchema.setPolicyNo(strPolicyNo);
        prpPheadSchema.setMakeCom(strMakeCom);
        
        //�������������ֹ�������������ʱ�������Ѿ����ڣ�������������Ч����Ϊ������ֹ�գ���������Ϊ������ֹ��-1��
        try{
        
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal=new GregorianCalendar(); 
        java.util.Date date=format.parse(blPolicy.getBLPrpCmain().getArr(0).getEndDate());
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,-1);
        date=cal.getTime();
        if(java.sql.Date.valueOf(format.format(format.parse(blPolicy.getBLPrpCmain().getArr(0).getEndDate()))).before(java.sql.Date.valueOf(format.format(format.parse(strInputDate1))))){
        prpPheadSchema.setEndorDate(format.format(date));
        prpPheadSchema.setValidDate(blPolicy.getBLPrpCmain().getArr(0).getEndDate());
        }else{
        prpPheadSchema.setEndorDate(strInputDate);
        prpPheadSchema.setValidDate(strValidDate);  
        }
        }catch(ParseException e){
          e.printStackTrace();
        }
        prpPheadSchema.setValidHour("0");
        prpPheadSchema.setOperatorCode(strOperatorCode);
        prpPheadSchema.setInputDate(strInputDate);
        prpPheadSchema.setInputHour("0");
        prpPheadSchema.setValidCountDate("9999-12-31");
        prpPheadSchema.setEndorType(strEndorType);
        prpPheadSchema.setCompensateNo(strCompensateNo);
        blEndorse.getBLPrpPhead().setArr(prpPheadSchema);

         //�ܱ��ѵı仯
         prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
         prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setFlag("U");
         //�洢ũ��������Ϣ�仯prpcitemkindagri
         blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
         //�洢ũ��������Ϣ�仯prpcmainagri
         //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
         //11��������������
         //xiaojian_leave����֮ǰ��Ҫ�����Fee�������
         
         blPolicy = blEndorse.generateSpecial(blPolicy);
         //��ȡԭʼ�����ֻ���Ϣ
         BLPolicy blPolicyOld1=null;
         System.err.println("111="+blPolicy.getBLPlantingPolicyList().getSize());
         System.err.println("inusrelistcode="+inusrelistcode);
         if(blPolicy.getBLPlantingPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
             blPolicyOld1 = new BLPolicy(); //ԭʼ����
             String conditions1=" inusrelistcode='"+inusrelistcode+"' ";
             blPolicyOld1.getPlantingPolicyData(strPolicyNo);
             System.err.println(strPolicyNo);
         }
         
     try{
        //�������±����嵥��¼����������¼
         blEndorse.evaluatePlantFromPolicyToEndor(blPolicyOld1,blPolicy);
        //����cmain,pmain
        blEndorse.webAfterCal(blPolicy); 
        //����������Ч���ڡ���������
        //Ĭ����Ч����Ϊ����������ڵĵ�2��
        prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
        prpPheadSchema.setCompensateNo(strCompensateNo);
        blEndorse.getBLPrpPhead().initArr();
        blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
        iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
        iEndorsetimes = iEndorsetimes + 1;
        blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
        
        // ��дprplEndor�е���������Ϣ
        EndorDto endorDto =(EndorDto)request.getAttribute("endorDto");
        ArrayList endorList = endorDto.getPrpLendorList();
        ArrayList endorNewList = new ArrayList();
        Iterator endorLists = endorList.iterator();
        while(endorLists.hasNext()){
           PrpLendorDto prpLendorDto = (PrpLendorDto) endorLists.next();
           prpLendorDto.setEndorseNo(strBizNo);
           endorNewList.add(prpLendorDto);
        }
        endorDto.setPrpLendorList(endorNewList);
        UIEndorAction uiEndorAction = new UIEndorAction();
        uiEndorAction.save(endorDto);
        //���ɳ����������
        blEndorse.generatePtext(blPolicy);
        //��ʾ����
        strPtext=blEndorse.getBLPrpPtext().getEndorseText();
        session.putValue("Policy",blPolicy);
        session.putValue("Endorse",blEndorse);
        session.setAttribute("endorDto",endorDto);
       }catch(Exception e){
        e.printStackTrace();
        throw e;
      } 
  }else if(null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode)>-1){
  //�ط�������ũ�ձ����Զ�������� START
  			PrpDuserDto prpDuserDto = new PrpDuserDto();
  			prpDuserDto.setUserCode(strOperatorCode);
  			prpDuserDto.setComCode(strMakeCom);
       		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
          	DbPool dbPool = new DbPool();
           	DbPool dbPool1 = new DbPool();
           	dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
           	dbPool1.open("NXDADataSource");
           	String strBizNo= "";
       	    DBManager dbManager = dbPool.getDBManager(SysConfig.getProperty("DDCCDATASOURCE"));
       	    DBWfLog dbWfLog = new DBWfLog(dbManager);
			AgriReduceAmountViewHelper AgriReduceAmountViewHelper = new AgriReduceAmountViewHelper();				
          	try {
				dbPool.beginTransaction();
				AgriReduceAmountViewHelper.deleteEndorsePlanting(request, dbPool,dbPool1,dbManager, dbWfLog, strCompensateNo);
				//��������������
				strBizNo=AgriReduceAmountViewHelper.endorseGenerateObjectForPlanting(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto);	
				dbPool1.commitTransaction();
				dbPool.commitTransaction();
			} catch (Exception e) {
				dbPool.rollbackTransaction();
				dbPool1.rollbackTransaction();
				AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
				e.printStackTrace();
				throw new Exception("�ط�������ũ�ճ������ʧ�ܡ�����");
			}finally{
			    dbPool.close();
			    dbPool1.close();
			}
			//try{
			//	if(!"".equals(strBizNo)&&null!=strBizNo){
			//	AgriReduceAmountViewHelper.start(strBizNo);
			//	AgriReduceAmountViewHelper.submitTaskPlanting(strBizNo,strCompensateNo);
			//	}else{
			//		throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");	
			//	}
			//}catch(Exception e){
			//	    e.printStackTrace();
			//	    throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");
			//}
          //�ط�������ũ�ձ��պ���ͨ���Զ�������� END
          //yx
    }else if("3224".equals(riskCode)){
    //}else if("3224,3201,3204,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3132,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196".indexOf(riskCode) > -1){
	  //�ط�������ũ�ձ����Զ�������� START
		PrpDuserDto prpDuserDto = new PrpDuserDto();
		prpDuserDto.setUserCode(strOperatorCode);
		prpDuserDto.setComCode(strMakeCom);
 		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
    	DbPool dbPool = new DbPool();
     	DbPool dbPool1 = new DbPool();
     	dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
     	dbPool1.open("NXDADataSource");
     	String strBizNo= "";
 	    DBManager dbManager = dbPool.getDBManager(SysConfig.getProperty("DDCCDATASOURCE"));
 	    DBWfLog dbWfLog = new DBWfLog(dbManager);
		AgriReduceAmountViewHelper AgriReduceAmountViewHelper = new AgriReduceAmountViewHelper();				
    	try {
    		
    		
			dbPool.beginTransaction();
			//System.out.println("999999");
			AgriReduceAmountViewHelper.deleteEndorseNyx(request, dbPool,dbPool1,dbManager, dbWfLog, strCompensateNo);
			//System.out.println("777777");
			//��������������
			strPtext = endorseGenerateObjectForNyx11(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
			System.out.println("888888");
			dbPool1.commitTransaction();
			dbPool.commitTransaction();
		} catch (Exception e) {
			dbPool.rollbackTransaction();
			dbPool1.rollbackTransaction();
			AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
			e.printStackTrace();
			throw new Exception("�ط�������ũ�ճ������ʧ�ܡ�����");
		}finally{
		    dbPool.close();
		    dbPool1.close();
		}
		//try{
		//	if(!"".equals(strBizNo)&&null!=strBizNo){
		//	AgriReduceAmountViewHelper.start(strBizNo);
		//	AgriReduceAmountViewHelper.submitTaskPlanting(strBizNo,strCompensateNo);
		//	}else{
		//		throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");	
		//	}
		//}catch(Exception e){
		//	    e.printStackTrace();
		//	    throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");
		//}
    //�ط�������ũ�ձ��պ���ͨ���Զ�������� END
    //yx
	}else if("3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1 && hasHeadInsureList){
		  //�ط�������ũ�ձ����Զ�������� START
			PrpDuserDto prpDuserDto = new PrpDuserDto();
			prpDuserDto.setUserCode(strOperatorCode);
			prpDuserDto.setComCode(strMakeCom);
	 		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
	    	DbPool dbPool = new DbPool();
	     	DbPool dbPool1 = new DbPool();
	     	dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
	     	dbPool1.open("NXDADataSource");
	     	String strBizNo= "";
	 	    DBManager dbManager = dbPool.getDBManager(SysConfig.getProperty("DDCCDATASOURCE"));
	 	    DBWfLog dbWfLog = new DBWfLog(dbManager);
			AgriReduceAmountViewHelper AgriReduceAmountViewHelper = new AgriReduceAmountViewHelper();				
	    	try {
	    		
	    		
				dbPool.beginTransaction();
				//System.out.println("999999");
				AgriReduceAmountViewHelper.deleteEndorseNyx(request, dbPool,dbPool1,dbManager, dbWfLog, strCompensateNo);
				//System.out.println("777777");
				//��������������
				strPtext = endorseGenerateObjectForNyx11(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
				System.out.println("888888");
				dbPool1.commitTransaction();
				dbPool.commitTransaction();
			} catch (Exception e) {
				dbPool.rollbackTransaction();
				dbPool1.rollbackTransaction();
				AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
				e.printStackTrace();
				throw new Exception("�ط�������ũ�ճ������ʧ�ܡ�����");
			}finally{
			    dbPool.close();
			    dbPool1.close();
			}

}else if("0311".equals(riskCode)){
	  //�ط�������ũ�ձ����Զ�������� START
	  System.err.println("����0311");
	PrpDuserDto prpDuserDto = new PrpDuserDto();
	prpDuserDto.setUserCode(strOperatorCode);
	prpDuserDto.setComCode(strMakeCom);
		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
	DbPool dbPool = new DbPool();
 	DbPool dbPool1 = new DbPool();
 	dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
 	dbPool1.open("NXDADataSource");
 	String strBizNo= "";
	    DBManager dbManager = dbPool.getDBManager(SysConfig.getProperty("DDCCDATASOURCE"));
	    DBWfLog dbWfLog = new DBWfLog(dbManager);
	AgriReduceAmountViewHelper AgriReduceAmountViewHelper = new AgriReduceAmountViewHelper();				
	try {
		
		
		dbPool.beginTransaction();
		//System.out.println("999999");
		AgriReduceAmountViewHelper.deleteEndorsePlanting(request, dbPool,dbPool1,dbManager, dbWfLog, strCompensateNo);
		//System.out.println("777777");
		//��������������
		strPtext = AgriReduceAmountViewHelper.endorseGenerateObjectForTemblor(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto);	
		System.out.println("888888");
		dbPool1.commitTransaction();
		dbPool.commitTransaction();
	} catch (Exception e) {
		dbPool.rollbackTransaction();
		dbPool1.rollbackTransaction();
		AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
		e.printStackTrace();
		throw new Exception("0311����                             �������ʧ�ܡ�����");
	}finally{
	    dbManager.close();
	    dbPool.close();
	    dbPool1.close();
	}
	//try{
	//	if(!"".equals(strBizNo)&&null!=strBizNo){
	//	AgriReduceAmountViewHelper.start(strBizNo);
	//	AgriReduceAmountViewHelper.submitTaskPlanting(strBizNo,strCompensateNo);
	//	}else{
	//		throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");	
	//	}
	//}catch(Exception e){
	//	    e.printStackTrace();
	//	    throw new Exception("�ط�������ũ�ճ������ɹ�������ͨ��ʧ�ܡ�����");
	//}
//�ط�������ũ�ձ��պ���ͨ���Զ�������� END
}else{
   // ԭʼ����
   blPolicyOld.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   // ����������ĺ�ı�������ʼ״̬��"ԭʼ����"һ�£�����Ļ��ڸ���prplendor�е���Ϣ�޸�"����������ĺ�ı���"��
   // �������ʱ��Ҫ������漸���ֵ���Ϣ��prpcitemkind��prpcitemkindargi��prpcmain��prpcfee
   blPolicy.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   
   //ȡ����ֻ��ı����Ϣ,��Դ��prpcvirturlitem    add by ��Ԫ��Ŀ�� Τ���� start
   String strPolicyNo= ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
   String strWherePart = "PolicyNo = '"+strPolicyNo+"'";
   BLPrpCvirturlItem  blPrpCvirturlItem = new BLPrpCvirturlItem();
   blPrpCvirturlItem.query(strWherePart);
   //ȡ����ֻ��ı����Ϣ,��Դ��prpcvirturlitem    add by ��Ԫ��Ŀ�� Τ���� end
   
   strPolicyCurrency = blPolicy.getBLPrpCmain().getArr(0).getCurrency();
   dblSumAmount = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getSumAmount());
   dblSumGrossQuantity = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getStatQuantity());
   String StrRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
   GroupProposalService groupProposalService = new GroupProposalService();
   //ȡ�Ƿ����ŵ��ı�־  ��Ԫ��Ŀ�� Τ����
   boolean isVirturlItemRisk = groupProposalService.isGroupProposal(StrRiskCode);
   // ����prplendor��Ϣ���prpcitemkind
   for (i=0;i<prpLendorDtoList.size();i++){
	   
      PrpLendorDto prpLendorDto = new PrpLendorDto();
      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
      strCurrency   = prpLendorDto.getCurrency();
 
      PrpCvirturlItemSchema prpCvirturlItemSchema = null;
      PrpCitemKindSchema prpCitemKindSchematemp = null; 
      
      if(isVirturlItemRisk){
    	    //����prpLendor��itemkindno��prpcvirturlitem������Ӧ�ı���
          for (int k =0 ;k<blPrpCvirturlItem.getSize();k++){
              prpCvirturlItemSchema = blPrpCvirturlItem.getArr(k);
              if(strItemKindNo.equals(prpCvirturlItemSchema.getItemKindNo())){
            	  //����ֻ�����ı���
            	  prpCvirturlItemSchema.setAmount(String.valueOf(Double
            	                          .parseDouble(ChgData.chgStrZero(prpCvirturlItemSchema.getAmount()))
            	                          + prpLendorDto .getEndorAmount()));
            	 //����ֻ����������
                  prpCvirturlItemSchema.setQuantity(String.valueOf(Double
                                          .parseDouble(ChgData.chgStrZero(prpCvirturlItemSchema.getQuantity()))
                                          + prpLendorDto.getEndorGrossQuantity()));
               //���Ƿ��������־λ��ֵ   
            	 prpCvirturlItemSchema.setAmountFlag("1");
                break;
              }
          }
          String strKindCode = prpLendorDto.getKindCode();
          String strItemCode = prpLendorDto.getItemCode();
          //����kindcode,itemcodeȥprpcitemkindȷ��Ψһ��itemkindno 
          for (int j=0 ;j<blPolicy.getBLPrpCitemKind().getSize();j++){
              prpCitemKindSchematemp=blPolicy.getBLPrpCitemKind().getArr(j);
              if(strKindCode.equals(prpCitemKindSchematemp.getKindCode())
                  &&strItemCode.equals(prpCitemKindSchematemp.getItemCode())){
            	  //��itemkinNo��ֵ
                strItemKindNo = prpCitemKindSchematemp.getItemKindNo();
                break;
              }
          }
      }
      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
      // ����itemkindNo���������
      if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
         prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
         if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
           throw new Exception("���ұ���Ͷ���ұ�һ��,���Ȼ���ɱ����ұ�");
         }
 
         // �������
         dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
         prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
         //�ŵ��ͻ��ߵ�·�͸�����ͬ
         if(isVirturlItemRisk){
             // ���prpcitemkind�� prpCitemKindAgri������
             
             dblGrossQuantity = Double.parseDouble(prpCitemKindSchema.getQuantity())+prpLendorDto.getEndorGrossQuantity();
             prpCitemKindAgriSchema.setGrossQuantity(String.valueOf(dblGrossQuantity));
             prpCitemKindSchema.setQuantity(String.valueOf(dblGrossQuantity));
         }else{
             // �������
             dblGrossQuantity = Double.parseDouble(prpCitemKindAgriSchema.getGrossQuantity())+prpLendorDto.getEndorGrossQuantity();
             prpCitemKindAgriSchema.setGrossQuantity(String.valueOf(dblGrossQuantity));
             prpCitemKindSchema.setQuantity(String.valueOf(dblGrossQuantity));
         }
 
         strFlag = prpCitemKindSchema.getFlag();
         if (strFlag.length()==0){
        	 strFlag = "U";}
         else{
           strFlag = "U"+strFlag.substring(1,strFlag.length());
         }
         prpCitemKindSchema.setFlag(strFlag);
         prpCitemKindAgriSchema.setFlag(strFlag);
         blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
         blPolicy.getBlPrpCitemKindAgri().setArr(icurr,prpCitemKindAgriSchema);
         
         // ��������ܱ���
         if("Y".equals(prpCitemKindSchema.getCalculateFlag())){
           dblSumAmount = dblSumAmount + prpLendorDto.getEndorAmount();  
         }
         dblSumGrossQuantity = dblSumGrossQuantity + prpLendorDto.getEndorGrossQuantity();
      }
   }
   
   // ����cmain�ı���
   blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
   blPolicy.getBLPrpCmain().getArr(0).setStatQuantity(String.valueOf(dblSumGrossQuantity));

   // �ɷѼƻ���Ϣ
   prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
   prpCfeeSchema.setAmount(String.valueOf(dblSumAmount));
   prpCfeeSchema.setAmount1(String.valueOf(dblSumAmount));
   prpCfeeSchema.setAmount2(String.valueOf(dblSumAmount));
   prpCfeeSchema.setFlag("U");
   
   // ����phead��¼
   Bill bill = new Bill();
   String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
   prpPheadSchema.setEndorseNo(strBizNo);
   prpPheadSchema.setMakeCom(strMakeCom);
   prpPheadSchema.setEndorDate(strInputDate);
   prpPheadSchema.setValidDate(strValidDate);
   prpPheadSchema.setValidHour("0");
   prpPheadSchema.setOperatorCode(strOperatorCode);
   prpPheadSchema.setInputDate(strInputDate);
   prpPheadSchema.setInputHour("0");
   prpPheadSchema.setValidCountDate("9999-12-31");
   prpPheadSchema.setEndorType(strEndorType);
   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
   
   try{
	   //�������±�����¼����������¼
	   blEndorse.evaluateFromPolicyToEndor(blPolicyOld,blPolicy);
	   //����cmain,pmain
	   blEndorse.webAfterCal(blPolicy); 
	   //����������Ч���ڡ���������
	   //Ĭ����Ч����Ϊ����������ڵĵ�2��
	   prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
	   prpPheadSchema.setCompensateNo(strCompensateNo);
	   blEndorse.getBLPrpPhead().initArr();
	   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
	   iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
	   iEndorsetimes = iEndorsetimes + 1;
	   blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
	   
	   // ��дprplEndor�е���������Ϣ
	   EndorDto endorDto =(EndorDto)request.getAttribute("endorDto");
	   ArrayList endorList = endorDto.getPrpLendorList();
	   ArrayList endorNewList = new ArrayList();
	   Iterator endorLists = endorList.iterator();
	   while(endorLists.hasNext()){
	      PrpLendorDto prpLendorDto = (PrpLendorDto) endorLists.next();
	      prpLendorDto.setEndorseNo(strBizNo);
	      endorNewList.add(prpLendorDto);
	   }
	   endorDto.setPrpLendorList(endorNewList);
	   UIEndorAction uiEndorAction = new UIEndorAction();
	   uiEndorAction.save(endorDto);
	   //���ɳ����������
	   blEndorse.generatePtext(blPolicy);
	   //��ʾ����
	   strPtext=blEndorse.getBLPrpPtext().getEndorseText();
	   session.putValue("Policy",blPolicy);
	   session.putValue("Endorse",blEndorse);
	   session.setAttribute("endorDto",endorDto);
	   //��������ķֻ�Ҫ���µĶ���
	   session.setAttribute("blPrpCvirturlItem",blPrpCvirturlItem);
   }catch(Exception e){
	   e.printStackTrace();
	   throw e;
	 }
	 }
%>

<script language=javascript>
  //װ�ش���
  function loadForm()
  {
    fm.oldPtext.value = '<%=Str.encode(strPtext)%>';
    fm.EndorType.value = '<%=strEndorType%>';        
  }
    function submitForm()
  {
    fm.buttonSubmit.disabled=true;  
    fm.submit();  
    
  }
</script>
