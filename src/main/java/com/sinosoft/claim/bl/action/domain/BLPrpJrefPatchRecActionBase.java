package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefPatchRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefpatchrec�������ѵǼǱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPatchRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPatchRecActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJrefPatchRecActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //�����¼
        dbPrpJrefPatchRec.insert(prpJrefPatchRecDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param refundGroupNo �������ѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String refundGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //ɾ����¼
        dbPrpJrefPatchRec.delete(refundGroupNo, certiNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //������ɾ����¼
        dbPrpJrefPatchRec.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //���¼�¼
        dbPrpJrefPatchRec.update(prpJrefPatchRecDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param refundGroupNo �������ѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @return prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public PrpJrefPatchRecDto findByPrimaryKey(DBManager dbManager,String refundGroupNo,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        //����DTO
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
        //��ѯ����,��ֵ��DTO
        prpJrefPatchRecDto = dbPrpJrefPatchRec.findByPrimaryKey(refundGroupNo, certiNo, serialNo);
        return prpJrefPatchRecDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJrefPatchRecDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefPatchRec.getCount(conditions);
        collection = dbPrpJrefPatchRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJrefPatchRec dbPrpJrefPatchRec = new DBPrpJrefPatchRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefPatchRec.getCount(conditions);
        return count;
    }
}
