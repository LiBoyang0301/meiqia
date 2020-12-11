package org.lby.meiqia.goods.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtils {
    /**
     * a、定义上传位置路径
     * b、判断路径是否存在，不存在则创建
     * c、根据MultipartFile获取文件原始名，获取文件后缀
     * d、通过UUID生成新的文件名
     * e、通过transferTo将file复制到指定的文件中
     * f、返回新文件名
     */
    public static String uploadFile(String path, MultipartFile file) {
        File parent = new File(path);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        //根据MultipartFile获取文件原始名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-", "") + extName;

        try {
            file.transferTo(new File(path, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
