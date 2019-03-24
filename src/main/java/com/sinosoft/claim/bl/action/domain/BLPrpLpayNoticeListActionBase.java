package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNoticeList;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单关联表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeListActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeListActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayNoticeListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //插入记录
        dbPrpLpayNoticeList.insert(prpLpayNoticeListDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param noticeNo 通知单号
     * @param paymentNo 收付编号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String noticeNo,String paymentNo)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //删除记录
        dbPrpLpayNoticeList.delete(noticeNo, paymentNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //按条件删除记录
        dbPrpLpayNoticeList.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //更新记录
        dbPrpLpayNoticeList.update(prpLpayNoticeListDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param noticeNo 通知单号
     * @param paymentNo 收付编号
     * @return prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public PrpLpayNoticeListDto findByPrimaryKey(DBManager dbManager,String noticeNo,String paymentNo)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //声明DTO
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        //查询数据,赋值给DTO
        prpLpayNoticeListDto = dbPrpLpayNoticeList.findByPrimaryKey(noticeNo, paymentNo);
        return prpLpayNoticeListDto;
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
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNoticeList.getCount(conditions);
        collection = dbPrpLpayNoticeList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpayNoticeListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayNoticeList.findByConditions(conditions);
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
        DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNoticeList.getCount(conditions);
        return count;
    }
    
    /**
     * 插入多条记录 add by zhongfen
     * @param dbManager
     * @param prplpayNoticelistList
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection prplpayNoticelistList)throws Exception{
    	DBPrpLpayNoticeList dbPrpLpayNoticeList = new DBPrpLpayNoticeList(dbManager);
        //插入多条记录
        dbPrpLpayNoticeList.insertAll(prplpayNoticelistList);
    }
}
