package com.elyjah._026_09_27springmvc3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/file")
    public String upload(@RequestPart("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        file.transferTo(new File("D:/temp/" + fileName));
        return "上传成功,文件名:" + fileName + ",大小:" + file.getSize() + " 字节";
    }

}