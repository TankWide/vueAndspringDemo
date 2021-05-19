package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.SupperFileMapper;
import com.example.demo.dao.entity.ObjectToJson;
import com.example.demo.dao.entity.SupplierFile;
import com.example.demo.service.UploadService;
import com.example.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${web.upload-path}")
    String uploadPath;

    @Autowired
    private SupperFileMapper supperMapper;


    @Override
    public SupplierFile uploadContract(MultipartFile[] multipartFiles) throws Exception {
        MultipartFile multipartFile = multipartFiles[0];
        String uploadFilePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
//        String uploadFilePath = uploadPath;
        // Date date = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // String time = sdf.format(date);
        String receiveFileName = multipartFile.getOriginalFilename();
        receiveFileName = receiveFileName == null ? "" : receiveFileName;
        int i = receiveFileName.lastIndexOf(".");
        String fileName;
        if (i == -1) {
            fileName = receiveFileName;
        } else {
            fileName = receiveFileName.substring(0, i);
            String fileFormat = receiveFileName.substring(i + 1);
            fileName = fileName + "." + fileFormat;
        }
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        File file = null;
        String randomStr = StringUtil.random(5);
        try {
            inputStream = multipartFile.getInputStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            file = new File(uploadFilePath + File.separator + fileName);
            if (!file.getParentFile().isDirectory()) {
                file.getParentFile().mkdirs();
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            byte[] bytes = new byte[2048];
            int n = -1;
            while ((n = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                bufferedOutputStream.write(bytes, 0, n);
            }
        } catch (Exception e) {
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        }
        SupplierFile supplierFile = new SupplierFile();
        if (file != null) {
            ObjectToJson object = new ObjectToJson();
            String filename = fileName;
            String url = "/" + randomStr + "/" + fileName;
            object.setFilename(filename);
            object.setUrl(url);
            String attachmentPath = JSON.toJSONString(object);
            supplierFile.setAttachmentPath(attachmentPath);
            supplierFile.setFileName(fileName);
            // supplierFile.setAttachmentPath(filename + "," + url);
            // supplierFile.setAttachmentPath("\\" + randomStr + File.separator
            // + fileName);
            // supplierFile.setFileName(receiveFileName);
        }
        supperMapper.insertFile(supplierFile);
        return supplierFile;
    }


    @Override
    public SupplierFile getUrl() {

        return supperMapper.getUrl();
    }

}
