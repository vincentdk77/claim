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
 * Request上传文件辅助工具类
 *
 * @author liujianbo
 * 20050322
 */
public class FileUploadUtils {
    private HttpServletRequest request;
    private boolean            isMultipart; //是否文件上传方式
    private Object[]           fileItemList; //解析后的FileItem列表
    private File               repository;  //存储路径

    /**
     * 构造方法
     * @param request HttpServletRequest
     * @param repository 存储路径
     * @param sizeMax 允许用户上传文件大小,单位:字节
     * @param sizeThreshold 置最多只允许在内存中存储的数据,单位:字节
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
        // 设置允许用户上传文件大小,单位:字节
        fu.setSizeMax(sizeMax);
        // 设置最多只允许在内存中存储的数据,单位:字节
        fu.setSizeThreshold(sizeThreshold);
        // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
        //fu.setRepositoryPath(System.getProperty("java.io.tmpdir"));
        fu.setRepositoryPath(repository.getPath());//加快移动速度
        try {
          //开始解析
          fileItemList = fu.parseRequest(request).toArray();
        }
        catch (FileUploadException e) {
          throw new ServletException(e);
        }
      }
    /**
     * 构造方法，允许用户上传文件总的大小为100M，在内存中存储的数据为8K
     *
     * @param request HttpServletRequest
     * @param repository 存储路径
     * @throws Exception
     */
    public FileUploadUtils(HttpServletRequest request, File repository) throws ServletException {
        this(request, repository, 200 * 1024 * 1024, 8192);
    }
    /**
     * 构造方法，用于获取参数值
     *
     * @param request HttpServletRequest
     * @throws Exception
     */
    public FileUploadUtils(HttpServletRequest request) throws ServletException {
        this(request, null, 200 * 1024 * 1024, 8192);
    }
    /**
     * 获取参数
     *
     * @param name 参数名称
     * @return
     */
    public String getParameter(String name) throws ServletException {
        //不是文件上传时的快速方法
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
                        //保存上传的文件到存储目录
                        File file = getUniqueFile(item.getName());
                        try {
                            //写文件
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
     * 获取参数
     * @param name 参数名称
     * @return
     */
    public String[] getParameterValues(String name) throws ServletException {
        //不是文件上传时的快速方法
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
                        //保存上传的文件到存储目录
                        File file = getUniqueFile(item.getName());
                        try {
                            //写文件
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
     * 是否是Multipart形式，即是否包含文件上传
     * @return 是则返回true,否则返回false
     */
    public boolean isMultipart() {
        return isMultipart;
    }
    /**
     * 得到唯一文件
     *
     * @param fileName 原始文件名
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
     * 得到短文件名. <br>
     * <br>
     * <b>示例: </b> <br>
     * FileUtils.getShortFileName(&quot;/home/app/config.xml&quot;) 返回 &quot;config.xml&quot;
     * FileUtils.getShortFileName(&quot;C:\\test\\config.xml&quot;) 返回 &quot;config.xml&quot;
     * @param fileName 文件名
     * @return 短文件名
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

