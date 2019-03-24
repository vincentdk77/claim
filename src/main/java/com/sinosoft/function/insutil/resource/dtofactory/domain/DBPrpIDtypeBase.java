package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpIDtypeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidtype�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpIDtypeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpIDtypeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpIDtypeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpIDtypeDto prpIDtypeDto
     * @throws Exception
     */
    public void insert(PrpIDtypeDto prpIDtypeDto) throws Exception{
        String statement = " Insert Into PrpIDtype(" + 
                           " CodeType," + 
                           " CodeTypeDesc) values(?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpIDtypeDto.getCodeType());
        dbManager.setString(2,prpIDtypeDto.getCodeTypeDesc());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDtypeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpIDtypeDto prpIDtypeDto = (PrpIDtypeDto)i.next();
            insert(prpIDtypeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param codeType codetype
     * @throws Exception
     */
    public void delete(String codeType) throws Exception{
        String statement = " Delete From PrpIDtype Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpIDtypeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpIDtypeDto prpIDtypeDto
     * @throws Exception
     */
    public void update(PrpIDtypeDto prpIDtypeDto) throws Exception{
        String statement = " Update PrpIDtype Set CodeTypeDesc = ? Where " +
                           " CodeType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpIDtypeDto.getCodeTypeDesc());
        //���������ֶ�;
        dbManager.setString(2,prpIDtypeDto.getCodeType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpIDtypeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param codeType codetype
     * @return PrpIDtypeDto
     * @throws Exception
     */
    public PrpIDtypeDto findByPrimaryKey(String codeType) throws Exception{
        String statement = " Select CodeType," + 
                           " CodeTypeDesc From PrpIDtype Where " +
                           " CodeType = ?";
        PrpIDtypeDto prpIDtypeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,codeType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpIDtypeDto = new PrpIDtypeDto();
            prpIDtypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDtypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
        }
        resultSet.close();
        log.info("DBPrpIDtypeBase.findByPrimaryKey() success!");
        return prpIDtypeDto;
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
                           " CodeTypeDesc From PrpIDtype Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpIDtypeDto prpIDtypeDto = null;
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

            prpIDtypeDto = new PrpIDtypeDto();
            prpIDtypeDto.setCodeType(dbManager.getString(resultSet,1));
            prpIDtypeDto.setCodeTypeDesc(dbManager.getString(resultSet,2));
            collection.add(prpIDtypeDto);
        }
        resultSet.close();
        log.info("DBPrpIDtypeBase.findByConditions() success!");
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
        String statement = "Delete From PrpIDtype Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpIDtypeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpIDtype Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpIDtypeBase.getCount() success!");
        return count;
    }
}
