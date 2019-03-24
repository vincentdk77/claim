package com.sinosoft.function.insutil.bl.facade;
/**
 * <p>Title: BLEncryptFacade</p>
 * <p>Description:MD5加密算法类 </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
import com.sinosoft.function.insutil.bl.action.custom.BLEncryptAction;
public class BLEncryptFacade {
  public BLEncryptFacade() {
  }
  /**
   * getEncryptCode是类MD5最主要的公共方法，入口参数是你想要进行MD5变换的加密后的字符串
   * 返回的是变换完的结果，这个结果是从公共成员digestHexStr取得的．
   * @param inputString 输入串
   * @return String MD5的结果
   */
  public String getEncryptCode(String inputString)
  {
     String encryptCode  = "";  //加密串
     BLEncryptAction blEncryptAction = new BLEncryptAction();
     encryptCode = blEncryptAction.getEncryptCode(inputString) ;
     return encryptCode;
  }
}
