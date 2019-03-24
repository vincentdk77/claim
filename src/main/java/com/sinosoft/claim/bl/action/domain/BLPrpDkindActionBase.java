package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDkindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDkind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdkind�ձ������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDkindActionBase{
    private static Log log = LogFactory.getLog(BLPrpDkindActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDkindActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDkindDto prpDkindDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDkindDto prpDkindDto) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        //�����¼
        dbPrpDkind.insert(prpDkindDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        //ɾ����¼
        dbPrpDkind.delete(riskCode, kindCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        //������ɾ����¼
        dbPrpDkind.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDkindDto prpDkindDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDkindDto prpDkindDto) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        //���¼�¼
        dbPrpDkind.update(prpDkindDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @return prpDkindDto prpDkindDto
     * @throws Exception
     */
    public PrpDkindDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        //����DTO
        PrpDkindDto prpDkindDto = null;
        //��ѯ����,��ֵ��DTO
        prpDkindDto = dbPrpDkind.findByPrimaryKey(riskCode, kindCode);
        return prpDkindDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDkindDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDkind.getCount(conditions);
        collection = dbPrpDkind.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDkind dbPrpDkind = new DBPrpDkind(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDkind.getCount(conditions);
        return count;
    }
}
