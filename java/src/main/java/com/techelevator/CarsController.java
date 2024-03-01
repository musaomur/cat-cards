package com.techelevator;

import com.techelevator.model.CatCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarsController {
//    @RequestMapping
//    @RequestMapping()
//    @RequestMapping("")
//    @RequestMapping(path = "")
    @RequestMapping(path = "bmw", method = RequestMethod.GET)
//    @GetMapping(path = "")
//    @GetMapping
    public CatCard someFunction() {
        CatCard cc = new CatCard();
        cc.setImgUrl("gsdfgsdf");
        cc.setCatFact("gsdfgsdfg");
        return cc;
    }

    @RequestMapping("audi")
    public String someFunction2() {
        return "hello audi<a href=\"/cars/bmw\">bmw</a> <a href=\"/cars/ford\">ford</a>";
    }

    @RequestMapping("ford")
    public String someFunction3() {
        return "hello ford<a href=\"/cars/bmw\">bmw</a> <a href=\"/cars/audi\">audi</a>";
    }
}
