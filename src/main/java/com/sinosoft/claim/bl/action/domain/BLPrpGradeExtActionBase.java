package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGradeExt;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgradeext��λ��չ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeExtActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGradeExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGradeExtDto prpGradeExtDto) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //�����¼
        dbPrpGradeExt.insert(prpGradeExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param gradeCode ��λ����
     * @param riskCode ���ִ���
     * @param currency �ұ�
     * @throws Exception
     */
    public void delete(DBManager dbManager,String gradeCode,String riskCode,String currency) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //ɾ����¼
        dbPrpGradeExt.delete(gradeCode, riskCode, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //������ɾ����¼
        dbPrpGradeExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGradeExtDto prpGradeExtDto) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //���¼�¼
        dbPrpGradeExt.update(prpGradeExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param gradeCode ��λ����
     * @param riskCode ���ִ���
     * @param currency �ұ�
     * @return prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public PrpGradeExtDto findByPrimaryKey(DBManager dbManager,String gradeCode,String riskCode,String currency) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //����DTO
        PrpGradeExtDto prpGradeExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpGradeExtDto = dbPrpGradeExt.findByPrimaryKey(gradeCode, riskCode, currency);
        return prpGradeExtDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGradeExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGradeExt.getCount(conditions);
        collection = dbPrpGradeExt.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGradeExt.getCount(conditions);
        return count;
    }
}
