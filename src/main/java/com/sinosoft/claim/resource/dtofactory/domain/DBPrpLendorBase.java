package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLendor的数据访问对象基类<br>
 * 创建于 2007-06-13 15:58:28.345<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLendorBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLendorBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLendorBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void insert(PrpLendorDto prpLendorDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLendor (");
        buffer.append("claimNo,");
        buffer.append("compensateNo,");
        buffer.append("policyNo,");
        buffer.append("itemKindNo,");
        buffer.append("itemCode,");
        buffer.append("itemName,");
        buffer.append("kindCode,");
        buffer.append("kindName,");
        buffer.append("currency,");
        buffer.append("endorAmount,");
        buffer.append("inputDate,");
        buffer.append("flag,");
        buffer.append("endorseNo,");
        buffer.append("endorType,");
        buffer.append("endorGrossQuantity ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLendorDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpLendorDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLendorDto.getItemCode()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getItemName()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLendorDto.getEndorAmount()).append(",");
            debugBuffer.append("'").append(prpLendorDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getEndorseNo()).append("',");
            debugBuffer.append("'").append(prpLendorDto.getEndorType()).append("',");
            debugBuffer.append("").append(prpLendorDto.getEndorGrossQuantity()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLendorDto.getClaimNo());
        dbManager.setString(2,prpLendorDto.getCompensateNo());
        dbManager.setString(3,prpLendorDto.getPolicyNo());
        dbManager.setInt(4,prpLendorDto.getItemKindNo());
        dbManager.setString(5,prpLendorDto.getItemCode());
        dbManager.setString(6,prpLendorDto.getItemName());
        dbManager.setString(7,prpLendorDto.getKindCode());
        dbManager.setString(8,prpLendorDto.getKindName());
        dbManager.setString(9,prpLendorDto.getCurrency());
        dbManager.setDouble(10,prpLendorDto.getEndorAmount());
        dbManager.setDateTime(11,prpLendorDto.getInputDate());
        dbManager.setString(12,prpLendorDto.getFlag());
        dbManager.setString(13,prpLendorDto.getEndorseNo());
        dbManager.setString(14,prpLendorDto.getEndorType());
        dbManager.setDouble(15,prpLendorDto.getEndorGrossQuantity());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLendor (");
        buffer.append("claimNo,");
        buffer.append("compensateNo,");
        buffer.append("policyNo,");
        buffer.append("itemKindNo,");
        buffer.append("itemCode,");
        buffer.append("itemName,");
        buffer.append("kindCode,");
        buffer.append("kindName,");
        buffer.append("currency,");
        buffer.append("endorAmount,");
        buffer.append("inputDate,");
        buffer.append("flag,");
        buffer.append("endorseNo,");
        buffer.append("endorType,");
        buffer.append("endorGrossQuantity ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLendorDto prpLendorDto = (PrpLendorDto)i.next();
            dbManager.setString(1,prpLendorDto.getClaimNo());
            dbManager.setString(2,prpLendorDto.getCompensateNo());
            dbManager.setString(3,prpLendorDto.getPolicyNo());
            dbManager.setInt(4,prpLendorDto.getItemKindNo());
            dbManager.setString(5,prpLendorDto.getItemCode());
            dbManager.setString(6,prpLendorDto.getItemName());
            dbManager.setString(7,prpLendorDto.getKindCode());
            dbManager.setString(8,prpLendorDto.getKindName());
            dbManager.setString(9,prpLendorDto.getCurrency());
            dbManager.setDouble(10,prpLendorDto.getEndorAmount());
            dbManager.setDateTime(11,prpLendorDto.getInputDate());
            dbManager.setString(12,prpLendorDto.getFlag());
            dbManager.setString(13,prpLendorDto.getEndorseNo());
            dbManager.setString(14,prpLendorDto.getEndorType());
            dbManager.setDouble(15,prpLendorDto.getEndorGrossQuantity());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @throws Exception
     */
    public void delete(String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLendor ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("policyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("itemKindNo=").append("").append(itemKindNo).append(" AND ");
            debugBuffer.append("endorType=").append("'").append(endorType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("policyNo = ? And ");
        buffer.append("itemKindNo = ? And ");
        buffer.append("endorType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,itemKindNo);
        dbManager.setString(4,endorType);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLendorDto prpLendorDto
     * @throws Exception
     */
    public void update(PrpLendorDto prpLendorDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLendor SET ");
        buffer.append("claimNo = ?, ");
        buffer.append("itemCode = ?, ");
        buffer.append("itemName = ?, ");
        buffer.append("kindCode = ?, ");
        buffer.append("kindName = ?, ");
        buffer.append("currency = ?, ");
        buffer.append("endorAmount = ?, ");
        buffer.append("inputDate = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("endorseNo = ?, ");
        buffer.append("endorGrossQuantity = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLendor SET ");
            debugBuffer.append("claimNo = '" + prpLendorDto.getClaimNo() + "', ");
            debugBuffer.append("itemCode = '" + prpLendorDto.getItemCode() + "', ");
            debugBuffer.append("itemName = '" + prpLendorDto.getItemName() + "', ");
            debugBuffer.append("kindCode = '" + prpLendorDto.getKindCode() + "', ");
            debugBuffer.append("kindName = '" + prpLendorDto.getKindName() + "', ");
            debugBuffer.append("currency = '" + prpLendorDto.getCurrency() + "', ");
            debugBuffer.append("endorAmount = " + prpLendorDto.getEndorAmount() + ", ");
            debugBuffer.append("inputDate = '" + prpLendorDto.getInputDate() + "', ");
            debugBuffer.append("flag = '" + prpLendorDto.getFlag() + "', ");
            debugBuffer.append("endorseNo = '" + prpLendorDto.getEndorseNo() + "', ");
            debugBuffer.append("endorGrossQuantity = " + prpLendorDto.getEndorGrossQuantity() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(prpLendorDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("policyNo=").append("'").append(prpLendorDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("itemKindNo=").append("").append(prpLendorDto.getItemKindNo()).append(" AND ");
            debugBuffer.append("endorType=").append("'").append(prpLendorDto.getEndorType()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("policyNo = ? And ");
        buffer.append("itemKindNo = ? And ");
        buffer.append("endorType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLendorDto.getClaimNo());
        dbManager.setString(2,prpLendorDto.getItemCode());
        dbManager.setString(3,prpLendorDto.getItemName());
        dbManager.setString(4,prpLendorDto.getKindCode());
        dbManager.setString(5,prpLendorDto.getKindName());
        dbManager.setString(6,prpLendorDto.getCurrency());
        dbManager.setDouble(7,prpLendorDto.getEndorAmount());
        dbManager.setDateTime(8,prpLendorDto.getInputDate());
        dbManager.setString(9,prpLendorDto.getFlag());
        dbManager.setString(10,prpLendorDto.getEndorseNo());
        dbManager.setDouble(11,prpLendorDto.getEndorGrossQuantity());
        //设置条件字段;
        dbManager.setString(12,prpLendorDto.getCompensateNo());
        dbManager.setString(13,prpLendorDto.getPolicyNo());
        dbManager.setInt(14,prpLendorDto.getItemKindNo());
        dbManager.setString(15,prpLendorDto.getEndorType());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param compensateNo compensateNo
     * @param policyNo policyNo
     * @param itemKindNo itemKindNo
     * @param endorType endorType
     * @return PrpLendorDto
     * @throws Exception
     */
    public PrpLendorDto findByPrimaryKey(String compensateNo,String policyNo,int itemKindNo,String endorType)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("claimNo,");
        buffer.append("compensateNo,");
        buffer.append("policyNo,");
        buffer.append("itemKindNo,");
        buffer.append("itemCode,");
        buffer.append("itemName,");
        buffer.append("kindCode,");
        buffer.append("kindName,");
        buffer.append("currency,");
        buffer.append("endorAmount,");
        buffer.append("inputDate,");
        buffer.append("flag,");
        buffer.append("endorseNo,");
        buffer.append("endorType,");
        buffer.append("endorGrossQuantity ");
        buffer.append("FROM PrpLendor ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("compensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("policyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("itemKindNo=").append("").append(itemKindNo).append(" AND ");
            debugBuffer.append("endorType=").append("'").append(endorType).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("compensateNo = ? And ");
        buffer.append("policyNo = ? And ");
        buffer.append("itemKindNo = ? And ");
        buffer.append("endorType = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,itemKindNo);
        dbManager.setString(4,endorType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLendorDto prpLendorDto = null;
        if(resultSet.next()){
            prpLendorDto = new PrpLendorDto();
            prpLendorDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLendorDto.setCompensateNo(dbManager.getString(resultSet,2));
            prpLendorDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLendorDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLendorDto.setItemCode(dbManager.getString(resultSet,5));
            prpLendorDto.setItemName(dbManager.getString(resultSet,6));
            prpLendorDto.setKindCode(dbManager.getString(resultSet,7));
            prpLendorDto.setKindName(dbManager.getString(resultSet,8));
            prpLendorDto.setCurrency(dbManager.getString(resultSet,9));
            prpLendorDto.setEndorAmount(dbManager.getDouble(resultSet,10));
            prpLendorDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLendorDto.setFlag(dbManager.getString(resultSet,12));
            prpLendorDto.setEndorseNo(dbManager.getString(resultSet,13));
            prpLendorDto.setEndorType(dbManager.getString(resultSet,14));
            prpLendorDto.setEndorGrossQuantity(dbManager.getDouble(resultSet,15));
        }
        resultSet.close();
        return prpLendorDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("claimNo,");
        buffer.append("compensateNo,");
        buffer.append("policyNo,");
        buffer.append("itemKindNo,");
        buffer.append("itemCode,");
        buffer.append("itemName,");
        buffer.append("kindCode,");
        buffer.append("kindName,");
        buffer.append("currency,");
        buffer.append("endorAmount,");
        buffer.append("inputDate,");
        buffer.append("flag,");
        buffer.append("endorseNo,");
        buffer.append("endorType,");
        buffer.append("endorGrossQuantity ");
        buffer.append("FROM PrpLendor WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLendorDto prpLendorDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLendorDto = new PrpLendorDto();
            prpLendorDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLendorDto.setCompensateNo(dbManager.getString(resultSet,2));
            prpLendorDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLendorDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLendorDto.setItemCode(dbManager.getString(resultSet,5));
            prpLendorDto.setItemName(dbManager.getString(resultSet,6));
            prpLendorDto.setKindCode(dbManager.getString(resultSet,7));
            prpLendorDto.setKindName(dbManager.getString(resultSet,8));
            prpLendorDto.setCurrency(dbManager.getString(resultSet,9));
            prpLendorDto.setEndorAmount(dbManager.getDouble(resultSet,10));
            prpLendorDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLendorDto.setFlag(dbManager.getString(resultSet,12));
            prpLendorDto.setEndorseNo(dbManager.getString(resultSet,13));
            prpLendorDto.setEndorType(dbManager.getString(resultSet,14));
            prpLendorDto.setEndorGrossQuantity(dbManager.getDouble(resultSet,15));
            collection.add(prpLendorDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLendor WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        String  statement ;
            statement = "SELECT count(1) FROM PrpLendor WHERE ";
              statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
