package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvMain;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口参数中间表子表计算书清单信息表的业务逻辑对象类<br>
 */
public class BLPrpLinterCompeInvMainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvMainActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompeInvMainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //插入记录
        dbPrpLinterCompeInvMain.insert(prpLinterCompeInvMainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 序号 PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //删除记录
        dbPrpLinterCompeInvMain.delete(id, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //按条件删除记录
        dbPrpLinterCompeInvMain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //更新记录
        dbPrpLinterCompeInvMain.update(prpLinterCompeInvMainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 序号 PK
     * @return prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @throws Exception
     */
    public PrpLinterCompeInvMainDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        //声明DTO
        PrpLinterCompeInvMainDto prpLinterCompeInvMainDto = null;
        //查询数据,赋值给DTO
        prpLinterCompeInvMainDto = dbPrpLinterCompeInvMain.findByPrimaryKey(id, serialNo);
        return prpLinterCompeInvMainDto;
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
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompeInvMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCompeInvMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompeInvMain.findByConditions(conditions);
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
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvMain.getCount(conditions);
        return count;
    }
}
