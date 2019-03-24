package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDetailDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefrecdetail付费登记明细表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefRecDetailBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJrefRecDetailBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJrefRecDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void insert(PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        String statement = " Insert Into PrpJrefRecDetail(" + 
                           " PolicyNo," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " Currency1," + 
                           " RefundFee) values(?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefRecDetailDto.getPolicyNo());
        dbManager.setString(2,prpJrefRecDetailDto.getCertiType());
        dbManager.setString(3,prpJrefRecDetailDto.getCertiNo());
        dbManager.setInt(4,prpJrefRecDetailDto.getSerialNo());
        dbManager.setInt(5,prpJrefRecDetailDto.getItemKindNo());
        dbManager.setString(6,prpJrefRecDetailDto.getKindCode());
        dbManager.setString(7,prpJrefRecDetailDto.getItemCode());
        dbManager.setString(8,prpJrefRecDetailDto.getCurrency1());
        dbManager.setDouble(9,prpJrefRecDetailDto.getRefundFee());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefRecDetailBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefRecDetailDto prpJrefRecDetailDto = (PrpJrefRecDetailDto)i.next();
            insert(prpJrefRecDetailDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @param itemKindNo 标的险别序号
     * @throws Exception
     */
    public void delete(String certiNo,int serialNo,int itemKindNo) throws Exception{
        String statement = " Delete From PrpJrefRecDetail Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,itemKindNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefRecDetailBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void update(PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        String statement = " Update PrpJrefRecDetail Set PolicyNo = ?," + 
                           " CertiType = ?," + 
                           " KindCode = ?," + 
                           " ItemCode = ?," + 
                           " Currency1 = ?," + 
                           " RefundFee = ? Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJrefRecDetailDto.getPolicyNo());
        dbManager.setString(2,prpJrefRecDetailDto.getCertiType());
        dbManager.setString(3,prpJrefRecDetailDto.getKindCode());
        dbManager.setString(4,prpJrefRecDetailDto.getItemCode());
        dbManager.setString(5,prpJrefRecDetailDto.getCurrency1());
        dbManager.setDouble(6,prpJrefRecDetailDto.getRefundFee());
        //设置条件字段;
        dbManager.setString(7,prpJrefRecDetailDto.getCertiNo());
        dbManager.setInt(8,prpJrefRecDetailDto.getSerialNo());
        dbManager.setInt(9,prpJrefRecDetailDto.getItemKindNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefRecDetailBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @param itemKindNo 标的险别序号
     * @return PrpJrefRecDetailDto
     * @throws Exception
     */
    public PrpJrefRecDetailDto findByPrimaryKey(String certiNo,int serialNo,int itemKindNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " Currency1," + 
                           " RefundFee From PrpJrefRecDetail Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ItemKindNo = ?";
        PrpJrefRecDetailDto prpJrefRecDetailDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,itemKindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefRecDetailDto = new PrpJrefRecDetailDto();
            prpJrefRecDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJrefRecDetailDto.setCertiType(dbManager.getString(resultSet,2));
            prpJrefRecDetailDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJrefRecDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJrefRecDetailDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpJrefRecDetailDto.setKindCode(dbManager.getString(resultSet,6));
            prpJrefRecDetailDto.setItemCode(dbManager.getString(resultSet,7));
            prpJrefRecDetailDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJrefRecDetailDto.setRefundFee(dbManager.getDouble(resultSet,9));
        }
        resultSet.close();
        log.info("DBPrpJrefRecDetailBase.findByPrimaryKey() success!");
        return prpJrefRecDetailDto;
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
        String statement = "Select PolicyNo," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " Currency1," + 
                           " RefundFee From PrpJrefRecDetail Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefRecDetailDto prpJrefRecDetailDto = null;
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

            prpJrefRecDetailDto = new PrpJrefRecDetailDto();
            prpJrefRecDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJrefRecDetailDto.setCertiType(dbManager.getString(resultSet,2));
            prpJrefRecDetailDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJrefRecDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJrefRecDetailDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpJrefRecDetailDto.setKindCode(dbManager.getString(resultSet,6));
            prpJrefRecDetailDto.setItemCode(dbManager.getString(resultSet,7));
            prpJrefRecDetailDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJrefRecDetailDto.setRefundFee(dbManager.getDouble(resultSet,9));
            collection.add(prpJrefRecDetailDto);
        }
        resultSet.close();
        log.info("DBPrpJrefRecDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpJrefRecDetail Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefRecDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJrefRecDetail Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefRecDetailBase.getCount() success!");
        return count;
    }
}
