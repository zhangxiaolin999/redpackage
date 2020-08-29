package com.icoom.redpack;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class Hello {
    @GetMapping("/say")
      public String say(@RequestParam(value = "id",required = true,defaultValue = "0") Integer id){
        return "id: " + id;
      }
}
