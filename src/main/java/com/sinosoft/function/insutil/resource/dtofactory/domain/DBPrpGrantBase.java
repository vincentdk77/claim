package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrant�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGrantBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpGrantBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGrantBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void insert(PrpGrantDto prpGrantDto) throws Exception{
        String statement = " Insert Into PrpGrant(" + 
                           " UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " GrantStartDate," + 
                           " GrantEndDate," + 
                           " Condition," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGrantDto.getUserCode());
        dbManager.setString(2,prpGrantDto.getGroupCode());
        dbManager.setString(3,prpGrantDto.getTaskCode());
        dbManager.setString(4,prpGrantDto.getCheckCode());
        dbManager.setString(5,prpGrantDto.getValue());
        dbManager.setDateTime(6,prpGrantDto.getGrantStartDate());
        dbManager.setDateTime(7,prpGrantDto.getGrantEndDate());
        dbManager.setString(8,prpGrantDto.getCondition());
        dbManager.setString(9,prpGrantDto.getRemark());
        dbManager.setString(10,prpGrantDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGrantBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGrantDto prpGrantDto = (PrpGrantDto)i.next();
            insert(prpGrantDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @param grantStartDate grantstartdate
     * @param grantEndDate grantenddate
     * @throws Exception
     */
    public void delete(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String statement = " Delete From PrpGrant Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.setDateTime(5,grantStartDate);
        dbManager.setDateTime(6,grantEndDate);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGrantBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpGrantDto prpGrantDto
     * @throws Exception
     */
    public void update(PrpGrantDto prpGrantDto) throws Exception{
        String statement = " Update PrpGrant Set Value = ?," + 
                           " Condition = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpGrantDto.getValue());
        dbManager.setString(2,prpGrantDto.getCondition());
        dbManager.setString(3,prpGrantDto.getRemark());
        dbManager.setString(4,prpGrantDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpGrantDto.getUserCode());
        dbManager.setString(6,prpGrantDto.getGroupCode());
        dbManager.setString(7,prpGrantDto.getTaskCode());
        dbManager.setString(8,prpGrantDto.getCheckCode());
        dbManager.setDateTime(9,prpGrantDto.getGrantStartDate());
        dbManager.setDateTime(10,prpGrantDto.getGrantEndDate());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGrantBase.update() success!");
    }

    /**
     * ����������һ������
     * @param userCode usercode
     * @param groupCode groupcode
     * @param taskCode taskcode
     * @param checkCode checkcode
     * @param grantStartDate grantstartdate
     * @param grantEndDate grantenddate
     * @return PrpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(String userCode,String groupCode,String taskCode,String checkCode,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String statement = " Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " GrantStartDate," + 
                           " GrantEndDate," + 
                           " Condition," + 
                           " Remark," + 
                           " Flag From PrpGrant Where " +
                           " UserCode = ? And " + 
                           " GroupCode = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckCode = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        PrpGrantDto prpGrantDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,groupCode);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkCode);
        dbManager.setDateTime(5,grantStartDate);
        dbManager.setDateTime(6,grantEndDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGrantDto = new PrpGrantDto();
            prpGrantDto.setUserCode(dbManager.getString(resultSet,1));
            prpGrantDto.setGroupCode(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckCode(dbManager.getString(resultSet,4));
            prpGrantDto.setValue(dbManager.getString(resultSet,5));
            prpGrantDto.setGrantStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpGrantDto.setGrantEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpGrantDto.setCondition(dbManager.getString(resultSet,8));
            prpGrantDto.setRemark(dbManager.getString(resultSet,9));
            prpGrantDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpGrantBase.findByPrimaryKey() success!");
        return prpGrantDto;
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
        String statement = "Select UserCode," + 
                           " GroupCode," + 
                           " TaskCode," + 
                           " CheckCode," + 
                           " Value," + 
                           " GrantStartDate," + 
                           " GrantEndDate," + 
                           " Condition," + 
                           " Remark," + 
                           " Flag From PrpGrant Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGrantDto prpGrantDto = null;
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

            prpGrantDto = new PrpGrantDto();
            prpGrantDto.setUserCode(dbManager.getString(resultSet,1));
            prpGrantDto.setGroupCode(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckCode(dbManager.getString(resultSet,4));
            prpGrantDto.setValue(dbManager.getString(resultSet,5));
            prpGrantDto.setGrantStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpGrantDto.setGrantEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpGrantDto.setCondition(dbManager.getString(resultSet,8));
            prpGrantDto.setRemark(dbManager.getString(resultSet,9));
            prpGrantDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpGrantDto);
        }
        resultSet.close();
        log.info("DBPrpGrantBase.findByConditions() success!");
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
        String statement = "Delete From PrpGrant Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGrantBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpGrant Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGrantBase.getCount() success!");
        return count;
    }
}
