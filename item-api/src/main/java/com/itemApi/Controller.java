package com.itemApi;

import com.itemApi.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    ItemService itemService;

    @RequestMapping("/{howMany}")
    public String getItems(@PathVariable("howMany") int howMany){
        return itemService.getItems(howMany);
    }
}