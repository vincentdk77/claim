package com.sinosoft.function.insutil.bl.facade;
/**
 * <p>Title: BLEncryptFacade</p>
 * <p>Description:MD5�����㷨�� </p>
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
   * getEncryptCode����MD5����Ҫ�Ĺ�����������ڲ���������Ҫ����MD5�任�ļ��ܺ���ַ���
   * ���ص��Ǳ任��Ľ�����������Ǵӹ�����ԱdigestHexStrȡ�õģ�
   * @param inputString ���봮
   * @return String MD5�Ľ��
   */
  public String getEncryptCode(String inputString)
  {
     String encryptCode  = "";  //���ܴ�
     BLEncryptAction blEncryptAction = new BLEncryptAction();
     encryptCode = blEncryptAction.getEncryptCode(inputString) ;
     return encryptCode;
  }
}
