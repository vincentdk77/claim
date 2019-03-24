package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpCinsuredNatureAction;
import com.sinosoft.claim.dto.domain.PrpCinsuredNatureDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCinsuredNature的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCinsuredNatureFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpCinsuredNatureFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpCinsuredNatureFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void insert(PrpCinsuredNatureDto prpCinsuredNatureDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //插入记录
            blPrpCinsuredNatureAction.insert(dbManager,prpCinsuredNatureDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo PolicyNo
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //删除记录
            blPrpCinsuredNatureAction.delete(dbManager,policyNo,serialNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //按条件删除记录
            blPrpCinsuredNatureAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public void update(PrpCinsuredNatureDto prpCinsuredNatureDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        try{
            dbManager.open("claimDataSource");
            dbManager.beginTransaction();
            //更新记录
            blPrpCinsuredNatureAction.update(dbManager,prpCinsuredNatureDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键查找一条数据
     * @param policyNo PolicyNo
     * @return prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredNatureDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredNatureAction blPrpCinsuredNatureAction = new BLPrpCinsuredNatureAction();
        //声明DTO
        PrpCinsuredNatureDto prpCinsuredNatureDto = null;
        try{
            dbManager.open("claimDataSource");
            //查询数据,赋值给DTO
            prpCinsuredNatureDto = blPrpCinsuredNatureAction.findByPrimaryKey(dbManager,policyNo,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCinsuredNatureDto;
    }

}
