package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDitemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDitem;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpditem�����Ŀ������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDitemActionBase{
    private static Log log = LogFactory.getLog(BLPrpDitemActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDitemActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDitemDto prpDitemDto) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //�����¼
        dbPrpDitem.insert(prpDitemDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param itemCode �����Ŀ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String itemCode) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //ɾ����¼
        dbPrpDitem.delete(riskCode, itemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //������ɾ����¼
        dbPrpDitem.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDitemDto prpDitemDto) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //���¼�¼
        dbPrpDitem.update(prpDitemDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param itemCode �����Ŀ����
     * @return prpDitemDto prpDitemDto
     * @throws Exception
     */
    public PrpDitemDto findByPrimaryKey(DBManager dbManager,String riskCode,String itemCode) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        //����DTO
        PrpDitemDto prpDitemDto = null;
        //��ѯ����,��ֵ��DTO
        prpDitemDto = dbPrpDitem.findByPrimaryKey(riskCode, itemCode);
        return prpDitemDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDitemDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDitem.getCount(conditions);
        collection = dbPrpDitem.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDitem dbPrpDitem = new DBPrpDitem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDitem.getCount(conditions);
        return count;
    }
}
