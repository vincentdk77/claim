package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDscrapTermDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdscrapterm�������ϱ�׼������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDscrapTermBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDscrapTermBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDscrapTermBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void insert(PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        String statement = " Insert Into PrpDscrapTerm(" + 
                           " CarKindCode," + 
                           " UseYear," + 
                           " ProLongYear," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDscrapTermDto.getCarKindCode());
        dbManager.setInt(2,prpDscrapTermDto.getUseYear());
        dbManager.setInt(3,prpDscrapTermDto.getProLongYear());
        dbManager.setString(4,prpDscrapTermDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDscrapTermBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDscrapTermDto prpDscrapTermDto = (PrpDscrapTermDto)i.next();
            insert(prpDscrapTermDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param carKindCode �����������
     * @throws Exception
     */
    public void delete(String carKindCode) throws Exception{
        String statement = " Delete From PrpDscrapTerm Where " +
                           " CarKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,carKindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDscrapTermBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDscrapTermDto prpDscrapTermDto
     * @throws Exception
     */
    public void update(PrpDscrapTermDto prpDscrapTermDto) throws Exception{
        String statement = " Update PrpDscrapTerm Set UseYear = ?," + 
                           " ProLongYear = ?," + 
                           " Flag = ? Where " +
                           " CarKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setInt(1,prpDscrapTermDto.getUseYear());
        dbManager.setInt(2,prpDscrapTermDto.getProLongYear());
        dbManager.setString(3,prpDscrapTermDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,prpDscrapTermDto.getCarKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDscrapTermBase.update() success!");
    }

    /**
     * ����������һ������
     * @param carKindCode �����������
     * @return PrpDscrapTermDto
     * @throws Exception
     */
    public PrpDscrapTermDto findByPrimaryKey(String carKindCode) throws Exception{
        String statement = " Select CarKindCode," + 
                           " UseYear," + 
                           " ProLongYear," + 
                           " Flag From PrpDscrapTerm Where " +
                           " CarKindCode = ?";
        PrpDscrapTermDto prpDscrapTermDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,carKindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDscrapTermDto = new PrpDscrapTermDto();
            prpDscrapTermDto.setCarKindCode(dbManager.getString(resultSet,1));
            prpDscrapTermDto.setUseYear(dbManager.getInt(resultSet,2));
            prpDscrapTermDto.setProLongYear(dbManager.getInt(resultSet,3));
            prpDscrapTermDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpDscrapTermBase.findByPrimaryKey() success!");
        return prpDscrapTermDto;
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
        String statement = "Select CarKindCode," + 
                           " UseYear," + 
                           " ProLongYear," + 
                           " Flag From PrpDscrapTerm Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDscrapTermDto prpDscrapTermDto = null;
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

            prpDscrapTermDto = new PrpDscrapTermDto();
            prpDscrapTermDto.setCarKindCode(dbManager.getString(resultSet,1));
            prpDscrapTermDto.setUseYear(dbManager.getInt(resultSet,2));
            prpDscrapTermDto.setProLongYear(dbManager.getInt(resultSet,3));
            prpDscrapTermDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpDscrapTermDto);
        }
        resultSet.close();
        log.info("DBPrpDscrapTermBase.findByConditions() success!");
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
        String statement = "Delete From PrpDscrapTerm Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDscrapTermBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDscrapTerm Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDscrapTermBase.getCount() success!");
        return count;
    }
}
