package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDtypeDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDtype;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdtype的业务逻辑对象类<br>
 * 创建于 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDtypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDtypeActionBase.class.getName());
    protected int count; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDtypeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDtypeDto prpDtypeDto) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //插入记录
        dbPrpDtype.insert(prpDtypeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param codeType codetype
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //删除记录
        dbPrpDtype.delete(codeType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //按条件删除记录
        dbPrpDtype.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDtypeDto prpDtypeDto) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //更新记录
        dbPrpDtype.update(prpDtypeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param codeType codetype
     * @return prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public PrpDtypeDto findByPrimaryKey(DBManager dbManager,String codeType) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        //声明DTO
        PrpDtypeDto prpDtypeDto = null;
        //查询数据,赋值给DTO
        prpDtypeDto = dbPrpDtype.findByPrimaryKey(codeType);
        return prpDtypeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDtypeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        count = dbPrpDtype.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDtype.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDtypeDto的集合
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
        DBPrpDtype dbPrpDtype = new DBPrpDtype(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDtype.getCount(conditions);
        return count;
    }
}
