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
 * ũ��ƽ̨ ��ʱ�����Զ��ϴ���
 * @author CDB
 * 
 */
public class UIAGRIZYClaimUploadFacade extends Action{
	public String orderTimeTask() throws Exception {
		Date S = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//����ʼʱ��
		String sTime = sdf1.format(S);
		String startTime = AppConfig.get("sysconst.STARTDATE");//��ʼʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String deathTime = sdf.format(date);//��ǰʱ��
		String dataType = "2";//��������
		String requestType="1";//��������
		String msg = "";//������Ϣ
		String uploadDate = sTime.substring(0,10);//�ϴ�����
		int mount = 0;
		String listSize = "";//�ϴ�����
  	    UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
  	    BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
  	    DbPool controlDBpool = new DbPool();
		try{
			try{
			controlDBpool.open(AppConfig.get("sysconst.DBJNDI"));
			//��ʼ����
			controlDBpool.beginTransaction();
			String sql = "insert into AGRITIMETASKCONTROL (THEMENAME, flag) values ('claim','1')";
		    controlDBpool.executeUpdate(sql);
		    controlDBpool.commitTransaction();
		  } catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			controlDBpool.rollbackTransaction();
			throw e;
		  } finally{
			//�ر����ݿ�����
			controlDBpool.close();
		  }
			    try{
				   //������������ֲ�����������ϴ��ӿ�
			    	 utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Claim_ListSize", 1);
			    	 listSize = utiPlatConfigRuleDto.getRule();
			    	 mount = Integer.parseInt(listSize);
					 msg += "������Ϣ:"+BLAGRIZYClaimUploadAction.getInstance().autoClaimUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
			    }catch(Exception e){
				   e.printStackTrace();
			    }
				try{
					//������������ֲ��ע��/���⣨�����������ϴ��ӿ�
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Cancel_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
				    msg += "ע��/������Ϣ:"+BLAGRIZYCancelUploadAction.getInstance().autoCancelUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					//������������ֲ��Ԥ�ⰸ�����ϴ��ӿ�
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Prepaid_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
					msg += "Ԥ�ⰸ��Ϣ:"+BLAGRIZYPrepaidUploadAction.getInstance().autoPrepaidUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				try{
					//������������ֲ���ⰸ�����ϴ��ӿ�
					utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Case_ListSize", 1);
			    	listSize = utiPlatConfigRuleDto.getRule();
			    	mount = Integer.parseInt(listSize);
					msg += "�ⰸ��Ϣ:"+BLAGRIZYCaseUploadAction.getInstance().autoCaseUpload(startTime,deathTime,dataType,mount,requestType)+"</br>";
				}catch(Exception e){
					e.printStackTrace();
				}
				
				Date ddd = new Date();
				String eTime = sdf1.format(ddd);//�������ʱ��
				//�洢�ϴ�ʱ��
				DbPool dbpool = new DbPool();
				  try {
					dbpool.open(AppConfig.get("sysconst.DBJNDI"));
					//��ʼ����
					dbpool.beginTransaction();
					String sql = "insert into uploaddateinfo (UPLOADDATE, THEMENAME, STARTTIME, ENDTIME)" +
						" values (to_date('"+uploadDate+"', 'yyyy-mm-dd'),'claim',to_date('"+sTime+"', 'yyyy-mm-dd hh24:mi:ss'),to_date('"+eTime+"', 'yyyy-mm-dd hh24:mi:ss'))";
				    dbpool.executeUpdate(sql);
				    dbpool.commitTransaction();
				  } catch (Exception e) {
					e.printStackTrace();
					//�ع�����
					dbpool.rollbackTransaction();
				  } finally{
					//�ر����ݿ�����
					dbpool.close();
				  }
				  try {
						controlDBpool.open(AppConfig.get("sysconst.DBJNDI"));
						//��ʼ����
						controlDBpool.beginTransaction();
						String sql = "delete from AGRITIMETASKCONTROL WHERE THEMENAME='claim' AND flag='1'";
					    controlDBpool.executeUpdate(sql);
					    controlDBpool.commitTransaction();
					  } catch (Exception e) {
						e.printStackTrace();
						//�ع�����
						controlDBpool.rollbackTransaction();
					  } finally{
						//�ر����ݿ�����
						controlDBpool.close();
					  }

		}catch(Exception ee){
			ee.printStackTrace();
		}
		return msg;
	}
}
