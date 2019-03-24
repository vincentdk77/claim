package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDidentifierDescDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDidentifierDesc;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifierdesc�������ı��������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDidentifierDescActionBase{
    private static Log log = LogFactory.getLog(BLPrpDidentifierDescActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDidentifierDescActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //�����¼
        dbPrpDidentifierDesc.insert(prpDidentifierDescDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param identifierCode �����˴���
     * @param lineNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String identifierCode,int lineNo) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //ɾ����¼
        dbPrpDidentifierDesc.delete(identifierCode, lineNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //������ɾ����¼
        dbPrpDidentifierDesc.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDidentifierDescDto prpDidentifierDescDto) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //���¼�¼
        dbPrpDidentifierDesc.update(prpDidentifierDescDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param identifierCode �����˴���
     * @param lineNo ���
     * @return prpDidentifierDescDto prpDidentifierDescDto
     * @throws Exception
     */
    public PrpDidentifierDescDto findByPrimaryKey(DBManager dbManager,String identifierCode,int lineNo) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        //����DTO
        PrpDidentifierDescDto prpDidentifierDescDto = null;
        //��ѯ����,��ֵ��DTO
        prpDidentifierDescDto = dbPrpDidentifierDesc.findByPrimaryKey(identifierCode, lineNo);
        return prpDidentifierDescDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDidentifierDescDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDidentifierDesc.getCount(conditions);
        collection = dbPrpDidentifierDesc.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDidentifierDesc dbPrpDidentifierDesc = new DBPrpDidentifierDesc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDidentifierDesc.getCount(conditions);
        return count;
    }
}
