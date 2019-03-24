<%--
****************************************************************************
* DESC       ：理赔冲减保额的处理
* Author     : 中国大地项目组
* CREATEDATE ：2003-09-24
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- 引入bean类部分 --%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.prpall.blsvr.lp.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLEndorse"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>
<%@page import="com.sinosoft.prpall.pubfun.Bill"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.dto.custom.EndorDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLendorDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLctextDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIEndorAction"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLendorFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLctextFacade"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.sinosoft.undwrt.ui.control.viewhelper.AgriReduceAmountViewHelper"%>
<%@page import="java.io.*"%>
<%@page import="com.sinosoft.utility.database.DbPool"%>
<%@page import="com.sinosoft.sysframework.reference.DBManager"%>
<%@page import="com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog" %>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.DBPrpLloss" %>
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLcompensate" %>
<%@page import="com.sinosoft.claim.dto.domain.PrpLlossDto"%>
<%@page import="com.sinosoft.temblor.schema.*"%>
<%@page import="com.sinosoft.temblor.blsvr.*"%>
<%@page import="com.gyic.claim.bl.facade.*"%>
<%@page import="com.gyic.claim.dto.domain.*"%>
<%@page import="com.sinosoft.temblor.blsvr.misc.*"%>
<%@page import="com.sinosoft.utility.error.UserException"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="java.math.*"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLPrpPtext"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sinosoft.platform.dto.domain.PrpDuserDto" %>
<%
String strClaimNo = request.getParameter("ClaimNo");
%>

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
    <input type="button" name="buttonSubmit" class="button"   value="保存" 
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

<%!
	/**
	 * 冲减保额出批单
	 * @param 
	 * @return
	 * @author
	 */
	public String endorseGenerateObjectForTemblor1(HttpServletRequest httpServletRequest,
			DbPool dbPool,DbPool dbPool1,DBManager dbManager,String businessNo,String RiskCode,String PolicyNo,PrpDuserDto prpDuserDto,HttpSession session) throws Exception
	{
		String conditions = " CompensateNo = '"+businessNo+"'";
		DBPrpLloss dbPrpLloss = new DBPrpLloss(dbManager);
		BLPrpLcompensate  bLPrpLcompensate = new BLPrpLcompensate();
		ArrayList agriLossList = (ArrayList)dbPrpLloss.findByConditions(conditions);
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
            //if(lossRate>=getTotalLossRate(prpLlossDtoTemp.getPolicyNo(),prpLlossDtoTemp.getKindCode(),prpLlossDtoTemp.getItemCode())){
              SettleArea=prpLlossDtoTemp.getSettleArea();

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
        //BLPrpCitemKindAgri blPrpCitemKindAgri=new BLPrpCitemKindAgri();
        PrpCfeeSchema   prpCfeeSchema = new PrpCfeeSchema();
        //PrpCitemKindAgriSchema prpCitemKindAgriSchema=null;
        PubTools pubTools = new PubTools();

        BLTemblorsettlelistFacade blTemblorSettleListFacade=new BLTemblorsettlelistFacade();
        String inusrelistcode = "";
    
        // 原始保单
        blPolicyOld.getData(PolicyNo);
        // 冲减保额批改后的保单（初始状态跟"原始保单"一致，下面的环节根据prplendor中的信息修改"冲减保额批改后的保单"）
        blPolicy.getData(PolicyNo);      
        String strRiskCode = blPolicy.getBLPrpCmain().getArr(0).getRiskCode();
        String conditionsOfFatchSettleMainList = " compensateNo='" + businessNo + "' and VALIDITY = '2' ";
        BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
        ArrayList settleMainList = (ArrayList)blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
        if(null!=settleMainList && settleMainList.size()>0){
          Object[] settleMainListDtoArray = settleMainList.toArray();
          SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainListDtoArray[0];
          inusrelistcode = settleMainListDto.getInusrelistcode();
        }
        BLTemblorEndorHead blTemblorEndorHead=new BLTemblorEndorHead();
        TemblorEndorHeadSchema temblorEndorHeadSchema =new TemblorEndorHeadSchema();
        TemblorPolicylistSchema temblorPolicyListSchema=new TemblorPolicylistSchema();
        //生成分户批改的头表信息。
        Bill bill = new Bill();
        String  strBizNo = bill.getNo(SysConfig.getProperty("ENDORSRE_TABLE"),blPolicy.getBLPrpCmain().getArr(0).getPolicyNo());
        httpServletRequest.setAttribute("EndorseNo", strBizNo);
        temblorEndorHeadSchema.setInusrelistCode(inusrelistcode);
        temblorEndorHeadSchema.setEndorseNo(strBizNo);
        temblorEndorHeadSchema.setRiskCode(strRiskCode);
        temblorEndorHeadSchema.setPolicyNo(PolicyNo);
        temblorEndorHeadSchema.setEndorFlag(strEndorType);
        blTemblorEndorHead.setArr(temblorEndorHeadSchema);
        blEndorse.setBLTemblorEndorHead(blTemblorEndorHead);
        

        BLPrpCmainProp blPrpCmainProp = new BLPrpCmainProp();
        blPrpCmainProp.query(" policyNo = '"+PolicyNo+"'");
        if(blPrpCmainProp.getSize()>0){
        	String strInsureListCode = ((PrpCmainPropSchema)blPrpCmainProp.getArr(0)).getHouseCertificate();
            String conditionsOfFatchInsureMainList = " INUSRELISTCODE = '"+strInsureListCode+"' and validity = '2' ";
	        BLInsuremainlistFacade  blInsuremainlistFacade= new BLInsuremainlistFacade();
	        Collection blInsureMainListCollection = blInsuremainlistFacade.findByConditions(conditionsOfFatchInsureMainList);
	        if(null != blInsureMainListCollection && blInsureMainListCollection.size() > 0){
	             Iterator iteratorBLInsureMainList  = blInsureMainListCollection.iterator();
	             while(iteratorBLInsureMainList.hasNext()){
	              InsuremainlistDto insureMainListDto = (InsuremainlistDto)iteratorBLInsureMainList.next();
	              String conditionsOfPolicyList = " inusreListCode = '"+strInsureListCode+"' and validity = '1'"; 
	              BLTemblorPolicylist blTemblorPolicyList = new BLTemblorPolicylist();
	              blTemblorPolicyList.query(conditionsOfPolicyList);
	              if(null!=blTemblorPolicyList && blTemblorPolicyList.getSize()>0){
		              for(int index = 0; index < blTemblorPolicyList.getSize(); index++){
		                temblorPolicyListSchema=blTemblorPolicyList.getArr(index);
		                blPolicy.getbLTemblorPolicylist().setArr(temblorPolicyListSchema);
		              }
	              }
	            }
	       }else{
	    	   throw new UserException(-3,200,"AgriReduceAmountViewHelper.java","没有找到保单对应的清单，请检查清单！");
	       }
        }
       if(null!=settleMainList && settleMainList.size()>0){  
    	   System.err.println("zouzouzou");
       
            int temblor31PolicyListSize = blPolicy.getbLTemblorPolicylist().getSize();
            SettlemainlistDto settleMainListDto = (SettlemainlistDto)settleMainList.get(0);
            String settleListCode = settleMainListDto.getSettlelistcode();
            String conditionsOfFatchSettleList = " SETTLELISTCODE = '" + settleListCode +"' and nodetype='compe'";
            ArrayList temblorSettleList = (ArrayList)blTemblorSettleListFacade.findByConditions(conditionsOfFatchSettleList);
            if(null!=temblorSettleList && temblorSettleList.size()>0){
              for(int j=0;j<temblorSettleList.size();j++){
            	  TemblorsettlelistDto temblor31SettleListDtoTemp = (TemblorsettlelistDto)temblorSettleList.get(j);
                String fIdCard = temblor31SettleListDtoTemp.getIdcard();
                String kindCode = temblor31SettleListDtoTemp.getKindcode();
                String itemCode = temblor31SettleListDtoTemp.getItemcode();
                String address = temblor31SettleListDtoTemp.getAddress();
                System.err.println(fIdCard+kindCode+itemCode+address);
                for(int index = 0; index < temblor31PolicyListSize; index ++){
                	TemblorPolicylistSchema temblor31PolicyListSchemaTemp= blPolicy.getbLTemblorPolicylist().getArr(index);
//             	   if("null".equals(temblor31PolicyListSchemaTemp.getFieldSource())){
//             		  temblor31PolicyListSchemaTemp.setFieldSource("");
//             	   }
					System.err.println(temblor31PolicyListSchemaTemp.getIdcard()+temblor31PolicyListSchemaTemp.getKindCode()+temblor31PolicyListSchemaTemp.getAddress()+temblor31PolicyListSchemaTemp.getItemCode());
                    if(!"".equals(fIdCard)&&null!= fIdCard && fIdCard.equals(temblor31PolicyListSchemaTemp.getIdcard()) &&
                    		!"".equals(kindCode)&&null!= kindCode && kindCode.equals(temblor31PolicyListSchemaTemp.getKindCode()) &&
                    		!"".equals(address)&&null!= address && address.equals(temblor31PolicyListSchemaTemp.getAddress()) && 
                    		!"".equals(itemCode)&&null!= itemCode && itemCode.equals(temblor31PolicyListSchemaTemp.getItemCode())){
                      double iTemblorAmount=temblor31PolicyListSchemaTemp.getSumAmount().doubleValue()-temblor31SettleListDtoTemp.getSettlesum();
                      System.err.println(iTemblorAmount);
                      //double iTemblorArea=temblor31PolicyListSchemaTemp.getInsureArea().doubleValue()-temblor31SettleListDtoTemp.getSettleArea();
                      if(iTemblorAmount>=0){
							System.err.println("zou");
                          temblor31PolicyListSchemaTemp.setSumAmount(new BigDecimal(temblor31PolicyListSchemaTemp.getSumAmount().doubleValue()-temblor31SettleListDtoTemp.getSettlesum()));
                          temblor31PolicyListSchemaTemp.setFlag("U");
//                          blPolicy.getbLTemblor31PolicyList().setArr(temblor31PolicyListSchemaTemp);
                        
                      }else{
                         throw new Exception("核赔已通过，但冲减保额未成功（理赔金额不能大于保单保额,理赔面积不能大于承包面积！）");
                      }
                    }
                }
              }
          }
       }
        
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
	           //prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
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
	           //prpCitemKindAgriSchema.setFlag(strFlag);
	           blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
	           //blPolicy.getBlPrpCitemKindAgri().setArr(blPolicy.getBlPrpCitemKindAgri().search(prpCitemKindAgriSchema.getItemKindNo(),prpCitemKindAgriSchema.getKindCode(),prpCitemKindAgriSchema.getTimes()),prpCitemKindAgriSchema);            
	        }
    	   }
       }else  throw new Exception("prpLendorList 为空，无法冲减prpcitemkind");
         
          //分户批改费用信息整理
          //根据分户累加计算总保费
          dblSumAmount=0;
          dblSumArea=0;
          
          //标的的保费生成,从清单中汇总标的保费，面积
          if(null!=blPolicy.getBLPrpCitemKind() && blPolicy.getBLPrpCitemKind().getSize()>0){
        	  BLTemblorPolicylist blTemblor31PolicyListTemp = new BLTemblorPolicylist();
        	  for(int index =0; index < blPolicy.getBLPrpCitemKind().getSize(); index++){
        		  PrpCitemKindSchema prpCitemKindSchemaTemp = (PrpCitemKindSchema)blPolicy.getBLPrpCitemKind().getArr(index);
        		  String strItemCode = prpCitemKindSchemaTemp.getItemCode();
        		  String strKindCode = prpCitemKindSchemaTemp.getKindCode();
        		  double  sumAmount = 0.0;
//        		  double  sumArea = 0.0;
        		  for(int indexOfPolicyList = 0; indexOfPolicyList < blPolicy.getbLTemblorPolicylist().getSize(); indexOfPolicyList ++){
        			  TemblorPolicylistSchema temblor31PolicyListSchemaTemp= blPolicy.getbLTemblorPolicylist().getArr(indexOfPolicyList);
        			  if(strItemCode.equals(temblor31PolicyListSchemaTemp.getItemCode())&& strKindCode.equals(temblor31PolicyListSchemaTemp.getKindCode())){
        				  sumAmount += temblor31PolicyListSchemaTemp.getSumAmount().doubleValue();
//        				  sumArea += temblor31PolicyListSchemaTemp.getInsureArea().doubleValue();
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
        
          
          blPolicy = blEndorse.generateSpecial(blPolicy);
          //获取原始保单分户信息
          BLPolicy blPolicyOld1=null;
          if(blPolicy.getbLTemblorPolicylist().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
              blPolicyOld1 = new BLPolicy(); //原始保单
              blPolicyOld1.getTemblorPolicyData(PolicyNo);
          }
          
      try{
         //根据最新保单清单记录生成批单记录
          blEndorse.evaluateTemblorFromPolicyToEndor(blPolicyOld1,blPolicy);
         //更新cmain,pmain
         blEndorse.webAfterCal(blPolicy); 
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
         //生成冲减保额批文
         blEndorse.generatePtext(blPolicy);
         //显示批文
         strPtext=blEndorse.getBLPrpPtext().getEndorseText();
        
         session.putValue("Policy",blPolicy);
         session.putValue("Endorse",blEndorse);
         session.setAttribute("endorDto",endorDto);
         
         //批文赋值
	 	 PrpPtextSchema prpPtextSchema = new PrpPtextSchema();
	 	 prpPtextSchema.setEndorseNo(blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
	 	 prpPtextSchema.setPolicyNo(blEndorse.getBLPrpPhead().getArr(0).getPolicyNo());
	 	 prpPtextSchema.setLineNo("1");
	 	 prpPtextSchema.setEndorseText(strPtext);
	 	 prpPtextSchema.setFlag("");
	 	 blEndorse.setBLPrpPtext(new BLPrpPtext());
	 	 blEndorse.getBLPrpPtext().setArr(prpPtextSchema);
	 	 blEndorse.settleBeforeSave(blPolicy);
	 	   
 	   //批单保存
       
       if(blEndorse.getbLTemblorEndorChgDetail().getSize()<=0){
         String strMessage = "分户信息没有变动，不能保存！";
         throw new Exception(strMessage);
       }
       blEndorse.saveReduceAmount(dbPool, blPolicy);
       blEndorse.saveTemblorInsureList(dbPool1, blPolicy);
      }catch(Exception e){
          bill.putNo(SysConfig.getProperty("ENDORSRE_TABLE"),blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
          throw e;
      } 
      return strBizNo;
	}
	%>

<%
   //定义变量
   String strCompensateNo = request.getParameter("CompensateNo");

   String  strValidDate = new DateTime().current().addDay(1).toString();
   int i = 0;
   int icurr = 0;
   int iEndorsetimes = 0;
   String strItemKindNo = "";
   String strCurrency   = "";
   String strFlag       = "";
   double dblAmount     = 0;
   double dblSumAmount  = 0;
   double dblExchangeRate = 0;
   String strPtext      = "";
   String strPolicyCurrency = "";
   String strEndorType     = "14";
   UserDto   userDto     = (UserDto)session.getAttribute("user");
   String strOperatorCode  = userDto.getUserCode();
   String strMakeCom       = userDto.getComCode();
   String strInputDate     = new ChgDate().getCurrentTime("yyyy/MM/dd");  
   String riskCode = request.getParameter("RiskCode");
   
   BLPolicy             blPolicy    = new BLPolicy();
   BLPolicy             blPolicyOld = new BLPolicy();
   BLEndorse            blEndorse   = new BLEndorse();
   
   BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
   ArrayList prpLendorDtoList = new ArrayList();
   prpLendorDtoList = (ArrayList)blPrpLendorFacade.findByConditions("CompensateNo = '" + strCompensateNo + "'");

   PrpCitemKindSchema   prpCitemKindSchema = new PrpCitemKindSchema();
   PrpPheadSchema       prpPheadSchema     = new PrpPheadSchema();
   PrpCfeeSchema        prpCfeeSchema      = new PrpCfeeSchema();
   PubTools    pubTools = new PubTools();
   blPolicy.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   blPolicyOld.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   strPolicyCurrency = blPolicy.getBLPrpCmain().getArr(0).getCurrency();
   dblSumAmount = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getSumAmount());
   
   if("0311".equals(riskCode)){
		  //地方政策性农险保险自动冲减保额 START
		  System.err.println("测试0311");
		com.sinosoft.platform.dto.domain.PrpDuserDto prpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
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
			AgriReduceAmountViewHelper.deleteEndorseTemblor(request, dbPool,dbPool1,dbManager, dbWfLog, strCompensateNo);
			//System.out.println("777777");
			//出冲减保额的批单
			strPtext = endorseGenerateObjectForTemblor1(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
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
	}else {
   
		   //根据prplendor信息冲减prpcitemkind
		   for (i=0;i<prpLendorDtoList.size();i++)
		   {
		      PrpLendorDto prpLendorDto = new PrpLendorDto();
		      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
		      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
		      strCurrency   = prpLendorDto.getCurrency();
		      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
		      if (icurr > -1 && "14".equals(prpLendorDto.getEndorType()))
		      {
		         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
		         if (!prpCitemKindSchema.getCurrency().equals(strCurrency))
		         {
		           
		           continue;
		         }
		         
		         dblAmount = Double.parseDouble(prpCitemKindSchema.getAmount())+ prpLendorDto.getEndorAmount();
		         prpCitemKindSchema.setAmount(String.valueOf(dblAmount));
		         
		         strFlag = prpCitemKindSchema.getFlag();
		         if (strFlag.length()==0)
		           {strFlag = "U";}
		         else
		           {
		            strFlag = "U"+strFlag.substring(1,strFlag.length());
		           }
		         prpCitemKindSchema.setFlag(strFlag);
		         blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
		         //汇总保额
		         dblExchangeRate = pubTools.getExchangeRate(prpCitemKindSchema.getCurrency(),
		                                                    strPolicyCurrency,
		                                                    prpCitemKindSchema.getStartDate());
		         if("Y".equals(prpCitemKindSchema.getCalculateFlag()))
		         {
		           dblSumAmount = dblSumAmount + prpLendorDto.getEndorAmount();  
		         }
		      }
		   }
		   
		   DecimalFormat df = new DecimalFormat("##0.00");
			 String strSumAmount = df.format(dblSumAmount);
			 
		   //更新cmain的保额
		
		   blPolicy.getBLPrpCmain().getArr(0).setSumAmount(strSumAmount);
		
		   
		   prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
		   prpCfeeSchema.setAmount(strSumAmount);
		   prpCfeeSchema.setAmount1(strSumAmount);
		   prpCfeeSchema.setAmount2(strSumAmount);
		   prpCfeeSchema.setFlag("U");
		   
		   //生成phead记录
		
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
		   prpPheadSchema.setEndorType(strEndorType);
		   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
		   
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
		   
		   EndorDto endorDto =(EndorDto)request.getAttribute("endorDto");
		   
		   ArrayList endorList = endorDto.getPrpLendorList();
		   ArrayList endorNewList = new ArrayList();
		   Iterator endorLists = endorList.iterator();
		   while(endorLists.hasNext()){
		      PrpLendorDto prpLendorDto = new PrpLendorDto();
		      prpLendorDto = (PrpLendorDto) endorLists.next();
		      prpLendorDto.setEndorseNo(strBizNo);
		      endorNewList.add(prpLendorDto);
		   }
		   endorDto.setPrpLendorList(endorNewList);
		   UIEndorAction uiEndorAction = new UIEndorAction();
		   uiEndorAction.save(endorDto);
		   
		   //Modify by chenrenda begin 20070713
		   //根据客户要求，意键险赔款批文直接取自计算书中审核批文
		   //得到险类
		   String strClassCode = blPolicy.getBLPrpCmain().getArr(0).getClassCode();
		   //生成冲减保额批文
		   if("27".equals(strClassCode)){
		     int j=0;
		     int intCount = 0;
		     String tempContext = "";
		     String strQueryCondi = "compensateno = '"+strCompensateNo+"' and texttype = '7'";//7为审核批文，1为赔款计算过程
		     BLPrpLctextFacade blPrpLctextFacade = new BLPrpLctextFacade();
		     ArrayList prpLctextList = (ArrayList)blPrpLctextFacade.findByConditions(strQueryCondi);
		     intCount = prpLctextList.size();
		     if(intCount>0){
		        PrpLctextDto prpLctextDtoTemp = null;
		        for (j=0;j<intCount;j++){
		           prpLctextDtoTemp = (PrpLctextDto)prpLctextList.get(j);
		           tempContext = tempContext+prpLctextDtoTemp.getContext();
		        }
		        strPtext = tempContext;
		     }
		    
		   
		   }else{
		     blEndorse.generatePtext(blPolicy);
		     strPtext=blEndorse.getBLPrpPtext().getEndorseText();
		   }
	
   
   //Modify by chenrenda end 20070713
   
   session.putValue("Policy",blPolicy);
   session.putValue("Endorse",blEndorse);
   
   
   session.setAttribute("endorDto",endorDto);
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

