package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifierdesc�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDidentifierDescBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDidentifierDescBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDidentifierDescBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void insert(PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        String statement = " Insert Into PrpDidentifierDesc(" + 
                           " IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDidentifierDescDto.getIdentifierCode());
        dbManager.setInt(2,prpDidentifierDescDto.getLineNo());
        dbManager.setString(3,prpDidentifierDescDto.getMark());
        dbManager.setString(4,prpDidentifierDescDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierDescBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDidentifierDescDto prpDidentifierDescDto = (PrpDidentifierDescDto)i.next();
            insert(prpDidentifierDescDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param identifierCode identifiercode
     * @param lineNo lineno
     * @throws Exception
     */
    public void delete(String identifierCode,int lineNo) throws Exception{
        String statement = " Delete From PrpDidentifierDesc Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,identifierCode);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDidentifierDescBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void update(PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        String statement = " Update PrpDidentifierDesc Set Mark = ?," + 
                           " Flag = ? Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDidentifierDescDto.getMark());
        dbManager.setString(2,prpDidentifierDescDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpDidentifierDescDto.getIdentifierCode());
        dbManager.setInt(4,prpDidentifierDescDto.getLineNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierDescBase.update() success!");
    }

    /**
     * ����������һ������
     * @param identifierCode identifiercode
     * @param lineNo lineno
     * @return PrpDidentifierDescDto
     * @throws Exception
     */
    public PrpDidentifierDescDto findByPrimaryKey(String identifierCode,int lineNo) throws Exception{
        String statement = " Select IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag From PrpDidentifierDesc Where " +
                           " IdentifierCode = ? And " + 
                           " LineNo = ?";
        PrpDidentifierDescDto prpDidentifierDescDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,identifierCode);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDidentifierDescDto = new PrpDidentifierDescDto();
            prpDidentifierDescDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDescDto.setLineNo(dbManager.getInt(resultSet,2));
            prpDidentifierDescDto.setMark(dbManager.getString(resultSet,3));
            prpDidentifierDescDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.findByPrimaryKey() success!");
        return prpDidentifierDescDto;
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
        String statement = "Select IdentifierCode," + 
                           " LineNo," + 
                           " Mark," + 
                           " Flag From PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDidentifierDescDto prpDidentifierDescDto = null;
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

            prpDidentifierDescDto = new PrpDidentifierDescDto();
            prpDidentifierDescDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDescDto.setLineNo(dbManager.getInt(resultSet,2));
            prpDidentifierDescDto.setMark(dbManager.getString(resultSet,3));
            prpDidentifierDescDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpDidentifierDescDto);
        }
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.findByConditions() success!");
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
        String statement = "Delete From PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDidentifierDescBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDidentifierDesc Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDidentifierDescBase.getCount() success!");
        return count;
    }
}
