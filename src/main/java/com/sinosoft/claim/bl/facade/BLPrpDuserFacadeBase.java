package com.sinosoft.claim.bl.facade;


import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDuser-员工代码表的业务逻辑对象Facade基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDuserFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpDuserFacadeBase.class);

    /**
     * 构造函数
     */
    public BLPrpDuserFacadeBase(){
    }
    /**
     * 按主键查找一条数据
     * @param userCode 员工代码
     * @return prpDuserDto prpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findByPrimaryKey(String userCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpDuserAction blPrpDuserAction = new BLPrpDuserAction();
        //声明DTO
        PrpDuserDto prpDuserDto = null;
        try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDuserDto = blPrpDuserAction.findByPrimaryKey(dbManager,userCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDuserDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
    	Collection collection = new ArrayList();
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDuserAction blPrpDuserAction = new BLPrpDuserAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDuserAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含prpDuserDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpDuserAction blPrpDuserAction = new BLPrpDuserAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpDuserAction.findByConditions(dbManager,conditions,0,0);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
