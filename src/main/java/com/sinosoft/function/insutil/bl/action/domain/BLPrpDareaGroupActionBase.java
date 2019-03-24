package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDareaGroupDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDareaGroup;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdareagroup的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDareaGroupActionBase{
    private static Log log = LogFactory.getLog(BLPrpDareaGroupActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDareaGroupActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //插入记录
        dbPrpDareaGroup.insert(prpDareaGroupDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param comCode comcode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //删除记录
        dbPrpDareaGroup.delete(riskCode, comCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //按条件删除记录
        dbPrpDareaGroup.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //更新记录
        dbPrpDareaGroup.update(prpDareaGroupDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode riskcode
     * @param comCode comcode
     * @return prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public PrpDareaGroupDto findByPrimaryKey(DBManager dbManager,String riskCode,String comCode) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        //声明DTO
        PrpDareaGroupDto prpDareaGroupDto = null;
        //查询数据,赋值给DTO
        prpDareaGroupDto = dbPrpDareaGroup.findByPrimaryKey(riskCode, comCode);
        return prpDareaGroupDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDareaGroupDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDareaGroup.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDareaGroup.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDareaGroupDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getCount(){
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDareaGroup dbPrpDareaGroup = new DBPrpDareaGroup(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDareaGroup.getCount(conditions);
        return count;
    }
}
