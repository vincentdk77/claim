package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPayDeleteRequest;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLINTERPAYDELETEQUEST的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayDeleteRequestActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayDeleteRequestActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayDeleteRequestActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //插入记录
        dbPRPLINTERPAYDELETEQUEST.insert(pRPLINTERPAYDELETEQUESTDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param outId 客户端主键
     * @throws Exception
     */
    public void delete(DBManager dbManager,String outId)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //删除记录
        dbPRPLINTERPAYDELETEQUEST.delete(outId);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //按条件删除记录
        dbPRPLINTERPAYDELETEQUEST.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //更新记录
        dbPRPLINTERPAYDELETEQUEST.update(pRPLINTERPAYDELETEQUESTDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param outId 客户端主键
     * @return pRPLINTERPAYDELETEQUESTDto pRPLINTERPAYDELETEQUESTDto
     * @throws Exception
     */
    public PrpLinterPayDeleteRequestDto findByPrimaryKey(DBManager dbManager,String outId)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        //声明DTO
        PrpLinterPayDeleteRequestDto pRPLINTERPAYDELETEQUESTDto = null;
        //查询数据,赋值给DTO
        pRPLINTERPAYDELETEQUESTDto = dbPRPLINTERPAYDELETEQUEST.findByPrimaryKey(outId);
        return pRPLINTERPAYDELETEQUESTDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPRPLINTERPAYDELETEQUEST.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPRPLINTERPAYDELETEQUEST.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含pRPLINTERPAYDELETEQUESTDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPRPLINTERPAYDELETEQUEST.findByConditions(conditions);
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
        DBPrpLinterPayDeleteRequest dbPRPLINTERPAYDELETEQUEST = new DBPrpLinterPayDeleteRequest(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPRPLINTERPAYDELETEQUEST.getCount(conditions);
        return count;
    }
}
