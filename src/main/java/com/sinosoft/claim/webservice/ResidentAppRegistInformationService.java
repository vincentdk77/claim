package com.sinosoft.claim.webservice;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.webservice.ResidentAppRegistInfor;
import com.sinosoft.claim.webservice.ResidentAppRegistInforList;
import com.sinosoft.claim.webservice.paymentinformatino.PaymentInfoBackList;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;

import java.util.Collection;
import java.util.Iterator;

/**
 * ResidentAppRegistInformationService案件查询方法
 * @author CDB
 *
 */
public class ResidentAppRegistInformationService {
	public ResidentAppRegistInfor getResidentAppRegistInforList(String registNo,String claimNo,String compensateNo,String riskCode,String areaCity,String areaTown,String startReportDate,String endReportDate,String userCode,int intPageNum, int intPageCount) throws Exception{
		ResidentAppRegistInfor residentAppRegistInfor = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		String strWhere ="";
		String listTable = "";
		String registNumber = null;
		String compensateNumber= null;
		/*String policyNumber =null;
		String insuredName=null;
		String riskCodeNum=null;
		String damageAreaCode=null;
		String caseType=null;
		String settleListCode=null;
		String damageStartDate=null;*/
		ArrayList<ResidentAppRegistInforList> residentAppRegistInfoList = new ArrayList<ResidentAppRegistInforList>();
		Collection collection1 = null;
		Collection collection2 = null;
		Collection collection3 = null;
		int intStartNum = 0;
		int intEndNum = 0;

		intStartNum = (intPageNum - 1) * intPageCount;
		intEndNum = intPageNum * intPageCount;
		/*if(registNo == null || registNo.trim().equals(""))
	    {
		   return null;
	    }
	    if(claimNo == null || claimNo.trim().equals(""))
	    {
		   return null;
	    }*/
		/*if(riskCode == null || riskCode.trim().equals(""))
	    {
		   return null;
	    }
	    if(areaCity == null || areaCity.trim().equals(""))
	    {
		   return null;
	    }
	    if(areaTown == null || areaTown.trim().equals(""))
	    {
		   return null;
	    }*/
	    /*if(startReportDate == null || startReportDate.trim().equals(""))
	    {
		   return null;
	    }
	    if(endReportDate == null || endReportDate.trim().equals(""))
	    {
		   return null;
	    }*/
	    if(intPageNum<1)
	    {
		   return null;
	    }
	    
	    if(intPageCount<1)
	    {
		   return null;
	    }
	    //if((fName == null || fName.trim().equals(""))&&(fCode == null || fCode.trim().equals(""))&&(fIdcard == null || fIdcard.trim().equals("")))
	    //{
	    //	return null;
	    //}
	    if(!"31".equals(riskCode.substring(0, 2)))
	    {
	    	return null;
	    }
	    /*if("3141".equals(riskCode))
	    {
	    	listTable = "planting31settlelist";
	    }
	    else
	    {
	    	listTable ="plantingsettlelist";
	    }*/
		//ArrayList<ResidentAppRegistInforList> residentAppInforList = new ArrayList<ResidentAppRegistInforList>();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			StringBuffer bufsql = new StringBuffer();
			StringBuffer bufsql1 = new StringBuffer();
			StringBuffer bufsql2 = new StringBuffer();
			strWhere = "select registno,policyno,insuredName,riskCode,damageaddress,reportdate,damagecode,damagename,damagestartdate from ( "
				       + "Select RowNum As LineNum,T.* From ( " +
				       "select r.registno as registno,r.policyno as policyno,r.insuredName as insuredName," +
				       "r.riskCode as riskCode,r.damageaddress as damageaddress,r.reportdate as reportdate,"+
				       "r.damagecode as damagecode,r.damagename as damagename,r.damagestartdate as damagestartdate";
					//"from  settlemainlist m, plantingsettlelist p where m.settlelistcode=p.settlelistcode "
					//+ iWherePart
					//") T Where RowNum<=" + intEndNum + ") Where LineNum>"+ intStartNum ;
			//strWhere = "select c.registno,c.claimno,c.policyno,c.insuredName,c.riskCode,c.damageaddress,g.nodename,r.reportdate";
			if(registNo != null && !registNo.trim().equals(""))
			{
				//strWhere = "select c.registno,c.claimno,c.policyno,c.insuredName,c.riskCode,c.damageaddress,c.caseType,r.reportdate" +
				strWhere += " from prplregist r , prpcmain m where  r.registno='"+registNo+"' and r.policyno=m.policyno";
				//strWhere +="and RowNum<=" + intEndNum + ") Where RowNum>"+ intStartNum;
				bufsql.append(strWhere);
			}
			else if(claimNo != null && !claimNo.trim().equals(""))
			{
				//strWhere = "select c.registno,c.claimno,c.policyno,c.insuredName,c.riskCode,c.damageaddress,c.caseType,r.reportdate" +
				strWhere += " from prplclaim c , prplregist r where c.claimno='"+claimNo+"'  and r.registno=c.registno";
				bufsql.append(strWhere);
			}
			else if(compensateNo != null && !compensateNo.trim().equals(""))
			{
				//strWhere = "select c.registno,c.claimno,c.policyno,c.insuredName,c.riskCode,c.damageaddress,c.caseType,r.reportdate" +
				strWhere += " from prplclaim c , prplregist r ,prplcompensate s where s.compensateno='"+compensateNo+"'  and r.registno=c.registno and s.claimno=c.claimno and s.policyno=r.policyno";
				bufsql.append(strWhere);
			}
			else{
				strWhere +=" from prplregist r , prpcmain m   where r.policyno=m.policyno ";
				bufsql.append(strWhere);
				if(riskCode != null && !riskCode.trim().equals(""))
			    {
					bufsql.append("and m.riskcode = '"+riskCode+"' ");
			    }else{
			    	return null;
			    }
			    if(areaCity != null && !areaCity.trim().equals(""))
			    {
					bufsql.append("and m.businesscity = '"+areaCity+"' ");
			    }else{
			    	return null;
			    }
			    if(areaTown != null && !areaTown.trim().equals(""))
			    {
			    	bufsql.append("and m.businessarea = '"+areaTown+"' ");
			    }else{
			    	//return null;
			    }
//				strWhere +=" from prplregist r , prpcmain m   where r.policyno=m.policyno ";
//				bufsql.append(strWhere);
//				bufsql.append("and m.businesscity = '"+areaCity+"' ");
//				bufsql.append("and m.businessarea = '"+areaTown+"' ");
                if((startReportDate != null && !startReportDate.trim().equals("")) && (startReportDate != null && !startReportDate.trim().equals(""))){
				bufsql.append(" and (r.reportdate  between date'");
				bufsql.append(startReportDate);
				bufsql.append("' and date'");
				bufsql.append(endReportDate);
				//bufsql.append("' or r.enddate  between date'");
				//bufsql.append(startReportDate);
				//bufsql.append("' and date'");
				//bufsql.append(endReportDate);
				bufsql.append("')");
                }
                //bufsql.append(")");
			}
			//if(registNo != null && !registNo.trim().equals(""))
			//{
			//	strWhere = "select r.registno,r.claimno,r.policyno,r.insuredName,r.riskCode,r.damageAreaCode,r.caseType,r.settleListCode,r.damageStartDate" +
			//			" from prplregist r where r.registno='" + registNo + "' ";	
			//}
			
			
			//StringBuffer buffsql = new StringBuffer();
			//bufsql.append("select r.registno, ");
			//bufsql.append("r.claimno, ");
			//bufsql.append("r.policyno, ");
			//bufsql.append("r.insuredName, ");
			//bufsql.append("r.riskCode, ");
			//bufsql.append("r.damageAreaCode, ");
			//bufsql.append("r.caseType, ");
			//bufsql.append("r.settleListCode, ");
			//bufsql.append("r.damageStartDate ");
			//bufsql.append("from prplregist r,prpcmain m,prplclaim c");
			//bufsql.append("where m.riskcode = c.riskcode ");
			//bufsql.append("and c.payreftimes = rec.payreftimes ");
			//bufsql.append("and rec.payrefdatetime <>Date'1970-01-01' ");
			//bufsql.append("and a.registno = '"+registNo+"' ");
			  //bufsql.append(strWhere);
			 bufsql.append(") T Where RowNum<=" + intEndNum + ") Where LineNum>"+ intStartNum );
			 //System.out.println("~~~~~~"+bufsql.toString());
			resultSet = dbManager.executeQuery(bufsql.toString());
			ResidentAppRegistInforList residentAppRegistInfoListinfo = new ResidentAppRegistInforList();
			while(resultSet.next()){
				registNumber = dbManager.getString(resultSet, 1);
				//policyNumber=dbManager.getString(resultSet, 2);//
				//insuredName=dbManager.getString(resultSet, 3);//
				//riskCodeNum=dbManager.getString(resultSet, 4);//
				//damageAreaCode=dbManager.getString(resultSet, 5);//
				//damageStartDate=dbManager.getString(resultSet, 6);//
				residentAppRegistInfoListinfo.setRegistNo(registNumber);//报案号
				residentAppRegistInfoListinfo.setPolicyNo(dbManager.getString(resultSet, 2));//保单号
				residentAppRegistInfoListinfo.setInsuredName(dbManager.getString(resultSet, 3));//被保险人姓名
				residentAppRegistInfoListinfo.setRiskCode(dbManager.getString(resultSet, 4));//险种
				residentAppRegistInfoListinfo.setDamageAreaCode(dbManager.getString(resultSet, 5));//出险地点
				residentAppRegistInfoListinfo.setDamageStartDate(dbManager.getDateTime(resultSet, 9).toString());//出险时间
				residentAppRegistInfoListinfo.setDamageCode(dbManager.getString(resultSet, 7));//出险原因
				residentAppRegistInfoListinfo.setDamageName(dbManager.getString(resultSet, 8));//出险原因中文说明
				residentAppRegistInfoListinfo.setRegistTime(dbManager.getDateTime(resultSet, 6).toString());//报案时间
				//System.out.println("$$$$$$$$$$$$$$"+dbManager.getDateTime(resultSet, 6).toString());// .getString(resultSet, 6));
				residentAppRegistInfoList.add(residentAppRegistInfoListinfo);
			}
			ResidentAppRegistInforList[] residentAppRegistBack = new ResidentAppRegistInforList[residentAppRegistInfoList.size()];
			for(int i = 0;i<residentAppRegistInfoList.size();i++){
				residentAppRegistBack[i] = residentAppRegistInfoList.get(i);
				String registnum=residentAppRegistInfoList.get(i).getRegistNo();
				String conditions1="logno = (select max(logno)from swflog where registno = '"+registNumber+"')";
				BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
				collection1 = bLSwfLogFacade.findByConditions(conditions1);
				if(collection1.size()!=0){
					ArrayList list=(ArrayList)collection1;
					for(int j=0;j<list.size();j++){
						SwfLogDto swfLogDto = (SwfLogDto)list.get(j);
						residentAppRegistBack[i].setCaseType(swfLogDto.getNodeName());
					}	
				}else{
					residentAppRegistBack[i].setCaseType("已结案");
				}
				String conditions2="registno = '"+registNumber+"'";
				BLPrpLclaimFacade bLPrpLclaimFacade = new BLPrpLclaimFacade();
				collection2 = bLPrpLclaimFacade.findByConditions(conditions2);
				ArrayList list1=(ArrayList)collection2;
				for(int k=0;k<list1.size();k++){
					PrpLclaimDto prpLclaimDto = (PrpLclaimDto)list1.get(k);
					residentAppRegistBack[i].setClaimNo(prpLclaimDto.getClaimNo());
					String conditions3="claimno = '"+prpLclaimDto.getClaimNo()+"'";
					BLPrpLcompensateFacade bLPrpLcompensateFacade = new BLPrpLcompensateFacade();
					collection3 = bLPrpLcompensateFacade.findByConditions(conditions3);
					ArrayList list2=(ArrayList)collection3;
//					String[] strArray=null;
//					int[] strBrray=null;
//					Double[]strCrray=null;
//					int[] strDrray=null;
//					Double[] strErray=null;
//					Double[] strFrray=null;
//					String[] strGrray=null;
					String[] strArray=new String[list2.size()];
					int[] strBrray=new int[list2.size()];
					Double[] strCrray=new Double[list2.size()];
					int[] strDrray=new int[list2.size()];
					Double[] strErray=new Double[list2.size()];
					Double[] strFrray=new Double[list2.size()];
					String[] strGrray=new String[list2.size()];
					for(int p=0;p<list2.size();p++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(p);
						//residentAppRegistBack[i].setCompensateNo(prpLcompensateDto.getCompensateNo());
						//compensateNumber+=prpLcompensateDto.getCompensateNo();
						//ArrayList<String> arraylist=new ArrayList<String>(list2.size());
						//arraylist.add(prpLcompensateDto.getCompensateNo()+',');
						strArray[p]=prpLcompensateDto.getCompensateNo();
					}
					for(int q=0;q<list2.size();q++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(q);
						strBrray[q]=prpLcompensateDto.getTimes();
					}
					for(int o=0;o<list2.size();o++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(o);
						strCrray[o]=prpLcompensateDto.getLossesNumber();
					}
					for(int r=0;r<list2.size();r++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(r);
						strDrray[r]=(int)prpLcompensateDto.getDamageInsured();
					}
					for(int s=0;s<list2.size();s++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(s);
						strErray[s]=prpLcompensateDto.getSumPaid();
					}
					for(int t=0;t<list2.size();t++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(t);
						strFrray[t]=prpLcompensateDto.getSumThisPaid();
					}
					for(int u=0;u<list2.size();u++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(u);
						strGrray[u]=prpLcompensateDto.getClaimRelationNo();
					}
					residentAppRegistBack[i].setCompensateNo(strArray);
					residentAppRegistBack[i].setTimes(strBrray);
					residentAppRegistBack[i].setLossesNumber(strCrray);
					residentAppRegistBack[i].setDamageInsured(strDrray);
					residentAppRegistBack[i].setSumPaid(strErray);
					residentAppRegistBack[i].setSumThisPaid(strFrray);
					residentAppRegistBack[i].setSettleListCode(strGrray);
				}
				
			}
			residentAppRegistInfor = new ResidentAppRegistInfor();
			residentAppRegistInfor.setResidentAppRegistInforList(residentAppRegistBack);
			
			
			/*bufsql1.append("select nodename from swflog where nodeno = (select max(nodeno)from swflog where registno = '"+registNumber+"') ");
			//buffsql.append("n.payamount, ");
			//buffsql.append("n.thirdpayflag, ");
			//buffsql.append("n.bankaccount ");
			//buffsql.append("from prplpaymain n ");
			//buffsql.append("where n.paymentno= '"+payMentno+"' ");
			resultSet1 = dbManager.executeQuery(bufsql1.toString());
			while(resultSet1.next()){
				caseType=dbManager.getString(resultSet1, 1);
			}
			//while(!resultSet1.next()){
			//	residentAppRegistInfoListinfo.setCaseType("gg");
			//}
			bufsql2.append("select claimno from prplclaim where registno = '"+registNumber+"'");
			resultSet2 = dbManager.executeQuery(bufsql2.toString());
			while(resultSet2.next()){
				residentAppRegistInfoListinfo.setClaimNo(dbManager.getString(resultSet2, 1));//
				residentAppRegistInfoListinfo.setRegistNo(registNumber);//
				residentAppRegistInfoListinfo.setPolicyNo(policyNumber);//
				residentAppRegistInfoListinfo.setInsuredName(insuredName);//
				residentAppRegistInfoListinfo.setRiskCode(riskCodeNum);//
				residentAppRegistInfoListinfo.setDamageAreaCode(damageAreaCode);//
				residentAppRegistInfoListinfo.setCaseType(caseType);//
				residentAppRegistInfoListinfo.setSettleListCode(" ");//
				residentAppRegistInfoListinfo.setDamageStartDate(damageStartDate);//
				residentAppRegistInfoList.add(residentAppRegistInfoListinfo);
			}*/
			
			//数据转换
			/*ResidentAppRegistInforList[] residentAppRegistBack = new ResidentAppRegistInforList[residentAppRegistInfoList.size()];
			for(int i = 0;i<residentAppRegistInfoList.size();i++){
				residentAppRegistBack[i] = residentAppRegistInfoList.get(i);
			}
			residentAppRegistInfor = new ResidentAppRegistInfor();
			residentAppRegistInfor.setResidentAppRegistInforList(residentAppRegistBack);*/
		}catch(Exception e){
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			/*if(resultSet1!=null){
				resultSet.close();
			}
			if(resultSet2!=null){
				resultSet.close();
			}*/
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return residentAppRegistInfor;
		
	}
	
}
