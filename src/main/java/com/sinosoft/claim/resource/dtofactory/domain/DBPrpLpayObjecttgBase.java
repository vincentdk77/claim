package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpayObjecttgDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpayObjecttg-֧��������������ݷ��ʶ������<br>
 * ������ 2006-08-03 14:43:26.153<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpayObjecttgBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLpayObjecttgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayObjecttgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpayObjectDto prpLpayObjectDto
     * @throws Exception
     */
    public void insert(PrpLpayObjecttgDto prpLpayObjectDto) throws Exception{
        String mainStatement = " Insert Into PrpLpayObjecttg (" + 
                           " PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Remark," + 
                           " ValidStatus)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLpayObjectDto.getPayObjectType() + "'," + 
                           "'" + prpLpayObjectDto.getPayObjectCode() + "'," + 
                           "'" + prpLpayObjectDto.getPayObjectName() + "'," + 
                           "'" + prpLpayObjectDto.getComCode() + "'," + 
                           "'" + prpLpayObjectDto.getOperatorCode() + "'," + 
                           "'" + prpLpayObjectDto.getRemark() + "'," + 
                           "'" + prpLpayObjectDto.getValidStatus() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpayObjectDto.getPayObjectType());
        dbManager.setString(2,prpLpayObjectDto.getPayObjectCode());
        dbManager.setString(3,prpLpayObjectDto.getPayObjectName());
        dbManager.setString(4,prpLpayObjectDto.getComCode());
        dbManager.setString(5,prpLpayObjectDto.getOperatorCode());
        dbManager.setString(6,prpLpayObjectDto.getRemark());
        dbManager.setString(7,prpLpayObjectDto.getValidStatus());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpayObjecttgBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpayObjecttgDto prpLpayObjectDto = (PrpLpayObjecttgDto)i.next();
            insert(prpLpayObjectDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param payObjectCode ֧���������
     * @throws Exception
     */
    public void delete(String payObjectCode) throws Exception{
        String statement = " Delete From PrpLpayObjecttg" + 
	            		   " Where " +
                           " PayObjectCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLpayObjecttg Where " +
                           " PayObjectCode = '" + payObjectCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,payObjectCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpayObjecttgBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpayObjectDto prpLpayObjectDto
     * @throws Exception
     */
    public void update(PrpLpayObjecttgDto prpLpayObjectDto) throws Exception{
        String statement = " Update PrpLpayObjecttg Set PayObjectType = ?," + 
                           " PayObjectName = ?," + 
                           " ComCode = ?," + 
                           " OperatorCode = ?," + 
                           " Remark = ?," + 
                           " ValidStatus = ?" + 
	            		   " Where " +
                           " PayObjectCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLpayObjecttg Set " + 
                           " PayObjectType = '" + prpLpayObjectDto.getPayObjectType() + "'," + 
                           " PayObjectCode = '" + prpLpayObjectDto.getPayObjectCode() + "'," + 
                           " PayObjectName = '" + prpLpayObjectDto.getPayObjectName() + "'," + 
                           " ComCode = '" + prpLpayObjectDto.getComCode() + "'," + 
                           " OperatorCode = '" + prpLpayObjectDto.getOperatorCode() + "'," + 
                           " Remark = '" + prpLpayObjectDto.getRemark() + "'," + 
                           " ValidStatus = '" + prpLpayObjectDto.getValidStatus() + "'" + 
			               " Where " +
                           " PayObjectCode = '" + prpLpayObjectDto.getPayObjectCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLpayObjectDto.getPayObjectType());
        dbManager.setString(2,prpLpayObjectDto.getPayObjectName());
        dbManager.setString(3,prpLpayObjectDto.getComCode());
        dbManager.setString(4,prpLpayObjectDto.getOperatorCode());
        dbManager.setString(5,prpLpayObjectDto.getRemark());
        dbManager.setString(6,prpLpayObjectDto.getValidStatus());
        //���������ֶ�;
        dbManager.setString(7,prpLpayObjectDto.getPayObjectCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpayObjecttgBase.update() success!");
    }

    /**
     * ����������һ������
     * @param payObjectCode ֧���������
     * @return PrpLpayObjecttgDto
     * @throws Exception
     */
    public PrpLpayObjecttgDto findByPrimaryKey(String payObjectCode) throws Exception{
        String mainStatement = " Select PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Remark," + 
                           " ValidStatus From PrpLpayObjecttg";
        String statement = mainStatement + " Where " +
                           " PayObjectCode = ?";
        PrpLpayObjecttgDto prpLpayObjectDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PayObjectCode = '" + payObjectCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,payObjectCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpayObjectDto = new PrpLpayObjecttgDto();
            prpLpayObjectDto.setPayObjectType(dbManager.getString(resultSet,1));
            prpLpayObjectDto.setPayObjectCode(dbManager.getString(resultSet,2));
            prpLpayObjectDto.setPayObjectName(dbManager.getString(resultSet,3));
            prpLpayObjectDto.setComCode(dbManager.getString(resultSet,4));
            prpLpayObjectDto.setOperatorCode(dbManager.getString(resultSet,5));
            prpLpayObjectDto.setRemark(dbManager.getString(resultSet,6));
            prpLpayObjectDto.setValidStatus(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        logger.info("DBPrpLpayObjecttgBase.findByPrimaryKey() success!");
        return prpLpayObjectDto;
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
        String statement = "Select PayObjectType," + 
                           " PayObjectCode," + 
                           " PayObjectName," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Remark," + 
                           " ValidStatus From PrpLpayObjecttg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpayObjecttgDto prpLpayObjectDto = null;
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

            prpLpayObjectDto = new PrpLpayObjecttgDto();
            prpLpayObjectDto.setPayObjectType(dbManager.getString(resultSet,1));
            prpLpayObjectDto.setPayObjectCode(dbManager.getString(resultSet,2));
            prpLpayObjectDto.setPayObjectName(dbManager.getString(resultSet,3));
            prpLpayObjectDto.setComCode(dbManager.getString(resultSet,4));
            prpLpayObjectDto.setOperatorCode(dbManager.getString(resultSet,5));
            prpLpayObjectDto.setRemark(dbManager.getString(resultSet,6));
            prpLpayObjectDto.setValidStatus(dbManager.getString(resultSet,7));
            collection.add(prpLpayObjectDto);
        }
        resultSet.close();
        logger.info("DBPrpLpayObjecttgBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpayObjecttg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpayObjecttgBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLpayObjecttg Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpayObjecttgBase.getCount() success!");
        return count;
    }
}
