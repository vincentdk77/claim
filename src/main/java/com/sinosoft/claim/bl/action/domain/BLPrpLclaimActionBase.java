package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaim;
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
public class BLPrpLclaimActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimDto prpLclaimDto) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //插入记录
        dbPrpLclaim.insert(prpLclaimDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //删除记录
        dbPrpLclaim.delete(claimNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //按条件删除记录
        dbPrpLclaim.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimDto prpLclaimDto) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //更新记录
        dbPrpLclaim.update(prpLclaimDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLclaimDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        //声明DTO
        PrpLclaimDto prpLclaimDto = null;
        //查询数据,赋值给DTO
        prpLclaimDto = dbPrpLclaim.findByPrimaryKey(claimNo);
        return prpLclaimDto;
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
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaim.getCount(SqlUtils.getWherePartForGetCount(conditions));
        //add by zhaolu 20060803 start
        int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
        if(maxQueryCount!=0&&count>maxQueryCount){   
          throw new UserException(1,3,"0000","查询结果个数超过系统限制"); 
        }
        //add by zhaolu 20060803 end 
        collection = dbPrpLclaim.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaim.findByConditions(conditions);
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
        DBPrpLclaim dbPrpLclaim = new DBPrpLclaim(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaim.getCount(conditions);
        return count;
    }
}
