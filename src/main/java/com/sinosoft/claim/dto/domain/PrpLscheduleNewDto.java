package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * ����prpLscheduleNew�°�����ʾ������ݴ��������<br>
 * ������ 2004-07-15 21:02:17.821<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleNewDto extends PrpLscheduleNewDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleNewDto����
     */
    public PrpLscheduleNewDto(){

    }
    /** ������ʾ�б�*/
    private Collection scheduleNewList ;
    
    /** ���Գ��մ��� */
    private int perilCount = 0;
    
//modify by lixiang add 20050311 start
//reason:�����ȵǼ����ӵ���ͣ��ʱ��

/** ���Գ��մ��� */
    private String waitTime ="";
//modify by lixiang add 20050311 end

    
     /**����������ʾ�б�
     * @param prpLctextList ������ʾ�б�
     */
    public void setScheduleNewList(Collection scheduleNewList) {
      this.scheduleNewList = scheduleNewList;
    }

  /**�õ�������ʾ�б�
  * @return ������ʾ�б�
  */
    public Collection getScheduleNewList() {
      return scheduleNewList;
    }
    
     /**
     * �������Գ��մ���
     * @param perilCount �����õ����Գ��մ�����ֵ
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * ��ȡ���Գ��մ���
     * @return ���Գ��մ�����ֵ
     */
    public int getPerilCount(){
        return perilCount;
    }
//modify by lixiang add 20050311 start
//reason:�����ȵǼ����ӵ���ͣ��ʱ��
  
     /**
     * �������Դ����ȵǼ����ӵ���ͣ��ʱ��
     * @param waitTime �����õ����Դ����ȵǼ����ӵ���ͣ��ʱ���ֵ
     */
    public void setWaitTime(String waitTime){
        this.waitTime = waitTime;
    }

    /**
     * ��ȡ���Դ����ȵǼ����ӵ���ͣ��ʱ��
     * @return ���Դ����ȵǼ����ӵ���ͣ��ʱ���ֵ
     */
    public String getWaitTime(){
        return waitTime;
    }
//modify by lixiang add 20050311 end

}
