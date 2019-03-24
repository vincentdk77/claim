package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDclauseKindDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdclausekind�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDclauseKindBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDclauseKindBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDclauseKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void insert(PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        String statement = " Insert Into PrpDclauseKind(" + 
                           " RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDclauseKindDto.getRiskCode());
        dbManager.setString(2,prpDclauseKindDto.getClauseType());
        dbManager.setString(3,prpDclauseKindDto.getKindCode());
        dbManager.setString(4,prpDclauseKindDto.getRelateKindCode());
        dbManager.setString(5,prpDclauseKindDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseKindBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDclauseKindDto prpDclauseKindDto = (PrpDclauseKindDto)i.next();
            insert(prpDclauseKindDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param relateKindCode relatekindcode
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        String statement = " Delete From PrpDclauseKind Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,relateKindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDclauseKindBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDclauseKindDto prpDclauseKindDto
     * @throws Exception
     */
    public void update(PrpDclauseKindDto prpDclauseKindDto) throws Exception{
        String statement = " Update PrpDclauseKind Set Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDclauseKindDto.getFlag());
        //���������ֶ�;
        dbManager.setString(2,prpDclauseKindDto.getRiskCode());
        dbManager.setString(3,prpDclauseKindDto.getClauseType());
        dbManager.setString(4,prpDclauseKindDto.getKindCode());
        dbManager.setString(5,prpDclauseKindDto.getRelateKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDclauseKindBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param relateKindCode relatekindcode
     * @return PrpDclauseKindDto
     * @throws Exception
     */
    public PrpDclauseKindDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String relateKindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag From PrpDclauseKind Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " RelateKindCode = ?";
        PrpDclauseKindDto prpDclauseKindDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,relateKindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDclauseKindDto = new PrpDclauseKindDto();
            prpDclauseKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDclauseKindDto.setClauseType(dbManager.getString(resultSet,2));
            prpDclauseKindDto.setKindCode(dbManager.getString(resultSet,3));
            prpDclauseKindDto.setRelateKindCode(dbManager.getString(resultSet,4));
            prpDclauseKindDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpDclauseKindBase.findByPrimaryKey() success!");
        return prpDclauseKindDto;
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
                           " ClauseType," + 
                           " KindCode," + 
                           " RelateKindCode," + 
                           " Flag From PrpDclauseKind Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDclauseKindDto prpDclauseKindDto = null;
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

            prpDclauseKindDto = new PrpDclauseKindDto();
            prpDclauseKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDclauseKindDto.setClauseType(dbManager.getString(resultSet,2));
            prpDclauseKindDto.setKindCode(dbManager.getString(resultSet,3));
            prpDclauseKindDto.setRelateKindCode(dbManager.getString(resultSet,4));
            prpDclauseKindDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpDclauseKindDto);
        }
        resultSet.close();
        log.info("DBPrpDclauseKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpDclauseKind Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDclauseKindBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDclauseKind Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDclauseKindBase.getCount() success!");
        return count;
    }
}
