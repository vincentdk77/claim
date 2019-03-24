package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

/**
 * 这是prpLscheduleNew新案件提示表的数据传输对象类<br>
 * 创建于 2004-07-15 21:02:17.821<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleNewDto extends PrpLscheduleNewDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLscheduleNewDto对象
     */
    public PrpLscheduleNewDto(){

    }
    /** 属性显示列表*/
    private Collection scheduleNewList ;
    
    /** 属性出险次数 */
    private int perilCount = 0;
    
//modify by lixiang add 20050311 start
//reason:待调度登记增加调度停留时间

/** 属性出险次数 */
    private String waitTime ="";
//modify by lixiang add 20050311 end

    
     /**设置属性显示列表
     * @param prpLctextList 属性显示列表
     */
    public void setScheduleNewList(Collection scheduleNewList) {
      this.scheduleNewList = scheduleNewList;
    }

  /**得到属性显示列表
  * @return 属性显示列表
  */
    public Collection getScheduleNewList() {
      return scheduleNewList;
    }
    
     /**
     * 设置属性出险次数
     * @param perilCount 待设置的属性出险次数的值
     */
    public void setPerilCount(int perilCount){
        this.perilCount = perilCount;
    }

    /**
     * 获取属性出险次数
     * @return 属性出险次数的值
     */
    public int getPerilCount(){
        return perilCount;
    }
//modify by lixiang add 20050311 start
//reason:待调度登记增加调度停留时间
  
     /**
     * 设置属性待调度登记增加调度停留时间
     * @param waitTime 待设置的属性待调度登记增加调度停留时间的值
     */
    public void setWaitTime(String waitTime){
        this.waitTime = waitTime;
    }

    /**
     * 获取属性待调度登记增加调度停留时间
     * @return 属性待调度登记增加调度停留时间的值
     */
    public String getWaitTime(){
        return waitTime;
    }
//modify by lixiang add 20050311 end

}
