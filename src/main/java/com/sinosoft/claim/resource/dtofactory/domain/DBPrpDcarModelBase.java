package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcarModelDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcarmodel���ʹ�������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcarModelBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDcarModelBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcarModelBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void insert(PrpDcarModelDto prpDcarModelDto) throws Exception{
        String statement = " Insert Into PrpDcarModel(" + 
                           " ModelCode," + 
                           " ShortHandCode," + 
                           " ModelName," + 
                           " CarSeriesName," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " Factory," + 
                           " CountryCode," + 
                           " PurchasePrice," + 
                           " RiskScope," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcarModelDto.getModelCode());
        dbManager.setString(2,prpDcarModelDto.getShortHandCode());
        dbManager.setString(3,prpDcarModelDto.getModelName());
        dbManager.setString(4,prpDcarModelDto.getCarSeriesName());
        dbManager.setInt(5,prpDcarModelDto.getSeatCount());
        dbManager.setDouble(6,prpDcarModelDto.getTonCount());
        dbManager.setString(7,prpDcarModelDto.getFactory());
        dbManager.setString(8,prpDcarModelDto.getCountryCode());
        dbManager.setDouble(9,prpDcarModelDto.getPurchasePrice());
        dbManager.setString(10,prpDcarModelDto.getRiskScope());
        dbManager.setDateTime(11,prpDcarModelDto.getValidDate());
        dbManager.setString(12,prpDcarModelDto.getValidStatus());
        dbManager.setString(13,prpDcarModelDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcarModelBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcarModelDto prpDcarModelDto = (PrpDcarModelDto)i.next();
            insert(prpDcarModelDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param modelCode ���ʹ���
     * @throws Exception
     */
    public void delete(String modelCode) throws Exception{
        String statement = " Delete From PrpDcarModel Where " +
                           " ModelCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,modelCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcarModelBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void update(PrpDcarModelDto prpDcarModelDto) throws Exception{
        String statement = " Update PrpDcarModel Set ShortHandCode = ?," + 
                           " ModelName = ?," + 
                           " CarSeriesName = ?," + 
                           " SeatCount = ?," + 
                           " TonCount = ?," + 
                           " Factory = ?," + 
                           " CountryCode = ?," + 
                           " PurchasePrice = ?," + 
                           " RiskScope = ?," + 
                           " ValidDate = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ModelCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDcarModelDto.getShortHandCode());
        dbManager.setString(2,prpDcarModelDto.getModelName());
        dbManager.setString(3,prpDcarModelDto.getCarSeriesName());
        dbManager.setInt(4,prpDcarModelDto.getSeatCount());
        dbManager.setDouble(5,prpDcarModelDto.getTonCount());
        dbManager.setString(6,prpDcarModelDto.getFactory());
        dbManager.setString(7,prpDcarModelDto.getCountryCode());
        dbManager.setDouble(8,prpDcarModelDto.getPurchasePrice());
        dbManager.setString(9,prpDcarModelDto.getRiskScope());
        dbManager.setDateTime(10,prpDcarModelDto.getValidDate());
        dbManager.setString(11,prpDcarModelDto.getValidStatus());
        dbManager.setString(12,prpDcarModelDto.getFlag());
        //���������ֶ�;
        dbManager.setString(13,prpDcarModelDto.getModelCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcarModelBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelCode ���ʹ���
     * @return PrpDcarModelDto
     * @throws Exception
     */
    public PrpDcarModelDto findByPrimaryKey(String modelCode) throws Exception{
        String statement = " Select ModelCode," + 
                           " ShortHandCode," + 
                           " ModelName," + 
                           " CarSeriesName," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " Factory," + 
                           " CountryCode," + 
                           " PurchasePrice," + 
                           " RiskScope," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDcarModel Where " +
                           " ModelCode = ?";
        PrpDcarModelDto prpDcarModelDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,modelCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcarModelDto = new PrpDcarModelDto();
            prpDcarModelDto.setModelCode(dbManager.getString(resultSet,1));
            prpDcarModelDto.setShortHandCode(dbManager.getString(resultSet,2));
            prpDcarModelDto.setModelName(dbManager.getString(resultSet,3));
            prpDcarModelDto.setCarSeriesName(dbManager.getString(resultSet,4));
            prpDcarModelDto.setSeatCount(dbManager.getInt(resultSet,5));
            prpDcarModelDto.setTonCount(dbManager.getDouble(resultSet,6));
            prpDcarModelDto.setFactory(dbManager.getString(resultSet,7));
            prpDcarModelDto.setCountryCode(dbManager.getString(resultSet,8));
            prpDcarModelDto.setPurchasePrice(dbManager.getDouble(resultSet,9));
            prpDcarModelDto.setRiskScope(dbManager.getString(resultSet,10));
            prpDcarModelDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpDcarModelDto.setValidStatus(dbManager.getString(resultSet,12));
            prpDcarModelDto.setFlag(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        log.info("DBPrpDcarModelBase.findByPrimaryKey() success!");
        return prpDcarModelDto;
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
        String statement = "Select ModelCode," + 
                           " ShortHandCode," + 
                           " ModelName," + 
                           " CarSeriesName," + 
                           " SeatCount," + 
                           " TonCount," + 
                           " Factory," + 
                           " CountryCode," + 
                           " PurchasePrice," + 
                           " RiskScope," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDcarModel Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcarModelDto prpDcarModelDto = null;
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

            prpDcarModelDto = new PrpDcarModelDto();
            prpDcarModelDto.setModelCode(dbManager.getString(resultSet,1));
            prpDcarModelDto.setShortHandCode(dbManager.getString(resultSet,2));
            prpDcarModelDto.setModelName(dbManager.getString(resultSet,3));
            prpDcarModelDto.setCarSeriesName(dbManager.getString(resultSet,4));
            prpDcarModelDto.setSeatCount(dbManager.getInt(resultSet,5));
            prpDcarModelDto.setTonCount(dbManager.getDouble(resultSet,6));
            prpDcarModelDto.setFactory(dbManager.getString(resultSet,7));
            prpDcarModelDto.setCountryCode(dbManager.getString(resultSet,8));
            prpDcarModelDto.setPurchasePrice(dbManager.getDouble(resultSet,9));
            prpDcarModelDto.setRiskScope(dbManager.getString(resultSet,10));
            prpDcarModelDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpDcarModelDto.setValidStatus(dbManager.getString(resultSet,12));
            prpDcarModelDto.setFlag(dbManager.getString(resultSet,13));
            collection.add(prpDcarModelDto);
        }
        resultSet.close();
        log.info("DBPrpDcarModelBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcarModel Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcarModelBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDcarModel Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcarModelBase.getCount() success!");
        return count;
    }
}
