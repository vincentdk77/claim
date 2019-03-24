package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefrec���ѵǼǱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJrefRecActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJrefRecDto prpJrefRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefRecDto prpJrefRecDto) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        //�����¼
        dbPrpJrefRec.insert(prpJrefRecDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        //ɾ����¼
        dbPrpJrefRec.delete(certiNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        //������ɾ����¼
        dbPrpJrefRec.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJrefRecDto prpJrefRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefRecDto prpJrefRecDto) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        //���¼�¼
        dbPrpJrefRec.update(prpJrefRecDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @return prpJrefRecDto prpJrefRecDto
     * @throws Exception
     */
    public PrpJrefRecDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        //����DTO
        PrpJrefRecDto prpJrefRecDto = null;
        //��ѯ����,��ֵ��DTO
        prpJrefRecDto = dbPrpJrefRec.findByPrimaryKey(certiNo, serialNo);
        return prpJrefRecDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJrefRecDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefRec.getCount(conditions);
        collection = dbPrpJrefRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJrefRec dbPrpJrefRec = new DBPrpJrefRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefRec.getCount(conditions);
        return count;
    }
}
