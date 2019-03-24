package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLEndcaseAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLcaseNoAction;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �᰸�߼��ַ�
 * <p>
 * Title: ��������᰸
 * </p>
 * <p>
 * Description: ��������᰸facade
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class BLEndcaseFacade {
    /**
     * ����᰸
     * 
     * @param endcaseDto���Զ���᰸����
     * @throws SQLException
     * @throws Exception
     */
    public void save(EndcaseDto endcaseDto) throws SQLException, Exception {
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //��ʼ����
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().save(dbManager, endcaseDto);
            //�ύ����
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            //�ع�����
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            //�ع�����
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }
    }
    /**
     * ����᰸��������
     * 
     * @param endcaseDto���Զ���᰸����
     * @throws SQLException
     * @throws Exception
     */
    public void save(EndcaseDto endcaseDto, WorkFlowDto workFlowDto) throws SQLException, Exception {
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //��ʼ����
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().save(dbManager, endcaseDto);
            if (workFlowDto != null) {
                new BLWorkFlowAction().deal(dbManager, workFlowDto);
            }
            //�ύ����
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            //�ع�����
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            ex.printStackTrace();
            //�ع�����
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }
    }

    /**
     * ɾ���᰸
     * 
     * @param caseNo
     * @param dbManager ��������
     * @throws SQLException
     * @throws Exception
     */
    public void delete(String caseNo) throws SQLException, Exception {
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //��ʼ����
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().delete(dbManager, caseNo);
            //�ύ����
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            //�ع�����
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            //�ع�����
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }

    }
    /**
     * ��ý᰸
     * 
     * @param caseNo
     * @param dbManager ��������
     * @return �Զ���᰸����
     * @throws SQLException
     * @throws Exception
     */
    public EndcaseDto findByPrimaryKey(String caseNo, String claimNo, String certiNo, String certiType)
            throws SQLException, Exception {
        EndcaseDto endcaseDto = null;
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            endcaseDto = new BLEndcaseAction().findByPrimaryKey(dbManager, caseNo, claimNo, certiNo, certiType);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }
        return endcaseDto;
    }

    /**
     * �жϽ᰸֪ͨ���Ƿ����
     * 
     * @param caseNo
     * @param dbManager ��������
     * @return ��/��
     * @throws SQLException
     * @throws Exception
     */
    public boolean isExist(String caseNo, String claimNo, String certiNo, String certiType) throws SQLException,
            Exception {

        boolean exist = false;
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            exist = new BLEndcaseAction().isExist(dbManager, caseNo, claimNo, certiNo, certiType);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }
        return exist;
    }

    /**
     * ����������ѯ�᰸������Ϣ
     * 
     * @param conditions String
     * @throws Exception
     * @return Collection
     */
    public Collection findByConditions(String conditions) throws Exception {
        DBManager dbManager = new DBManager();
        PrpLcaseNoDto prpLcaseNoDto = null;
        Collection endcaseList = new ArrayList();
        try {
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            BLPrpLcaseNoAction blPrpLendcaseAction = new BLPrpLcaseNoAction();
            endcaseList = (Collection) blPrpLendcaseAction.findByConditions(dbManager, conditions, 0, 0);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return endcaseList;
    }

    /**
     * ����������ѯ����������Ϣ
     * 
     * @param conditions String
     * @throws Exception
     * @return Collection Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
     */
    public Collection findByQueryConditions(String conditions) throws Exception {
        DBManager dbManager = new DBManager();
        Collection endcaseList = new ArrayList();
        try {

            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
            BLEndcaseAction blEndcaseAction = new BLEndcaseAction();
            endcaseList = (Collection) blEndcaseAction.findByQueryConditions(dbManager, conditions, 0, 0);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            dbManager.close();
        }
        return endcaseList;
    }

    /**
     * ��ý᰸
     * 
     * @param caseNo
     * @param dbManager ��������
     * @return �Զ���᰸����
     * @throws SQLException
     * @throws Exception
     */
    public EndcaseDto findByPrimaryKey(String claimNo) throws SQLException, Exception {
        EndcaseDto endcaseDto = null;
        //�������ݿ�������
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            endcaseDto = new BLEndcaseAction().findByPrimaryKey(dbManager, claimNo);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //�ر����ݿ�����
            dbManager.close();
        }
        return endcaseDto;
    }

}