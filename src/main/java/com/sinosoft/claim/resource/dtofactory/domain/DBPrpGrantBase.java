package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGrantDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrant��Ȩ��¼������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGrantBase{
    private DBManager dbManager = null; //��Դ������
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
                           " RiskType," + 
                           " TaskCode," + 
                           " CheckType," + 
                           " Power," + 
                           " GrantStartDate," + 
                           " GrantEndDate," + 
                           " Condition," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGrantDto.getUserCode());
        dbManager.setString(2,prpGrantDto.getRiskType());
        dbManager.setString(3,prpGrantDto.getTaskCode());
        dbManager.setString(4,prpGrantDto.getCheckType());
        dbManager.setString(5,prpGrantDto.getPower());
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
     * @param userCode Ա������
     * @param riskType ��Ȩ����
     * @param taskCode ��Ȩ����
     * @param checkType ��Ȩ����
     * @param grantStartDate ��Ȩ��ʼʱ��
     * @param grantEndDate ��Ȩ��ֹʱ��
     * @throws Exception
     */
    public void delete(String userCode,String riskType,String taskCode,String checkType,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String statement = " Delete From PrpGrant Where " +
                           " UserCode = ? And " + 
                           " RiskType = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckType = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,riskType);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkType);
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
        String statement = " Update PrpGrant Set Power = ?," + 
                           " Condition = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " UserCode = ? And " + 
                           " RiskType = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckType = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpGrantDto.getPower());
        dbManager.setString(2,prpGrantDto.getCondition());
        dbManager.setString(3,prpGrantDto.getRemark());
        dbManager.setString(4,prpGrantDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpGrantDto.getUserCode());
        dbManager.setString(6,prpGrantDto.getRiskType());
        dbManager.setString(7,prpGrantDto.getTaskCode());
        dbManager.setString(8,prpGrantDto.getCheckType());
        dbManager.setDateTime(9,prpGrantDto.getGrantStartDate());
        dbManager.setDateTime(10,prpGrantDto.getGrantEndDate());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGrantBase.update() success!");
    }

    /**
     * ����������һ������
     * @param userCode Ա������
     * @param riskType ��Ȩ����
     * @param taskCode ��Ȩ����
     * @param checkType ��Ȩ����
     * @param grantStartDate ��Ȩ��ʼʱ��
     * @param grantEndDate ��Ȩ��ֹʱ��
     * @return PrpGrantDto
     * @throws Exception
     */
    public PrpGrantDto findByPrimaryKey(String userCode,String riskType,String taskCode,String checkType,DateTime grantStartDate,DateTime grantEndDate) throws Exception{
        String statement = " Select UserCode," + 
                           " RiskType," + 
                           " TaskCode," + 
                           " CheckType," + 
                           " Power," + 
                           " GrantStartDate," + 
                           " GrantEndDate," + 
                           " Condition," + 
                           " Remark," + 
                           " Flag From PrpGrant Where " +
                           " UserCode = ? And " + 
                           " RiskType = ? And " + 
                           " TaskCode = ? And " + 
                           " CheckType = ? And " + 
                           " GrantStartDate = ? And " + 
                           " GrantEndDate = ?";
        PrpGrantDto prpGrantDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,userCode);
        dbManager.setString(2,riskType);
        dbManager.setString(3,taskCode);
        dbManager.setString(4,checkType);
        dbManager.setDateTime(5,grantStartDate);
        dbManager.setDateTime(6,grantEndDate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGrantDto = new PrpGrantDto();
            prpGrantDto.setUserCode(dbManager.getString(resultSet,1));
            prpGrantDto.setRiskType(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckType(dbManager.getString(resultSet,4));
            prpGrantDto.setPower(dbManager.getString(resultSet,5));
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
                           " RiskType," + 
                           " TaskCode," + 
                           " CheckType," + 
                           " Power," + 
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
            prpGrantDto.setRiskType(dbManager.getString(resultSet,2));
            prpGrantDto.setTaskCode(dbManager.getString(resultSet,3));
            prpGrantDto.setCheckType(dbManager.getString(resultSet,4));
            prpGrantDto.setPower(dbManager.getString(resultSet,5));
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
        String statement = "Select count(1) from PrpGrant Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGrantBase.getCount() success!");
        return count;
    }
}
