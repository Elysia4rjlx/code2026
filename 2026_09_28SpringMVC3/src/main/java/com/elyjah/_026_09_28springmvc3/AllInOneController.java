package com.elyjah._026_09_27springmvc3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/all")
public class AllInOneController {

    @PostMapping("/{id}/update")
    public String update(
            @PathVariable Integer id,
            @RequestParam("from") String from,
            @RequestHeader("token" ) String token,
            @RequestBody Person person
    ){
        return "id = " + id +
                ", from = " + from +
                ". token = " + token +
                " , person = " + person;
    }
}