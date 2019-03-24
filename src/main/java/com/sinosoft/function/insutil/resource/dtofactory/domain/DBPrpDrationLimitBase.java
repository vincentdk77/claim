package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrationLimitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrationlimit�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrationLimitBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDrationLimitBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrationLimitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void insert(PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        String statement = " Insert Into PrpDrationLimit(" + 
                           " RiskCode," + 
                           " LimitGrade," + 
                           " LimitCode," + 
                           " RationType," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " Currency," + 
                           " LimitFee," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrationLimitDto.getRiskCode());
        dbManager.setString(2,prpDrationLimitDto.getLimitGrade());
        dbManager.setString(3,prpDrationLimitDto.getLimitCode());
        dbManager.setString(4,prpDrationLimitDto.getRationType());
        dbManager.setString(5,prpDrationLimitDto.getKindCode());
        dbManager.setString(6,prpDrationLimitDto.getItemCode());
        dbManager.setString(7,prpDrationLimitDto.getModeCode());
        dbManager.setString(8,prpDrationLimitDto.getCurrency());
        dbManager.setDouble(9,prpDrationLimitDto.getLimitFee());
        dbManager.setString(10,prpDrationLimitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationLimitBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrationLimitDto prpDrationLimitDto = (PrpDrationLimitDto)i.next();
            insert(prpDrationLimitDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @throws Exception
     */
    public void delete(String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        String statement = " Delete From PrpDrationLimit Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ? And " + 
                           " RationType = ? And " + 
                           " KindCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,limitCode);
        dbManager.setString(3,rationType);
        dbManager.setString(4,kindCode);
        dbManager.setString(5,itemCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrationLimitBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDrationLimitDto prpDrationLimitDto
     * @throws Exception
     */
    public void update(PrpDrationLimitDto prpDrationLimitDto) throws Exception{
        String statement = " Update PrpDrationLimit Set LimitGrade = ?," + 
                           " ModeCode = ?," + 
                           " Currency = ?," + 
                           " LimitFee = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ? And " + 
                           " RationType = ? And " + 
                           " KindCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDrationLimitDto.getLimitGrade());
        dbManager.setString(2,prpDrationLimitDto.getModeCode());
        dbManager.setString(3,prpDrationLimitDto.getCurrency());
        dbManager.setDouble(4,prpDrationLimitDto.getLimitFee());
        dbManager.setString(5,prpDrationLimitDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpDrationLimitDto.getRiskCode());
        dbManager.setString(7,prpDrationLimitDto.getLimitCode());
        dbManager.setString(8,prpDrationLimitDto.getRationType());
        dbManager.setString(9,prpDrationLimitDto.getKindCode());
        dbManager.setString(10,prpDrationLimitDto.getItemCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationLimitBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param limitCode limitcode
     * @param rationType rationtype
     * @param kindCode kindcode
     * @param itemCode itemcode
     * @return PrpDrationLimitDto
     * @throws Exception
     */
    public PrpDrationLimitDto findByPrimaryKey(String riskCode,String limitCode,String rationType,String kindCode,String itemCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " LimitGrade," + 
                           " LimitCode," + 
                           " RationType," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " Currency," + 
                           " LimitFee," + 
                           " Flag From PrpDrationLimit Where " +
                           " RiskCode = ? And " + 
                           " LimitCode = ? And " + 
                           " RationType = ? And " + 
                           " KindCode = ? And " + 
                           " ItemCode = ?";
        PrpDrationLimitDto prpDrationLimitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,limitCode);
        dbManager.setString(3,rationType);
        dbManager.setString(4,kindCode);
        dbManager.setString(5,itemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrationLimitDto = new PrpDrationLimitDto();
            prpDrationLimitDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationLimitDto.setLimitGrade(dbManager.getString(resultSet,2));
            prpDrationLimitDto.setLimitCode(dbManager.getString(resultSet,3));
            prpDrationLimitDto.setRationType(dbManager.getString(resultSet,4));
            prpDrationLimitDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationLimitDto.setItemCode(dbManager.getString(resultSet,6));
            prpDrationLimitDto.setModeCode(dbManager.getString(resultSet,7));
            prpDrationLimitDto.setCurrency(dbManager.getString(resultSet,8));
            prpDrationLimitDto.setLimitFee(dbManager.getDouble(resultSet,9));
            prpDrationLimitDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDrationLimitBase.findByPrimaryKey() success!");
        return prpDrationLimitDto;
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
        String statement = "Select RiskCode," + 
                           " LimitGrade," + 
                           " LimitCode," + 
                           " RationType," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ModeCode," + 
                           " Currency," + 
                           " LimitFee," + 
                           " Flag From PrpDrationLimit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrationLimitDto prpDrationLimitDto = null;
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

            prpDrationLimitDto = new PrpDrationLimitDto();
            prpDrationLimitDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationLimitDto.setLimitGrade(dbManager.getString(resultSet,2));
            prpDrationLimitDto.setLimitCode(dbManager.getString(resultSet,3));
            prpDrationLimitDto.setRationType(dbManager.getString(resultSet,4));
            prpDrationLimitDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationLimitDto.setItemCode(dbManager.getString(resultSet,6));
            prpDrationLimitDto.setModeCode(dbManager.getString(resultSet,7));
            prpDrationLimitDto.setCurrency(dbManager.getString(resultSet,8));
            prpDrationLimitDto.setLimitFee(dbManager.getDouble(resultSet,9));
            prpDrationLimitDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDrationLimitDto);
        }
        resultSet.close();
        log.info("DBPrpDrationLimitBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrationLimit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrationLimitBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrationLimit Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrationLimitBase.getCount() success!");
        return count;
    }
}
