package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonWoundDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonWound-������Ϣ��(����)�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLpersonWoundBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLpersonWoundBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpersonWoundBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void insert(PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        String mainStatement = " Insert Into PrpLpersonWound (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " WoundCode," + 
                           " WoundDesc," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLpersonWoundDto.getRegistNo() + "'," + 
                           "'" + prpLpersonWoundDto.getClaimNo() + "'," + 
                           "'" + prpLpersonWoundDto.getPolicyNo() + "'," + 
                           "" + prpLpersonWoundDto.getSerialNo() + "," + 
                           "" + prpLpersonWoundDto.getPersonNo() + "," + 
                           "'" + prpLpersonWoundDto.getPersonName() + "'," + 
                           "'" + prpLpersonWoundDto.getWoundCode() + "'," + 
                           "'" + prpLpersonWoundDto.getWoundDesc() + "'," + 
                           "'" + prpLpersonWoundDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpersonWoundDto.getRegistNo());
        dbManager.setString(2,prpLpersonWoundDto.getClaimNo());
        dbManager.setString(3,prpLpersonWoundDto.getPolicyNo());
        dbManager.setInt(4,prpLpersonWoundDto.getSerialNo());
        dbManager.setInt(5,prpLpersonWoundDto.getPersonNo());
        dbManager.setString(6,prpLpersonWoundDto.getPersonName());
        dbManager.setString(7,prpLpersonWoundDto.getWoundCode());
        dbManager.setString(8,prpLpersonWoundDto.getWoundDesc());
        dbManager.setString(9,prpLpersonWoundDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonWoundBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLpersonWound (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " WoundCode," + 
                           " WoundDesc," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpersonWoundDto prpLpersonWoundDto = (PrpLpersonWoundDto)i.next();
            dbManager.setString(1,prpLpersonWoundDto.getRegistNo());
            dbManager.setString(2,prpLpersonWoundDto.getClaimNo());
            dbManager.setString(3,prpLpersonWoundDto.getPolicyNo());
            dbManager.setInt(4,prpLpersonWoundDto.getSerialNo());
            dbManager.setInt(5,prpLpersonWoundDto.getPersonNo());
            dbManager.setString(6,prpLpersonWoundDto.getPersonName());
            dbManager.setString(7,prpLpersonWoundDto.getWoundCode());
            dbManager.setString(8,prpLpersonWoundDto.getWoundDesc());
            dbManager.setString(9,prpLpersonWoundDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLpersonWoundBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @param serialNo ���
     * @param personNo ��Ա���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,int personNo) throws Exception{
        String statement = " Delete From PrpLpersonWound" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " PersonNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLpersonWound Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " PersonNo = " + personNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,personNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpersonWoundBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpersonWoundDto prpLpersonWoundDto
     * @throws Exception
     */
    public void update(PrpLpersonWoundDto prpLpersonWoundDto) throws Exception{
        String statement = " Update PrpLpersonWound Set ClaimNo = ?," + 
                           " PolicyNo = ?," + 
                           " PersonName = ?," + 
                           " WoundCode = ?," + 
                           " WoundDesc = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " PersonNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLpersonWound Set " + 
                           " RegistNo = '" + prpLpersonWoundDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLpersonWoundDto.getClaimNo() + "'," + 
                           " PolicyNo = '" + prpLpersonWoundDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLpersonWoundDto.getSerialNo() + "," + 
                           " PersonNo = " + prpLpersonWoundDto.getPersonNo() + "," + 
                           " PersonName = '" + prpLpersonWoundDto.getPersonName() + "'," + 
                           " WoundCode = '" + prpLpersonWoundDto.getWoundCode() + "'," + 
                           " WoundDesc = '" + prpLpersonWoundDto.getWoundDesc() + "'," + 
                           " Flag = '" + prpLpersonWoundDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLpersonWoundDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLpersonWoundDto.getSerialNo() + " And " + 
                           " PersonNo = " + prpLpersonWoundDto.getPersonNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLpersonWoundDto.getClaimNo());
        dbManager.setString(2,prpLpersonWoundDto.getPolicyNo());
        dbManager.setString(3,prpLpersonWoundDto.getPersonName());
        dbManager.setString(4,prpLpersonWoundDto.getWoundCode());
        dbManager.setString(5,prpLpersonWoundDto.getWoundDesc());
        dbManager.setString(6,prpLpersonWoundDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpLpersonWoundDto.getRegistNo());
        dbManager.setInt(8,prpLpersonWoundDto.getSerialNo());
        dbManager.setInt(9,prpLpersonWoundDto.getPersonNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpersonWoundBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @param serialNo ���
     * @param personNo ��Ա���
     * @return PrpLpersonWoundDto
     * @throws Exception
     */
    public PrpLpersonWoundDto findByPrimaryKey(String registNo,int serialNo,int personNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " WoundCode," + 
                           " WoundDesc," + 
                           " Flag From PrpLpersonWound";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " PersonNo = ?";
        PrpLpersonWoundDto prpLpersonWoundDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " PersonNo = " + personNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,personNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpersonWoundDto = new PrpLpersonWoundDto();
            prpLpersonWoundDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpersonWoundDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLpersonWoundDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonWoundDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonWoundDto.setPersonNo(dbManager.getInt(resultSet,5));
            prpLpersonWoundDto.setPersonName(dbManager.getString(resultSet,6));
            prpLpersonWoundDto.setWoundCode(dbManager.getString(resultSet,7));
            prpLpersonWoundDto.setWoundDesc(dbManager.getString(resultSet,8));
            prpLpersonWoundDto.setFlag(dbManager.getString(resultSet,9));
            logger.info("DBPrpLpersonWoundBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLpersonWoundBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLpersonWoundDto;
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
                           " ClaimNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PersonNo," + 
                           " PersonName," + 
                           " WoundCode," + 
                           " WoundDesc," + 
                           " Flag From PrpLpersonWound Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpersonWoundDto prpLpersonWoundDto = null;
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

            prpLpersonWoundDto = new PrpLpersonWoundDto();
            prpLpersonWoundDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpersonWoundDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLpersonWoundDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpersonWoundDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpersonWoundDto.setPersonNo(dbManager.getInt(resultSet,5));
            prpLpersonWoundDto.setPersonName(dbManager.getString(resultSet,6));
            prpLpersonWoundDto.setWoundCode(dbManager.getString(resultSet,7));
            prpLpersonWoundDto.setWoundDesc(dbManager.getString(resultSet,8));
            prpLpersonWoundDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpLpersonWoundDto);
        }
        resultSet.close();
        logger.info("DBPrpLpersonWoundBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpersonWound Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpersonWoundBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLpersonWound Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpersonWoundBase.getCount() success!");
        return count;
    }
}
