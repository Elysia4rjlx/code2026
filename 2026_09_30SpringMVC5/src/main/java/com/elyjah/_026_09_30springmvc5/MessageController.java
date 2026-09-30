package com.elyjah._026_09_30springmvc5;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private List<MessageInfo> messageInfos = new ArrayList<>();

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        return messageInfos;
    }

    @RequestMapping("/publish")
    public boolean publish(@RequestBody()MessageInfo messageInfo){
        System.out.println(messageInfo);

        if (StringUtils.hasText(messageInfo.getFrom())
                && StringUtils.hasText(messageInfo.getTo())
                && StringUtils.hasText(messageInfo.getMessage())){
            messageInfos.add(messageInfo);
            return true;
        }
        return false;

    }

}