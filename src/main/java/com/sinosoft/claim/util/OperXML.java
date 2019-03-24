package com.sinosoft.claim.util;

/**
 * <p>Title: ����XML�ļ�</p>
 * <p>Description: ��XML�ļ����ж���д���޸Ĳ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: sinosoft</p>
 * <p>CreateDate ��2004-06-15</p>
 * @Author     :
 * @version 1.0
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;


public class OperXML {
	private boolean blHasParent = false;
	private String strParentTag = "";
	private String strParentValue = "";
	private Document doc = null;
	private Element root = null;


  /**
   * Ĭ�ϵĹ��캯��
   */
  public OperXML() {
  } 

  /**
   * �������Ĺ��캯��
   * @param iParentTag ���ڵ�ı�ǩ
   * @param iParentValue ���ڵ��ֵ
   */
  
  public OperXML(String iParentTag,String iParentValue) {
    this.blHasParent = true;
    this.strParentTag = iParentTag;
    this.strParentValue = iParentValue;
  }

  /**
   * ����XML�ļ�
   * @param iFileSrc Ҫ������XML�ļ�·��
   * @throws IOException
   * @throws JDOMException
   * @throws Exception
   */
  public void parser(String iFileSrc) throws IOException,JDOMException,Exception
  {
    try
    {
      SAXBuilder sb = new SAXBuilder();
      doc = sb.build(new FileInputStream(iFileSrc));
      root = doc.getRootElement();
    }
    catch(IOException ioe)
    {
      throw new IOException("�����������ļ���" + iFileSrc);
    }
    catch(JDOMException jdome)
    {
      jdome = new JDOMException("������Ч��XML�ĵ�!");
      throw jdome;
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * ����XML�ַ���
   * @param iXMLStr Ҫ������XML�ַ���
   * @throws IOException
   * @throws JDOMException
   * @throws Exception
   */
  public void parserFromXMLString(String iXMLStr) throws IOException,JDOMException,Exception
  {
    try
    {
      SAXBuilder sb = new SAXBuilder();
      doc = sb.build(new StringReader(iXMLStr));
      root = doc.getRootElement();
    }
    catch(IOException ioe)
    {
      throw ioe;
    }
    catch(JDOMException jdome)
    {
      jdome = new JDOMException("������Ч��XML�ĵ�!");
      throw jdome;
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�Ľڵ�ĸ���
   * @param iKeyCode �ڵ��ǩ
   * @return int �ڵ����
   * @throws JDOMException
   * @throws Exception
   */
  public int getCountByTag(String iKeyCode) throws JDOMException,Exception
  {
    int iCount = 0;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        iCount = lKeyList.size();
      }
      else
      {
        iCount = 0;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return iCount;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�Ľڵ�ĸ���
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @return int �ڵ����
   * @throws JDOMException
   * @throws Exception
   */
  public int getCountByTag(Element iElem,String iKeyCode) throws JDOMException,Exception
  {
    int iCount = 0;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        iCount = lKeyList.size();
      }
      else
      {
        iCount = 0;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return iCount;
  }

  /**
   * ��ȡ���ڵ���¼��ӽڵ�ĸ���
   * @return int �ڵ����
   * @throws JDOMException
   * @throws Exception
   */
  public int getCount() throws JDOMException,Exception
  {
    int iCount = 0;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren();
      if(lKeyList.size()>0)
      {
        iCount = lKeyList.size();
      }
      else
      {
        iCount = 0;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return iCount;
  }

  /**
   * ��ȡ�ڵ�iElem���¼��ӽڵ�ĸ���
   * @param iElem �ڵ�Element
   * @return int �ڵ����
   * @throws JDOMException
   * @throws Exception
   */
  public int getCount(Element iElem) throws JDOMException,Exception
  {
    int iCount = 0;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren();
      if(lKeyList.size()>0)
      {
        iCount = lKeyList.size();
      }
      else
      {
        iCount = 0;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return iCount;
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�����нڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @return String[] �ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String[] getKeyValues(String iKeyCode) throws JDOMException,Exception
  {
    String[] strArrValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        strArrValue = new String[lKeyList.size()];
        for(int i=0;i<lKeyList.size();i++)
        {
          Element item = (Element)lKeyList.get(i);
          strArrValue[i] = item.getText();
        }
      }
      else
      {
        throw new Exception("����û�д˽ڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strArrValue;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�����нڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @return String[] �ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String[] getKeyValues(Element iElem,String iKeyCode) throws JDOMException,Exception
  {
    String[] strArrValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        strArrValue = new String[lKeyList.size()];
        for(int i=0;i<lKeyList.size();i++)
        {
          Element item = (Element)lKeyList.get(i);
          strArrValue[i] = item.getText();
        }
      }
      else
      {
        throw new Exception("�ڵ�" + iElem.getName() + "��û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strArrValue;
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�ĵ�һ���ڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @return String ��һ���ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String getKeyValue(String iKeyCode) throws JDOMException,Exception
  {
    String strValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        Element item = (Element)lKeyList.get(0);
        strValue = item.getText();
      }
      else
      {
        throw new Exception("����û�д˽ڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strValue;
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�ĵ�index+1���ڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @param index �ڵ���±�
   * @return String ��index+1���ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String getKeyValue(String iKeyCode,int index) throws JDOMException,Exception
  {
    String strValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        if(index>=lKeyList.size())
          throw new Exception("�±�Խ�磺" + index);
        else
        {
          Element item = (Element)lKeyList.get(index);
          strValue = item.getText();
        }
      }
      else
      {
        throw new Exception("����û�д˽ڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strValue;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�ĵ�һ���ڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @return String ��һ���ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String getKeyValue(Element iElem,String iKeyCode) throws JDOMException,Exception
  {
    String strValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        Element item = (Element)lKeyList.get(0);
        strValue = item.getText();
      }
      else
      {
        throw new Exception("�ڵ�" + iElem.getName() + "��û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strValue;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�ĵ�index+1���ڵ��ֵ
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @param index �ڵ���±�
   * @return String ��index+1���ڵ��ֵ
   * @throws JDOMException
   * @throws Exception
   */
  public String getKeyValue(Element iElem,String iKeyCode,int index) throws JDOMException,Exception
  {
    String strValue = null;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        if(index>=lKeyList.size())
          throw new Exception("�±�Խ�磺" + index);
        else
        {
          Element item = (Element)lKeyList.get(index);
          strValue = item.getText();
        }
      }
      else
      {
        throw new Exception("����û�д˽ڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return strValue;
  }


  /**
   * ���ýڵ�iElem����ΪiAttributeCode��ֵ
   * @param iAttributeCode �ڵ��ֵ
   * @param iElem �ڵ�Element
   * @throws JDOMException
   * @throws Exception
   */
  public String getAttribute(Element iElem,String iAttributeCode) throws JDOMException,Exception
  {
    Attribute attr = null;
    String strAttributeValue = "";
    try
    {
       attr = iElem.getAttribute(iAttributeCode);
       if(attr==null)
       {
          throw new Exception("");
       }
       else
         strAttributeValue = attr.getValue();
    }
    catch(Exception e)
    {
      throw e;
    }
    return strAttributeValue;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�ĵ�һ���ڵ�
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @return Element ��һ���ڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public Element getElement(Element iElem,String iKeyCode) throws JDOMException,Exception
  {
    Element element = null;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        element = (Element)lKeyList.get(0);
      }
      else
      {
        throw new Exception("�ڵ�" + iElem.getName() + "��û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return element;
  }

  /**
   * ��ȡ(�ڵ�iElem��)��ǩΪiKeyCode�ĵ�index+1���ڵ�
   * @param iKeyCode �ڵ��ǩ
   * @param iElem �ڵ�Element
   * @param index �ڵ���±�
   * @return Element ��index+1���ڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public Element getElement(Element iElem,String iKeyCode,int index) throws JDOMException,Exception
  {
    Element element = null;
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        if(index>=lKeyList.size())
          throw new Exception("�±�Խ�磺" + index);
        else
          element = (Element)lKeyList.get(index);
      }
      else
      {
        throw new Exception("�ڵ�" + iElem.getName() + "��û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return element;
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�ĵ�һ���ڵ�
   * @param iKeyCode �ڵ��ǩ
   * @return Element ��һ���ڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public Element getElement(String iKeyCode) throws JDOMException,Exception
  {
    Element element = null;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        element = (Element)lKeyList.get(0);
      }
      else
      {
        throw new Exception("����û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return element;
  }

  /**
   * ��ȡ(���ڵ���)��ǩΪiKeyCode�ĵ�index+1���ڵ�
   * @param iKeyCode �ڵ��ǩ
   * @param index �ڵ���±�
   * @return Element ��index+1���ڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public Element getElement(String iKeyCode,int index) throws JDOMException,Exception
  {
    Element element = null;
    List lKeyList = null;
    try
    {
      lKeyList = root.getChildren(iKeyCode);
      if(lKeyList.size()>0)
      {
        if(index>=lKeyList.size())
          throw new Exception("�±�Խ�磺" + index);
        else
          element = (Element)lKeyList.get(index);
      }
      else
      {
        throw new Exception("����û�д��ӽڵ㣺" + iKeyCode);
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    return element;
  }

  /**
   * ���ýڵ�iElem��ֵ
   * @param iKeyValue �ڵ��ֵ
   * @param iElem �ڵ�Element
   * @throws JDOMException
   * @throws Exception
   */
  public void setKeyValue(Element iElem,String iKeyValue) throws JDOMException,Exception
  {
    List lKeyList = null;
    try
    {
      lKeyList = iElem.getChildren();
      if(lKeyList.size()>0)
      {
         throw new Exception("�ڵ�" + iElem.getName() + "�»����ӽڵ㣬�������øýڵ��ֵ!");
      }
      else
        iElem.setText(iKeyValue);
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * ���ýڵ�iElem����iAttributeCode��ֵiAttributeValue
   * @param iAttributeCode �ڵ�����Ե�����
   * @param iAttributeValue �ڵ��ֵ
   * @param iElem �ڵ�Element
   * @param blFlag ��־����������ڸ�����ʱtrue����/false�����Ӳ��׳��쳣
   * @throws JDOMException
   * @throws Exception
   */
  public void setAttribute(Element iElem,String iAttributeCode,String iAttributeValue,boolean blFlag) throws JDOMException,Exception
  {
    Attribute attr = null;
    try
    {
      attr = iElem.getAttribute(iAttributeCode);
      if(attr==null)
      {
        if(blFlag)
        {
          iElem.setAttribute(iAttributeCode,iAttributeValue);
        }
        else
          throw new Exception("�ڵ�" + iElem.getName() + "û������" + iAttributeCode + "���������ø����Ե�ֵ!");
      }
      else
        iElem.setAttribute(iAttributeCode,iAttributeValue);
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * ���ýڵ�iElem����iAttributeCode��ֵiAttributeValue
   * @param iAttributeCode �ڵ�����Ե�����
   * @param iAttributeValue �ڵ��ֵ
   * @param iElem �ڵ�Element
   * @throws JDOMException
   * @throws Exception
   */
  public void setAttribute(Element iElem,String iAttributeCode,String iAttributeValue) throws JDOMException,Exception
  {
    try
    {
      setAttribute(iElem,iAttributeCode,iAttributeValue,false);
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * �ڽڵ�iParentElem������һ���ӽڵ�
   * @param iParentElem ���ڵ�
   * @param iSubElem �ӽڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public void addElement(Element iParentElem,Element iSubElem) throws JDOMException,Exception
  {
    try
    {
      iParentElem.addContent(iSubElem);
    }
    catch(Exception e)
    {
      throw e;
    }
  }

  /**
   * �ڽڵ�iParentElem������һ���ӽڵ�
   * @param iParentElem ���ڵ�
   * @param iSubElem �ӽڵ�
   * @param index �ӽڵ���ӵ�λ��
   * @throws JDOMException
   * @throws Exception
   */
  public void addElement(Element iParentElem,Element iSubElem,int index) throws JDOMException,Exception
  {
    try
    {
      iParentElem.addContent(index,iSubElem);
    }
    catch(Exception e)
    {
      throw e;
    }
  }


  /**
   * �����ڵ�
   * @param iElemCode �ڵ������
   * @param iElemValue �ڵ��ֵ
   * @return Element Ҫ�����Ľڵ�
   * @throws JDOMException
   * @throws Exception
   */
  public Element createElement(String iElemCode,String iElemValue) throws JDOMException,Exception
  {
    Element elem = null;
    try
    {
      elem = new Element(iElemCode,iElemValue);
    }
    catch(Exception e)
    {
      throw e;
    }
    return elem;
  }

  /**
   * �����ĵ�
   * @param iRootName ���ڵ������
   */
  public void createDocument(String iRootName) throws JDOMException,Exception
  {
     try {
       if(doc==null)
         doc = new Document(new Element(iRootName));
         root = doc.getRootElement();
     }
     catch (Exception e) {
       e.printStackTrace();
     }
  }

  /**
   * �����ĵ�
   * @param outputFileSrc Ҫ������ĵ���·��
   */
 
  public void saveDocument(String outputFileSrc) throws IOException,JDOMException,Exception
  {
      try {
          XMLOutputter outputter;
          outputter = new XMLOutputter("  ",false,"GB2312");
          outputter.output(doc, new FileOutputStream(outputFileSrc));
      }
      catch (IOException ioe) {
          ioe.printStackTrace();
      }
      catch (Exception e) {
          e.printStackTrace();
      }
  }

	/*<p>Description: ��ȡ���ڵ�����ͬ�ڵ�list�������������¼XML��ʽ</p>
	* <p>Copyright: Copyright (c) 2004</p>
	* <p>Company: sinosoft ������Ŀ��</p>
	* @author luyang
	* @date 2004-11-01
	*/
	public List getChildrenElement(String strXML,String strElement) throws IOException,JDOMException,Exception
	{
		List list = null;
		try
		{
			SAXBuilder sb = new SAXBuilder();
			doc = sb.build(new StringReader(strXML));
			root = doc.getRootElement();
			list = root.getChildren(strElement);
		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (JDOMException jdome) {
			jdome = new JDOMException("������Ч��XML�ĵ�!");
			throw jdome;
		}
		catch (Exception e) {
			throw e;
		}
		return list;
	}

  /**
   * ������
   */
  public static void main(String[] args) {

  }
}
