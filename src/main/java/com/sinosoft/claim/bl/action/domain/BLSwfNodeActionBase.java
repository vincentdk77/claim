package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNode;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfNode工作流节点定义表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.312<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNodeActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNodeActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfNodeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfNodeDto swfNodeDto) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //插入记录
        dbSwfNode.insert(swfNodeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param nodeNo 节点编号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int nodeNo) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //删除记录
        dbSwfNode.delete(modelNo, nodeNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //按条件删除记录
        dbSwfNode.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfNodeDto swfNodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfNodeDto swfNodeDto) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //更新记录
        dbSwfNode.update(swfNodeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param nodeNo 节点编号
     * @return swfNodeDto swfNodeDto
     * @throws Exception
     */
    public SwfNodeDto findByPrimaryKey(DBManager dbManager,int modelNo,int nodeNo) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        //声明DTO
        SwfNodeDto swfNodeDto = null;
        //查询数据,赋值给DTO
        swfNodeDto = dbSwfNode.findByPrimaryKey(modelNo, nodeNo);
        return swfNodeDto;
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
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNode.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfNode.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfNodeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfNode.findByConditions(conditions);
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
        DBSwfNode dbSwfNode = new DBSwfNode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfNode.getCount(conditions);
        return count;
    }
}
