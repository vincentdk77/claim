package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class CompensateGenerateImplCompelViewHelper extends CompensateGenerateViewHelper {
	private static Log logger = LogFactory.getLog(CompensateGenerateImplCompelViewHelper.class);
	private static CompensateGenerateViewHelper compensateGenerateViewHelper= new CompensateGenerateImplCompelViewHelper();
	private CompensateGenerateImplCompelViewHelper(){
		//禁止构造，通过getInstance()获得实例。
	}
	public static CompensateGenerateViewHelper getInstance(){
		return compensateGenerateViewHelper;
	}	
	public void compensateGenerate(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws UserException, Exception {
		CompensateData compensateData = new CompensateData();
		
		compensateDto.setPrpLctextDtoDtoList(new ArrayList());
		
		String claimNo = compensateDto.getPrpLcompensateDto().getClaimNo();
		compensateDto.setPrpLclaimDto(UIClaimAction.getInstance().findByPrimaryKey(claimNo).getPrpLclaimDto());
		
		ReportForCompelB(httpServletRequest, compensateDto,compensateData);				
		
		PrpLctextDto prpLctextDto = new PrpLctextDto();
		prpLctextDto.setPrpLctextList(compensateData.prpLctextlist);
		httpServletRequest.setAttribute("prpLctextDto", prpLctextDto);
		
	}
	
	public void ReportForCompelB(HttpServletRequest httpServletRequest, CompensateDto compensateDto,CompensateData compensateData)throws UserException,Exception{
		
		PrpLlossDto prpLlossDto = new PrpLlossDto();
		
		
		//限额
		double propLimit  = 0;    //财产限额
		double medicLimit = 0;    //医疗限额
		double deathLimit = 0;    //死亡残疾限额
		double dbChargeRealPay=0;  //记入赔款费用 wealthTitle
		String duty = httpServletRequest.getParameter("prpLcompensateIndemnityDuty");
		String[] StrPropLimit = httpServletRequest.getParameterValues("wealth");
		String[] strMedicLimit = httpServletRequest.getParameterValues("medical");
		String[] strDeathLimit = httpServletRequest.getParameterValues("diedeformity");
		propLimit =Double.parseDouble(StrPropLimit[4]);
		medicLimit =Double.parseDouble(strMedicLimit[4]);
		deathLimit =Double.parseDouble(strDeathLimit[4]);
		
		
		int licensenoNumber = 0;
		int personcount = 0;
		int textlosscount = 0;
		int textpersoncount = 0;
		int j = 0;
		int intpropflag = 0;
		String[] arrKindCode = new String[20];
		String[] arrLicenseNo = new String[20];
		String[] arrKindCodePerson = new String[20];
		String[] arrPersonNo = new String[20];
		String[] arrPersonName = new String[20];
		String[] arrFamilyName = new String[20];
		String[] arrLossName = new String[20];
		String[] arrFeeReport = {};
		String strCompensateNo = compensateDto.getPrpLcompensateDto().getCompensateNo();
		String lineText = "";
		int      lineNumber=1;
		int      propindex=0;
		int      proptitileindex=0;
		double dbtempSumloss = 0;
		double dbtempSumRest = 0;
		double dbpropall=0;
		double dbnoDutyall=0;
		double dbnoInsPall=0;
		double dbnoInsMall=0;
		double dbnoInsDall=0;
		
		HashMap mybackupvalue= new HashMap();		
		String  propname="车辆";
		String[] lineReportText ={"财产损失：",
				"核定赔偿金",
				"",
				"＋(伤亡残疾费用－强三伤亡残疾限额))×事故责任比例",
				"赔偿限额：",
				"实赔金额＝（财产赔款金额＋医疗赔款金额＋死亡伤残赔款金额）",//LYM
		};
		int    ireport=0;
		
		
		PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
		for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
			prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
			for (j = 1; j <= licensenoNumber; j++) {
				if (arrKindCode[j].indexOf(prpLlossDto.getKindCode()) < 0&& 
						prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					arrKindCode[j] = arrKindCode[j].trim() + prpLlossDto.getKindCode();
				if (prpLlossDto.getLicenseNo().equals(arrLicenseNo[j].trim()))
					break;
			}
			if (j > licensenoNumber && prpLlossDto.getLicenseNo() != null && prpLlossDto.getLicenseNo().length() > 0) {
				licensenoNumber++;
				arrLossName [licensenoNumber] = prpLlossDto.getLossName();
				arrLicenseNo [licensenoNumber] = prpLlossDto.getLicenseNo();
				arrKindCode  [licensenoNumber] = prpLlossDto.getKindCode();
			}
			if ((prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
					&& prpLlossDto.getLossName() != null && prpLlossDto.getKindCode().equals("BZ"))
				intpropflag = 1;
		}
		
		for(int i=0; i<compensateDto.getPrpLnodutyLossDtoList().size(); i++)
		{
			PrpLnodutyLossDto prpLnodutyLossDto = (PrpLnodutyLossDto)compensateDto.getPrpLnodutyLossDtoList().get(i);
			if(prpLnodutyLossDto.getPaidType().equals("noDuty"))
			{
				dbnoDutyall += prpLnodutyLossDto.getRealPaid();
			}
			else if(prpLnodutyLossDto.getPaidType().equals("noInsP"))
			{
				dbnoInsPall += prpLnodutyLossDto.getRealPaid();
			}
			else if(prpLnodutyLossDto.getPaidType().equals("noInsM"))
			{
				dbnoInsMall += prpLnodutyLossDto.getRealPaid();
			}
			else if(prpLnodutyLossDto.getPaidType().equals("noInsD"))
			{
				dbnoInsDall += prpLnodutyLossDto.getRealPaid();
			}
			
		}
		for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
			prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
			for (j = 1; j <= personcount; j++) {
				if (arrKindCodePerson[j].indexOf(prpLpersonLossDto.getKindCode()) < 0
						&& String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					arrKindCodePerson[j] = arrKindCodePerson[j].trim() + prpLpersonLossDto.getKindCode();
				if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j].trim()))
					break;
			}
			if (j > personcount) {
				personcount++;
				arrKindCodePerson   [personcount] = prpLpersonLossDto.getKindCode();
				arrPersonNo     [personcount] = String.valueOf(prpLpersonLossDto.getPersonNo());
				arrPersonName [personcount] = prpLpersonLossDto.getPersonName();
				arrFamilyName [personcount] = prpLpersonLossDto.getFamilyName();
			}
		}
		List strLctextList = new ArrayList();
		//财产部分--------------------------------------
		if(compensateDto.getPrpLchargeDtoList().size()>0  ){		
			for (int k = 0; k < compensateDto.getPrpLchargeDtoList().size(); k++) {  //费用累加;
				PrpLchargeDto  prpLchargeDto =(PrpLchargeDto) compensateDto.getPrpLchargeDtoList().get(k);
				if ("BZ".equals(prpLchargeDto.getKindCode()) && "03".equals(prpLchargeDto.getChargeCode())) {
					dbChargeRealPay += prpLchargeDto.getSumRealPay();
				}
				
			}
			
		}
		if(compensateDto.getPrpLlossDtoList().size()>0  ){		
			for (int i = 1; i <= licensenoNumber; i++) {
				ireport=0;
				if (arrKindCode[i].indexOf("BZ") < 0)	continue;
				if (lineNumber==1)
					strLctextList.add(lineReportText[ireport]);
				lineNumber++;
				ireport++;
				if (!arrLossName [i].trim().equals(propname)) {
					lineText = space(4) +"财物:("+ arrLossName [i].trim()+")";
				} else {
					lineText = space(4) +propname+"("+ arrLicenseNo[i].trim() + "号车"+")";  
				}
				mybackupvalue.put("proptitle"+proptitileindex,propname+"("+ arrLicenseNo [i].trim()+")"+"核定赔偿金");			
				proptitileindex++;
				strLctextList.add(lineText);
				
				lineText = space(4) + lineReportText[ireport];  //核定赔偿金=
				ireport++;
				lineText +="=";
				textlosscount++;//还不清楚这个点是干什么髟的
				
				for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
					if (prpLlossDto.getKindCode().equals("BZ") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
						if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {
							strLctextList.add(lineText);
							lineText = space(17) + prpLlossDto.getFeeTypeName() + "＋";
						} else {
							lineText += prpLlossDto.getFeeTypeName() + "＋";
						}
					}
				}
				lineText = SubtractDesignate(lineText,"＋");						
				lineText +=lineReportText[ireport];//到残值那步了,暂时以空格替代 ireport=2  第三行
				
				ireport++;					
				strLctextList.add(lineText);  
				dbtempSumRest=0;
				dbtempSumloss=0;
				
				lineText = space(16) + "=";
				for (j = 0; j < compensateDto.getPrpLlossDtoList().size(); j++) {  //财产累加;
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(j);
					if (prpLlossDto.getKindCode().equals("BZ") && prpLlossDto.getLicenseNo().equals(arrLicenseNo[i])) {
						//dbtempSumRest+=prpLlossDto.getSumRest(); //不考虑残值 LYM
						dbtempSumloss+=prpLlossDto.getSumDefPay();  //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
						if (ExceedFormat(lineText, prpLlossDto.getFeeTypeName().length() + 2)) {
							strLctextList.add(lineText);
							lineText = space(17) + formatPay(prpLlossDto.getSumDefPay()) + "＋";  //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
						} else {
							lineText += formatPay(prpLlossDto.getSumDefPay()) + "＋"; //原来取Sumloss,现在取核定赔偿SumDefPay  LYM
						}
					}
				}
				
				
				
				lineText = SubtractDesignate(lineText,"＋");						
				//			lineText += CombinationBracket(lineText,")");						
				//lineText +="－"+formatPay(dbtempSumRest);   //不考虑残值 LYM
				strLctextList.add(lineText);  //第四行
				lineText = space(16) + "=" + formatPay(dbtempSumloss) + "元"; //不考虑残值 LYM
				dbpropall+=dbtempSumloss; //不考虑残值 LYM
				mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss)); //不考虑残值 LYM
				propindex++;
				strLctextList.add(lineText);
				
			}
			
			
			
			
			
			lineText="";
			lineNumber=1;
			dbtempSumRest=0;
			dbtempSumloss=0;
			
			if (intpropflag == 1) {
				textlosscount++;
				for (int i = 0; i < compensateDto.getPrpLlossDtoList().size(); i++) {
					prpLlossDto = (PrpLlossDto) compensateDto.getPrpLlossDtoList().get(i);
					if (prpLlossDto.getKindCode().equals("BZ")
							&& (prpLlossDto.getLicenseNo() == null || prpLlossDto.getLicenseNo().length() == 0)
							&& prpLlossDto.getLossName() != null) {
						lineText = space(4) + "财物:" + prpLlossDto.getLossName();
						strLctextList.add(lineText);					
						mybackupvalue.put("proptitle"+proptitileindex,prpLlossDto.getLossName()+"核定赔偿金");			
						proptitileindex++;
						lineText = space(4) + lineReportText[1];
						lineText +="=";
						lineText += prpLlossDto.getFeeTypeName() ;
						lineText +=lineReportText[2];	
						strLctextList.add(lineText);																								
						//dbtempSumRest=prpLlossDto.getSumRest();
						dbtempSumloss=prpLlossDto.getSumDefPay();
						lineText = space(16) + "=";					
						lineText +=formatPay(dbtempSumloss);//不考虑残值
						strLctextList.add(lineText);														
						lineText = space(16) + "=" + formatPay(dbtempSumloss) + "元"; //不考虑残值
						strLctextList.add(lineText);
						dbpropall+=dbtempSumloss;		 //不考虑残值			
						mybackupvalue.put("prop"+propindex,formatPay(dbtempSumloss));//不考虑残值
						propindex++;
					}
				}}
			lineText = space(4) + "财产总核定赔偿金";
			lineText +="=";			
			for(int jj=0;jj<proptitileindex;jj++){
				lineText +=mybackupvalue.get("proptitle"+jj).toString()+"＋"	;
			}
			lineText =SubtractDesignate(lineText, "＋");	
			if ( dbChargeRealPay!=0 && compensateDto.getPrpLlossDtoList().size()>0){
				lineText = lineText + " +  施救费用 " ;
			}
			
			strLctextList.add(lineText);			
			lineText = space(16) + "=";					
			for(int jj=0;jj<propindex;jj++){
				lineText +=mybackupvalue.get("prop"+jj).toString()+"＋"	;
			}
			lineText =SubtractDesignate(lineText, "＋");
			if ( dbChargeRealPay!=0){
				lineText = lineText + " + " + dbChargeRealPay ;  //加施救费
				dbpropall +=dbChargeRealPay ;
			}
			
			strLctextList.add(lineText);
			lineText = space(16) + "=" + formatPay(dbpropall ) + "元";  //得加上施救费,暂时写死100,这里100应包含到dbpropall
			strLctextList.add(lineText);  //  财产总核定赔偿金zheyihang 
			if (( dbpropall) > propLimit){
				lineText = space(4)	+ " 因核定赔偿金超过财产赔偿限额("+ formatPay(propLimit)+"元)，所以 ：";
				strLctextList.add(lineText);
				lineText = space(4) + "财产赔款金额＝财产赔偿限额";
				lineText += "=" + formatPay(propLimit) + "元";  //得加上施救费,暂时写死100 
				dbpropall = propLimit ; //
			}else {
				lineText = space(4) + "财产赔款金额＝财产核定赔偿金";
				lineText += "=" + formatPay(dbpropall ) + "元";  //得加上施救费,暂时写死100
			}
			
			strLctextList.add(lineText);
		}//财产部分---end-----下面是只有施救费的情况-----------------------------------------
		else if (compensateDto.getPrpLlossDtoList().size()<1 && compensateDto.getPrpLchargeDtoList().size()>0  ){
			strLctextList.add(lineReportText[ireport]);
			lineText =space(4)+"核定赔偿金 = 施救费" ;
			strLctextList.add(lineText);
			lineText = space(14) +" =" + formatPay(dbChargeRealPay) +"元";
			strLctextList.add(lineText);
			dbpropall =dbChargeRealPay;
			if (( dbpropall) > propLimit){
				lineText = space(4)	+ " 因核定赔偿金超过财产赔偿限额("+ formatPay(propLimit)+"元)，所以 ：";
				strLctextList.add(lineText);
				lineText = space(4) + "财产赔款金额＝财产赔偿限额";
				lineText += "=" + formatPay(propLimit) + "元";  //得加上施救费,暂时写死100 
				dbpropall = propLimit ; //
			}else {
				lineText = space(4) + "财产赔款金额＝财产核定赔偿金";
				lineText += "=" + formatPay(dbpropall ) + "元";  //得加上施救费,暂时写死100
			}
			
			strLctextList.add(lineText);
		}
		
		
		
		
		String strFeeReport = "";
		String strFeeValueReport = "";
		int persontitleindex=0;
		int personindex=0;
		double dbpersonall=0;
		double dbpersonmedicalall=0;
		double dbpersondeformityall=0;		
		//	double dbpersonmedicallimit=0;		
		dbtempSumRest=0;
		dbtempSumloss=0;
		//ren--------------------------------------------------------
		String medicFlag="N";
		String deathFlag="N";
		if(compensateDto.getPrpLpersonLossDtoList().size()>0){
			for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
				prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
				if ("M".equals(prpLpersonLossDto.getFeeCategory()) ) {
					medicFlag ="Y";
				}
				if ("D".equals(prpLpersonLossDto.getFeeCategory()) ){
					deathFlag ="Y";
				}
				
			}
			
			if ("Y".equals(medicFlag)){ 
				lineText="医疗费用：";
				strLctextList.add(lineText);
				System.out.println("  personcount =="+personcount);
				for (j = 1; j <= personcount; j++) {
					System.out.println("(arrKindCodePerson[j]=="+arrKindCodePerson[j]);
					if (arrKindCodePerson[j].indexOf("B") < 0)
						continue;
					
					
					lineText = space(4) + "出险人员"+ "  "
					+ arrPersonName[j].trim() + "：";
					strLctextList.add(lineText);			
					mybackupvalue.put("persontitle"+persontitleindex,arrPersonName[j].trim()+"核定赔偿金");						
					persontitleindex++;
					textpersoncount++;
					for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
						prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
						if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])
								&&prpLpersonLossDto.getFeeCategory().equals("M")) {
							strFeeReport +=prpLpersonLossDto.getLiabDetailName();
							strFeeReport +="＋";
							strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());//LYM
							strFeeValueReport+="＋";
							//dbtempSumRest+=prpLpersonLossDto.getSumRest(); //暂时不要残值 LYM
							dbtempSumloss+=	prpLpersonLossDto.getSumDefPay();//LYM
							
						}
					}
					strFeeReport  = space(4) + lineReportText[1]+"="+strFeeReport;
					strFeeValueReport= space(16) + "="+strFeeValueReport;					
					
					if (StringUtils.getBytesLength(strFeeReport) > 60) {
						arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
						lineText = arrFeeReport[0];
						strLctextList.add(lineText);
						lineText = space(7) + arrFeeReport[1];
					} else {
						lineText = strFeeReport;
					}
					
					lineText = SubtractDesignate(lineText ,"＋");	
					lineText =lineText+lineReportText[2];
					strLctextList.add(lineText);
					if (StringUtils.getBytesLength(strFeeValueReport) > 60) {
						arrFeeReport = (String[]) StringUtils.split(strFeeValueReport, 60);
						lineText = arrFeeReport[0];
						strLctextList.add(lineText);
						lineText = space(7) + arrFeeReport[1];
					} else {
						lineText = strFeeValueReport;
					}
					lineText = SubtractDesignate(lineText ,"＋");
					//lineText =lineText+"－"+formatPay(dbtempSumRest) ;  //暂时不要残值 LYM
					strLctextList.add(lineText);
					lineText= space(16) + "="+formatPay(dbtempSumloss) + "元";  //暂时不要残值 LYM
					strLctextList.add(lineText);
					mybackupvalue.put("person"+personindex,formatPay(dbtempSumloss)); //暂时不要残值 LYM
					dbpersonall+=(dbtempSumloss); //暂时不要残值 LYM
					personindex++;
					strFeeReport="";
					strFeeValueReport="";
					dbtempSumRest =0;
					dbtempSumloss  =	0;			
				}
				lineText = space(4) + "医疗核定赔偿金=";
				for(int jj=0;jj<persontitleindex;jj++){
					lineText +=mybackupvalue.get("persontitle"+jj).toString()+"＋"	;
				}
				lineText =SubtractDesignate(lineText, "＋");			
				strLctextList.add(lineText);			
				lineText = space(16) + "=";							
				for(int jj=0;jj<personindex;jj++){
					lineText +=mybackupvalue.get("person"+jj).toString()+"＋"	;
				}		
				lineText =SubtractDesignate(lineText, "＋");					
				strLctextList.add(lineText);			 
				lineText = space(16) + "=" + formatPay(dbpersonall) + "元";
				
				if (dbpersonall>medicLimit){
					lineText = space(4) + "因医疗核定赔偿金超过医疗费用限额（"+ formatPay(medicLimit)+"元）,所以：";   	
					strLctextList.add(lineText);
					lineText = space(4) + "医疗赔款金额＝医疗费用限额 ";
					lineText += "=" + formatPay(medicLimit) + "元";
					dbpersonmedicalall=medicLimit;
				}
				else {
					lineText = space(4) + "医疗赔款金额＝医疗核定赔偿金 ";
					lineText += "=" + formatPay(dbpersonall) + "元";
					dbpersonmedicalall=dbpersonall;
				}
				
				strLctextList.add(lineText);
			}
			if ("Y".equals(deathFlag)){ 
				//dbpersonmedicalall=dbpersonall;
				strFeeReport = "";
				strFeeValueReport = "";
				persontitleindex=0;
				personindex=0;
				dbpersonall=0;
				dbtempSumRest=0;
				dbtempSumloss=0;
				lineText="死亡伤残费用：";
				strLctextList.add(lineText);
				for (j = 1; j <= personcount; j++) {
					if (arrKindCodePerson[j].indexOf("BZ") < 0)
						continue;
					
					
					lineText = space(4) + "出险人员"+ "  "
					+ arrPersonName[j].trim() + "：";
					strLctextList.add(lineText);			
					mybackupvalue.put("persondeformitytitle"+persontitleindex,arrPersonName[j].trim()+"核定赔偿金");						
					persontitleindex++;
					textpersoncount++;
					for (int i = 0; i < compensateDto.getPrpLpersonLossDtoList().size(); i++) {
						prpLpersonLossDto = (PrpLpersonLossDto) compensateDto.getPrpLpersonLossDtoList().get(i);
						
						if (String.valueOf(prpLpersonLossDto.getPersonNo()).equals(arrPersonNo[j])
								&&prpLpersonLossDto.getFeeCategory().equals("D")) {
							strFeeReport +=prpLpersonLossDto.getLiabDetailName();
							strFeeReport +="＋";
							strFeeValueReport+=formatPay(prpLpersonLossDto.getSumDefPay());  // LYM
							strFeeValueReport+="＋";
							//dbtempSumRest+=prpLpersonLossDto.getSumRest();  //暂时不要残值 LYM
							dbtempSumloss+=	prpLpersonLossDto.getSumDefPay(); // LYM
							
						}
					}
					strFeeReport  = space(4) + lineReportText[1]+"="+strFeeReport;
					strFeeValueReport= space(16) + "="+strFeeValueReport;					
					if (StringUtils.getBytesLength(strFeeReport) > 60) {
						arrFeeReport = (String[]) StringUtils.split(strFeeReport, 60);
						lineText = arrFeeReport[0];
						strLctextList.add(lineText);
						lineText = space(7) + arrFeeReport[1];
					} else {
						lineText = strFeeReport;
					}
					lineText = SubtractDesignate(lineText ,"＋");	
					lineText =lineText+lineReportText[2];
					strLctextList.add(lineText);
					if (StringUtils.getBytesLength(strFeeValueReport) > 60) {
						arrFeeReport = (String[]) StringUtils.split(strFeeValueReport, 60);
						lineText = arrFeeReport[0];
						strLctextList.add(lineText);
						lineText = space(7) + arrFeeReport[1];
					} else {
						lineText = strFeeValueReport;
					}
					lineText = SubtractDesignate(lineText ,"＋");
					//lineText =lineText+"－"+formatPay(dbtempSumRest) ; //暂时不要残值 LYM
					strLctextList.add(lineText);
					lineText= space(16) + "="+formatPay(dbtempSumloss) + "元"; //暂时不要残值 LYM
					strLctextList.add(lineText);
					mybackupvalue.put("persondeformity"+personindex,formatPay(dbtempSumloss)); //暂时不要残值 LYM
					dbpersonall+=(dbtempSumloss); //暂时不要残值 LYM
					personindex++;
					strFeeReport="";
					strFeeValueReport="";
					dbtempSumRest =0;
					dbtempSumloss  =	0;
					
				}
				lineText = space(4) + "死亡伤残核定赔偿金=";
				for(int jj=0;jj<persontitleindex;jj++){
					lineText +=mybackupvalue.get("persondeformitytitle"+jj).toString()+"＋"	;
				}
				lineText =SubtractDesignate(lineText, "＋");			
				strLctextList.add(lineText);			
				lineText = space(16) + "=";							
				for(int jj=0;jj<personindex;jj++){
					lineText +=mybackupvalue.get("persondeformity"+jj).toString()+"＋"	;
				}		
				lineText =SubtractDesignate(lineText, "＋");					
				strLctextList.add(lineText);			 
				lineText = space(16) + "=" + formatPay(dbpersonall) + "元";
				strLctextList.add(lineText);
				
				if (dbpersonall>deathLimit){
					lineText = space(4) + "因死亡伤残核定赔偿金超过死亡伤残限额（"+ formatPay(deathLimit)+"元）,所以：";   	
					strLctextList.add(lineText);
					lineText = space(4) + "死亡伤残赔款金额＝死亡伤残限额 ";
					lineText += "=" + formatPay(deathLimit) + "元";
					dbpersondeformityall = deathLimit;  
				}
				else {
					lineText = space(4) + "死亡伤残赔款金额＝死亡伤残核定赔偿金 ";
					lineText += "=" + formatPay(dbpersonall) + "元";
					dbpersondeformityall =dbpersonall;
				}
				
				strLctextList.add(lineText);			 
			}	//dbpersondeformityall+=dbpersonall;
		} //ren end ----------------------------------------------------------------
		lineReportText[5] ="实赔金额＝(财产赔款金额＋医疗赔款金额＋死亡伤残赔款金额";
		if(compensateDto.getPrpLnodutyLossDtoList().size() > 0)
		{
			if(dbnoDutyall > 0)
			{
				lineText = "无责代赔金额＝无责代赔核定赔偿金额 ";
				strLctextList.add(lineText);	
				lineText = space(14) + "=" + formatPay(dbnoDutyall) + "元";
				strLctextList.add(lineText);
				lineReportText[5] =lineReportText[5]+"＋无责代赔金额";
				if(dbnoInsPall > 0 || dbnoInsMall > 0 ||dbnoInsDall > 0 )
				{
					lineText = "财产无保险代赔金额＝财产无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) + "=" + formatPay(dbnoInsPall) + "元";
					strLctextList.add(lineText);
				
				
					lineText = "医疗无保险代赔金额＝医疗无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) +  "=" + formatPay(dbnoInsMall) + "元";
					strLctextList.add(lineText);	
			
					lineText = "死亡伤残无保险代赔金额＝死亡伤残无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) +  "=" + formatPay(dbnoInsDall) + "元";
					strLctextList.add(lineText);	
					
					lineReportText[5] =lineReportText[5]+"＋财产无保险金额＋医疗无保险金额＋死亡伤残无保险金额";
				}
				lineReportText[5] += ")";
			}
			else
			{
				if(dbnoInsPall > 0 || dbnoInsMall > 0 ||dbnoInsDall > 0 )
				{
					lineText = "财产无保险代赔金额＝财产无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) + "=" + formatPay(dbnoInsPall) + "元";
					strLctextList.add(lineText);
				
				
					lineText = "医疗无保险代赔金额＝医疗无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) +  "=" + formatPay(dbnoInsMall) + "元";
					strLctextList.add(lineText);	
			
					lineText = "死亡伤残无保险代赔金额＝死亡伤残无保险代赔核定赔偿金额 ";
					strLctextList.add(lineText);	
					lineText = space(14) +  "=" + formatPay(dbnoInsDall) + "元";
					strLctextList.add(lineText);	
					
					lineReportText[5] ="实赔金额＝（财产赔款金额＋医疗赔款金额＋死亡伤残赔款金额＋财产无保险金额＋医疗无保险金额＋死亡伤残无保险金额）";
				}
			}
			
			
				
		
		}
		
		
		lineText="本案实赔金额"; ///这里都被写死了
		strLctextList.add(lineText);
		lineText =space(4) +lineReportText[5];
		strLctextList.add(lineText);
		lineText = space(16) + "=(" + formatPay(dbpropall) +"＋"
		+formatPay(dbpersonmedicalall) +"＋"+formatPay(dbpersondeformityall)+"＋";	
		double dball = dbpropall+dbpersonmedicalall+dbpersondeformityall;
		
		if(dbnoDutyall>0)
		{
			lineText = lineText + formatPay(dbnoDutyall) +"+";			
			dball = dball+dbnoDutyall;
		
			if(dbnoInsPall>0 || dbnoInsMall>0 || dbnoInsDall>0)
			{
				lineText = lineText +formatPay(dbnoInsPall)+"＋"+formatPay(dbnoInsMall)+	"＋"+formatPay(dbnoInsDall);
				dball = dball +dbnoInsPall+dbnoInsMall+dbnoInsDall;
			}			
		}
		else
		{
			if(dbnoInsPall>0 || dbnoInsMall>0 || dbnoInsDall>0)
			{
				lineText = lineText +formatPay(dbnoInsPall)+"＋"+formatPay(dbnoInsMall)+"＋"+formatPay(dbnoInsDall);
				dball = dball +dbnoInsPall+dbnoInsMall+dbnoInsDall;
			}	
					
		}
		
				
		lineText = lineText + ")";
		strLctextList.add(lineText);	
		lineText = space(16) + "=" + formatPay(dball) + "元";
		strLctextList.add(lineText);
		int ctextcount = compensateDto.getPrpLctextDtoDtoList().size();
		
		for (Iterator iter = strLctextList.iterator(); iter.hasNext();) {
			lineText = (String) iter.next();
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo(strCompensateNo);
			prpLctextDto.setTextType("1");
			prpLctextDto.setLineNo(ctextcount++);
			prpLctextDto.setContext(lineText);
			prpLctextDto.setFlag("");
			compensateData.prpLctextlist.add(prpLctextDto);
		}
		
	}
	
	
	private static class CompensateData{
		List prpLctextlist = new ArrayList();
	}
	
	
	
	
	private boolean ExceedFormat(String a,int b) {
		int limitline=60;
		if (StringUtils.getBytesLength(a) + b> limitline) {
			return true;
		};
		return false;
	}
	private String  SubtractDesignate(String a,String b) {
		a = a.substring(0, (a.length() - b.length())) ;
		return a;
	}	
}
