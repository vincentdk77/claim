package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeExtDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgradeext��λ��չ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGradeExtBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpGradeExtBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGradeExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void insert(PrpGradeExtDto prpGradeExtDto) throws Exception{
        String statement = " Insert Into PrpGradeExt(" + 
                           " GradeCode," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPaid) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGradeExtDto.getGradeCode());
        dbManager.setString(2,prpGradeExtDto.getRiskCode());
        dbManager.setString(3,prpGradeExtDto.getCurrency());
        dbManager.setDouble(4,prpGradeExtDto.getSumAmount());
        dbManager.setDouble(5,prpGradeExtDto.getRate());
        dbManager.setDouble(6,prpGradeExtDto.getSumPaid());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeExtBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGradeExtDto prpGradeExtDto = (PrpGradeExtDto)i.next();
            insert(prpGradeExtDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param gradeCode ��λ����
     * @param riskCode ���ִ���
     * @param currency �ұ�
     * @throws Exception
     */
    public void delete(String gradeCode,String riskCode,String currency) throws Exception{
        String statement = " Delete From PrpGradeExt Where " +
                           " GradeCode = ? And " + 
                           " RiskCode = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,gradeCode);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,currency);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGradeExtBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void update(PrpGradeExtDto prpGradeExtDto) throws Exception{
        String statement = " Update PrpGradeExt Set SumAmount = ?," + 
                           " Rate = ?," + 
                           " SumPaid = ? Where " +
                           " GradeCode = ? And " + 
                           " RiskCode = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDouble(1,prpGradeExtDto.getSumAmount());
        dbManager.setDouble(2,prpGradeExtDto.getRate());
        dbManager.setDouble(3,prpGradeExtDto.getSumPaid());
        //���������ֶ�;
        dbManager.setString(4,prpGradeExtDto.getGradeCode());
        dbManager.setString(5,prpGradeExtDto.getRiskCode());
        dbManager.setString(6,prpGradeExtDto.getCurrency());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGradeExtBase.update() success!");
    }

    /**
     * ����������һ������
     * @param gradeCode ��λ����
     * @param riskCode ���ִ���
     * @param currency �ұ�
     * @return PrpGradeExtDto
     * @throws Exception
     */
    public PrpGradeExtDto findByPrimaryKey(String gradeCode,String riskCode,String currency) throws Exception{
        String statement = " Select GradeCode," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPaid From PrpGradeExt Where " +
                           " GradeCode = ? And " + 
                           " RiskCode = ? And " + 
                           " Currency = ?";
        PrpGradeExtDto prpGradeExtDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,gradeCode);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGradeExtDto = new PrpGradeExtDto();
            prpGradeExtDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpGradeExtDto.setCurrency(dbManager.getString(resultSet,3));
            prpGradeExtDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpGradeExtDto.setRate(dbManager.getDouble(resultSet,5));
            prpGradeExtDto.setSumPaid(dbManager.getDouble(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpGradeExtBase.findByPrimaryKey() success!");
        return prpGradeExtDto;
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
        String statement = "Select GradeCode," + 
                           " RiskCode," + 
                           " Currency," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPaid From PrpGradeExt Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGradeExtDto prpGradeExtDto = null;
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

            prpGradeExtDto = new PrpGradeExtDto();
            prpGradeExtDto.setGradeCode(dbManager.getString(resultSet,1));
            prpGradeExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpGradeExtDto.setCurrency(dbManager.getString(resultSet,3));
            prpGradeExtDto.setSumAmount(dbManager.getDouble(resultSet,4));
            prpGradeExtDto.setRate(dbManager.getDouble(resultSet,5));
            prpGradeExtDto.setSumPaid(dbManager.getDouble(resultSet,6));
            collection.add(prpGradeExtDto);
        }
        resultSet.close();
        log.info("DBPrpGradeExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpGradeExt Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGradeExtBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpGradeExt Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGradeExtBase.getCount() success!");
        return count;
    }
}
