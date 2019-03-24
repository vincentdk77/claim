package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PropDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpeds_Prop;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Prop�Ʋ���ʧ�ӿ����ݱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_PropActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_PropActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLpeds_PropActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpeds_PropDto prpLpeds_PropDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpeds_PropDto prpLpeds_PropDto) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        //�����¼
        dbPrpLpeds_Prop.insert(prpLpeds_PropDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        //ɾ����¼
        dbPrpLpeds_Prop.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        //������ɾ����¼
        dbPrpLpeds_Prop.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpeds_PropDto prpLpeds_PropDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpeds_PropDto prpLpeds_PropDto) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        //���¼�¼
        dbPrpLpeds_Prop.update(prpLpeds_PropDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @return prpLpeds_PropDto prpLpeds_PropDto
     * @throws Exception
     */
    public PrpLpeds_PropDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        //����DTO
        PrpLpeds_PropDto prpLpeds_PropDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpeds_PropDto = dbPrpLpeds_Prop.findByPrimaryKey(registNo, serialNo);
        return prpLpeds_PropDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLpeds_PropDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLpeds_Prop.getCount(conditions);
        collection = dbPrpLpeds_Prop.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpeds_Prop dbPrpLpeds_Prop = new DBPrpLpeds_Prop(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpeds_Prop.getCount(conditions);
        return count;
    }
}
