package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGrade;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgrade��λ������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGradeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGradeDto prpGradeDto) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //�����¼
        dbPrpGrade.insert(prpGradeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param gradeCode ��λ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String gradeCode) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //ɾ����¼
        dbPrpGrade.delete(gradeCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //������ɾ����¼
        dbPrpGrade.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGradeDto prpGradeDto) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //���¼�¼
        dbPrpGrade.update(prpGradeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param gradeCode ��λ����
     * @return prpGradeDto prpGradeDto
     * @throws Exception
     */
    public PrpGradeDto findByPrimaryKey(DBManager dbManager,String gradeCode) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //����DTO
        PrpGradeDto prpGradeDto = null;
        //��ѯ����,��ֵ��DTO
        prpGradeDto = dbPrpGrade.findByPrimaryKey(gradeCode);
        return prpGradeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGrade.getCount(conditions);
        collection = dbPrpGrade.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGrade.getCount(conditions);
        return count;
    }
}
