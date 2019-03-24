package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipClassDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdshipclass������������յ����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDshipClassBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDshipClassBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDshipClassBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void insert(PrpDshipClassDto prpDshipClassDto) throws Exception{
        String statement = " Insert Into PrpDshipClass(" + 
                           " ShipCode," + 
                           " SerialNo," + 
                           " Classification," + 
                           " IssuedonDate," + 
                           " ClosingDate," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDshipClassDto.getShipCode());
        dbManager.setInt(2,prpDshipClassDto.getSerialNo());
        dbManager.setString(3,prpDshipClassDto.getClassification());
        dbManager.setDateTime(4,prpDshipClassDto.getIssuedonDate());
        dbManager.setDateTime(5,prpDshipClassDto.getClosingDate());
        dbManager.setString(6,prpDshipClassDto.getRemark());
        dbManager.setString(7,prpDshipClassDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshipClassBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDshipClassDto prpDshipClassDto = (PrpDshipClassDto)i.next();
            insert(prpDshipClassDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param shipCode ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String shipCode,int serialNo) throws Exception{
        String statement = " Delete From PrpDshipClass Where " +
                           " ShipCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,shipCode);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDshipClassBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void update(PrpDshipClassDto prpDshipClassDto) throws Exception{
        String statement = " Update PrpDshipClass Set Classification = ?," + 
                           " IssuedonDate = ?," + 
                           " ClosingDate = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " ShipCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDshipClassDto.getClassification());
        dbManager.setDateTime(2,prpDshipClassDto.getIssuedonDate());
        dbManager.setDateTime(3,prpDshipClassDto.getClosingDate());
        dbManager.setString(4,prpDshipClassDto.getRemark());
        dbManager.setString(5,prpDshipClassDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpDshipClassDto.getShipCode());
        dbManager.setInt(7,prpDshipClassDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDshipClassBase.update() success!");
    }

    /**
     * ����������һ������
     * @param shipCode ��������
     * @param serialNo ���
     * @return PrpDshipClassDto
     * @throws Exception
     */
    public PrpDshipClassDto findByPrimaryKey(String shipCode,int serialNo) throws Exception{
        String statement = " Select ShipCode," + 
                           " SerialNo," + 
                           " Classification," + 
                           " IssuedonDate," + 
                           " ClosingDate," + 
                           " Remark," + 
                           " Flag From PrpDshipClass Where " +
                           " ShipCode = ? And " + 
                           " SerialNo = ?";
        PrpDshipClassDto prpDshipClassDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,shipCode);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDshipClassDto = new PrpDshipClassDto();
            prpDshipClassDto.setShipCode(dbManager.getString(resultSet,1));
            prpDshipClassDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpDshipClassDto.setClassification(dbManager.getString(resultSet,3));
            prpDshipClassDto.setIssuedonDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDshipClassDto.setClosingDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpDshipClassDto.setRemark(dbManager.getString(resultSet,6));
            prpDshipClassDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDshipClassBase.findByPrimaryKey() success!");
        return prpDshipClassDto;
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
        String statement = "Select ShipCode," + 
                           " SerialNo," + 
                           " Classification," + 
                           " IssuedonDate," + 
                           " ClosingDate," + 
                           " Remark," + 
                           " Flag From PrpDshipClass Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDshipClassDto prpDshipClassDto = null;
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

            prpDshipClassDto = new PrpDshipClassDto();
            prpDshipClassDto.setShipCode(dbManager.getString(resultSet,1));
            prpDshipClassDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpDshipClassDto.setClassification(dbManager.getString(resultSet,3));
            prpDshipClassDto.setIssuedonDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDshipClassDto.setClosingDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpDshipClassDto.setRemark(dbManager.getString(resultSet,6));
            prpDshipClassDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDshipClassDto);
        }
        resultSet.close();
        log.info("DBPrpDshipClassBase.findByConditions() success!");
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
        String statement = "Delete From PrpDshipClass Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDshipClassBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDshipClass Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDshipClassBase.getCount() success!");
        return count;
    }
}
