package com.sinosoft.claimzy.ui.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts.action.Action;
import com.sinosoft.claimzy.bl.action.BLAGRIZYCancelUploadAction;
import com.sinosoft.claimzy.bl.action.BLAGRIZYCaseUploadAction;
import com.sinosoft.claimzy.bl.action.BLAGRIZYClaimUploadAction;
import com.sinosoft.claimzy.bl.action.BLAGRIZYPrepaidUploadAction;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;
/**
 * 农险平台 定时任务自动上传类
 * @author CDB
 * 
 */
public class UIAGRIZYClaimUploadFacade extends Action{
	public String orderTimeTask() throws Exception {
		Date S = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//任务开始时间
		String sTime = sdf1.format(S);
		String startTime = AppConfig.get("sysconst.STARTDATE");//开始时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String deathTime = sdf.format(date);//当前时间
		String dataType = "2";//数据类型
		String requestType="1";//请求类型
		String msg = "";//返回信息
		String uploadDate = sTime.substring(0,10);//上传日期
		int mount = 0;
		String listSize = "";//上传条数
  	    UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
  	    BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
  	    DbPool controlDBpool = new DbPool();
		try{
			try{
			controlDBpool.open(AppConfig.get("sysconst.DBJNDI"));
			//开始事务
			controlDBpool.beginTransaction();
			String sql = "insert into AGRITIMETASKCONTROL (THEMENAME, flag) values ('claim','1')";
		    controlDBpool.executeUpdate(sql);
		    controlDBpool.commitTransaction();
		  } catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			controlDBpool.rollbackTransaction();
			throw e;
		  } finally{
			//关闭数据库连接
			controlDBpool.close();
		  }
			    try{
				   //中央政策性种植险立案数据上传接口
			    	 utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Claim_ListSize", 1);
			    	 listSize = utiPlatConfigRuleDto.getRule();
			    	 mount = Integer.parseInt(listSize);
					 msg += "立案信息:"+BLAGRIZYClaimUploadAction.getInstance().autoClaimUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
			    }catch(Exception e){
				   e.printStackTrace();
			    }
				try{
					//中央政策性种植险注销/拒赔（立案）数据上传接口
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Cancel_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
				    msg += "注销/拒赔信息:"+BLAGRIZYCancelUploadAction.getInstance().autoCancelUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					//中央政策性种植险预赔案数据上传接口
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Prepaid_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
					msg += "预赔案信息:"+BLAGRIZYPrepaidUploadAction.getInstance().autoPrepaidUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					//中央政策性种植险赔案数据上传接口
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Case_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
					msg += "赔案信息:"+BLAGRIZYCaseUploadAction.getInstance().autoCaseUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				
				Date ddd = new Date();
				String eTime = sdf1.format(ddd);//任务结束时间
				//存储上传时间
				DbPool dbpool = new DbPool();
				  try {
					dbpool.open(AppConfig.get("sysconst.DBJNDI"));
					//开始事务
					dbpool.beginTransaction();
					String sql = "insert into uploaddateinfo (UPLOADDATE, THEMENAME, STARTTIME, ENDTIME)" +
						" values (to_date('"+uploadDate+"', 'yyyy-mm-dd'),'claim',to_date('"+sTime+"', 'yyyy-mm-dd hh24:mi:ss'),to_date('"+eTime+"', 'yyyy-mm-dd hh24:mi:ss'))";
				    dbpool.executeUpdate(sql);
				    dbpool.commitTransaction();
				  } catch (Exception e) {
					e.printStackTrace();
					//回滚事务
					dbpool.rollbackTransaction();
				  } finally{
					//关闭数据库连接
					dbpool.close();
				  }
				  try {
						controlDBpool.open(AppConfig.get("sysconst.DBJNDI"));
						//开始事务
						controlDBpool.beginTransaction();
						String sql = "delete from AGRITIMETASKCONTROL WHERE THEMENAME='claim' AND flag='1'";
					    controlDBpool.executeUpdate(sql);
					    controlDBpool.commitTransaction();
					  } catch (Exception e) {
						e.printStackTrace();
						//回滚事务
						controlDBpool.rollbackTransaction();
					  } finally{
						//关闭数据库连接
						controlDBpool.close();
					  }

		}catch(Exception ee){
			ee.printStackTrace();
		}
		return msg;
	}
}
