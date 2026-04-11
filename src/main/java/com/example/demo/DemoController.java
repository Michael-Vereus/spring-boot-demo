package com.example.demo;

import com.example.demo.dto.DemoResponse;
import com.example.demo.dto.Item.CreateItem;
import com.example.demo.helper.DebugHelp;
import com.example.demo.model.Item;
import com.example.demo.services.DemoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/item")
public class DemoController {
    @Autowired
    private DemoService demoService;

    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }
    @GetMapping("/welcome")
    public String sayHello() {
        return "Server is Up and Running \n";
    }
    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable String msg){
        return "You whispered : " + msg + "\n";
    }
    @GetMapping("/test")
    public DemoResponse<String> test(){
        return DemoResponse.debug(demoService.test());
    }

    @GetMapping("/testSQLdb")
    public DebugHelp testALl(){ // still uses DebugHelp for simplicity and debugging
        DebugHelp debugCheck = DebugHelp.debug();
        debugCheck.addDebug("debug_1", demoService.testAll());
        return debugCheck;
    }

    @GetMapping("/get/{id}")
    public DemoResponse search(@PathVariable Long id){
        Map<String, Optional<Item>> itemFound = new HashMap<>();
        itemFound.put("Result", demoService.searchById(id));
        return  DemoResponse.debug(itemFound);
    }

    @DeleteMapping("/del")
    public DebugHelp destroy(@RequestBody Map<String, List<Long>> body){
        List<Long> listOfId = body.get("itemId");
        if (listOfId == null){return DebugHelp.fail("No Id Given");}
        DebugHelp debugHelp = new DebugHelp();
        debugHelp.addDebug("Test", demoService.deleteById(listOfId));
        return debugHelp;
    }

    @PostMapping("/add")
    public DebugHelp add(@Valid @RequestBody CreateItem createItem){
        // still empty, still void
         // add logic for throwing there
        Item newItem = new Item(createItem);
        demoService.insertItem(newItem);
        return DebugHelp.fail("This is a Debug : " + newItem.getName() + " ," + newItem.getId() + " ," + newItem.getPrice() );
    }

    @PutMapping("/update")
    public void update(@RequestBody Item item){
        // still empty
    }
}


// check the pasrsing system, see if