<%--
****************************************************************************
* DESC       ������������Ĵ���
* Author     : �й������Ŀ��
* CREATEDATE ��2003-09-24
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- ����bean�ಿ�� --%>
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
    <input type="button" name="buttonSubmit" class="button"   value="����" 
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
	 * ������������
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
    
        // ԭʼ����
        blPolicyOld.getData(PolicyNo);
        // ����������ĺ�ı�������ʼ״̬��"ԭʼ����"һ�£�����Ļ��ڸ���prplendor�е���Ϣ�޸�"����������ĺ�ı���"��
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
        //���ɷֻ����ĵ�ͷ����Ϣ��
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
	    	   throw new UserException(-3,200,"AgriReduceAmountViewHelper.java","û���ҵ�������Ӧ���嵥�������嵥��");
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
                         throw new Exception("������ͨ�������������δ�ɹ���������ܴ��ڱ�������,����������ܴ��ڳа��������");
                      }
                    }
                }
              }
          }
       }
        
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
	           //prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
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
	           //prpCitemKindAgriSchema.setFlag(strFlag);
	           blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
	           //blPolicy.getBlPrpCitemKindAgri().setArr(blPolicy.getBlPrpCitemKindAgri().search(prpCitemKindAgriSchema.getItemKindNo(),prpCitemKindAgriSchema.getKindCode(),prpCitemKindAgriSchema.getTimes()),prpCitemKindAgriSchema);            
	        }
    	   }
       }else  throw new Exception("prpLendorList Ϊ�գ��޷����prpcitemkind");
         
          //�ֻ����ķ�����Ϣ����
          //���ݷֻ��ۼӼ����ܱ���
          dblSumAmount=0;
          dblSumArea=0;
          
          //��ĵı�������,���嵥�л��ܱ�ı��ѣ����
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
        
          
          blPolicy = blEndorse.generateSpecial(blPolicy);
          //��ȡԭʼ�����ֻ���Ϣ
          BLPolicy blPolicyOld1=null;
          if(blPolicy.getbLTemblorPolicylist().getSize()>0 && null != inusrelistcode && !"".equals(inusrelistcode)){
              blPolicyOld1 = new BLPolicy(); //ԭʼ����
              blPolicyOld1.getTemblorPolicyData(PolicyNo);
          }
          
      try{
         //�������±����嵥��¼����������¼
          blEndorse.evaluateTemblorFromPolicyToEndor(blPolicyOld1,blPolicy);
         //����cmain,pmain
         blEndorse.webAfterCal(blPolicy); 
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
         //���ɳ����������
         blEndorse.generatePtext(blPolicy);
         //��ʾ����
         strPtext=blEndorse.getBLPrpPtext().getEndorseText();
        
         session.putValue("Policy",blPolicy);
         session.putValue("Endorse",blEndorse);
         session.setAttribute("endorDto",endorDto);
         
         //���ĸ�ֵ
	 	 PrpPtextSchema prpPtextSchema = new PrpPtextSchema();
	 	 prpPtextSchema.setEndorseNo(blEndorse.getBLPrpPhead().getArr(0).getEndorseNo());
	 	 prpPtextSchema.setPolicyNo(blEndorse.getBLPrpPhead().getArr(0).getPolicyNo());
	 	 prpPtextSchema.setLineNo("1");
	 	 prpPtextSchema.setEndorseText(strPtext);
	 	 prpPtextSchema.setFlag("");
	 	 blEndorse.setBLPrpPtext(new BLPrpPtext());
	 	 blEndorse.getBLPrpPtext().setArr(prpPtextSchema);
	 	 blEndorse.settleBeforeSave(blPolicy);
	 	   
 	   //��������
       
       if(blEndorse.getbLTemblorEndorChgDetail().getSize()<=0){
         String strMessage = "�ֻ���Ϣû�б䶯�����ܱ��棡";
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
   //�������
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
		  //�ط�������ũ�ձ����Զ�������� START
		  System.err.println("����0311");
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
			//��������������
			strPtext = endorseGenerateObjectForTemblor1(request, dbPool, dbPool1, dbManager, strCompensateNo, riskCode, strPolicyNo, prpDuserDto,session);	
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
	}else {
   
		   //����prplendor��Ϣ���prpcitemkind
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
		         //���ܱ���
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
			 
		   //����cmain�ı���
		
		   blPolicy.getBLPrpCmain().getArr(0).setSumAmount(strSumAmount);
		
		   
		   prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
		   prpCfeeSchema.setAmount(strSumAmount);
		   prpCfeeSchema.setAmount1(strSumAmount);
		   prpCfeeSchema.setAmount2(strSumAmount);
		   prpCfeeSchema.setFlag("U");
		   
		   //����phead��¼
		
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
		   //���ݿͻ�Ҫ��������������ֱ��ȡ�Լ��������������
		   //�õ�����
		   String strClassCode = blPolicy.getBLPrpCmain().getArr(0).getClassCode();
		   //���ɳ����������
		   if("27".equals(strClassCode)){
		     int j=0;
		     int intCount = 0;
		     String tempContext = "";
		     String strQueryCondi = "compensateno = '"+strCompensateNo+"' and texttype = '7'";//7Ϊ������ģ�1Ϊ���������
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

