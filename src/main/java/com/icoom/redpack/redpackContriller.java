package com.icoom.redpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class redpackContriller {


    @Autowired
    private redpackDio repository;

    /**
     *  获取红包列表
     * **/

    @GetMapping("/redpackmoney")
    public List<money> list () {
    return repository.findAll();
    }

    /**
     * 创建红包🧧
     * **/
    @PostMapping("/redpackmoney")
    public money create(@RequestParam("producer") String producer,
                        @RequestParam("money") BigDecimal money,
                        @RequestParam("consumer") String consumer ){
        money m1 = new money();
        m1.setProducer(producer);
        m1.setMoney(money);
        m1.setConsumer(consumer);
        return repository.save(m1);
    }


    /**
     * 通过id查询红包
     * **/

    @GetMapping("/redpackmoney/{id}")
    public money findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包 (领红包)
     * **/
    @PutMapping("/redpackmoney/{id}")
    public money update(@PathVariable("id") Integer id,
                        @RequestParam("consumer") String consumer ) {
        Optional<money> optional = repository.findById(id);
        if (optional.isPresent()){
          money m2 = optional.get();
          m2.setId(id);
          m2.setConsumer(consumer);
          return repository.save(m2);
        }
        return null;
    }
}
