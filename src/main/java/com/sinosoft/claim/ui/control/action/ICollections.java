package com.sinosoft.claim.ui.control.action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.struts.util.LabelValueBean;
/**
 * 连接的工具类
 */
public class ICollections {
    /**
     * 加上选项"所有"后返回
     *
     * @param old 原始集合
     * @return 加上选项"所有"后的集合
     */
    public static Collection getCollectionWithAll(Collection old) {
        Collection result = new ArrayList(old.size() + 1);
        result.add(new LabelValueBean("所有", ""));
        result.addAll(old);
        return result;
    }
    /**
     * 得到有效状态列表
     *
     * @return 有效状态列表
     */
    public static Collection getValidStatusList() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("有效", "1"));
        result.add(new LabelValueBean("失效", "0"));
        return result;
    }

    /**
    * 得到回访业务类型列表
    *
    * @return 启用回访业务类型列表
    */
   public static Collection getBackVisitTypeList() {
       Collection result = new ArrayList(2);
       result.add(new LabelValueBean("查勘回访", "1"));
       result.add(new LabelValueBean("定损回访", "2"));
       return result;
   }

   /**
   * 得到回访客户满意度列表
   *
   * @return 启用回访客户满意度列表
   */
  public static Collection getCustomOpinionList() {
      Collection result = new ArrayList(5);
      result.add(new LabelValueBean("很不满意", "1"));
      result.add(new LabelValueBean("不满意", "2"));
      result.add(new LabelValueBean("一般", "3"));
      result.add(new LabelValueBean("满意", "4"));
      result.add(new LabelValueBean("很满意", "5"));

      return result;
  }


    /**
     * 得到是与否列表
     *
     * @return 是与否列表
     */
    public static Collection getYesNoList() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("是", "1"));
        result.add(new LabelValueBean("否", "0"));
        return result;
    }

    /**
     * 得到出险原因代码列表
     *
     * @return 列表
     */
    public static Collection getDamageCodeList() {
        Collection result = new ArrayList(29);
        result.add(new LabelValueBean("碰撞", "456"));
        result.add(new LabelValueBean("车与车碰撞", "621"));
        result.add(new LabelValueBean("车与物碰撞", "622"));
        result.add(new LabelValueBean("车与人碰撞", "623"));
        result.add(new LabelValueBean("玻璃破碎", "417"));
        result.add(new LabelValueBean("倾覆", "403"));
        result.add(new LabelValueBean("坠落", "411"));
        result.add(new LabelValueBean("盗抢", "409"));
        result.add(new LabelValueBean("自燃", "410"));
        result.add(new LabelValueBean("外界物体倒塌", "404"));
        result.add(new LabelValueBean("外界物体坠落", "405"));
        result.add(new LabelValueBean("火灾", "401"));
        result.add(new LabelValueBean("爆炸", "402"));
        result.add(new LabelValueBean("暴雨", "001"));
        result.add(new LabelValueBean("暴风", "002"));
        result.add(new LabelValueBean("龙卷风", "003"));
        result.add(new LabelValueBean("雷击", "004"));
        result.add(new LabelValueBean("洪水", "005"));
        result.add(new LabelValueBean("海啸", "007"));
        result.add(new LabelValueBean("地陷", "008"));
        result.add(new LabelValueBean("冰陷", "011"));
        result.add(new LabelValueBean("雪崩", "012"));
        result.add(new LabelValueBean("崖崩", "022"));
        result.add(new LabelValueBean("雹灾", "013"));
        result.add(new LabelValueBean("泥石流", "014"));
        result.add(new LabelValueBean("滑坡", "015"));
        result.add(new LabelValueBean("载运保险车辆的渡船遭受自然灾害", "024"));
        result.add(new LabelValueBean("资金周转不灵", "618"));
        result.add(new LabelValueBean("其他", "999"));
        return result;
    }

   /**
    * 得到事故原因代码列表
    *
    * @return 列表
    */
   public static Collection getDamageTypeCodeList() {
       Collection result = new ArrayList(12);
       result.add(new LabelValueBean("疏忽大意、措施不当", "009"));
       result.add(new LabelValueBean("安全间距不够", "001"));
       result.add(new LabelValueBean("超速行驶", "002"));
       result.add(new LabelValueBean("逆向行驶", "003"));
       result.add(new LabelValueBean("疲劳驾驶", "004"));
       result.add(new LabelValueBean("违章装载", "006"));
       result.add(new LabelValueBean("制动失灵", "007"));
       result.add(new LabelValueBean("转向失灵", "008"));
       result.add(new LabelValueBean("违章并线", "010"));
       result.add(new LabelValueBean("其他机械故障", "995"));
       result.add(new LabelValueBean("其他违章行驶", "996"));
       result.add(new LabelValueBean("其他", "999"));
       return result;
   }

   /**
    * 得到事故原因代码列表
    *
    * @return 列表
    */
   public static Collection getIndemnityDutyList() {
       Collection result = new ArrayList(12);
       result.add(new LabelValueBean("全责", "0"));
       result.add(new LabelValueBean("主责", "1"));
       result.add(new LabelValueBean("同责", "2"));
       result.add(new LabelValueBean("次责", "3"));
       result.add(new LabelValueBean("无责", "4"));
       result.add(new LabelValueBean("其它", "9"));
       return result;
   }

   /**
    * 得到损失部件代码列表
    *
    * @return 损失部件列表
    */
   public static Collection getPartCodeList() {
       Collection result = new ArrayList(4);
       result.add(new LabelValueBean("前部", "1"));
       result.add(new LabelValueBean("左车身", "2"));
       result.add(new LabelValueBean("右车身", "3"));
       result.add(new LabelValueBean("后部", "4"));
       
       
       //原因：损失部件代码中增加玻璃一项
       //result.add(new LabelValueBean("玻璃", "5"));
      
       
       return result;
   }
   
   /**
    * 得到核价意见代码列表
    *
    * @return 核价意见列表
    */
   public static Collection getVerifyPriceOpinionList() {
       Collection result = new ArrayList(6);
       result.add(new LabelValueBean("同意报价", "01"));
       result.add(new LabelValueBean("补充信息", "02"));
       result.add(new LabelValueBean("价格异议发回", "03"));
       result.add(new LabelValueBean("价格已修正", "04"));
       result.add(new LabelValueBean("向外询价", "05"));
       result.add(new LabelValueBean("其它", "99"));
       return result;
   }

   public static Collection getVerifyPriceVerpoOpinionList() {
    Collection result = new ArrayList(5);
    result.add(new LabelValueBean("同意报价", "01"));
    result.add(new LabelValueBean("补充信息", "02"));
    result.add(new LabelValueBean("价格异议发回", "03"));
    result.add(new LabelValueBean("价格已修正", "04"));
    result.add(new LabelValueBean("其它", "99"));
    return result;
}
   
   
   /**
    * 得到核损意见代码列表
    *
    * @return 核损意见列表
    */
   public static Collection getVerifyOpinionList() {
       Collection result = new ArrayList(5);
       result.add(new LabelValueBean("同意定损", "01"));
       result.add(new LabelValueBean("价格异议", "02"));
       result.add(new LabelValueBean("信息不充分", "03"));
       result.add(new LabelValueBean("出具检验报告", "04"));
       result.add(new LabelValueBean("其它", "99"));
       return result;
   }
  
   /**
    * 得到修理厂类型代码列表
    *
    * @return 修理厂类型列表
    */
   public static Collection getRepairFactoryType() {
       Collection result = new ArrayList(3);
       result.add(new LabelValueBean("4S店", "01"));
       result.add(new LabelValueBean("一类厂", "02"));
       result.add(new LabelValueBean("二类厂以下", "03"));
       return result;
   }
   
     //begin以下为客户资料管理
      public static Collection getCustomerKind() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("0-专业代理人", "0"));
        result.add(new LabelValueBean("1-兼业代理人", "1"));
        result.add(new LabelValueBean("2-经纪人", "2"));
        return result;
        }
      public static Collection getCustomerFlag() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("0-准客户", "0"));
        result.add(new LabelValueBean("1-正式客户", "1"));
        return result;
        }
      public static Collection getShareHolder() {
        Collection result = new ArrayList(2);
        result.add(new LabelValueBean("否", "0"));
        result.add(new LabelValueBean("是", "1"));
        return result;
    }
      /**
       * 获得理赔结论下拉列表选项
       * @return
       */
      public static Collection getCompensateResultList(){
    	Collection result = new LinkedList();
        result.add(new LabelValueBean("给付", "1"));
        result.add(new LabelValueBean("拒付", "0"));
      	return result;
      }        
      
      /**
       * 获得理算退回信息下拉列表选项
       * @return
       */
      public static Collection getCompensateBackList(){
    	Collection result = new LinkedList();
        result.add(new LabelValueBean("补充材料", "01"));
        result.add(new LabelValueBean("拒赔条件", "02"));
        result.add(new LabelValueBean("增补项目[修改按增补项目处理]", "03"));
      	return result;
      }        
      //end 

}
