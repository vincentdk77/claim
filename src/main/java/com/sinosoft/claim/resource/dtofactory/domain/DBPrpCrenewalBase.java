package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcrenewal������Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCrenewalBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCrenewalBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCrenewalBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void insert(PrpCrenewalDto prpCrenewalDto) throws Exception{
        String statement = " Insert Into PrpCrenewal(" + 
                           " PolicyNo," + 
                           " OldPolicyNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCrenewalDto.getPolicyNo());
        dbManager.setString(2,prpCrenewalDto.getOldPolicyNo());
        dbManager.setString(3,prpCrenewalDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCrenewalBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCrenewalDto prpCrenewalDto = (PrpCrenewalDto)i.next();
            insert(prpCrenewalDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(String policyNo) throws Exception{
        String statement = " Delete From PrpCrenewal Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCrenewalBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void update(PrpCrenewalDto prpCrenewalDto) throws Exception{
        String statement = " Update PrpCrenewal Set OldPolicyNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCrenewalDto.getOldPolicyNo());
        dbManager.setString(2,prpCrenewalDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpCrenewalDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCrenewalBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @return PrpCrenewalDto
     * @throws Exception
     */
    public PrpCrenewalDto findByPrimaryKey(String policyNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " OldPolicyNo," + 
                           " Flag From PrpCrenewal Where " +
                           " PolicyNo = ?";
        PrpCrenewalDto prpCrenewalDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCrenewalDto = new PrpCrenewalDto();
            prpCrenewalDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCrenewalDto.setOldPolicyNo(dbManager.getString(resultSet,2));
            prpCrenewalDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpCrenewalBase.findByPrimaryKey() success!");
        return prpCrenewalDto;
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
                           " OldPolicyNo," + 
                           " Flag From PrpCrenewal Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCrenewalDto prpCrenewalDto = null;
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

            prpCrenewalDto = new PrpCrenewalDto();
            prpCrenewalDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCrenewalDto.setOldPolicyNo(dbManager.getString(resultSet,2));
            prpCrenewalDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpCrenewalDto);
        }
        resultSet.close();
        log.info("DBPrpCrenewalBase.findByConditions() success!");
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
        String statement = "Delete From PrpCrenewal Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCrenewalBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCrenewal Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCrenewalBase.getCount() success!");
        return count;
    }
}
