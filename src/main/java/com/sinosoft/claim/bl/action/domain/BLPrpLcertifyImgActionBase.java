package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg-理赔图片上传路径的业务逻辑对象类<br>
 * 创建于 2005-03-23 16:36:58.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyImgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyImgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyImgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //插入记录
        dbPrpLcertifyImg.insert(prpLcertifyImgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //删除记录
        dbPrpLcertifyImg.delete(businessNo, serialNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //按条件删除记录
        dbPrpLcertifyImg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //更新记录
        dbPrpLcertifyImg.update(prpLcertifyImgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public PrpLcertifyImgDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //声明DTO
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        //查询数据,赋值给DTO
        prpLcertifyImgDto = dbPrpLcertifyImg.findByPrimaryKey(businessNo, serialNo, lossItemCode);
        return prpLcertifyImgDto;
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
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyImg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyImg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcertifyImgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyImg.findByConditions(conditions);
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
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyImg.getCount(conditions);
        return count;
    }
}
