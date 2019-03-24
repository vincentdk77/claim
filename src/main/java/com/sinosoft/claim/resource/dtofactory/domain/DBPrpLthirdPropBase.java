package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ������ݷ��ʶ������<br>
 * ������ 2005-04-12 16:23:36.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdPropBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLthirdPropBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLthirdPropBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void insert(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        String mainStatement = " Insert Into PrpLthirdProp (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " LossItemDesc," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLthirdPropDto.getRegistNo() + "'," + 
                           "'" + prpLthirdPropDto.getRiskCode() + "'," + 
                           "" + prpLthirdPropDto.getSerialNo() + "," + 
                           "'" + prpLthirdPropDto.getLicenseNo() + "'," + 
                           "'" + prpLthirdPropDto.getLossItemCode() + "'," + 
                           "'" + prpLthirdPropDto.getLossItemName() + "'," + 
                           "'" + prpLthirdPropDto.getLossItemDesc() + "'," + 
                           "'" + prpLthirdPropDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLthirdPropDto.getRegistNo());
        dbManager.setString(2,prpLthirdPropDto.getRiskCode());
        dbManager.setInt(3,prpLthirdPropDto.getSerialNo());
        dbManager.setString(4,prpLthirdPropDto.getLicenseNo());
        dbManager.setString(5,prpLthirdPropDto.getLossItemCode());
        dbManager.setString(6,prpLthirdPropDto.getLossItemName());
        dbManager.setString(7,prpLthirdPropDto.getLossItemDesc());
        dbManager.setString(8,prpLthirdPropDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdPropBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLthirdProp (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " LossItemDesc," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLthirdPropDto prpLthirdPropDto = (PrpLthirdPropDto)i.next();
            dbManager.setString(1,prpLthirdPropDto.getRegistNo());
            dbManager.setString(2,prpLthirdPropDto.getRiskCode());
            dbManager.setInt(3,prpLthirdPropDto.getSerialNo());
            dbManager.setString(4,prpLthirdPropDto.getLicenseNo());
            dbManager.setString(5,prpLthirdPropDto.getLossItemCode());
            dbManager.setString(6,prpLthirdPropDto.getLossItemName());
            dbManager.setString(7,prpLthirdPropDto.getLossItemDesc());
            dbManager.setString(8,prpLthirdPropDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLthirdPropBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ��������
     * @param serialNo ��ʧ��Ŀ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLthirdProp" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLthirdProp Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLthirdPropBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void update(PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        String statement = " Update PrpLthirdProp Set RiskCode = ?," + 
                           " LicenseNo = ?," + 
                           " LossItemCode = ?," + 
                           " LossItemName = ?," + 
                           " LossItemDesc = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLthirdProp Set " + 
                           " RegistNo = '" + prpLthirdPropDto.getRegistNo() + "'," + 
                           " RiskCode = '" + prpLthirdPropDto.getRiskCode() + "'," + 
                           " SerialNo = " + prpLthirdPropDto.getSerialNo() + "," + 
                           " LicenseNo = '" + prpLthirdPropDto.getLicenseNo() + "'," + 
                           " LossItemCode = '" + prpLthirdPropDto.getLossItemCode() + "'," + 
                           " LossItemName = '" + prpLthirdPropDto.getLossItemName() + "'," + 
                           " LossItemDesc = '" + prpLthirdPropDto.getLossItemDesc() + "'," + 
                           " Flag = '" + prpLthirdPropDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLthirdPropDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLthirdPropDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLthirdPropDto.getRiskCode());
        dbManager.setString(2,prpLthirdPropDto.getLicenseNo());
        dbManager.setString(3,prpLthirdPropDto.getLossItemCode());
        dbManager.setString(4,prpLthirdPropDto.getLossItemName());
        dbManager.setString(5,prpLthirdPropDto.getLossItemDesc());
        dbManager.setString(6,prpLthirdPropDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpLthirdPropDto.getRegistNo());
        dbManager.setInt(8,prpLthirdPropDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdPropBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ��������
     * @param serialNo ��ʧ��Ŀ���
     * @return PrpLthirdPropDto
     * @throws Exception
     */
    public PrpLthirdPropDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " LossItemDesc," + 
                           " Flag From PrpLthirdProp";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLthirdPropDto prpLthirdPropDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLthirdPropDto = new PrpLthirdPropDto();
            prpLthirdPropDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdPropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdPropDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdPropDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLthirdPropDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLthirdPropDto.setLossItemName(dbManager.getString(resultSet,6));
            prpLthirdPropDto.setLossItemDesc(dbManager.getString(resultSet,7));
            prpLthirdPropDto.setFlag(dbManager.getString(resultSet,8));
            logger.info("DBPrpLthirdPropBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLthirdPropBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLthirdPropDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LicenseNo," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " LossItemDesc," + 
                           " Flag From PrpLthirdProp Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLthirdPropDto prpLthirdPropDto = null;
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

            prpLthirdPropDto = new PrpLthirdPropDto();
            prpLthirdPropDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLthirdPropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLthirdPropDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdPropDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLthirdPropDto.setLossItemCode(dbManager.getString(resultSet,5));
            prpLthirdPropDto.setLossItemName(dbManager.getString(resultSet,6));
            prpLthirdPropDto.setLossItemDesc(dbManager.getString(resultSet,7));
            prpLthirdPropDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpLthirdPropDto);
        }
        resultSet.close();
        logger.info("DBPrpLthirdPropBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLthirdProp Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLthirdPropBase.deleteByConditions() success!");
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(1) from PrpLthirdProp Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLthirdPropBase.getCount() success!");
        return count;
    }
}
