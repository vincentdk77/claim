package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg-理赔图片上传路径的数据访问对象基类<br>
 * 创建于 2005-03-23 16:36:56.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcertifyImgBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLcertifyImgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertifyImgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void insert(PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        String mainStatement = " Insert Into PrpLcertifyImg (" + 
                           " BusinessNo," + 
                           " SerialNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " TypeCode," + 
                           " PicName," + 
                           " SignInDate," + 
                           " ThirdPartyCode," + 
                           " UploadFileName," + 
                           " ImgFileName," + 
                           " PicPath," + 
                           " CollectorName," + 
                           " ReceiveStatus," + 
                           " Flag," + 
                           " ImgSize," + 
                           " UploadNodeFlag," + 
                           " DisplayName," + 
                           " PolicyNo," +
						   " ValidStatus)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcertifyImgDto.getBusinessNo() + "'," + 
                           "" + prpLcertifyImgDto.getSerialNo() + "," + 
                           "'" + prpLcertifyImgDto.getLossItemCode() + "'," + 
                           "'" + prpLcertifyImgDto.getLossItemName() + "'," + 
                           "'" + prpLcertifyImgDto.getTypeCode() + "'," + 
                           "'" + prpLcertifyImgDto.getPicName() + "'," + 
                           "'" + prpLcertifyImgDto.getSignInDate() + "'," + 
                           "'" + prpLcertifyImgDto.getThirdPartyCode() + "'," + 
                           "'" + prpLcertifyImgDto.getUploadFileName() + "'," + 
                           "'" + prpLcertifyImgDto.getImgFileName() + "'," + 
                           "'" + prpLcertifyImgDto.getPicPath() + "'," + 
                           "'" + prpLcertifyImgDto.getCollectorName() + "'," + 
                           "'" + prpLcertifyImgDto.getReceiveStatus() + "'," + 
                           "'" + prpLcertifyImgDto.getFlag() + "'," + 
                           "'" + prpLcertifyImgDto.getImgSize() + "'," + 
                           "'" + prpLcertifyImgDto.getUploadNodeFlag() + "'," + 
                           "'" + prpLcertifyImgDto.getDisplayName() + "'," + 
                           "'" + prpLcertifyImgDto.getPolicyNo() + "'," + 
                           "'" + prpLcertifyImgDto.getValidStatus() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcertifyImgDto.getBusinessNo());
        dbManager.setInt(2,prpLcertifyImgDto.getSerialNo());
        dbManager.setString(3,prpLcertifyImgDto.getLossItemCode());
        dbManager.setString(4,prpLcertifyImgDto.getLossItemName());
        dbManager.setString(5,prpLcertifyImgDto.getTypeCode());
        dbManager.setString(6,prpLcertifyImgDto.getPicName());
        dbManager.setDateTime(7,prpLcertifyImgDto.getSignInDate());
        dbManager.setString(8,prpLcertifyImgDto.getThirdPartyCode());
        dbManager.setString(9,prpLcertifyImgDto.getUploadFileName());
        dbManager.setString(10,prpLcertifyImgDto.getImgFileName());
        dbManager.setString(11,prpLcertifyImgDto.getPicPath());
        dbManager.setString(12,prpLcertifyImgDto.getCollectorName());
        dbManager.setString(13,prpLcertifyImgDto.getReceiveStatus());
        dbManager.setString(14,prpLcertifyImgDto.getFlag());
        dbManager.setDouble(15,prpLcertifyImgDto.getImgSize());
        dbManager.setString(16,prpLcertifyImgDto.getUploadNodeFlag());
        dbManager.setString(17,prpLcertifyImgDto.getDisplayName());
        dbManager.setString(18,prpLcertifyImgDto.getPolicyNo());
        dbManager.setString(19,prpLcertifyImgDto.getValidStatus());
		
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcertifyImgBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcertifyImg (" + 
                           " BusinessNo," + 
                           " SerialNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " TypeCode," + 
                           " PicName," + 
                           " SignInDate," + 
                           " ThirdPartyCode," + 
                           " UploadFileName," + 
                           " ImgFileName," + 
                           " PicPath," + 
                           " CollectorName," + 
                           " ReceiveStatus," + 
                           " Flag," + 
                           " ImgSize," + 
                           " UploadNodeFlag," + 
                           " DisplayName," + 
                           " PolicyNo," +
						   " ValidStatus)";

        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcertifyImgDto prpLcertifyImgDto = (PrpLcertifyImgDto)i.next();
            dbManager.setString(1,prpLcertifyImgDto.getBusinessNo());
            dbManager.setInt(2,prpLcertifyImgDto.getSerialNo());
            dbManager.setString(3,prpLcertifyImgDto.getLossItemCode());
            dbManager.setString(4,prpLcertifyImgDto.getLossItemName());
            dbManager.setString(5,prpLcertifyImgDto.getTypeCode());
            dbManager.setString(6,prpLcertifyImgDto.getPicName());
            dbManager.setDateTime(7,prpLcertifyImgDto.getSignInDate());
            dbManager.setString(8,prpLcertifyImgDto.getThirdPartyCode());
            dbManager.setString(9,prpLcertifyImgDto.getUploadFileName());
            dbManager.setString(10,prpLcertifyImgDto.getImgFileName());
            dbManager.setString(11,prpLcertifyImgDto.getPicPath());
            dbManager.setString(12,prpLcertifyImgDto.getCollectorName());
            dbManager.setString(13,prpLcertifyImgDto.getReceiveStatus());
            dbManager.setString(14,prpLcertifyImgDto.getFlag());
            dbManager.setDouble(15,prpLcertifyImgDto.getImgSize());
            dbManager.setString(16,prpLcertifyImgDto.getUploadNodeFlag());
            dbManager.setString(17,prpLcertifyImgDto.getDisplayName());
            dbManager.setString(18,prpLcertifyImgDto.getPolicyNo());
            dbManager.setString(19,prpLcertifyImgDto.getValidStatus());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcertifyImgBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo,String lossItemCode) throws Exception{
        String statement = " Delete From PrpLcertifyImg" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcertifyImg Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcertifyImgBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void update(PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        String statement = " Update PrpLcertifyImg Set LossItemName = ?," + 
                           " TypeCode = ?," + 
                           " PicName = ?," + 
                           " SignInDate = ?," + 
                           " ThirdPartyCode = ?," + 
                           " UploadFileName = ?," + 
                           " ImgFileName = ?," + 
                           " PicPath = ?," + 
                           " CollectorName = ?," + 
                           " ReceiveStatus = ?," + 
                           " Flag = ?," + 
                           " ImgSize = ?," + 
                           " UploadNodeFlag = ?," + 
                           " DisplayName = ?," + 
                           " PolicyNo = ?" + 
                           " ValidStatus = ?" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcertifyImg Set " + 
                           " BusinessNo = '" + prpLcertifyImgDto.getBusinessNo() + "'," + 
                           " SerialNo = " + prpLcertifyImgDto.getSerialNo() + "," + 
                           " LossItemCode = '" + prpLcertifyImgDto.getLossItemCode() + "'," + 
                           " LossItemName = '" + prpLcertifyImgDto.getLossItemName() + "'," + 
                           " TypeCode = '" + prpLcertifyImgDto.getTypeCode() + "'," + 
                           " PicName = '" + prpLcertifyImgDto.getPicName() + "'," + 
                           " SignInDate = '" + prpLcertifyImgDto.getSignInDate() + "'," + 
                           " ThirdPartyCode = '" + prpLcertifyImgDto.getThirdPartyCode() + "'," + 
                           " UploadFileName = '" + prpLcertifyImgDto.getUploadFileName() + "'," + 
                           " ImgFileName = '" + prpLcertifyImgDto.getImgFileName() + "'," + 
                           " PicPath = '" + prpLcertifyImgDto.getPicPath() + "'," + 
                           " CollectorName = '" + prpLcertifyImgDto.getCollectorName() + "'," + 
                           " ReceiveStatus = '" + prpLcertifyImgDto.getReceiveStatus() + "'," + 
                           " Flag = '" + prpLcertifyImgDto.getFlag() + "'," + 
                           " ImgSize = '" + prpLcertifyImgDto.getImgSize() + "'," + 
                           " UploadNodeFlag = '" + prpLcertifyImgDto.getUploadNodeFlag() + "'," + 
                           " DisplayName = '" + prpLcertifyImgDto.getDisplayName() + "'," + 
                           " PolicyNo = '" + prpLcertifyImgDto.getPolicyNo() + "'" + 
                           " ValidStatus = '" + prpLcertifyImgDto.getValidStatus() + "'" +
			               " Where " +
                           " BusinessNo = '" + prpLcertifyImgDto.getBusinessNo() + "' And " + 
                           " SerialNo = " + prpLcertifyImgDto.getSerialNo() + " And " + 
                           " LossItemCode = '" + prpLcertifyImgDto.getLossItemCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLcertifyImgDto.getLossItemName());
        dbManager.setString(2,prpLcertifyImgDto.getTypeCode());
        dbManager.setString(3,prpLcertifyImgDto.getPicName());
        dbManager.setDateTime(4,prpLcertifyImgDto.getSignInDate());
        dbManager.setString(5,prpLcertifyImgDto.getThirdPartyCode());
        dbManager.setString(6,prpLcertifyImgDto.getUploadFileName());
        dbManager.setString(7,prpLcertifyImgDto.getImgFileName());
        dbManager.setString(8,prpLcertifyImgDto.getPicPath());
        dbManager.setString(9,prpLcertifyImgDto.getCollectorName());
        dbManager.setString(10,prpLcertifyImgDto.getReceiveStatus());
        dbManager.setString(11,prpLcertifyImgDto.getFlag());
        dbManager.setDouble(12,prpLcertifyImgDto.getImgSize());
        dbManager.setString(13,prpLcertifyImgDto.getUploadNodeFlag());
        dbManager.setString(14,prpLcertifyImgDto.getDisplayName());
        dbManager.setString(15,prpLcertifyImgDto.getPolicyNo());
        dbManager.setString(16,prpLcertifyImgDto.getValidStatus());
		
        //设置条件字段;
        dbManager.setString(17,prpLcertifyImgDto.getBusinessNo());
        dbManager.setInt(18,prpLcertifyImgDto.getSerialNo());
        dbManager.setString(19,prpLcertifyImgDto.getLossItemCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcertifyImgBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param businessNo 业务号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return PrpLcertifyImgDto
     * @throws Exception
     */
    public PrpLcertifyImgDto findByPrimaryKey(String businessNo,int serialNo,String lossItemCode) throws Exception{
        String mainStatement = " Select BusinessNo," + 
                           " SerialNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " TypeCode," + 
                           " PicName," + 
                           " SignInDate," + 
                           " ThirdPartyCode," + 
                           " UploadFileName," + 
                           " ImgFileName," + 
                           " PicPath," + 
                           " CollectorName," + 
                           " ReceiveStatus," + 
                           " Flag," + 
                           " ImgSize," + 
                           " UploadNodeFlag," + 
                           " DisplayName," + 
                           " PolicyNo," + 
                           " ValidStatus From PrpLcertifyImg";
        String statement = mainStatement + " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LossItemCode = ?";
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LossItemCode = '" + lossItemCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,lossItemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcertifyImgDto = new PrpLcertifyImgDto();
            prpLcertifyImgDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcertifyImgDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyImgDto.setLossItemCode(dbManager.getString(resultSet,3));
            prpLcertifyImgDto.setLossItemName(dbManager.getString(resultSet,4));
            prpLcertifyImgDto.setTypeCode(dbManager.getString(resultSet,5));
            prpLcertifyImgDto.setPicName(dbManager.getString(resultSet,6));
            prpLcertifyImgDto.setSignInDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLcertifyImgDto.setThirdPartyCode(dbManager.getString(resultSet,8));
            prpLcertifyImgDto.setUploadFileName(dbManager.getString(resultSet,9));
            prpLcertifyImgDto.setImgFileName(dbManager.getString(resultSet,10));
            prpLcertifyImgDto.setPicPath(dbManager.getString(resultSet,11));
            prpLcertifyImgDto.setCollectorName(dbManager.getString(resultSet,12));
            prpLcertifyImgDto.setReceiveStatus(dbManager.getString(resultSet,13));
            prpLcertifyImgDto.setFlag(dbManager.getString(resultSet,14));
            prpLcertifyImgDto.setImgSize(dbManager.getDouble(resultSet,15));
            prpLcertifyImgDto.setUploadNodeFlag(dbManager.getString(resultSet,16));
            prpLcertifyImgDto.setDisplayName(dbManager.getString(resultSet,17));
            prpLcertifyImgDto.setPolicyNo(dbManager.getString(resultSet,18));
            prpLcertifyImgDto.setValidStatus(dbManager.getString(resultSet,19));
            logger.info("DBPrpLcertifyImgBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcertifyImgBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcertifyImgDto;
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
        String statement = "Select BusinessNo," + 
                           " SerialNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " TypeCode," + 
                           " PicName," + 
                           " SignInDate," + 
                           " ThirdPartyCode," + 
                           " UploadFileName," + 
                           " ImgFileName," + 
                           " PicPath," + 
                           " CollectorName," + 
                           " ReceiveStatus," + 
                           " Flag," + 
                           " ImgSize," + 
                           " UploadNodeFlag," + 
                           " DisplayName," + 
                           " PolicyNo," + 
                           " ValidStatus  From PrpLcertifyImg Where " + conditions;

        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcertifyImgDto prpLcertifyImgDto = null;
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

            prpLcertifyImgDto = new PrpLcertifyImgDto();
            prpLcertifyImgDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcertifyImgDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcertifyImgDto.setLossItemCode(dbManager.getString(resultSet,3));
            prpLcertifyImgDto.setLossItemName(dbManager.getString(resultSet,4));
            prpLcertifyImgDto.setTypeCode(dbManager.getString(resultSet,5));
            prpLcertifyImgDto.setPicName(dbManager.getString(resultSet,6));
            prpLcertifyImgDto.setSignInDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,7));
            prpLcertifyImgDto.setThirdPartyCode(dbManager.getString(resultSet,8));
            prpLcertifyImgDto.setUploadFileName(dbManager.getString(resultSet,9));
            prpLcertifyImgDto.setImgFileName(dbManager.getString(resultSet,10));
            prpLcertifyImgDto.setPicPath(dbManager.getString(resultSet,11));
            prpLcertifyImgDto.setCollectorName(dbManager.getString(resultSet,12));
            prpLcertifyImgDto.setReceiveStatus(dbManager.getString(resultSet,13));
            prpLcertifyImgDto.setFlag(dbManager.getString(resultSet,14));
            prpLcertifyImgDto.setImgSize(dbManager.getDouble(resultSet,15));
            prpLcertifyImgDto.setUploadNodeFlag(dbManager.getString(resultSet,16));
            prpLcertifyImgDto.setDisplayName(dbManager.getString(resultSet,17));
            prpLcertifyImgDto.setPolicyNo(dbManager.getString(resultSet,18));
            prpLcertifyImgDto.setValidStatus(dbManager.getString(resultSet,19));
			
            collection.add(prpLcertifyImgDto);
        }
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcertifyImg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcertifyImgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcertifyImg Where " + conditions;
    statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.getCount() success!");
        return count;
    }
}
