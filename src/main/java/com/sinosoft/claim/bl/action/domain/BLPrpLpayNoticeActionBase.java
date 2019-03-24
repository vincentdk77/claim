package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayNotice;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是通知单表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayNoticeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayNoticeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpayNoticeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //插入记录
        dbPrpLpayNotice.insert(prpLpayNoticeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param noticeNo 通知单号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String noticeNo)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //删除记录
        dbPrpLpayNotice.delete(noticeNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //按条件删除记录
        dbPrpLpayNotice.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //更新记录
        dbPrpLpayNotice.update(prpLpayNoticeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param noticeNo 通知单号
     * @return prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(DBManager dbManager,String noticeNo)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        //声明DTO
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        //查询数据,赋值给DTO
        prpLpayNoticeDto = dbPrpLpayNotice.findByPrimaryKey(noticeNo);
        return prpLpayNoticeDto;
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
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNotice.getCount(conditions);
        collection = dbPrpLpayNotice.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpayNoticeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpayNotice.findByConditions(conditions);
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
        DBPrpLpayNotice dbPrpLpayNotice = new DBPrpLpayNotice(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpayNotice.getCount(conditions);
        return count;
    }
}
