package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpPcontractpause��ֹ���պ�ͬ��Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPcontractpauseBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpPcontractpauseBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPcontractpauseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void insert(PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        String statement = " Insert Into PrpPcontractpause(" + 
                           " EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPcontractpauseDto.getEndorseNo());
        dbManager.setString(2,prpPcontractpauseDto.getPolicyNo());
        dbManager.setDateTime(3,prpPcontractpauseDto.getStartDate());
        dbManager.setInt(4,prpPcontractpauseDto.getStartHour());
        dbManager.setDateTime(5,prpPcontractpauseDto.getEndDate());
        dbManager.setInt(6,prpPcontractpauseDto.getEndHour());
        dbManager.setDateTime(7,prpPcontractpauseDto.getInvalidStartDate());
        dbManager.setInt(8,prpPcontractpauseDto.getInvalidStartHour());
        dbManager.setDateTime(9,prpPcontractpauseDto.getInvalidEndDate());
        dbManager.setInt(10,prpPcontractpauseDto.getInvalidEndHour());
        dbManager.setString(11,prpPcontractpauseDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpPcontractpauseBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPcontractpauseDto prpPcontractpauseDto = (PrpPcontractpauseDto)i.next();
            insert(prpPcontractpauseDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param endorseNo ������
     * @throws Exception
     */
    public void delete(String endorseNo) throws Exception{
        String statement = " Delete From PrpPcontractpause Where " +
                           " EndorseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpPcontractpauseBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void update(PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        String statement = " Update PrpPcontractpause Set PolicyNo = ?," + 
                           " StartDate = ?," + 
                           " StartHour = ?," + 
                           " EndDate = ?," + 
                           " EndHour = ?," + 
                           " InvalidStartDate = ?," + 
                           " InvalidStartHour = ?," + 
                           " InvalidEndDate = ?," + 
                           " InvalidEndHour = ?," + 
                           " flag = ? Where " +
                           " EndorseNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpPcontractpauseDto.getPolicyNo());
        dbManager.setDateTime(2,prpPcontractpauseDto.getStartDate());
        dbManager.setInt(3,prpPcontractpauseDto.getStartHour());
        dbManager.setDateTime(4,prpPcontractpauseDto.getEndDate());
        dbManager.setInt(5,prpPcontractpauseDto.getEndHour());
        dbManager.setDateTime(6,prpPcontractpauseDto.getInvalidStartDate());
        dbManager.setInt(7,prpPcontractpauseDto.getInvalidStartHour());
        dbManager.setDateTime(8,prpPcontractpauseDto.getInvalidEndDate());
        dbManager.setInt(9,prpPcontractpauseDto.getInvalidEndHour());
        dbManager.setString(10,prpPcontractpauseDto.getFlag());
        //���������ֶ�;
        dbManager.setString(11,prpPcontractpauseDto.getEndorseNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpPcontractpauseBase.update() success!");
    }

    /**
     * ����������һ������
     * @param endorseNo ������
     * @return PrpPcontractpauseDto
     * @throws Exception
     */
    public PrpPcontractpauseDto findByPrimaryKey(String endorseNo) throws Exception{
        String statement = " Select EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag From PrpPcontractpause Where " +
                           " EndorseNo = ?";
        PrpPcontractpauseDto prpPcontractpauseDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPcontractpauseDto = new PrpPcontractpauseDto();
            prpPcontractpauseDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcontractpauseDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcontractpauseDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpPcontractpauseDto.setStartHour(dbManager.getInt(resultSet,4));
            prpPcontractpauseDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpPcontractpauseDto.setEndHour(dbManager.getInt(resultSet,6));
            prpPcontractpauseDto.setInvalidStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpPcontractpauseDto.setInvalidStartHour(dbManager.getInt(resultSet,8));
            prpPcontractpauseDto.setInvalidEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpPcontractpauseDto.setInvalidEndHour(dbManager.getInt(resultSet,10));
            prpPcontractpauseDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.findByPrimaryKey() success!");
        return prpPcontractpauseDto;
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
        String statement = "Select EndorseNo," + 
                           " PolicyNo," + 
                           " StartDate," + 
                           " StartHour," + 
                           " EndDate," + 
                           " EndHour," + 
                           " InvalidStartDate," + 
                           " InvalidStartHour," + 
                           " InvalidEndDate," + 
                           " InvalidEndHour," + 
                           " flag From PrpPcontractpause Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpPcontractpauseDto prpPcontractpauseDto = null;
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

            prpPcontractpauseDto = new PrpPcontractpauseDto();
            prpPcontractpauseDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPcontractpauseDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPcontractpauseDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpPcontractpauseDto.setStartHour(dbManager.getInt(resultSet,4));
            prpPcontractpauseDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpPcontractpauseDto.setEndHour(dbManager.getInt(resultSet,6));
            prpPcontractpauseDto.setInvalidStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpPcontractpauseDto.setInvalidStartHour(dbManager.getInt(resultSet,8));
            prpPcontractpauseDto.setInvalidEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpPcontractpauseDto.setInvalidEndHour(dbManager.getInt(resultSet,10));
            prpPcontractpauseDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpPcontractpauseDto);
        }
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.findByConditions() success!");
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
        String statement = "Delete From PrpPcontractpause Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpPcontractpauseBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPcontractpause Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpPcontractpauseBase.getCount() success!");
        return count;
    }
}
