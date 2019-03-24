package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpXPcolDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpXPcol;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxpcol���������ֵ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpXPcolActionBase{
    private static Log log = LogFactory.getLog(BLPrpXPcolActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpXPcolActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpXPcolDto prpXPcolDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpXPcolDto prpXPcolDto) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        //�����¼
        dbPrpXPcol.insert(prpXPcolDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param tableName ���ݱ���
     * @param colSeq �ֶ�˳��
     * @param dispSeq ��ʾ˳��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String tableName,int colSeq,int dispSeq) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        //ɾ����¼
        dbPrpXPcol.delete(riskCode, tableName, colSeq, dispSeq);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        //������ɾ����¼
        dbPrpXPcol.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpXPcolDto prpXPcolDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpXPcolDto prpXPcolDto) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        //���¼�¼
        dbPrpXPcol.update(prpXPcolDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param tableName ���ݱ���
     * @param colSeq �ֶ�˳��
     * @param dispSeq ��ʾ˳��
     * @return prpXPcolDto prpXPcolDto
     * @throws Exception
     */
    public PrpXPcolDto findByPrimaryKey(DBManager dbManager,String riskCode,String tableName,int colSeq,int dispSeq) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        //����DTO
        PrpXPcolDto prpXPcolDto = null;
        //��ѯ����,��ֵ��DTO
        prpXPcolDto = dbPrpXPcol.findByPrimaryKey(riskCode, tableName, colSeq, dispSeq);
        return prpXPcolDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpXPcolDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpXPcol.getCount(conditions);
        collection = dbPrpXPcol.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpXPcol dbPrpXPcol = new DBPrpXPcol(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpXPcol.getCount(conditions);
        return count;
    }
}
