package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLlocklogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLlocklog;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLLOCKLOG的业务逻辑对象类<br>
 */
public class BLPrpLlocklogActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLlocklogActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLlocklogActionBase(){
    }

    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        for(Iterator itr = collection.iterator();itr.hasNext();){
        	PrpLlocklogDto prpllocklogDto = (PrpLlocklogDto)itr.next();
        	dbPrpllocklog.delete(prpllocklogDto.getRegistNo(), prpllocklogDto.getRecoveryCode(), prpllocklogDto.getRiskCode());
        }
        //插入记录
        dbPrpllocklog.insertAll(collection);
    }
    
    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLlocklogDto prpllocklogDto)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //插入记录
        dbPrpllocklog.insert(prpllocklogDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String recoverycode,String serialno)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //删除记录
        dbPrpllocklog.delete(registno, recoverycode, serialno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //按条件删除记录
        dbPrpllocklog.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLlocklogDto prpllocklogDto)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //更新记录
        dbPrpllocklog.update(prpllocklogDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registno REGISTNO
     * @param recoverycode RECOVERYCODE
     * @param serialno SERIALNO
     * @return prpllocklogDto prpllocklogDto
     * @throws Exception
     */
    public PrpLlocklogDto findByPrimaryKey(DBManager dbManager,String registno,String recoverycode,String serialno)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        //声明DTO
        PrpLlocklogDto prpllocklogDto = null;
        //查询数据,赋值给DTO
        prpllocklogDto = dbPrpllocklog.findByPrimaryKey(registno, recoverycode, serialno);
        return prpllocklogDto;
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
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpllocklog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpllocklog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpllocklogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpllocklog.findByConditions(conditions);
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
        DBPrpLlocklog dbPrpllocklog = new DBPrpLlocklog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpllocklog.getCount(conditions);
        return count;
    }
}
