package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpljobmanagertime;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLJOBMANAGERTIME的业务逻辑对象类<br>
 */
public class BLPrpljobmanagertimeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpljobmanagertimeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpljobmanagertimeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //插入记录
        dbPrpljobmanagertime.insert(prpljobmanagertimeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param fid FID
     * @throws Exception
     */
    public void delete(DBManager dbManager,String fid)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //删除记录
        dbPrpljobmanagertime.delete(fid);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //按条件删除记录
        dbPrpljobmanagertime.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpljobmanagertimeDto prpljobmanagertimeDto)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //更新记录
        dbPrpljobmanagertime.update(prpljobmanagertimeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param fid FID
     * @return prpljobmanagertimeDto prpljobmanagertimeDto
     * @throws Exception
     */
    public PrpljobmanagertimeDto findByPrimaryKey(DBManager dbManager,String fid)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        //声明DTO
        PrpljobmanagertimeDto prpljobmanagertimeDto = null;
        //查询数据,赋值给DTO
        prpljobmanagertimeDto = dbPrpljobmanagertime.findByPrimaryKey(fid);
        return prpljobmanagertimeDto;
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
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanagertime.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpljobmanagertime.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpljobmanagertimeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpljobmanagertime.findByConditions(conditions);
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
        DBPrpljobmanagertime dbPrpljobmanagertime = new DBPrpljobmanagertime(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpljobmanagertime.getCount(conditions);
        return count;
    }
}
