package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口参数中间表子表计算书清单信息明细表的业务逻辑对象类<br>
 */
public class BLPrpLinterCompeInvDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompeInvDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //插入记录
        dbPrpLinterCompeInvDetail.insert(prpLinterCompeInvDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 清单主表序号
     * @param detilSerialNo 清单明细序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo,int detilSerialNo)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //删除记录
        dbPrpLinterCompeInvDetail.delete(id, serialNo, detilSerialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //按条件删除记录
        dbPrpLinterCompeInvDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //更新记录
        dbPrpLinterCompeInvDetail.update(prpLinterCompeInvDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 清单主表序号
     * @param detilSerialNo 清单明细序号
     * @return prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public PrpLinterCompeInvDetailDto findByPrimaryKey(DBManager dbManager,String id,int serialNo,int detilSerialNo)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //声明DTO
        PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = null;
        //查询数据,赋值给DTO
        prpLinterCompeInvDetailDto = dbPrpLinterCompeInvDetail.findByPrimaryKey(id, serialNo, detilSerialNo);
        return prpLinterCompeInvDetailDto;
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
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompeInvDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCompeInvDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompeInvDetail.findByConditions(conditions);
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
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompeInvDetail.getCount(conditions);
        return count;
    }
}
