package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDTypeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype�ӿڴ������ͱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpIDTypeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpIDTypeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpIDTypeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void insert(PrpIDTypeDto prpIDTypeDto) throws Exception{
        String statement = " Insert Into PrpIDType(" + 
                           " CodeType," + 
                           " CodeTypeDesc) values(?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpIDTypeDto.getCodeType());
        dbManager.setString(2,prpIDTypeDto.getCodeTypeDesc());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDTypeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpIDTypeDto prpIDTypeDto = (PrpIDTypeDto)i.next();
            insert(prpIDTypeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param codeType �ӿڴ�������
     * @throws Exception
     */
    public void delete(String codeType) throws Exception{
        String statement = " Delete From PrpIDType Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpIDTypeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpIDTypeDto prpIDTypeDto
     * @throws Exception
     */
    public void update(PrpIDTypeDto prpIDTypeDto) throws Exception{
        String statement = " Update PrpIDType Set CodeTypeDesc = ? Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpIDTypeDto.getCodeTypeDesc());
        //���������ֶ�;
        dbManager.setString(2,prpIDTypeDto.getCodeType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDTypeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param codeType �ӿڴ�������
     * @return PrpIDTypeDto
     * @throws Exception
     */
    public PrpIDTypeDto findByPrimaryKey(String codeType) throws Exception{
        String statement = " Select CodeType," + 
                           " CodeTypeDesc From PrpIDType Where " +
                           " CodeType = ?";
        PrpIDTypeDto prpIDTypeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpIDTypeDto = new PrpIDTypeDto();
            prpIDTypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDTypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
        }
        resultSet.close();
        log.info("DBPrpIDTypeBase.findByPrimaryKey() success!");
        return prpIDTypeDto;
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
                           " CodeTypeDesc From PrpIDType Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpIDTypeDto prpIDTypeDto = null;
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

            prpIDTypeDto = new PrpIDTypeDto();
            prpIDTypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDTypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
            collection.add(prpIDTypeDto);
        }
        resultSet.close();
        log.info("DBPrpIDTypeBase.findByConditions() success!");
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
        String statement = "Delete From PrpIDType Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpIDTypeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpIDType Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpIDTypeBase.getCount() success!");
        return count;
    }
}
