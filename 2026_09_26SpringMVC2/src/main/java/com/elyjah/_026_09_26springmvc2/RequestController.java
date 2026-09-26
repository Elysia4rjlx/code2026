package com.elyjah._026_09_26springmvc2;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @RequestMapping("/r1")
    public String r1(Persom persom){
        return "接收到的参数： " + persom;
    }

    //参数绑定，参数出门明年
    @RequestMapping("/r2")
    public String r2(@RequestParam(value = "ss",required = false) String key){
        return "接收到的参数： " + key;
    }

    //接收数组
    @RequestMapping("/r3")
    public String r3(String[] arr){
        return Arrays.toString(arr);
    }

    //接受集合
    @RequestMapping("/r4")
    public String r4(@RequestParam List<String> list){
        return list.toString();
    }

    //接收 一个 JSON字符串，并把JSON字符串转换为Person对象
    @RequestMapping("/r5")
    public String r5(@RequestBody Persom persom){
        return persom.toString();
    }

    //获取URL中的参数
    @RequestMapping("/r6/{id}")
    public String r6(@PathVariable("id") Integer userId){
        return "从URL获取id ：" + userId;
    }

    //获取URL中的参数
    @RequestMapping("/r7/{id}/{type}")
    public String r7(@PathVariable("id") Integer userId,@PathVariable String type){
        return "从URL获取id ：" + userId + ",type : " + type;
    }

    //文件上传
    @RequestMapping("r8")
    public String r8(@RequestPart("file")MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());

        //文件上传
        File file = new File("D:/code/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return "文件上传成功";
    }

    @PostMapping("r9")
    public String r9(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());

        File file = new File("D:/code/" + multipartFile.getOriginalFilename());
        // 确保父目录存在，防止目录不存在导致上传失败
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        multipartFile.transferTo(file);
        return "文件上传成功";
    }
}