package com.sinosoft.claim.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileUploadException;
/**
 * Request�ϴ��ļ�����������
 *
 * @author liujianbo
 * 20050322
 */
public class FileUploadUtils {
    private HttpServletRequest request;
    private boolean            isMultipart; //�Ƿ��ļ��ϴ���ʽ
    private Object[]           fileItemList; //�������FileItem�б�
    private File               repository;  //�洢·��

    /**
     * ���췽��
     * @param request HttpServletRequest
     * @param repository �洢·��
     * @param sizeMax �����û��ϴ��ļ���С,��λ:�ֽ�
     * @param sizeThreshold �����ֻ�������ڴ��д洢������,��λ:�ֽ�
     * @throws Exception
     */
    public FileUploadUtils(HttpServletRequest request, File repository, int sizeMax, int sizeThreshold)
            throws ServletException {
        this.request = request;
        this.repository = repository;
        isMultipart = FileUpload.isMultipartContent(request);
        if (isMultipart == false) {
            return;
        }
        if (isMultipart == true && repository == null) {
            throw new ServletException("you can't set repository to null when content-type is multipart");
        }
        DiskFileUpload fu = new DiskFileUpload();
        // ���������û��ϴ��ļ���С,��λ:�ֽ�
        fu.setSizeMax(sizeMax);
        // �������ֻ�������ڴ��д洢������,��λ:�ֽ�
        fu.setSizeThreshold(sizeThreshold);
        // ����һ���ļ���С����getSizeThreshold()��ֵʱ���ݴ����Ӳ�̵�Ŀ¼
        //fu.setRepositoryPath(System.getProperty("java.io.tmpdir"));
        fu.setRepositoryPath(repository.getPath());//�ӿ��ƶ��ٶ�
        try {
          //��ʼ����
          fileItemList = fu.parseRequest(request).toArray();
        }
        catch (FileUploadException e) {
          throw new ServletException(e);
        }
      }
    /**
     * ���췽���������û��ϴ��ļ��ܵĴ�СΪ100M�����ڴ��д洢������Ϊ8K
     *
     * @param request HttpServletRequest
     * @param repository �洢·��
     * @throws Exception
     */
    public FileUploadUtils(HttpServletRequest request, File repository) throws ServletException {
        this(request, repository, 200 * 1024 * 1024, 8192);
    }
    /**
     * ���췽�������ڻ�ȡ����ֵ
     *
     * @param request HttpServletRequest
     * @throws Exception
     */
    public FileUploadUtils(HttpServletRequest request) throws ServletException {
        this(request, null, 200 * 1024 * 1024, 8192);
    }
    /**
     * ��ȡ����
     *
     * @param name ��������
     * @return
     */
    public String getParameter(String name) throws ServletException {
        //�����ļ��ϴ�ʱ�Ŀ��ٷ���
        if (isMultipart == false) {
            return request.getParameter(name);
        }
        String value = null;
        for (int i = 0; i < fileItemList.length; i++) {
            FileItem item = (FileItem) fileItemList[i];
            if (item.getFieldName().equals(name)) {
                if (item.isFormField()) {
                    value = item.getString();
                    break;
                } else {
                    if (item.getName().equals("")) {
                        value = "";
                    } else {
                        //�����ϴ����ļ����洢Ŀ¼
                        File file = getUniqueFile(item.getName());
                        try {
                            //д�ļ�
                            item.write(file);
                        } catch (Exception e) {
                            throw new ServletException(e);
                        }
                        value = file.getPath();
                        value = file.getName();
                    }
                    break;
                }
            }
        }
        return value;
    }

    /**
     * ��ȡ����
     * @param name ��������
     * @return
     */
    public String[] getParameterValues(String name) throws ServletException {
        //�����ļ��ϴ�ʱ�Ŀ��ٷ���
        if (isMultipart == false) {
            return request.getParameterValues(name);
        }
        ArrayList values = new ArrayList();
        String value = "";
        for (int i = 0; i < fileItemList.length; i++) {
            FileItem item = (FileItem) fileItemList[i];
            if (item.getFieldName().equals(name)) {
                if (item.isFormField()) {
                    value = item.getString();
                    values.add(value);
                } else {
                    if (item.getName().equals("")) {
                        value = "";
                    } else {
                        //�����ϴ����ļ����洢Ŀ¼
                        File file = getUniqueFile(item.getName());
                        try {
                            //д�ļ�
                            item.write(file);
                        } catch (Exception e) {
                            throw new ServletException(e);
                        }
                        value = file.getPath();
                        value = file.getName();
                    }
                    values.add(value);
                }
            }
        }
        String[] retValues = new String[values.size()];
        values.toArray(retValues);
        return retValues;
    }
    /**
     * �Ƿ���Multipart��ʽ�����Ƿ�����ļ��ϴ�
     * @return ���򷵻�true,���򷵻�false
     */
    public boolean isMultipart() {
        return isMultipart;
    }
    /**
     * �õ�Ψһ�ļ�
     *
     * @param fileName ԭʼ�ļ���
     * @return
     */
    private synchronized File getUniqueFile(String fileName) {
        String tempFileName = getShortFileName(fileName);
        File file = new File(repository, tempFileName);
        synchronized (FileUploadUtils.class) {
            while (file.exists()) {
                file = new File(repository, Math.abs(new Random().nextInt()) + tempFileName);
            }
        }
        return file;
    }
    /**
     * �õ����ļ���. <br>
     * <br>
     * <b>ʾ��: </b> <br>
     * FileUtils.getShortFileName(&quot;/home/app/config.xml&quot;) ���� &quot;config.xml&quot;
     * FileUtils.getShortFileName(&quot;C:\\test\\config.xml&quot;) ���� &quot;config.xml&quot;
     * @param fileName �ļ���
     * @return ���ļ���
     */
    private static String getShortFileName(String fileName) {
        String shortFileName = "";
        int pos = fileName.lastIndexOf('\\');
        if (pos == -1) {
            pos = fileName.lastIndexOf('/');
        }
        if (pos > -1) {
            shortFileName = fileName.substring(pos + 1);
        } else {
            shortFileName = fileName;
        }
        return shortFileName;
    }
}

