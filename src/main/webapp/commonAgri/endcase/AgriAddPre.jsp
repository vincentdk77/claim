<%--
****************************************************************************
* DESC       ��ũ�����������ѵĴ���
* Author     : ������Ŀ��
* CREATEDATE ��2006-11-24
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@page errorPage="/UIErrorPage"%> 

<%-- ����bean�ಿ�� --%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.utility.string.Date"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.prpall.blsvr.lp.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@page import="com.sinosoft.prpall.blsvr.pg.BLEndorse"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.*"%>
<%@page import="com.sinosoft.prpall.schema.*"%>
<%@page import="com.sinosoft.prpall.pubfun.Bill"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpDuserDto"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLregistTextDto"%>
<%@page import="com.sinosoft.claim.dto.custom.ClaimDto"%>
<%@page import="com.sinosoft.claim.dto.custom.RegistDto"%>
<%@page import="com.sinosoft.claim.dto.custom.CompensateDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcompensateDto"%>
<%@page import="com.sinosoft.claim.dto.custom.EndorDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLendorDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIEndorAction"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLendorFacade"%>

 <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 <body onload="loadForm()" class="interface">
 <form name="fm" method="post" action="/claim/endor.do">
 <input name="EndorType" type="hidden"  >
 <input type="hidden" name = "editType" value="SAVEENDORSE">
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
    <IMG name="buttonSubmit" class="button" type="button"  alt="����" src=""
		   onclick="submit();">
  </td>
</tr>    
</table>
</form>
</body> 

<%
   //�������
   String strCompensateNo = request.getParameter("CompensateNo");
   String claimNo = request.getParameter("ClaimNo");
   String  strValidDate = new DateTime().current().addDay(1).toString();
   int i = 0;
   int icurr = 0;
   int iEndorsetimes = 0;
   String strItemKindNo = "";
   String strCurrency   = "";
   String strFlag       = "";
   double dblPremium     = 0;
   double dblSumPremium  = 0;
   double dbChgPremium  = 0;
   double dblExchangeRate = 0;
   double cmainPremium  = 0;
   String strPtext      = "";
   String strPolicyCurrency = "";
   String strEndorType     = "72";
   UserDto   userDto     = (UserDto)session.getAttribute("user");
   String strOperatorCode  = userDto.getUserCode();
   String strMakeCom       = userDto.getComCode();
   String strInputDate     = new ChgDate().getCurrentTime("yyyy-MM-dd");  
   BLPolicy             blPolicy    = new BLPolicy();
   BLPolicy             blPolicyOld = new BLPolicy();
   BLEndorse            blEndorse   = new BLEndorse();
   BLPrpCplan           blPrpCplan  = new BLPrpCplan();
   UICompensateAction uiCompensateAction = new UICompensateAction();
   UIClaimAction uiClaimAction = new UIClaimAction();
   UIRegistAction uiRegistAction = new UIRegistAction();
   ArrayList prpLregistTextDtoList = new ArrayList();
   CompensateDto compensateDto = new CompensateDto();
   ClaimDto claimDto = new ClaimDto();
   RegistDto registDto = new RegistDto();
   PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
	 PrpLclaimDto prpLclaimDto = new PrpLclaimDto();
   PrpCitemKindSchema   prpCitemKindSchema = new PrpCitemKindSchema();
   PrpCfeeSchema   prpCfeeSchema = new PrpCfeeSchema();
   PrpCplanSchema   prpCplanSchema = new PrpCplanSchema();
   PrpPheadSchema       prpPheadSchema     = new PrpPheadSchema();
   BLPrpCitemKindAgri blPrpCitemKindAgri=new BLPrpCitemKindAgri();
   PrpCitemKindAgriSchema prpCitemKindAgriSchema=null;
   PubTools    pubTools = new PubTools();
   
   compensateDto = uiCompensateAction.findByPrimaryKey(strCompensateNo);
   claimDto = uiClaimAction.findByPrimaryKey(claimNo);
   prpLcompensateDto = compensateDto.getPrpLcompensateDto();
   prpLclaimDto = claimDto.getPrpLclaimDto();
   registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
   prpLregistTextDtoList = registDto.getPrpLregistExtDtoList();
   
   BLPrpLendorFacade blPrpLendorFacade = new BLPrpLendorFacade();
   ArrayList prpLendorDtoList = new ArrayList();
   prpLendorDtoList = (ArrayList)blPrpLendorFacade.findByConditions("CompensateNo = '" + strCompensateNo + "'");
   
   blPolicy.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   blPolicyOld.getData(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   strPolicyCurrency = blPolicy.getBLPrpCmain().getArr(0).getCurrency();
   cmainPremium = Double.parseDouble(blPolicy.getBLPrpCmain().getArr(0).getSumPremium());
   String registContext="";  
   if (registDto.getPrpLregistTextDtoList()   !=null){
				PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
				Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
				while (iterator.hasNext()) {
					prpLregistTextDto = (PrpLregistTextDto) iterator
							.next();
					if (prpLregistTextDto.getTextType().equals("1")) {
						registContext = registContext
								+ prpLregistTextDto.getContext();
					}
				}
		}  
   //����prplendor��Ϣ���prpcitemkind
   for (i=0;i<prpLendorDtoList.size();i++)
   {
      PrpLendorDto prpLendorDto = new PrpLendorDto();
      prpLendorDto = (PrpLendorDto)prpLendorDtoList.get(i);
      strItemKindNo = String.valueOf(prpLendorDto.getItemKindNo());
      strCurrency   = prpLendorDto.getCurrency();
      icurr = blPolicy.getBLPrpCitemKind().search(strItemKindNo);
      if (icurr > -1 && "72".equals(prpLendorDto.getEndorType()))
      {
         prpCitemKindSchema = blPolicy.getBLPrpCitemKind().getArr(icurr);
         prpCitemKindAgriSchema=blPrpCitemKindAgri.getKindAgri(prpCitemKindSchema);
         if (!prpCitemKindSchema.getCurrency().equals(strCurrency))
         {
           System.out.println("���ұ���Ͷ���ұ�һ��,���Ȼ���ɱ����ұ�");
           continue;
         }
         System.out.println("����ǰ����"+prpCitemKindSchema.getPremium());
         dblPremium = Double.parseDouble(prpCitemKindSchema.getPremium())+ prpLendorDto.getEndorAmount();
         dbChgPremium += prpLendorDto.getEndorAmount();
         prpCitemKindSchema.setPremium(String.valueOf(dblPremium));
         System.out.println("���պ󱣷�"+prpCitemKindSchema.getPremium());
         strFlag = prpCitemKindSchema.getFlag();
         if (strFlag.length()==0)
           {strFlag = "U";}
         else
           {
            strFlag = "U"+strFlag.substring(1,strFlag.length());
           }
         prpCitemKindSchema.setFlag(strFlag);
         prpCitemKindAgriSchema.setFlag(strFlag);
         blPolicy.getBLPrpCitemKind().setArr(icurr,prpCitemKindSchema);
         blPolicy.getBlPrpCitemKindAgri().setArr(icurr,prpCitemKindAgriSchema);   
         //���ܱ���
         dblExchangeRate = pubTools.getExchangeRate(prpCitemKindSchema.getCurrency(),
                                                    strPolicyCurrency,
                                                    prpCitemKindSchema.getStartDate());                                       
         dblSumPremium = dblSumPremium + dblPremium*dblExchangeRate;  
      }
   }
   prpCfeeSchema = blPolicy.getBLPrpCfee().getArr(0);
   prpCfeeSchema.setPremium(String.valueOf(cmainPremium+dbChgPremium));
   prpCfeeSchema.setPremium1(String.valueOf(cmainPremium+dbChgPremium));
   prpCfeeSchema.setPremium2(String.valueOf(cmainPremium+dbChgPremium));
   prpCfeeSchema.setFlag("U");
   
   prpCplanSchema.setPolicyNo(((PrpLendorDto)prpLendorDtoList.get(0)).getPolicyNo());
   prpCplanSchema.setSerialNo(Integer.toString(Integer.parseInt(((PrpCplanSchema)(blPolicy.getBLPrpCplan().getArr(blPolicy.getBLPrpCplan().getSize()-1))).getSerialNo())+1));
   
   prpCplanSchema.setPayNo("1");
   prpCplanSchema.setPayReason("P72");
   prpCplanSchema.setPlanDate(prpLcompensateDto.getUnderWriteEndDate().toString());
   prpCplanSchema.setCurrency(strCurrency);
   prpCplanSchema.setPlanFee(String.valueOf(dbChgPremium));
   prpCplanSchema.setDelinquentFee(String.valueOf(dbChgPremium));
   prpCplanSchema.setFlag("I");
   prpCplanSchema.setPlanStartDate(prpLcompensateDto.getUnderWriteEndDate().toString());
   blPolicy.getBLPrpCplan().setArr(prpCplanSchema);
   
   
   //����cmain�ı���
System.out.println("����ǰ��������"+blPolicy.getBLPrpCmain().getArr(0).getSumPremium());
   blPolicy.getBLPrpCmain().getArr(0).setSumPremium(String.valueOf(cmainPremium+dbChgPremium));
System.out.println("���պ󱣵�����"+blPolicy.getBLPrpCmain().getArr(0).getSumPremium());
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
   System.out.println("----����������¼��ʼ---");
    System.out.println("blPolicy=="+blPolicy.getBlPrpCitemKindAgri().getSize());
       System.out.println("blPolic*********="+blPolicy.getBLPrpCitemKind().getSize());
   blEndorse.evaluateFromPolicyToEndor(blPolicyOld,blPolicy);
      System.out.println("blEndorse=="+blEndorse.getBlPrpPitemKindAgri().getSize());
          System.out.println("blEndorse=="+blEndorse.getBlPrpPitemKindAgri().getSize());
   System.out.println("----����������¼����---");
   //����cmain,pmain
   System.out.println("----�������㿪ʼ---");
   blEndorse.webAfterCal(blPolicy); 
   System.out.println("----�����������---");
   //����������Ч���ڡ���������
   //Ĭ����Ч����Ϊ����������ڵĵ�2��
   prpPheadSchema = blEndorse.getBLPrpPhead().getArr(0);
   prpPheadSchema.setCompensateNo(strCompensateNo);
   blEndorse.getBLPrpPhead().initArr();
   blEndorse.getBLPrpPhead().setArr(prpPheadSchema);
   iEndorsetimes = Integer.parseInt(blPolicy.getBLPrpCmain().getArr(0).getEndorseTimes());
   iEndorsetimes = iEndorsetimes + 1;
   blPolicy.getBLPrpCmain().getArr(0).setEndorseTimes(""+iEndorsetimes);
   //���ɳ����������
   System.out.println("----�������Ŀ�ʼ-"+blPolicy.getBLPrpCmain().getArr(0).getRiskCode());
   //blEndorse.generatePtext(blPolicy);
   //��ʾ����
   System.out.println("----�������Ľ���---");
   //strPtext=blEndorse.getBLPrpPtext().getEndorseText();
   strPtext = registContext+"\n    �ʲ��ձ��ѣ�"+dbChgPremium+"Ԫ��";
   session.putValue("Policy",blPolicy);
      System.out.println("blEndorse=="+blEndorse.getBlPrpPitemKindAgri().getSize());
   session.putValue("Endorse",blEndorse);
   System.out.println("over");
   EndorDto endorDto =(EndorDto)request.getAttribute("endorDto");
   ArrayList endorList = endorDto.getPrpLendorList();
   ArrayList endorNewList = new ArrayList();
   Iterator endorLists = endorList.iterator();
   while(endorLists.hasNext()){
      PrpLendorDto prpLendorDto = new PrpLendorDto();
   	  prpLendorDto = (PrpLendorDto) endorLists.next();
   	  PrpLendorDto prpLendorDtoTemp = new PrpLendorDto();
   	  
   	  
   	     prpLendorDtoTemp.setEndorseNo(strBizNo);
   	     prpLendorDtoTemp.setClaimNo(prpLendorDto.getClaimNo());
   	     prpLendorDtoTemp.setCompensateNo(prpLendorDto.getCompensateNo());
   	     prpLendorDtoTemp.setPolicyNo(prpLendorDto.getPolicyNo());
   	     prpLendorDtoTemp.setItemKindNo(prpLendorDto.getItemKindNo());
   	     prpLendorDtoTemp.setItemCode(prpLendorDto.getItemCode());
   	     prpLendorDtoTemp.setItemName(prpLendorDto.getItemName());
   	     prpLendorDtoTemp.setKindCode(prpLendorDto.getKindCode());
   	     prpLendorDtoTemp.setKindName(prpLendorDto.getKindName());
   	     prpLendorDtoTemp.setCurrency(prpLendorDto.getCurrency());
   	     prpLendorDtoTemp.setEndorAmount(prpLendorDto.getEndorAmount());
   	     prpLendorDtoTemp.setInputDate(prpLendorDto.getInputDate());
   	     prpLendorDtoTemp.setFlag(prpLendorDto.getFlag());
   	     prpLendorDtoTemp.setEndorType(prpLendorDto.getEndorType());
   	     endorNewList.add(prpLendorDtoTemp);
   	  
   }
   endorDto.setPrpLendorList(endorNewList);
   UIEndorAction uiEndorAction = new UIEndorAction();
   uiEndorAction.save(endorDto);
   session.setAttribute("endorDto",endorDto);
%>

<script language=javascript>
  //װ�ش���
  function loadForm()
  {
    fm.oldPtext.value = '<%=Str.encode(strPtext)%>';
    fm.EndorType.value = '<%=strEndorType%>';        
  }
</script>
