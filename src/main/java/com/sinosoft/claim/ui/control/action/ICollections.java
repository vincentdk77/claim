package com.sinosoft.claim.ui.control.action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.struts.util.LabelValueBean;
/**
 * ���ӵĹ�����
 */
public class ICollections {
    /**
     * ����ѡ��"����"�󷵻�
     *
     * @param old ԭʼ����
     * @return ����ѡ��"����"��ļ���
     */
    public static Collection getCollectionWithAll(Collection old) {
        Collection result = new ArrayList(old.size() + 1);
        result.add(new LabelValueBean("����", ""));
        result.addAll(old);
        return result;
    }
    /**
     * �õ���Ч״̬�б�
     *
     * @return ��Ч״̬�б�
     */
    public static Collection getValidStatusList() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("��Ч", "1"));
        result.add(new LabelValueBean("ʧЧ", "0"));
        return result;
    }

    /**
    * �õ��ط�ҵ�������б�
    *
    * @return ���ûط�ҵ�������б�
    */
   public static Collection getBackVisitTypeList() {
       Collection result = new ArrayList(2);
       result.add(new LabelValueBean("�鿱�ط�", "1"));
       result.add(new LabelValueBean("����ط�", "2"));
       return result;
   }

   /**
   * �õ��طÿͻ�������б�
   *
   * @return ���ûطÿͻ�������б�
   */
  public static Collection getCustomOpinionList() {
      Collection result = new ArrayList(5);
      result.add(new LabelValueBean("�ܲ�����", "1"));
      result.add(new LabelValueBean("������", "2"));
      result.add(new LabelValueBean("һ��", "3"));
      result.add(new LabelValueBean("����", "4"));
      result.add(new LabelValueBean("������", "5"));

      return result;
  }


    /**
     * �õ�������б�
     *
     * @return ������б�
     */
    public static Collection getYesNoList() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("��", "1"));
        result.add(new LabelValueBean("��", "0"));
        return result;
    }

    /**
     * �õ�����ԭ������б�
     *
     * @return �б�
     */
    public static Collection getDamageCodeList() {
        Collection result = new ArrayList(29);
        result.add(new LabelValueBean("��ײ", "456"));
        result.add(new LabelValueBean("���복��ײ", "621"));
        result.add(new LabelValueBean("��������ײ", "622"));
        result.add(new LabelValueBean("��������ײ", "623"));
        result.add(new LabelValueBean("��������", "417"));
        result.add(new LabelValueBean("�㸲", "403"));
        result.add(new LabelValueBean("׹��", "411"));
        result.add(new LabelValueBean("����", "409"));
        result.add(new LabelValueBean("��ȼ", "410"));
        result.add(new LabelValueBean("������嵹��", "404"));
        result.add(new LabelValueBean("�������׹��", "405"));
        result.add(new LabelValueBean("����", "401"));
        result.add(new LabelValueBean("��ը", "402"));
        result.add(new LabelValueBean("����", "001"));
        result.add(new LabelValueBean("����", "002"));
        result.add(new LabelValueBean("�����", "003"));
        result.add(new LabelValueBean("�׻�", "004"));
        result.add(new LabelValueBean("��ˮ", "005"));
        result.add(new LabelValueBean("��Х", "007"));
        result.add(new LabelValueBean("����", "008"));
        result.add(new LabelValueBean("����", "011"));
        result.add(new LabelValueBean("ѩ��", "012"));
        result.add(new LabelValueBean("�±�", "022"));
        result.add(new LabelValueBean("����", "013"));
        result.add(new LabelValueBean("��ʯ��", "014"));
        result.add(new LabelValueBean("����", "015"));
        result.add(new LabelValueBean("���˱��ճ����Ķɴ�������Ȼ�ֺ�", "024"));
        result.add(new LabelValueBean("�ʽ���ת����", "618"));
        result.add(new LabelValueBean("����", "999"));
        return result;
    }

   /**
    * �õ��¹�ԭ������б�
    *
    * @return �б�
    */
   public static Collection getDamageTypeCodeList() {
       Collection result = new ArrayList(12);
       result.add(new LabelValueBean("������⡢��ʩ����", "009"));
       result.add(new LabelValueBean("��ȫ��಻��", "001"));
       result.add(new LabelValueBean("������ʻ", "002"));
       result.add(new LabelValueBean("������ʻ", "003"));
       result.add(new LabelValueBean("ƣ�ͼ�ʻ", "004"));
       result.add(new LabelValueBean("Υ��װ��", "006"));
       result.add(new LabelValueBean("�ƶ�ʧ��", "007"));
       result.add(new LabelValueBean("ת��ʧ��", "008"));
       result.add(new LabelValueBean("Υ�²���", "010"));
       result.add(new LabelValueBean("������е����", "995"));
       result.add(new LabelValueBean("����Υ����ʻ", "996"));
       result.add(new LabelValueBean("����", "999"));
       return result;
   }

   /**
    * �õ��¹�ԭ������б�
    *
    * @return �б�
    */
   public static Collection getIndemnityDutyList() {
       Collection result = new ArrayList(12);
       result.add(new LabelValueBean("ȫ��", "0"));
       result.add(new LabelValueBean("����", "1"));
       result.add(new LabelValueBean("ͬ��", "2"));
       result.add(new LabelValueBean("����", "3"));
       result.add(new LabelValueBean("����", "4"));
       result.add(new LabelValueBean("����", "9"));
       return result;
   }

   /**
    * �õ���ʧ���������б�
    *
    * @return ��ʧ�����б�
    */
   public static Collection getPartCodeList() {
       Collection result = new ArrayList(4);
       result.add(new LabelValueBean("ǰ��", "1"));
       result.add(new LabelValueBean("����", "2"));
       result.add(new LabelValueBean("�ҳ���", "3"));
       result.add(new LabelValueBean("��", "4"));
       
       
       //ԭ����ʧ�������������Ӳ���һ��
       //result.add(new LabelValueBean("����", "5"));
      
       
       return result;
   }
   
   /**
    * �õ��˼���������б�
    *
    * @return �˼�����б�
    */
   public static Collection getVerifyPriceOpinionList() {
       Collection result = new ArrayList(6);
       result.add(new LabelValueBean("ͬ�ⱨ��", "01"));
       result.add(new LabelValueBean("������Ϣ", "02"));
       result.add(new LabelValueBean("�۸����鷢��", "03"));
       result.add(new LabelValueBean("�۸�������", "04"));
       result.add(new LabelValueBean("����ѯ��", "05"));
       result.add(new LabelValueBean("����", "99"));
       return result;
   }

   public static Collection getVerifyPriceVerpoOpinionList() {
    Collection result = new ArrayList(5);
    result.add(new LabelValueBean("ͬ�ⱨ��", "01"));
    result.add(new LabelValueBean("������Ϣ", "02"));
    result.add(new LabelValueBean("�۸����鷢��", "03"));
    result.add(new LabelValueBean("�۸�������", "04"));
    result.add(new LabelValueBean("����", "99"));
    return result;
}
   
   
   /**
    * �õ�������������б�
    *
    * @return ��������б�
    */
   public static Collection getVerifyOpinionList() {
       Collection result = new ArrayList(5);
       result.add(new LabelValueBean("ͬ�ⶨ��", "01"));
       result.add(new LabelValueBean("�۸�����", "02"));
       result.add(new LabelValueBean("��Ϣ�����", "03"));
       result.add(new LabelValueBean("���߼��鱨��", "04"));
       result.add(new LabelValueBean("����", "99"));
       return result;
   }
  
   /**
    * �õ��������ʹ����б�
    *
    * @return ���������б�
    */
   public static Collection getRepairFactoryType() {
       Collection result = new ArrayList(3);
       result.add(new LabelValueBean("4S��", "01"));
       result.add(new LabelValueBean("һ�೧", "02"));
       result.add(new LabelValueBean("���೧����", "03"));
       return result;
   }
   
     //begin����Ϊ�ͻ����Ϲ���
      public static Collection getCustomerKind() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("0-רҵ������", "0"));
        result.add(new LabelValueBean("1-��ҵ������", "1"));
        result.add(new LabelValueBean("2-������", "2"));
        return result;
        }
      public static Collection getCustomerFlag() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("0-׼�ͻ�", "0"));
        result.add(new LabelValueBean("1-��ʽ�ͻ�", "1"));
        return result;
        }
      public static Collection getShareHolder() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("��", "0"));
        result.add(new LabelValueBean("��", "1"));
        return result;
    }
      /**
       * ���������������б�ѡ��
       * @return
       */
      public static Collection getCompensateResultList(){
    	Collection result = new LinkedList();
        result.add(new LabelValueBean("����", "1"));
        result.add(new LabelValueBean("�ܸ�", "0"));
      	return result;
      }        
      
      /**
       * ��������˻���Ϣ�����б�ѡ��
       * @return
       */
      public static Collection getCompensateBackList(){
    	Collection result = new LinkedList();
        result.add(new LabelValueBean("�������", "01"));
        result.add(new LabelValueBean("��������", "02"));
        result.add(new LabelValueBean("������Ŀ[�޸İ�������Ŀ����]", "03"));
      	return result;
      }        
      //end 

}
