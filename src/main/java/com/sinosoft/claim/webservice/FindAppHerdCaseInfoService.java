package com.sinosoft.claim.webservice;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 驻点员App案件查询接口（养殖险）
 * @author CDB
 *
 */
public class FindAppHerdCaseInfoService {
	public ResidentAppRegistInfor findAppHerdCaseInfoList(String registNo,String claimNo,String compensateNo,String riskCode,String areaCity,String areaTown,String startReportDate,String endReportDate,String userCode,int intPageNum, int intPageCount) throws Exception{
		ResidentAppRegistInfor residentAppRegistInfor = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		String strWhere ="";
		String registNumber = null;
		String compensateNumber= null;
		ArrayList<ResidentAppRegistInforList> residentAppRegistInfoList = new ArrayList<ResidentAppRegistInforList>();
		Collection collection1 = null;
		Collection collection2 = null;
		Collection collection3 = null;
		int intStartNum = 0;
		int intEndNum = 0;

		intStartNum = (intPageNum - 1) * intPageCount;
		intEndNum = intPageNum * intPageCount;
	    if(intPageNum<1)
	    {
		   return null;
	    }
	    
	    if(intPageCount<1)
	    {
		   return null;
	    }
	    if(!"32".equals(riskCode.substring(0, 2)))
	    {
	    	return null;
	    }
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
			if(registNo != null && !registNo.trim().equals(""))
			{
				strWhere += " from prplregist r , prpcmain m where  r.registno='"+registNo+"' and r.policyno=m.policyno";
				bufsql.append(strWhere);
			}
			else if(claimNo != null && !claimNo.trim().equals(""))
			{
				strWhere += " from prplclaim c , prplregist r where c.claimno='"+claimNo+"'  and r.registno=c.registno";
				bufsql.append(strWhere);
			}
			else if(compensateNo != null && !compensateNo.trim().equals(""))
			{
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
			    	throw new Exception("险种为必录条件，不可为空!");
			    }
			    if(areaCity != null && !areaCity.trim().equals(""))
			    {
					bufsql.append("and m.businesscity = '"+areaCity+"' ");
			    }else{
			    	throw new Exception("地区（乡镇）为必录条件，不可为空!");
			    }
			    if(areaTown != null && !areaTown.trim().equals(""))
			    {
			    	bufsql.append("and m.businessarea = '"+areaTown+"' ");
			    }else{
			    	//return null;
			    }
                if((startReportDate != null && !startReportDate.trim().equals(""))){
                	bufsql.append(" and r.reportdate >= date'"+startReportDate+"' ");
                }
                if((endReportDate != null && !endReportDate.trim().equals(""))){
                	bufsql.append(" and r.reportdate <= date'"+endReportDate+"' ");
                }
			}
			 bufsql.append(") T Where RowNum<=" + intEndNum + ") Where LineNum>"+ intStartNum );
			 System.err.println("~~~~~~"+bufsql.toString());
			resultSet = dbManager.executeQuery(bufsql.toString());
			ResidentAppRegistInforList residentAppRegistInfoListinfo = null;
			while(resultSet.next()){
				residentAppRegistInfoListinfo = new ResidentAppRegistInforList();
				registNumber = dbManager.getString(resultSet, 1);
				residentAppRegistInfoListinfo.setRegistNo(registNumber);//报案号
				residentAppRegistInfoListinfo.setPolicyNo(dbManager.getString(resultSet, 2));//保单号
				residentAppRegistInfoListinfo.setInsuredName(dbManager.getString(resultSet, 3));//被保险人姓名
				residentAppRegistInfoListinfo.setRiskCode(dbManager.getString(resultSet, 4));//险种
				residentAppRegistInfoListinfo.setDamageAreaCode(dbManager.getString(resultSet, 5));//出险地点
				residentAppRegistInfoListinfo.setDamageStartDate(dbManager.getDateTime(resultSet, 9).toString());//出险时间
				residentAppRegistInfoListinfo.setDamageCode(dbManager.getString(resultSet, 7));//出险原因
				residentAppRegistInfoListinfo.setDamageName(dbManager.getString(resultSet, 8));//出险原因中文说明
				residentAppRegistInfoListinfo.setRegistTime(dbManager.getDateTime(resultSet, 6).toString());//报案时间
				residentAppRegistInfoList.add(residentAppRegistInfoListinfo);
			}
			ResidentAppRegistInforList[] residentAppRegistBack = new ResidentAppRegistInforList[residentAppRegistInfoList.size()];
			for(int i = 0;i<residentAppRegistInfoList.size();i++){
				residentAppRegistBack[i] = residentAppRegistInfoList.get(i);
				String registnum=residentAppRegistInfoList.get(i).getRegistNo();
				String conditions1="1=1 And registno = '"+registnum+"' And logno = (select max(logno)from swflog where registno = '"+registnum+"')";
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
				String conditions2="registno = '"+registnum+"'";
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
					String[] strArray=new String[list2.size()];
					int[] strBrray=new int[list2.size()];
					Double[] strCrray=new Double[list2.size()];
					int[] strDrray=new int[list2.size()];
					Double[] strErray=new Double[list2.size()];
					Double[] strFrray=new Double[list2.size()];
					String[] strGrray=new String[list2.size()];
					Double[] strHrray=new Double[list2.size()];
					Double[] strIrray=new Double[list2.size()];
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
						//if(riskCode!=null && riskCode.trim().equals("3224") && riskCode.trim().equals("3228")){
						if(riskCode!=null && riskCode.trim().equals("3224") ){
							strGrray[u]=prpLcompensateDto.getClaimRelationNo();
						}
						if(riskCode!=null && !riskCode.trim().equals("") && (riskCode.equals("3220")||
								riskCode.equals("3202")||riskCode.equals("3223")||riskCode.equals("3234")||riskCode.equals("3225")||riskCode.equals("3236")
								||riskCode.equals("3227")||riskCode.equals("3233")||riskCode.equals("3239")||riskCode.equals("3240"))){
							strGrray[u]=prpLcompensateDto.getCompensateNo();
						}
					}
					for(int v=0;v<list2.size();v++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(v);
						strHrray[v]=prpLcompensateDto.getKillQuantity();
					}
					for(int w=0;w<list2.size();w++){
						PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)list2.get(w);
						strIrray[w]=prpLcompensateDto.getDeathQuantity();
					}
					residentAppRegistBack[i].setCompensateNo(strArray);
					residentAppRegistBack[i].setTimes(strBrray);
					residentAppRegistBack[i].setLossesNumber(strCrray);
					residentAppRegistBack[i].setDamageInsured(strDrray);
					residentAppRegistBack[i].setSumPaid(strErray);
					residentAppRegistBack[i].setSumThisPaid(strFrray);
					residentAppRegistBack[i].setSettleListCode(strGrray);
					residentAppRegistBack[i].setKillQuantity(strHrray);
					residentAppRegistBack[i].setDeathQunatity(strIrray);
				}
				
			}
			residentAppRegistInfor = new ResidentAppRegistInfor();
			residentAppRegistInfor.setResidentAppRegistInforList(residentAppRegistBack);
		}catch(Exception e){
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return residentAppRegistInfor;
		
	}
}
