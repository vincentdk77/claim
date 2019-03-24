package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.custom.BLCertainLossAction;
import com.sinosoft.claim.bl.action.custom.BLCheckAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcheckAction;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.function.insutil.dto.domain.PrpXPcolDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  �鿱�߼��ַ�
 * <p>Title: ��������鿱</p>
 * <p>Description: ��������鿱facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCheckFacade
{
  /**
   * ����鿱
   * @param checkDto���Զ���鿱����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto) throws SQLException,Exception
  {
    //�������ݿ�������   
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    { new BLCheckAction().save(dbManager,checkDto);
      new BLCertainLossAction().save(dbManager,certainLossDto);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  /**
   * ����鿱
   * @param checkDto���Զ���鿱����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList) throws SQLException,Exception
  {
    //�������ݿ�������   
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    { 
    	for(int i=0;i<checkDtoList.size();i++){
    	new BLCheckAction().save(dbManager,(CheckDto)checkDtoList.get(i));}
    	for(int i=0;i<certainLossDtoList.size();i++){
      new BLCertainLossAction().save(dbManager,(CertainLossDto)certainLossDtoList.get(i));}
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  /**
   * ����鿱/��������
   * @param checkDto���Զ���鿱����
   * @throws SQLException
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {  
  	 //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try 
    {
      new BLCheckAction().save(dbManager,checkDto);
     if (certainLossDto.getPrpLverifyLossDto()!=null&&
	 	(certainLossDto.getPrpLverifyLossDto().getRegistNo()!=null
	 	&&!certainLossDto.getPrpLverifyLossDto().getRegistNo().trim().equals("")
		)){
      new BLCertainLossAction().save(dbManager,certainLossDto);
      	}
       if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
     
      
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
  /**
   * ����鿱/��������
   * @param checkDto���Զ���鿱����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {  
  	 //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try 
    {
    	for(int i=0;i<checkDtoList.size();i++){
      new BLCheckAction().save(dbManager,(CheckDto)checkDtoList.get(i));}
    	for(int i=0;i<certainLossDtoList.size();i++){
     if (((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto()!=null&&
	 	(((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto().getRegistNo()!=null
	 	&&!((CertainLossDto)certainLossDtoList.get(i)).getPrpLverifyLossDto().getRegistNo().trim().equals("")
		)){
      new BLCertainLossAction().save(dbManager,((CertainLossDto)certainLossDtoList.get(i)));
      	}
    	}
    	for(int i=0;i<workFlowDtoList.size();i++){
       if((WorkFlowDto)workFlowDtoList.get(i)!=null){
        new BLWorkFlowAction().deal(dbManager,(WorkFlowDto)workFlowDtoList.get(i));
      }
    	}
      
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
        sqle.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
  }
 
  /**
   * ɾ���鿱
   * @param  checkNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String checkNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLCheckAction().delete(dbManager,checkNo);
      //�ύ����
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //�ع�����
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }

  }
  /**
   * ��ò鿱
   * @param  checkNo
   * @param dbManager  ��������
   * @return �Զ���鿱����
   * @throws SQLException
   * @throws Exception
   */
  public CheckDto findByPrimaryKey(String checkNo) throws SQLException,Exception
  {
    CheckDto checkDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      checkDto = new BLCheckAction().findByPrimaryKey(dbManager,checkNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return checkDto;
  }

  /**
   * �жϲ鿱֪ͨ���Ƿ����
   * @param checkNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String checkNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLCheckAction().isExist(dbManager,checkNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //�ر����ݿ�����
      dbManager.close();
    }
    return exist;
  }

  /**
   * ����������ѯ�鿱������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLcheckAction blPrpLcheckAction = new BLPrpLcheckAction(); 
       checkList = (Collection)blPrpLcheckAction.findByConditions(dbManager,conditions);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return checkList;
  }


  /**
   * �����Ҫ�鿱�ĵ��ȹ���������
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findNewScheduleTaskList(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection checkScheduleList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLCheckAction blCheckAction = new BLCheckAction();
       checkScheduleList = (Collection)blCheckAction.findNewScheduleTaskList(dbManager,conditions);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return checkScheduleList;
  }

  /**
     * ����鿱����
     * @param checkDto���Զ���鿱���ȶ���
     * @throws SQLException
     * @throws Exception
     */
    public void saveSchedule(ScheduleDto scheduleDto) throws SQLException,Exception
    {
      //�������ݿ�������
      DBManager dbManager = new DBManager();
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction();
      try
      {
        new BLCheckAction().saveSchedule(dbManager,scheduleDto);
        //�ύ����
        dbManager.commitTransaction();
      }
      catch(SQLException sqle)
      {
        //�ع�����
        dbManager.rollbackTransaction();
        throw sqle;
      }
      catch(Exception ex)
      {
        //�ع�����
        dbManager.rollbackTransaction();
        throw ex;
      }
      finally
      {
        //�ر����ݿ�����
        dbManager.close();
      }
    }


  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCheckAction blCheckAction = new BLCheckAction();
       checkList = (Collection)blCheckAction.findByQueryConditions(dbManager,conditions,0,0);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return checkList;
  }

  /**
   * ����������ѯ����������Ϣ
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditionsAcci(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLcheckDto prpLcheckDto = null;
     Collection checkList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLCheckAction blCheckAction = new BLCheckAction();
       checkList = (Collection)blCheckAction.findByQueryConditionsAcci(dbManager,conditions,0,0);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return checkList;
  }
  
  //add by zhaolu 20060802 start
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			 BLCheckAction blCheckAction = new BLCheckAction();
			pageRecord = (PageRecord) blCheckAction.findByConditions(
					dbManager, conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  
  
  public PageRecord findByQueryConditionsAcci(String conditions,int pageNo,int recordPerPage) throws Exception
  {
	  DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLCheckAction blCheckAction = new BLCheckAction();
			pageRecord = (PageRecord) blCheckAction.findByConditionsAcci(
					dbManager, conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
  }
  //add b yzhaolu 20060802 end
  
  public void saveClaimLoss(PrpLclaimDto prpLclaimDto,
			ArrayList prpLpropDtoList) throws Exception {
	    // �ܶ�����
	    double sumLoss = 0.0;
	    // ��������������Ϣ(��ɾ�������)
	  	BLPrpLclaimLossFacade blPrpLclaimLossFacade = new BLPrpLclaimLossFacade();
	  	blPrpLclaimLossFacade.deleteByConditions("claimNo = '" + prpLclaimDto.getClaimNo() + "'"); // ɾ������������Ϣ
		for (int i = 0; i < prpLpropDtoList.size(); i++) {
			PrpLclaimLossDto prpLclaimLossDto = new PrpLclaimLossDto();
			PrpLpropDto prpLpropDto = (PrpLpropDto) prpLpropDtoList.get(i);
		
			sumLoss += prpLpropDto.getSumLoss();
			prpLclaimLossDto.setClaimNo(prpLclaimDto.getClaimNo());
			prpLclaimLossDto.setRiskCode(prpLclaimDto.getRiskCode());
			prpLclaimLossDto.setSerialNo(prpLpropDto.getSerialNo()); // �ֻ����
			prpLclaimLossDto.setItemKindNo(prpLpropDto.getItemKindNo());//����������
			prpLclaimLossDto.setKindCode(prpLpropDto.getKindCode());//�ձ����
			prpLclaimLossDto.setItemCode(prpLpropDto.getItemCode());//���������Ŀ����
			prpLclaimLossDto.setCurrency(prpLpropDto.getCurrency());//�ұ�
			prpLclaimLossDto.setInputDate(prpLpropDto.getBuyDate());//��������
			prpLclaimLossDto.setLossFeeType("p");//Ҫ�ֱ������ֱ���������
			prpLclaimLossDto.setFamilyNo(prpLpropDto.getFamilyNo());
			prpLclaimLossDto.setFamilyName(prpLpropDto.getFamilyName());
			prpLclaimLossDto.setSumClaim(sumLoss);//������
			prpLclaimLossDto.setKindLoss(prpLpropDto.getSumDefLoss());//�ձ���ʧ
			prpLclaimLossDto.setItemDetailName(prpLpropDto.getLossItemName());//�����Ŀ��ϸ����	
			//prpLclaimLossDto.setItemCode(prpLpropDto.getLossItemCode());//�����Ŀ��ϸ���
		    blPrpLclaimLossFacade.insert(prpLclaimLossDto);
		}
		
		
		// �޸������ܹ�����
		prpLclaimDto.setSumClaim(sumLoss);
		BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
		blPrpLclaimFacade.update(prpLclaimDto);
	}
}
