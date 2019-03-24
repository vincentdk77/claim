package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.claim.resource.dtofactory.domain.DBED_AGENT_INFO;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是座席员工信息表的业务逻辑对象类<br>
 * 创建于 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOActionBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOActionBase.class);

    /**
     * 构造函数
     */
    public BLED_AGENT_INFOActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void insert(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //插入记录
        dbED_AGENT_INFO.insert(eD_AGENT_INFODto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param aGENTID 座席工号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String aGENTID) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //删除记录
        dbED_AGENT_INFO.delete(aGENTID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //按条件删除记录
        dbED_AGENT_INFO.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void update(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //更新记录
        dbED_AGENT_INFO.update(eD_AGENT_INFODto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param aGENTID 座席工号
     * @return eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFODto findByPrimaryKey(DBManager dbManager,String aGENTID) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //声明DTO
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
        //查询数据,赋值给DTO
        eD_AGENT_INFODto = dbED_AGENT_INFO.findByPrimaryKey(aGENTID);
        return eD_AGENT_INFODto;
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
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbED_AGENT_INFO.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbED_AGENT_INFO.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含eD_AGENT_INFODto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbED_AGENT_INFO.findByConditions(conditions);
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
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbED_AGENT_INFO.getCount(conditions);
        return count;
    }
}
