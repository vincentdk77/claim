package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDtypeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdtypeͨ�ô����������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDtypeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDtypeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDtypeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void insert(PrpDtypeDto prpDtypeDto) throws Exception{
        String statement = " Insert Into PrpDtype(" + 
                           " CodeType," + 
                           " CodeTypeDesc," + 
                           " NewCodeType," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDtypeDto.getCodeType());
        dbManager.setString(2,prpDtypeDto.getCodeTypeDesc());
        dbManager.setString(3,prpDtypeDto.getNewCodeType());
        dbManager.setString(4,prpDtypeDto.getValidStatus());
        dbManager.setString(5,prpDtypeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDtypeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDtypeDto prpDtypeDto = (PrpDtypeDto)i.next();
            insert(prpDtypeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param codeType ��������
     * @throws Exception
     */
    public void delete(String codeType) throws Exception{
        String statement = " Delete From PrpDtype Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDtypeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDtypeDto prpDtypeDto
     * @throws Exception
     */
    public void update(PrpDtypeDto prpDtypeDto) throws Exception{
        String statement = " Update PrpDtype Set CodeTypeDesc = ?," + 
                           " NewCodeType = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDtypeDto.getCodeTypeDesc());
        dbManager.setString(2,prpDtypeDto.getNewCodeType());
        dbManager.setString(3,prpDtypeDto.getValidStatus());
        dbManager.setString(4,prpDtypeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpDtypeDto.getCodeType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDtypeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param codeType ��������
     * @return PrpDtypeDto
     * @throws Exception
     */
    public PrpDtypeDto findByPrimaryKey(String codeType) throws Exception{
        String statement = " Select CodeType," + 
                           " CodeTypeDesc," + 
                           " NewCodeType," + 
                           " ValidStatus," + 
                           " Flag From PrpDtype Where " +
                           " CodeType = ?";
        PrpDtypeDto prpDtypeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDtypeDto = new PrpDtypeDto();
            prpDtypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpDtypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
            prpDtypeDto.setNewCodeType(dbManager.getString(resultSet,3));
            prpDtypeDto.setValidStatus(dbManager.getString(resultSet,4));
            prpDtypeDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDtypeBase.findByPrimaryKey() success!");
        return prpDtypeDto;
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
        String statement = "Select CodeType," + 
                           " CodeTypeDesc," + 
                           " NewCodeType," + 
                           " ValidStatus," + 
                           " Flag From PrpDtype Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDtypeDto prpDtypeDto = null;
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

            prpDtypeDto = new PrpDtypeDto();
            prpDtypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpDtypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
            prpDtypeDto.setNewCodeType(dbManager.getString(resultSet,3));
            prpDtypeDto.setValidStatus(dbManager.getString(resultSet,4));
            prpDtypeDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDtypeDto);
        }
        resultSet.close();
        log.info("DBPrpDtypeBase.findByConditions() success!");
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
        String statement = "Delete From PrpDtype Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDtypeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDtype Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDtypeBase.getCount() success!");
        return count;
    }
}
