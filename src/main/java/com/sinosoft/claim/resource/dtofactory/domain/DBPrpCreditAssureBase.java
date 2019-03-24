package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCreditAssureDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpCreditAssure����Ԥ��ȷ�Ϻ��ű�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCreditAssureBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCreditAssureBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCreditAssureBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void insert(PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        String statement = " Insert Into PrpCreditAssure(" + 
                           " ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCreditAssureDto.getConfirmNo());
        dbManager.setString(2,prpCreditAssureDto.getInvestigateNo());
        dbManager.setString(3,prpCreditAssureDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditAssureBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCreditAssureDto prpCreditAssureDto = (PrpCreditAssureDto)i.next();
            insert(prpCreditAssureDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param confirmNo ����Ԥ��ȷ�Ϻ���
     * @throws Exception
     */
    public void delete(String confirmNo) throws Exception{
        String statement = " Delete From PrpCreditAssure Where " +
                           " ConfirmNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,confirmNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCreditAssureBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCreditAssureDto prpCreditAssureDto
     * @throws Exception
     */
    public void update(PrpCreditAssureDto prpCreditAssureDto) throws Exception{
        String statement = " Update PrpCreditAssure Set InvestigateNo = ?," + 
                           " Flag = ? Where " +
                           " ConfirmNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCreditAssureDto.getInvestigateNo());
        dbManager.setString(2,prpCreditAssureDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpCreditAssureDto.getConfirmNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCreditAssureBase.update() success!");
    }

    /**
     * ����������һ������
     * @param confirmNo ����Ԥ��ȷ�Ϻ���
     * @return PrpCreditAssureDto
     * @throws Exception
     */
    public PrpCreditAssureDto findByPrimaryKey(String confirmNo) throws Exception{
        String statement = " Select ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag From PrpCreditAssure Where " +
                           " ConfirmNo = ?";
        PrpCreditAssureDto prpCreditAssureDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,confirmNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCreditAssureDto = new PrpCreditAssureDto();
            prpCreditAssureDto.setConfirmNo(dbManager.getString(resultSet,1));
            prpCreditAssureDto.setInvestigateNo(dbManager.getString(resultSet,2));
            prpCreditAssureDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpCreditAssureBase.findByPrimaryKey() success!");
        return prpCreditAssureDto;
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
        String statement = "Select ConfirmNo," + 
                           " InvestigateNo," + 
                           " Flag From PrpCreditAssure Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCreditAssureDto prpCreditAssureDto = null;
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

            prpCreditAssureDto = new PrpCreditAssureDto();
            prpCreditAssureDto.setConfirmNo(dbManager.getString(resultSet,1));
            prpCreditAssureDto.setInvestigateNo(dbManager.getString(resultSet,2));
            prpCreditAssureDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpCreditAssureDto);
        }
        resultSet.close();
        log.info("DBPrpCreditAssureBase.findByConditions() success!");
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
        String statement = "Delete From PrpCreditAssure Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCreditAssureBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCreditAssure Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCreditAssureBase.getCount() success!");
        return count;
    }
}
