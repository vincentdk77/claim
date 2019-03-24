package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDprofitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdprofit�Ż��ۿ�����������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDprofitBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDprofitBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDprofitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void insert(PrpDprofitDto prpDprofitDto) throws Exception{
        String statement = " Insert Into PrpDprofit(" + 
                           " Comcode," + 
                           " RiskCode," + 
                           " ProfitPeriod," + 
                           " ValidDate," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValueLower," + 
                           " FieldValueUpper," + 
                           " minprofitrate," + 
                           " ProfitRate," + 
                           " MaxProfitRate," + 
                           " ProfitFlag," + 
                           " ValidStatus," + 
                           " flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDprofitDto.getComcode());
        dbManager.setString(2,prpDprofitDto.getRiskCode());
        dbManager.setInt(3,prpDprofitDto.getProfitPeriod());
        dbManager.setDateTime(4,prpDprofitDto.getValidDate());
        dbManager.setString(5,prpDprofitDto.getProfitCode());
        dbManager.setString(6,prpDprofitDto.getProfitName());
        dbManager.setInt(7,prpDprofitDto.getSerialNo());
        dbManager.setString(8,prpDprofitDto.getCondition());
        dbManager.setDouble(9,prpDprofitDto.getFieldValueLower());
        dbManager.setDouble(10,prpDprofitDto.getFieldValueUpper());
        dbManager.setDouble(11,prpDprofitDto.getMinprofitrate());
        dbManager.setDouble(12,prpDprofitDto.getProfitRate());
        dbManager.setDouble(13,prpDprofitDto.getMaxProfitRate());
        dbManager.setString(14,prpDprofitDto.getProfitFlag());
        dbManager.setString(15,prpDprofitDto.getValidStatus());
        dbManager.setString(16,prpDprofitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDprofitBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDprofitDto prpDprofitDto = (PrpDprofitDto)i.next();
            insert(prpDprofitDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param comcode ��������
     * @param riskCode ����
     * @param profitPeriod ����
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        String statement = " Delete From PrpDprofit Where " +
                           " Comcode = ? And " + 
                           " RiskCode = ? And " + 
                           " ProfitPeriod = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,comcode);
        dbManager.setString(2,riskCode);
        dbManager.setInt(3,profitPeriod);
        dbManager.setString(4,profitCode);
        dbManager.setInt(5,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDprofitBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDprofitDto prpDprofitDto
     * @throws Exception
     */
    public void update(PrpDprofitDto prpDprofitDto) throws Exception{
        String statement = " Update PrpDprofit Set ValidDate = ?," + 
                           " ProfitName = ?," + 
                           " Condition = ?," + 
                           " FieldValueLower = ?," + 
                           " FieldValueUpper = ?," + 
                           " minprofitrate = ?," + 
                           " ProfitRate = ?," + 
                           " MaxProfitRate = ?," + 
                           " ProfitFlag = ?," + 
                           " ValidStatus = ?," + 
                           " flag = ? Where " +
                           " Comcode = ? And " + 
                           " RiskCode = ? And " + 
                           " ProfitPeriod = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpDprofitDto.getValidDate());
        dbManager.setString(2,prpDprofitDto.getProfitName());
        dbManager.setString(3,prpDprofitDto.getCondition());
        dbManager.setDouble(4,prpDprofitDto.getFieldValueLower());
        dbManager.setDouble(5,prpDprofitDto.getFieldValueUpper());
        dbManager.setDouble(6,prpDprofitDto.getMinprofitrate());
        dbManager.setDouble(7,prpDprofitDto.getProfitRate());
        dbManager.setDouble(8,prpDprofitDto.getMaxProfitRate());
        dbManager.setString(9,prpDprofitDto.getProfitFlag());
        dbManager.setString(10,prpDprofitDto.getValidStatus());
        dbManager.setString(11,prpDprofitDto.getFlag());
        //���������ֶ�;
        dbManager.setString(12,prpDprofitDto.getComcode());
        dbManager.setString(13,prpDprofitDto.getRiskCode());
        dbManager.setInt(14,prpDprofitDto.getProfitPeriod());
        dbManager.setString(15,prpDprofitDto.getProfitCode());
        dbManager.setInt(16,prpDprofitDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDprofitBase.update() success!");
    }

    /**
     * ����������һ������
     * @param comcode ��������
     * @param riskCode ����
     * @param profitPeriod ����
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @return PrpDprofitDto
     * @throws Exception
     */
    public PrpDprofitDto findByPrimaryKey(String comcode,String riskCode,int profitPeriod,String profitCode,int serialNo) throws Exception{
        String statement = " Select Comcode," + 
                           " RiskCode," + 
                           " ProfitPeriod," + 
                           " ValidDate," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValueLower," + 
                           " FieldValueUpper," + 
                           " minprofitrate," + 
                           " ProfitRate," + 
                           " MaxProfitRate," + 
                           " ProfitFlag," + 
                           " ValidStatus," + 
                           " flag From PrpDprofit Where " +
                           " Comcode = ? And " + 
                           " RiskCode = ? And " + 
                           " ProfitPeriod = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        PrpDprofitDto prpDprofitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,comcode);
        dbManager.setString(2,riskCode);
        dbManager.setInt(3,profitPeriod);
        dbManager.setString(4,profitCode);
        dbManager.setInt(5,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDprofitDto = new PrpDprofitDto();
            prpDprofitDto.setComcode(dbManager.getString(resultSet,1));
            prpDprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpDprofitDto.setProfitPeriod(dbManager.getInt(resultSet,3));
            prpDprofitDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDprofitDto.setProfitCode(dbManager.getString(resultSet,5));
            prpDprofitDto.setProfitName(dbManager.getString(resultSet,6));
            prpDprofitDto.setSerialNo(dbManager.getInt(resultSet,7));
            prpDprofitDto.setCondition(dbManager.getString(resultSet,8));
            prpDprofitDto.setFieldValueLower(dbManager.getDouble(resultSet,9));
            prpDprofitDto.setFieldValueUpper(dbManager.getDouble(resultSet,10));
            prpDprofitDto.setMinprofitrate(dbManager.getDouble(resultSet,11));
            prpDprofitDto.setProfitRate(dbManager.getDouble(resultSet,12));
            prpDprofitDto.setMaxProfitRate(dbManager.getDouble(resultSet,13));
            prpDprofitDto.setProfitFlag(dbManager.getString(resultSet,14));
            prpDprofitDto.setValidStatus(dbManager.getString(resultSet,15));
            prpDprofitDto.setFlag(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        log.info("DBPrpDprofitBase.findByPrimaryKey() success!");
        return prpDprofitDto;
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
        String statement = "Select Comcode," + 
                           " RiskCode," + 
                           " ProfitPeriod," + 
                           " ValidDate," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValueLower," + 
                           " FieldValueUpper," + 
                           " minprofitrate," + 
                           " ProfitRate," + 
                           " MaxProfitRate," + 
                           " ProfitFlag," + 
                           " ValidStatus," + 
                           " flag From PrpDprofit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDprofitDto prpDprofitDto = null;
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

            prpDprofitDto = new PrpDprofitDto();
            prpDprofitDto.setComcode(dbManager.getString(resultSet,1));
            prpDprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpDprofitDto.setProfitPeriod(dbManager.getInt(resultSet,3));
            prpDprofitDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpDprofitDto.setProfitCode(dbManager.getString(resultSet,5));
            prpDprofitDto.setProfitName(dbManager.getString(resultSet,6));
            prpDprofitDto.setSerialNo(dbManager.getInt(resultSet,7));
            prpDprofitDto.setCondition(dbManager.getString(resultSet,8));
            prpDprofitDto.setFieldValueLower(dbManager.getDouble(resultSet,9));
            prpDprofitDto.setFieldValueUpper(dbManager.getDouble(resultSet,10));
            prpDprofitDto.setMinprofitrate(dbManager.getDouble(resultSet,11));
            prpDprofitDto.setProfitRate(dbManager.getDouble(resultSet,12));
            prpDprofitDto.setMaxProfitRate(dbManager.getDouble(resultSet,13));
            prpDprofitDto.setProfitFlag(dbManager.getString(resultSet,14));
            prpDprofitDto.setValidStatus(dbManager.getString(resultSet,15));
            prpDprofitDto.setFlag(dbManager.getString(resultSet,16));
            collection.add(prpDprofitDto);
        }
        resultSet.close();
        log.info("DBPrpDprofitBase.findByConditions() success!");
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
        String statement = "Delete From PrpDprofit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDprofitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDprofit Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDprofitBase.getCount() success!");
        return count;
    }
}
