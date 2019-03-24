package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdCarLoss-损失部位(新增)的数据访问对象基类<br>
 * 创建于 2005-04-06 09:08:02.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdCarLossBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLthirdCarLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLthirdCarLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void insert(PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        String mainStatement = " Insert Into PrpLthirdCarLoss (" +
                           " RegistNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " ItemNo," +
                           " LicenseNo," +
                           " CompCode," +
                           " CompName," +
                           " LossGrade," +
                           " LossDesc," +
                           " Flag," +
                           " PartCode," +
                           " PartName,"+
                           " KindCode)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpLthirdCarLossDto.getRegistNo() + "'," +
                           "'" + prpLthirdCarLossDto.getRiskCode() + "'," +
                           "" + prpLthirdCarLossDto.getSerialNo() + "," +
                           "" + prpLthirdCarLossDto.getItemNo() + "," +
                           "'" + prpLthirdCarLossDto.getLicenseNo() + "'," +
                           "'" + prpLthirdCarLossDto.getCompCode() + "'," +
                           "'" + prpLthirdCarLossDto.getCompName() + "'," +
                           "'" + prpLthirdCarLossDto.getLossGrade() + "'," +
                           "'" + prpLthirdCarLossDto.getLossDesc() + "'," +
                           "'" + prpLthirdCarLossDto.getFlag() + "'," +
                           "'" + prpLthirdCarLossDto.getPartCode() + "'," +
                           "'" + prpLthirdCarLossDto.getPartName() + "',"+
                            "'" + prpLthirdCarLossDto.getKindCode() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLthirdCarLossDto.getRegistNo());
        dbManager.setString(2,prpLthirdCarLossDto.getRiskCode());
        dbManager.setInt(3,prpLthirdCarLossDto.getSerialNo());
        dbManager.setInt(4,prpLthirdCarLossDto.getItemNo());
        dbManager.setString(5,prpLthirdCarLossDto.getLicenseNo());
        dbManager.setString(6,prpLthirdCarLossDto.getCompCode());
        dbManager.setString(7,prpLthirdCarLossDto.getCompName());
        dbManager.setString(8,prpLthirdCarLossDto.getLossGrade());
        dbManager.setString(9,prpLthirdCarLossDto.getLossDesc());
        dbManager.setString(10,prpLthirdCarLossDto.getFlag());
        dbManager.setString(11,prpLthirdCarLossDto.getPartCode());
        dbManager.setString(12,prpLthirdCarLossDto.getPartName());
        dbManager.setString(13,prpLthirdCarLossDto.getKindCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdCarLossBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLthirdCarLoss (" +
                           " RegistNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " ItemNo," +
                           " LicenseNo," +
                           " CompCode," +
                           " CompName," +
                           " LossGrade," +
                           " LossDesc," +
                           " Flag," +
                           " PartCode," +
                           " PartName,"+
                           " KindCode)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLthirdCarLossDto prpLthirdCarLossDto = (PrpLthirdCarLossDto)i.next();
            dbManager.setString(1,prpLthirdCarLossDto.getRegistNo());
            dbManager.setString(2,prpLthirdCarLossDto.getRiskCode());
            dbManager.setInt(3,prpLthirdCarLossDto.getSerialNo());
            dbManager.setInt(4,prpLthirdCarLossDto.getItemNo());
            dbManager.setString(5,prpLthirdCarLossDto.getLicenseNo());
            dbManager.setString(6,prpLthirdCarLossDto.getCompCode());
            dbManager.setString(7,prpLthirdCarLossDto.getCompName());
            dbManager.setString(8,prpLthirdCarLossDto.getLossGrade());
            dbManager.setString(9,prpLthirdCarLossDto.getLossDesc());
            dbManager.setString(10,prpLthirdCarLossDto.getFlag());
            dbManager.setString(11,prpLthirdCarLossDto.getPartCode());
            dbManager.setString(12,prpLthirdCarLossDto.getPartName());
            dbManager.setString(13,prpLthirdCarLossDto.getKindCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLthirdCarLossBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param itemNo 损失项目序号
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,int itemNo) throws Exception{
        String statement = " Delete From PrpLthirdCarLoss" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ? And " +
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLthirdCarLoss Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " SerialNo = " + serialNo + " And " +
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,itemNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLthirdCarLossBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLthirdCarLossDto prpLthirdCarLossDto
     * @throws Exception
     */
    public void update(PrpLthirdCarLossDto prpLthirdCarLossDto) throws Exception{
        String statement = " Update PrpLthirdCarLoss Set RiskCode = ?," +
                           " LicenseNo = ?," +
                           " CompCode = ?," +
                           " CompName = ?," +
                           " LossGrade = ?," +
                           " LossDesc = ?," +
                           " Flag = ?," +
                           " PartCode = ?," +
                           " PartName = ?" +
                           " KindCode = ?" +
	            		   " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ? And " +
                           " ItemNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLthirdCarLoss Set " +
                           " RegistNo = '" + prpLthirdCarLossDto.getRegistNo() + "'," +
                           " RiskCode = '" + prpLthirdCarLossDto.getRiskCode() + "'," +
                           " SerialNo = " + prpLthirdCarLossDto.getSerialNo() + "," +
                           " ItemNo = " + prpLthirdCarLossDto.getItemNo() + "," +
                           " LicenseNo = '" + prpLthirdCarLossDto.getLicenseNo() + "'," +
                           " CompCode = '" + prpLthirdCarLossDto.getCompCode() + "'," +
                           " CompName = '" + prpLthirdCarLossDto.getCompName() + "'," +
                           " LossGrade = '" + prpLthirdCarLossDto.getLossGrade() + "'," +
                           " LossDesc = '" + prpLthirdCarLossDto.getLossDesc() + "'," +
                           " Flag = '" + prpLthirdCarLossDto.getFlag() + "'," +
                           " PartCode = '" + prpLthirdCarLossDto.getPartCode() + "'," +
                           " PartName = '" + prpLthirdCarLossDto.getPartName() + "'" +
                           " KindCode = '" + prpLthirdCarLossDto.getKindCode() + "'" +
			               " Where " +
                           " RegistNo = '" + prpLthirdCarLossDto.getRegistNo() + "' And " +
                           " SerialNo = " + prpLthirdCarLossDto.getSerialNo() + " And " +
                           " ItemNo = " + prpLthirdCarLossDto.getItemNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLthirdCarLossDto.getRiskCode());
        dbManager.setString(2,prpLthirdCarLossDto.getLicenseNo());
        dbManager.setString(3,prpLthirdCarLossDto.getCompCode());
        dbManager.setString(4,prpLthirdCarLossDto.getCompName());
        dbManager.setString(5,prpLthirdCarLossDto.getLossGrade());
        dbManager.setString(6,prpLthirdCarLossDto.getLossDesc());
        dbManager.setString(7,prpLthirdCarLossDto.getFlag());
        dbManager.setString(8,prpLthirdCarLossDto.getPartCode());
        dbManager.setString(9,prpLthirdCarLossDto.getPartName());
        dbManager.setString(10,prpLthirdCarLossDto.getKindCode());
        //设置条件字段;
        dbManager.setString(11,prpLthirdCarLossDto.getRegistNo());
        dbManager.setInt(12,prpLthirdCarLossDto.getSerialNo());
        dbManager.setInt(13,prpLthirdCarLossDto.getItemNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdCarLossBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param itemNo 损失项目序号
     * @return PrpLthirdCarLossDto
     * @throws Exception
     */
    public PrpLthirdCarLossDto findByPrimaryKey(String registNo,int serialNo,int itemNo) throws Exception{
        String mainStatement = " Select RegistNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " ItemNo," +
                           " LicenseNo," +
                           " CompCode," +
                           " CompName," +
                           " LossGrade," +
                           " LossDesc," +
                           " Flag," +
                           " PartCode," +
                           " PartName,"+
                           " KindCode From PrpLthirdCarLoss";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " +
                           " SerialNo = ? And " +
                           " ItemNo = ?";
        PrpLthirdCarLossDto prpLthirdCarLossDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " +
                           " SerialNo = " + serialNo + " And " +
                           " ItemNo = " + itemNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLthirdCarLossDto = new PrpLthirdCarLossDto();
            prpLthirdCarLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdCarLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdCarLossDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdCarLossDto.setItemNo(dbManager.getInt(resultSet,4));
            prpLthirdCarLossDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLthirdCarLossDto.setCompCode(dbManager.getString(resultSet,6));
            prpLthirdCarLossDto.setCompName(dbManager.getString(resultSet,7));
            prpLthirdCarLossDto.setLossGrade(dbManager.getString(resultSet,8));
            prpLthirdCarLossDto.setLossDesc(dbManager.getString(resultSet,9));
            prpLthirdCarLossDto.setFlag(dbManager.getString(resultSet,10));
            prpLthirdCarLossDto.setPartCode(dbManager.getString(resultSet,11));
            prpLthirdCarLossDto.setPartName(dbManager.getString(resultSet,12));
            prpLthirdCarLossDto.setKindCode(dbManager.getString(resultSet,13));
            logger.info("DBPrpLthirdCarLossBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLthirdCarLossBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLthirdCarLossDto;
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
        String statement = "Select RegistNo," +
                           " RiskCode," +
                           " SerialNo," +
                           " ItemNo," +
                           " LicenseNo," +
                           " CompCode," +
                           " CompName," +
                           " LossGrade," +
                           " LossDesc," +
                           " Flag," +
                           " PartCode," +
                           " PartName," +
                           " KindCode From PrpLthirdCarLoss Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLthirdCarLossDto prpLthirdCarLossDto = null;
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

            prpLthirdCarLossDto = new PrpLthirdCarLossDto();
            prpLthirdCarLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdCarLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdCarLossDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdCarLossDto.setItemNo(dbManager.getInt(resultSet,4));
            prpLthirdCarLossDto.setLicenseNo(dbManager.getString(resultSet,5));
            prpLthirdCarLossDto.setCompCode(dbManager.getString(resultSet,6));
            prpLthirdCarLossDto.setCompName(dbManager.getString(resultSet,7));
            prpLthirdCarLossDto.setLossGrade(dbManager.getString(resultSet,8));
            prpLthirdCarLossDto.setLossDesc(dbManager.getString(resultSet,9));
            prpLthirdCarLossDto.setFlag(dbManager.getString(resultSet,10));
            prpLthirdCarLossDto.setPartCode(dbManager.getString(resultSet,11));
            prpLthirdCarLossDto.setPartName(dbManager.getString(resultSet,12));
            prpLthirdCarLossDto.setKindCode(dbManager.getString(resultSet,13));
            collection.add(prpLthirdCarLossDto);
        }
        resultSet.close();
        logger.info("DBPrpLthirdCarLossBase.findByConditions() success!");
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
        String statement = "Delete From PrpLthirdCarLoss Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLthirdCarLossBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLthirdCarLoss Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLthirdCarLossBase.getCount() success!");
        return count;
    }
}
