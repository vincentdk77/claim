package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredArtifDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsuredartif������Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsuredArtifBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCinsuredArtifBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCinsuredArtifBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCinsuredArtifDto prpCinsuredArtifDto
     * @throws Exception
     */
    public void insert(PrpCinsuredArtifDto prpCinsuredArtifDto) throws Exception{
        String statement = " Insert Into PrpCinsuredArtif(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " LeaderName," + 
                           " LeaderID," + 
                           " PhoneNumber," + 
                           " PostCode," + 
                           " BusinessCode," + 
                           " RevenueRegistNo," + 
                           " CarType," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCinsuredArtifDto.getPolicyNo());
        dbManager.setInt(2,prpCinsuredArtifDto.getSerialNo());
        dbManager.setString(3,prpCinsuredArtifDto.getInsuredFlag());
        dbManager.setString(4,prpCinsuredArtifDto.getLeaderName());
        dbManager.setString(5,prpCinsuredArtifDto.getLeaderID());
        dbManager.setString(6,prpCinsuredArtifDto.getPhoneNumber());
        dbManager.setString(7,prpCinsuredArtifDto.getPostCode());
        dbManager.setString(8,prpCinsuredArtifDto.getBusinessCode());
        dbManager.setString(9,prpCinsuredArtifDto.getRevenueRegistNo());
        dbManager.setString(10,prpCinsuredArtifDto.getCarType());
        dbManager.setString(11,prpCinsuredArtifDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredArtifBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCinsuredArtifDto prpCinsuredArtifDto = (PrpCinsuredArtifDto)i.next();
            insert(prpCinsuredArtifDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCinsuredArtif Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCinsuredArtifBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCinsuredArtifDto prpCinsuredArtifDto
     * @throws Exception
     */
    public void update(PrpCinsuredArtifDto prpCinsuredArtifDto) throws Exception{
        String statement = " Update PrpCinsuredArtif Set InsuredFlag = ?," + 
                           " LeaderName = ?," + 
                           " LeaderID = ?," + 
                           " PhoneNumber = ?," + 
                           " PostCode = ?," + 
                           " BusinessCode = ?," + 
                           " RevenueRegistNo = ?," + 
                           " CarType = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCinsuredArtifDto.getInsuredFlag());
        dbManager.setString(2,prpCinsuredArtifDto.getLeaderName());
        dbManager.setString(3,prpCinsuredArtifDto.getLeaderID());
        dbManager.setString(4,prpCinsuredArtifDto.getPhoneNumber());
        dbManager.setString(5,prpCinsuredArtifDto.getPostCode());
        dbManager.setString(6,prpCinsuredArtifDto.getBusinessCode());
        dbManager.setString(7,prpCinsuredArtifDto.getRevenueRegistNo());
        dbManager.setString(8,prpCinsuredArtifDto.getCarType());
        dbManager.setString(9,prpCinsuredArtifDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpCinsuredArtifDto.getPolicyNo());
        dbManager.setInt(11,prpCinsuredArtifDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredArtifBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @return PrpCinsuredArtifDto
     * @throws Exception
     */
    public PrpCinsuredArtifDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " LeaderName," + 
                           " LeaderID," + 
                           " PhoneNumber," + 
                           " PostCode," + 
                           " BusinessCode," + 
                           " RevenueRegistNo," + 
                           " CarType," + 
                           " Flag From PrpCinsuredArtif Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCinsuredArtifDto prpCinsuredArtifDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCinsuredArtifDto = new PrpCinsuredArtifDto();
            prpCinsuredArtifDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredArtifDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredArtifDto.setInsuredFlag(dbManager.getString(resultSet,3));
            prpCinsuredArtifDto.setLeaderName(dbManager.getString(resultSet,4));
            prpCinsuredArtifDto.setLeaderID(dbManager.getString(resultSet,5));
            prpCinsuredArtifDto.setPhoneNumber(dbManager.getString(resultSet,6));
            prpCinsuredArtifDto.setPostCode(dbManager.getString(resultSet,7));
            prpCinsuredArtifDto.setBusinessCode(dbManager.getString(resultSet,8));
            prpCinsuredArtifDto.setRevenueRegistNo(dbManager.getString(resultSet,9));
            prpCinsuredArtifDto.setCarType(dbManager.getString(resultSet,10));
            prpCinsuredArtifDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpCinsuredArtifBase.findByPrimaryKey() success!");
        return prpCinsuredArtifDto;
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
        String statement = "Select PolicyNo," + 
                           " SerialNo," + 
                           " InsuredFlag," + 
                           " LeaderName," + 
                           " LeaderID," + 
                           " PhoneNumber," + 
                           " PostCode," + 
                           " BusinessCode," + 
                           " RevenueRegistNo," + 
                           " CarType," + 
                           " Flag From PrpCinsuredArtif Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCinsuredArtifDto prpCinsuredArtifDto = null;
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

            prpCinsuredArtifDto = new PrpCinsuredArtifDto();
            prpCinsuredArtifDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredArtifDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredArtifDto.setInsuredFlag(dbManager.getString(resultSet,3));
            prpCinsuredArtifDto.setLeaderName(dbManager.getString(resultSet,4));
            prpCinsuredArtifDto.setLeaderID(dbManager.getString(resultSet,5));
            prpCinsuredArtifDto.setPhoneNumber(dbManager.getString(resultSet,6));
            prpCinsuredArtifDto.setPostCode(dbManager.getString(resultSet,7));
            prpCinsuredArtifDto.setBusinessCode(dbManager.getString(resultSet,8));
            prpCinsuredArtifDto.setRevenueRegistNo(dbManager.getString(resultSet,9));
            prpCinsuredArtifDto.setCarType(dbManager.getString(resultSet,10));
            prpCinsuredArtifDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpCinsuredArtifDto);
        }
        resultSet.close();
        log.info("DBPrpCinsuredArtifBase.findByConditions() success!");
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
        String statement = "Delete From PrpCinsuredArtif Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCinsuredArtifBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpCinsuredArtif Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredArtifBase.getCount() success!");
        return count;
    }
}
