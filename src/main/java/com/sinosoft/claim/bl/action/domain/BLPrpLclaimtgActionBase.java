package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimtg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaim-立案基本信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimtgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimtgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimtgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //插入记录
        dbPrpLclaimtg.insert(prpLclaimtgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //删除记录
        dbPrpLclaimtg.delete(claimNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //按条件删除记录
        dbPrpLclaimtg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //更新记录
        dbPrpLclaimtg.update(prpLclaimtgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @return prpLclaimtgDto prpLclaimtgDto
     * @throws Exception
     */
    public PrpLclaimtgDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        //声明DTO
        PrpLclaimtgDto prpLclaimtgDto = null;
        //查询数据,赋值给DTO
        prpLclaimtgDto = dbPrpLclaimtg.findByPrimaryKey(claimNo);
        return prpLclaimtgDto;
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
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimtg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLclaimtg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimtgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimtg.findByConditions(conditions);
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
        DBPrpLclaimtg dbPrpLclaimtg = new DBPrpLclaimtg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimtg.getCount(conditions);
        return count;
    }
}
