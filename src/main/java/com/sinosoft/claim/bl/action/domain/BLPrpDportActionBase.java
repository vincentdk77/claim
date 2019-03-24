package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDportDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDport;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdport�ۿڴ����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDportActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDportActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDportDto prpDportDto) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //�����¼
        dbPrpDport.insert(prpDportDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param portCode �ۿڴ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String portCode) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //ɾ����¼
        dbPrpDport.delete(portCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //������ɾ����¼
        dbPrpDport.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDportDto prpDportDto) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //���¼�¼
        dbPrpDport.update(prpDportDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param portCode �ۿڴ���
     * @return prpDportDto prpDportDto
     * @throws Exception
     */
    public PrpDportDto findByPrimaryKey(DBManager dbManager,String portCode) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //����DTO
        PrpDportDto prpDportDto = null;
        //��ѯ����,��ֵ��DTO
        prpDportDto = dbPrpDport.findByPrimaryKey(portCode);
        return prpDportDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDportDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDport.getCount(conditions);
        collection = dbPrpDport.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDport.getCount(conditions);
        return count;
    }
}
