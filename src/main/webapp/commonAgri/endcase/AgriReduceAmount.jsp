<%--
****************************************************************************
* DESC       ：农险理赔冲减保额的处理
* Author     : 安信项目组
* CREATEDATE ：2006-11-24
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- 引入bean类部分 --%>
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
             冲 减 保 额 批 文
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
    <input type="button"  name="buttonSubmit" class="button"  value="保存" 
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
    
        // 原始保单
        blPolicyOld.getData(PolicyNo);
        System.out.println("114");
        
        // 冲减保额批改后的保单（初始状态跟"原始保单"一致，下面的环节根据prplendor中的信息修改"冲减保额批改后的保单"）
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
        //生成分户批改的头表信息。
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
	    	   throw new UserException(-3,200,"AgriReduceAmountViewHelper.java","没有找到保单对应的清单，请检查清单！");
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
                         throw new Exception("核赔已通过，但冲减保额未成功（理赔金额不能大于保单保额,理赔面积不能大于承包面积！）");
                      }
                    }
                }
              }
              
              
              
          }
           //throw new Exception("调试"); 
       }
       
       System.out.println("size4:"+blPolicy.getbLNyxPolicyList().getSize());
       
       System.out.println("122");
       
        
        // 根据prpLendorList信息冲减prpcitemkind
       if(null!=prpLendorList && prpLendorList.size()>0){
    	   for(int indexLendor = 0; indexLendor < prpLendorList.size(); indexLendor ++){
    		PrpLendorDto prpLendorDto = (PrpLendorDto)prpLendorList.get(indexLendor);
	        strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
	        strCurrency   = prpLendorDto.getCurrency();
	        icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
	        // 根据itemkindNo来冲减保额
	        if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
	           prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
	           prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
	           if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
	             throw new Exception("赔款币别与投保币别不一致,请先换算成保单币别");
	           }
	   
	           // 冲减保额
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
       }else  throw new Exception("prpLendorList 为空，无法冲减prpcitemkind");
        
        
       System.out.println("123");
         
          //分户批改费用信息整理
          //根据分户累加计算总保费
          dblSumAmount=0;
          dblSumArea=0;
          
          //标的的保费生成,从清单中汇总标的保费，面积
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
        		  //不做面积冲减。
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
        	  if("Y".equals(blPolicy.getBLPrpCitemKind().getArr(index).getCalculateFlag()))//汇总计入保额的险别标的。
               dblSumAmount += Double.parseDouble(blPolicy.getBLPrpCitemKind().getArr(index).getAmount());
          }
          for(int index=0;index<blPolicy.getBLPrpCitemKind().getSize();index++){
        	  if("Y".equals(blPolicy.getBLPrpCitemKind().getArr(index).getCalculateFlag())){//取计入保额的险别标的中面积最大的作为总面积。
        		  double insuredAreaTemp = Double.parseDouble(blPolicy.getBLPrpCitemKind().getArr(index).getQuantity());
        		  if(dblSumArea < insuredAreaTemp)
        			  dblSumArea = insuredAreaTemp;
        	  }
          }
          //更新cmain表保费
          blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
        //不做面积冲减。
//          blPolicy.getBLPrpCmain().getArr(0).setStatQuantity(String.valueOf(dblSumArea));
           // 生成phead记录
         prpPheadSchema.setEndorseNo(strBizNo);
         prpPheadSchema.setPolicyNo(PolicyNo);
         prpPheadSchema.setMakeCom(strMakeCom);
         System.out.println("125");
         //如果冲减保额时，保单已经过期，则冲减批单的生效日期为保单终止日，批改日期为保单终止日-1。
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

          //总保费的变化
          prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
          prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
          prpCfeeSchema.setFlag("U");
          //存储农险特有信息变化prpcitemkindagri
//          if(null!=blPolicy.getBlPrpCitemKindAgri() && blPolicy.getBlPrpCitemKindAgri().getSize()>0){
//        	  for(int indexItemKindAgri = 0;indexItemKindAgri < blPolicy.getBlPrpCitemKindAgri().getSize(); indexItemKindAgri ++){
//        		  if("0".equals(blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getTimes()))
//        				  blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getFlag().substring(1,blPolicy.getBlPrpCitemKindAgri().getArr(indexItemKindAgri).getFlag().length()));
//        	  }
//          }
          //存储农险特有信息变化prpcmainagri
          //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
          //11、生成批单对象
          
           //blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
        
            System.out.println("127");
          blPolicy = blEndorse.generateSpecial(blPolicy);
          System.out.println("128");
          //获取原始保单分户信息
          BLPolicy blPolicyOld1=null;
          System.out.println("SIZE2:"+blPolicy.getbLNyxPolicyList().getSize());
          System.out.println("inusrelistcode:"+inusrelistcode);
          if(blPolicy.getbLNyxPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
        	  System.out.println("129");
              blPolicyOld1 = new BLPolicy(); //原始保单
              blPolicyOld1.getNyxPolicyData(PolicyNo);
          }
          
          
          System.out.println("130");
      try{
         //根据最新保单清单记录生成批单记录
          blEndorse.evaluateNyxFromPolicyToEndor(blPolicyOld1,blPolicy);
          System.out.println("131");
         //更新cmain,pmain
         blEndorse.webAfterCal(blPolicy); 
         System.out.println("132");
         //更新批改生效日期、批改类型
         //默认生效日期为冲减保额日期的第2天
       
         iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
         iEndorsetimes = iEndorsetimes + 1;
         blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
         
         // 回写prplEndor中的批单号信息
         
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
         //生成冲减保额批文
         blEndorse.generatePtext(blPolicy);
         System.out.println("134");
         //显示批文
         strPtext=blEndorse.getBLPrpPtext().getEndorseText();
         
         session.putValue("Policy",blPolicy);
         session.putValue("Endorse",blEndorse);
         session.setAttribute("endorDto",endorDto);
        
   
         //批文赋值
	 	 //PrpPtextSchema prpPtextSchema = new PrpPtextSchema();
	 	 //prpPtextSchema.setEndorseNo(blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
	 	 //prpPtextSchema.setPolicyNo(blEndorse.getBLPrpPhead().getArr(0).getPolicyNo());
	 	 //prpPtextSchema.setLineNo("1");
	 	 //prpPtextSchema.setEndorseText(strPtext);
	 	 //prpPtextSchema.setFlag("");
	 	 //blEndorse.setBLPrpPtext(new BLPrpPtext());
	 	 //blEndorse.getBLPrpPtext().setArr(prpPtextSchema);
	 	 //blEndorse.settleBeforeSave(blPolicy);
	 	   
 	   //批单保存
       
       //if(blEndorse.getbLPlanting31EndorChgDetail().getSize()<=0){
       //  String strMessage = "分户信息没有变动，不能保存！";
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
   //定义变量
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

   boolean hasHeadInsureList = false;//判断养殖险是否含有投保清单，有清单的走新冲减保费方法，无清单走老冲减保费方法。
   String breedingFarmerListFlag = SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG");
   String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG");
   String riskCode = request.getParameter("RiskCode");
   //先对应当有清单的养殖险做判断。
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
   // 养殖险清单冲减保费，原有的不变。
   if(null!=breedingFarmerListFlag && !"".equals(breedingFarmerListFlag) && breedingFarmerListFlag.indexOf(riskCode)>-1 && hasHeadInsureList && !"3224".equals(riskCode) &&!("3201,3204,3238,3228,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){
   		
   		BLHerdsettlelistFacade blHerdSettleListFacade = new BLHerdsettlelistFacade();
   		BLPlantingsettlelistFacade blPlantingSettleListFacade = new BLPlantingsettlelistFacade();
   		String inusrelistcode = "";
   		String strPolicyNo = ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
   		// 原始保单
	   	blPolicyOld.getData(strPolicyNo);
	   	// 冲减保额批改后的保单（初始状态跟"原始保单"一致，下面的环节根据prplendor中的信息修改"冲减保额批改后的保单"）
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
	    //生成分户批改的头表信息。
		Bill bill = new Bill();
	   	String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
		herdEndorHeadSchema.setInusreListCode(inusrelistcode);
		herdEndorHeadSchema.setEndorseNo(strBizNo);
		herdEndorHeadSchema.setPolicyNo(strPolicyNo);
		herdEndorHeadSchema.setRiskCode(strRiskCode);
		herdEndorHeadSchema.setEndorFlag(strEndorType);
		blHerdEndorHead.setArr(herdEndorHeadSchema);
		blEndorse.setBlHerdEndorHead(blHerdEndorHead);
		
      
      	//根据保单号将所有的保单最新清单分户放入BLPolicy的BlHerdPolicyList中
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
      	}else throw new UserException(-3,200,"AgriReduceAmount.jsp","没有找到保单对应的清单，请检查清单！");
      	BLHerdPolicyList bLHerdPolicyList = new BLHerdPolicyList();
      	//根据理赔清单中的耳标号信息从BLPolicy的BLHerdPolicyList中找到相应的保单最新清单分户，把保额置零。
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
					//	        	else throw new UserException(-98,-2,"AgriReduceAmount.jsp","身份证"+fidCard+"保额为0，不可冲减！");
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
						        	else throw new UserException(-98,-2,"AgriReduceAmount.jsp","耳标号"+earLabel+"保额为0，不可冲减！");
						        	
						        }
							}
	   					}
	   				}
   			}
   			}//blPolicy.setBlHerdPolicyList(bLHerdPolicyList);
   		}
   		
	   	// 冲减保额时主要冲减下面几部分的信息：prpcitemkind，prpcitemkindargi，prpcmain，prpcfee
	   	
	   	 // 根据prplendor信息冲减prpcitemkind
		   for (i=0;i<prpLendorDtoList.size();i++){
			   
		      PrpLendorDto prpLendorDto = new PrpLendorDto();
		      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
		      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
		      strCurrency   = prpLendorDto.getCurrency();
		 
		      
		      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
		      // 根据itemkindNo来冲减保额
		      if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
		         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
		         prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
		         if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
		           throw new Exception("赔款币别与投保币别不一致,请先换算成保单币别");
		         }
		 
		         // 冲减保额
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
	      //分户批改费用信息整理
	      //根据分户累加计算总保费
	      for(int index=0;index<blPolicy.getBlHerdPolicyList().getSize();index++){
	          dblSumAmount += Double.parseDouble(blPolicy.getBlHerdPolicyList().getArr(index).getSumAmount());
	      }
	      
	      //更新cmain表保费
	      blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
	      //标的的保费生成
	      blPolicy.getBLPrpCitemKind().getArr(0).setAmount(String.valueOf(dblSumAmount));
	       // 生成phead记录
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

	      //总保费的变化
	      prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
	      prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
	      prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
	      prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
		  prpCfeeSchema.setFlag("U");
	      //存储农险特有信息变化prpcitemkindagri
	      //blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
	      //存储农险特有信息变化prpcmainagri
	      //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
		    //11、生成批单对象
		    //xiaojian_leave：这之前就要整理好Fee表的数据
		    
		    blPolicy = blEndorse.generateSpecial(blPolicy);
		    //获取原始保单分户信息
		    BLPolicy blPolicyOld1=null;
		    if(blPolicy.getBlHerdPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
		        blPolicyOld1 = new BLPolicy(); //原始保单
		        String conditions1=" inusrelistcode='"+inusrelistcode+"' ";
		        blPolicyOld1.getInsureListData(conditions1);
		    }
		    
		try{
		   //根据最新保单清单记录生成批单记录
		    blEndorse.evaluateInsureListFromPolicyToEndor(blPolicyOld1,blPolicy);
		    //户次计算赋值
    	    blPolicy.getBlHerdPolicyList().cancelCP(inusrelistcode);
		   //更新cmain,pmain
		   blEndorse.webAfterCal(blPolicy); 
		   //更新批改生效日期、批改类型
		   //默认生效日期为冲减保额日期的第2天
		   prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
		   prpPheadSchema.setCompensateNo(strCompensateNo);
		   blEndorse.getBLPrpPhead().initArr();
		   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
		   iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
		   iEndorsetimes = iEndorsetimes + 1;
		   blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
		   
		   // 回写prplEndor中的批单号信息
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
		   //生成冲减保额批文
		   blEndorse.generatePtext(blPolicy);
		   //显示批文
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
       // 原始保单
       blPolicyOld.getData(strPolicyNo);
       // 冲减保额批改后的保单（初始状态跟"原始保单"一致，下面的环节根据prplendor中的信息修改"冲减保额批改后的保单"）
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
       //生成分户批改的头表信息。
       Bill bill = new Bill();
       String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
       plantingEndorHeadSchema.setInusreListCode(inusrelistcode);
       plantingEndorHeadSchema.setEndorseNo(strBizNo);
       plantingEndorHeadSchema.setRiskCode(strRiskCode);
       plantingEndorHeadSchema.setPolicyNo(strPolicyNo);
       plantingEndorHeadSchema.setEndorFlag(strEndorType);
       blPlantingEndorHead.setArr(plantingEndorHeadSchema);
       blEndorse.setBLPlantingEndorHead(blPlantingEndorHead);
       //根据保单号将所有的保单最新清单分户放入BLPolicy的BlHerdPolicyList中
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
         }else throw new UserException(-3,200,"AgriReduceAmount.jsp","没有找到保单对应的清单，请检查清单！");
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
                       // 3177不冲减面积只冲减保额
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
                        throw new Exception("理赔金额不能大于保单保额,理赔面积不能大于承包面积！");
                     }
                   }
               }
             }
         }//blPolicy.setBlHerdPolicyList(bLHerdPolicyList);
       }
       // 冲减保额时主要冲减下面几部分的信息：prpcitemkind，prpcitemkindargi，prpcmain，prpcfee
       
        // 根据prplendor信息冲减prpcitemkind
        for (i=0;i<prpLendorDtoList.size();i++){
          
           PrpLendorDto prpLendorDto = new PrpLendorDto();
           prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
           strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
           strCurrency   = prpLendorDto.getCurrency();
      
           
           icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
           // 根据itemkindNo来冲减保额
           if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
              prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
              prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
              if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
                throw new Exception("赔款币别与投保币别不一致,请先换算成保单币别");
              }
      
              // 冲减保额
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
         //分户批改费用信息整理
         //根据分户累加计算总保费
         dblSumAmount=0;
         dblSumArea=0;
         for(int index=0;index<blPolicy.getBLPlantingPolicyList().getSize();index++){
              dblSumAmount += blPolicy.getBLPlantingPolicyList().getArr(index).getSumAmount().doubleValue();
         }
         for(int index=0;index<blPolicy.getBLPlantingPolicyList().getSize();index++){
             dblSumArea += blPolicy.getBLPlantingPolicyList().getArr(index).getInsureArea().doubleValue();
         }
         //更新cmain表保费
         blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
         //标的的保费生成
         blPolicy.getBLPrpCitemKind().getArr(0).setAmount(String.valueOf(dblSumAmount));
         //blPolicy.getBLPrpCitemKind().getArr(0).setQuantity(String.valueOf(dblSumArea));
         //blPolicy.getBlPrpCitemKindAgri().getArr(0).setGrossQuantity(String.valueOf(dblSumArea));
          // 生成phead记录
        prpPheadSchema.setEndorseNo(strBizNo);
        prpPheadSchema.setPolicyNo(strPolicyNo);
        prpPheadSchema.setMakeCom(strMakeCom);
        
        //中央政策性险种规则：如果冲减保额时，保单已经过期，则冲减批单的生效日期为保单终止日，批改日期为保单终止日-1。
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

         //总保费的变化
         prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
         prpCfeeSchema.setAmount1(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setAmount2(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setAmount(String.valueOf(Str.round(dblSumAmount,2)));
         prpCfeeSchema.setFlag("U");
         //存储农险特有信息变化prpcitemkindagri
         blPolicy.getBlPrpCitemKindAgri().getArr(0).setFlag("U"+blPolicy.getBlPrpCitemKindAgri().getArr(0).getFlag().substring(1,2));
         //存储农险特有信息变化prpcmainagri
         //blPolicy.getBLPrpCmainAgri().getArr(0).setFlag("U");
         //11、生成批单对象
         //xiaojian_leave：这之前就要整理好Fee表的数据
         
         blPolicy = blEndorse.generateSpecial(blPolicy);
         //获取原始保单分户信息
         BLPolicy blPolicyOld1=null;
         System.err.println("111="+blPolicy.getBLPlantingPolicyList().getSize());
         System.err.println("inusrelistcode="+inusrelistcode);
         if(blPolicy.getBLPlantingPolicyList().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
             blPolicyOld1 = new BLPolicy(); //原始保单
             String conditions1=" inusrelistcode='"+inusrelistcode+"' ";
             blPolicyOld1.getPlantingPolicyData(strPolicyNo);
             System.err.println(strPolicyNo);
         }
         
     try{
        //根据最新保单清单记录生成批单记录
         blEndorse.evaluatePlantFromPolicyToEndor(blPolicyOld1,blPolicy);
        //更新cmain,pmain
        blEndorse.webAfterCal(blPolicy); 
        //更新批改生效日期、批改类型
        //默认生效日期为冲减保额日期的第2天
        prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
        prpPheadSchema.setCompensateNo(strCompensateNo);
        blEndorse.getBLPrpPhead().initArr();
        blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
        iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
        iEndorsetimes = iEndorsetimes + 1;
        blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
        
        // 回写prplEndor中的批单号信息
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
        //生成冲减保额批文
        blEndorse.generatePtext(blPolicy);
        //显示批文
        strPtext=blEndorse.getBLPrpPtext().getEndorseText();
        session.putValue("Policy",blPolicy);
        session.putValue("Endorse",blEndorse);
        session.setAttribute("endorDto",endorDto);
       }catch(Exception e){
        e.printStackTrace();
        throw e;
      } 
  }else if(null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode)>-1){
  //地方政策性农险保险自动冲减保额 START
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
				//出冲减保额的批单
				strBizNo=AgriReduceAmountViewHelper.endorseGenerateObjectForPlanting(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto);	
				dbPool1.commitTransaction();
				dbPool.commitTransaction();
			} catch (Exception e) {
				dbPool.rollbackTransaction();
				dbPool1.rollbackTransaction();
				AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
				e.printStackTrace();
				throw new Exception("地方政策性农险冲减保额失败。。。");
			}finally{
			    dbPool.close();
			    dbPool1.close();
			}
			//try{
			//	if(!"".equals(strBizNo)&&null!=strBizNo){
			//	AgriReduceAmountViewHelper.start(strBizNo);
			//	AgriReduceAmountViewHelper.submitTaskPlanting(strBizNo,strCompensateNo);
			//	}else{
			//		throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");	
			//	}
			//}catch(Exception e){
			//	    e.printStackTrace();
			//	    throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");
			//}
          //地方政策性农险保险核赔通过自动冲减保额 END
          //yx
    }else if("3224".equals(riskCode)){
    //}else if("3224,3201,3204,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3132,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196".indexOf(riskCode) > -1){
	  //地方政策性农险保险自动冲减保额 START
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
			//出冲减保额的批单
			strPtext = endorseGenerateObjectForNyx11(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
			System.out.println("888888");
			dbPool1.commitTransaction();
			dbPool.commitTransaction();
		} catch (Exception e) {
			dbPool.rollbackTransaction();
			dbPool1.rollbackTransaction();
			AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
			e.printStackTrace();
			throw new Exception("地方政策性农险冲减保额失败。。。");
		}finally{
		    dbPool.close();
		    dbPool1.close();
		}
		//try{
		//	if(!"".equals(strBizNo)&&null!=strBizNo){
		//	AgriReduceAmountViewHelper.start(strBizNo);
		//	AgriReduceAmountViewHelper.submitTaskPlanting(strBizNo,strCompensateNo);
		//	}else{
		//		throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");	
		//	}
		//}catch(Exception e){
		//	    e.printStackTrace();
		//	    throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");
		//}
    //地方政策性农险保险核赔通过自动冲减保额 END
    //yx
	}else if("3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1 && hasHeadInsureList){
		  //地方政策性农险保险自动冲减保额 START
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
				//出冲减保额的批单
				strPtext = endorseGenerateObjectForNyx11(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
				System.out.println("888888");
				dbPool1.commitTransaction();
				dbPool.commitTransaction();
			} catch (Exception e) {
				dbPool.rollbackTransaction();
				dbPool1.rollbackTransaction();
				AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
				e.printStackTrace();
				throw new Exception("地方政策性农险冲减保额失败。。。");
			}finally{
			    dbPool.close();
			    dbPool1.close();
			}

}else if("0311".equals(riskCode)){
	  //地方政策性农险保险自动冲减保额 START
	  System.err.println("测试0311");
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
		//出冲减保额的批单
		strPtext = AgriReduceAmountViewHelper.endorseGenerateObjectForTemblor(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto);	
		System.out.println("888888");
		dbPool1.commitTransaction();
		dbPool.commitTransaction();
	} catch (Exception e) {
		dbPool.rollbackTransaction();
		dbPool1.rollbackTransaction();
		AgriReduceAmountViewHelper.deletePrplendor(strCompensateNo);
		e.printStackTrace();
		throw new Exception("0311地震                             冲减保额失败。。。");
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
	//		throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");	
	//	}
	//}catch(Exception e){
	//	    e.printStackTrace();
	//	    throw new Exception("地方政策性农险冲减保额成功，核批通过失败。。。");
	//}
//地方政策性农险保险核赔通过自动冲减保额 END
}else{
   // 原始保单
   blPolicyOld.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   // 冲减保额批改后的保单（初始状态跟"原始保单"一致，下面的环节根据prplendor中的信息修改"冲减保额批改后的保单"）
   // 冲减保额时主要冲减下面几部分的信息：prpcitemkind，prpcitemkindargi，prpcmain，prpcfee
   blPolicy.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   
   //取虚拟分户的标的信息,来源于prpcvirturlitem    add by 国元项目组 韦吉亮 start
   String strPolicyNo= ((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo();
   String strWherePart = "PolicyNo = '"+strPolicyNo+"'";
   BLPrpCvirturlItem  blPrpCvirturlItem = new BLPrpCvirturlItem();
   blPrpCvirturlItem.query(strWherePart);
   //取虚拟分户的标的信息,来源于prpcvirturlitem    add by 国元项目组 韦吉亮 end
   
   strPolicyCurrency = blPolicy.getBLPrpCmain().getArr(0).getCurrency();
   dblSumAmount = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getSumAmount());
   dblSumGrossQuantity = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getStatQuantity());
   String StrRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
   GroupProposalService groupProposalService = new GroupProposalService();
   //取是否是团单的标志  国元项目组 韦吉亮
   boolean isVirturlItemRisk = groupProposalService.isGroupProposal(StrRiskCode);
   // 根据prplendor信息冲减prpcitemkind
   for (i=0;i<prpLendorDtoList.size();i++){
	   
      PrpLendorDto prpLendorDto = new PrpLendorDto();
      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
      strCurrency   = prpLendorDto.getCurrency();
 
      PrpCvirturlItemSchema prpCvirturlItemSchema = null;
      PrpCitemKindSchema prpCitemKindSchematemp = null; 
      
      if(isVirturlItemRisk){
    	    //根据prpLendor的itemkindno到prpcvirturlitem查冲减相应的保额
          for (int k =0 ;k<blPrpCvirturlItem.getSize();k++){
              prpCvirturlItemSchema = blPrpCvirturlItem.getArr(k);
              if(strItemKindNo.equals(prpCvirturlItemSchema.getItemKindNo())){
            	  //冲减分户本身的保额
            	  prpCvirturlItemSchema.setAmount(String.valueOf(Double
            	                          .parseDouble(ChgData.chgStrZero(prpCvirturlItemSchema.getAmount()))
            	                          + prpLendorDto .getEndorAmount()));
            	 //冲减分户本身的数量
                  prpCvirturlItemSchema.setQuantity(String.valueOf(Double
                                          .parseDouble(ChgData.chgStrZero(prpCvirturlItemSchema.getQuantity()))
                                          + prpLendorDto.getEndorGrossQuantity()));
               //给是否冲减保额标志位赋值   
            	 prpCvirturlItemSchema.setAmountFlag("1");
                break;
              }
          }
          String strKindCode = prpLendorDto.getKindCode();
          String strItemCode = prpLendorDto.getItemCode();
          //利用kindcode,itemcode去prpcitemkind确定唯一的itemkindno 
          for (int j=0 ;j<blPolicy.getBLPrpCitemKind().getSize();j++){
              prpCitemKindSchematemp=blPolicy.getBLPrpCitemKind().getArr(j);
              if(strKindCode.equals(prpCitemKindSchematemp.getKindCode())
                  &&strItemCode.equals(prpCitemKindSchematemp.getItemCode())){
            	  //给itemkinNo赋值
                strItemKindNo = prpCitemKindSchematemp.getItemKindNo();
                break;
              }
          }
      }
      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
      // 根据itemkindNo来冲减保额
      if (icurr > -1 && "14".equals(prpLendorDto.getEndorType())){
         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
         prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
         if (!prpCitemKindSchema.getCurrency().equals(strCurrency)){
           throw new Exception("赔款币别与投保币别不一致,请先换算成保单币别");
         }
 
         // 冲减保额
         dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
         prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
         //团单客户走的路和个单不同
         if(isVirturlItemRisk){
             // 冲减prpcitemkind和 prpCitemKindAgri的数量
             
             dblGrossQuantity = Double.parseDouble(prpCitemKindSchema.getQuantity())+prpLendorDto.getEndorGrossQuantity();
             prpCitemKindAgriSchema.setGrossQuantity(String.valueOf(dblGrossQuantity));
             prpCitemKindSchema.setQuantity(String.valueOf(dblGrossQuantity));
         }else{
             // 冲减数量
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
         
         // 冲减保单总保额
         if("Y".equals(prpCitemKindSchema.getCalculateFlag())){
           dblSumAmount = dblSumAmount + prpLendorDto.getEndorAmount();  
         }
         dblSumGrossQuantity = dblSumGrossQuantity + prpLendorDto.getEndorGrossQuantity();
      }
   }
   
   // 更新cmain的保额
   blPolicy.getBLPrpCmain().getArr(0).setSumAmount(String.valueOf(dblSumAmount));
   blPolicy.getBLPrpCmain().getArr(0).setStatQuantity(String.valueOf(dblSumGrossQuantity));

   // 缴费计划信息
   prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
   prpCfeeSchema.setAmount(String.valueOf(dblSumAmount));
   prpCfeeSchema.setAmount1(String.valueOf(dblSumAmount));
   prpCfeeSchema.setAmount2(String.valueOf(dblSumAmount));
   prpCfeeSchema.setFlag("U");
   
   // 生成phead记录
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
	   //根据最新保单记录生成批单记录
	   blEndorse.evaluateFromPolicyToEndor(blPolicyOld,blPolicy);
	   //更新cmain,pmain
	   blEndorse.webAfterCal(blPolicy); 
	   //更新批改生效日期、批改类型
	   //默认生效日期为冲减保额日期的第2天
	   prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
	   prpPheadSchema.setCompensateNo(strCompensateNo);
	   blEndorse.getBLPrpPhead().initArr();
	   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
	   iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
	   iEndorsetimes = iEndorsetimes + 1;
	   blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
	   
	   // 回写prplEndor中的批单号信息
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
	   //生成冲减保额批文
	   blEndorse.generatePtext(blPolicy);
	   //显示批文
	   strPtext=blEndorse.getBLPrpPtext().getEndorseText();
	   session.putValue("Policy",blPolicy);
	   session.putValue("Endorse",blEndorse);
	   session.setAttribute("endorDto",endorDto);
	   //传递虚拟的分户要更新的对象
	   session.setAttribute("blPrpCvirturlItem",blPrpCvirturlItem);
   }catch(Exception e){
	   e.printStackTrace();
	   throw e;
	 }
	 }
%>

<script language=javascript>
  //装载窗口
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
