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
 * 结案逻辑分发
 * <p>
 * Title: 车险理赔结案
 * </p>
 * <p>
 * Description: 车险理赔结案facade
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
     * 保存结案
     * 
     * @param endcaseDto：自定义结案对象
     * @throws SQLException
     * @throws Exception
     */
    public void save(EndcaseDto endcaseDto) throws SQLException, Exception {
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //开始事务
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().save(dbManager, endcaseDto);
            //提交事务
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            //回滚事务
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            //回滚事务
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }
    }
    /**
     * 保存结案带工作流
     * 
     * @param endcaseDto：自定义结案对象
     * @throws SQLException
     * @throws Exception
     */
    public void save(EndcaseDto endcaseDto, WorkFlowDto workFlowDto) throws SQLException, Exception {
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //开始事务
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().save(dbManager, endcaseDto);
            if (workFlowDto != null) {
                new BLWorkFlowAction().deal(dbManager, workFlowDto);
            }
            //提交事务
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            //回滚事务
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            ex.printStackTrace();
            //回滚事务
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }
    }

    /**
     * 删除结案
     * 
     * @param caseNo
     * @param dbManager 数据连接
     * @throws SQLException
     * @throws Exception
     */
    public void delete(String caseNo) throws SQLException, Exception {
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        //开始事务
        dbManager.beginTransaction();
        try {
            new BLEndcaseAction().delete(dbManager, caseNo);
            //提交事务
            dbManager.commitTransaction();
        } catch (SQLException sqle) {
            //回滚事务
            dbManager.rollbackTransaction();
            throw sqle;
        } catch (Exception ex) {
            //回滚事务
            dbManager.rollbackTransaction();
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }

    }
    /**
     * 获得结案
     * 
     * @param caseNo
     * @param dbManager 数据连接
     * @return 自定义结案对象
     * @throws SQLException
     * @throws Exception
     */
    public EndcaseDto findByPrimaryKey(String caseNo, String claimNo, String certiNo, String certiType)
            throws SQLException, Exception {
        EndcaseDto endcaseDto = null;
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            endcaseDto = new BLEndcaseAction().findByPrimaryKey(dbManager, caseNo, claimNo, certiNo, certiType);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }
        return endcaseDto;
    }

    /**
     * 判断结案通知号是否存在
     * 
     * @param caseNo
     * @param dbManager 数据连接
     * @return 是/否
     * @throws SQLException
     * @throws Exception
     */
    public boolean isExist(String caseNo, String claimNo, String certiNo, String certiType) throws SQLException,
            Exception {

        boolean exist = false;
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            exist = new BLEndcaseAction().isExist(dbManager, caseNo, claimNo, certiNo, certiType);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }
        return exist;
    }

    /**
     * 根据条件查询结案主表信息
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
     * 根据条件查询报案主表信息
     * 
     * @param conditions String
     * @throws Exception
     * @return Collection Add By sunhao 2004-08-24 Reason:增加新的查询方法
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
     * 获得结案
     * 
     * @param caseNo
     * @param dbManager 数据连接
     * @return 自定义结案对象
     * @throws SQLException
     * @throws Exception
     */
    public EndcaseDto findByPrimaryKey(String claimNo) throws SQLException, Exception {
        EndcaseDto endcaseDto = null;
        //创建数据库管理对象
        DBManager dbManager = new DBManager();
        dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        try {
            endcaseDto = new BLEndcaseAction().findByPrimaryKey(dbManager, claimNo);
        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            //关闭数据库连接
            dbManager.close();
        }
        return endcaseDto;
    }

}