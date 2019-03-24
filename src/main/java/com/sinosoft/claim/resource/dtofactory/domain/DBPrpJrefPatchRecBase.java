package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefpatchrec批量付费登记表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefPatchRecBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJrefPatchRecBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJrefPatchRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void insert(PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        String statement = " Insert Into PrpJrefPatchRec(" + 
                           " RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefPatchRecDto.getRefundGroupNo());
        dbManager.setString(2,prpJrefPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJrefPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPatchRecBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefPatchRecDto prpJrefPatchRecDto = (PrpJrefPatchRecDto)i.next();
            insert(prpJrefPatchRecDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param refundGroupNo 批量付费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @throws Exception
     */
    public void delete(String refundGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJrefPatchRec Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,refundGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefPatchRecBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void update(PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        String statement = " Update PrpJrefPatchRec Set  Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        //设置条件字段;
        dbManager.setString(1,prpJrefPatchRecDto.getRefundGroupNo());
        dbManager.setString(2,prpJrefPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJrefPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPatchRecBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param refundGroupNo 批量付费登记号
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @return PrpJrefPatchRecDto
     * @throws Exception
     */
    public PrpJrefPatchRecDto findByPrimaryKey(String refundGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Select RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJrefPatchRec Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,refundGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefPatchRecDto = new PrpJrefPatchRecDto();
            prpJrefPatchRecDto.setRefundGroupNo(dbManager.getString(resultSet,1));
            prpJrefPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJrefPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.findByPrimaryKey() success!");
        return prpJrefPatchRecDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJrefPatchRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpJrefPatchRecDto = new PrpJrefPatchRecDto();
            prpJrefPatchRecDto.setRefundGroupNo(dbManager.getString(resultSet,1));
            prpJrefPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJrefPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
            collection.add(prpJrefPatchRecDto);
        }
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpJrefPatchRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefPatchRecBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpJrefPatchRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.getCount() success!");
        return count;
    }
}
