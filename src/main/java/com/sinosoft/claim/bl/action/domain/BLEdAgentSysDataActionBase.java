package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdAgentSysData;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdAgentSysData的业务逻辑对象类<br>
 * 创建于 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdAgentSysDataActionBase{
    private static Log logger = LogFactory.getLog(BLEdAgentSysDataActionBase.class);

    /**
     * 构造函数
     */
    public BLEdAgentSysDataActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //插入记录
        dbEdAgentSysData.insert(edAgentSysDataDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param cALLID 呼叫标识
     * @throws Exception
     */
    public void delete(DBManager dbManager,String cALLID) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //删除记录
        dbEdAgentSysData.delete(cALLID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //按条件删除记录
        dbEdAgentSysData.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //更新记录
        dbEdAgentSysData.update(edAgentSysDataDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param cALLID 呼叫标识
     * @return edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataDto findByPrimaryKey(DBManager dbManager,String cALLID) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //声明DTO
        EdAgentSysDataDto edAgentSysDataDto = null;
        //查询数据,赋值给DTO
        edAgentSysDataDto = dbEdAgentSysData.findByPrimaryKey(cALLID);
        return edAgentSysDataDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdAgentSysData.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdAgentSysData.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含edAgentSysDataDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdAgentSysData.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdAgentSysData.getCount(conditions);
        return count;
    }
}
