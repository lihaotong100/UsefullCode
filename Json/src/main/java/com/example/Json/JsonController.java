package com.example.Json;

import com.example.Object.JsonObject;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class JsonController {

    /*
    Method: Post
    Data From: Request body
    example: localhost:8080/getDataByJson
    Body:
    {
        "name": "Oliver",
        "age": "26"
    }
    */
    @PostMapping("/getDataByJson")
    public void getDataByJson(@RequestBody JsonObject data){
    System.out.print(data.getAge());
    }


    /*
    Method: Get
    Data From: URL
    example: localhost:8080/getDataByUrl?name=Oliver&age=26
    */
    @GetMapping("/getDataByUrl")
    public void getDataByUrl(@RequestParam(value = "name",required=true)String name,
                             @RequestParam(value = "age",required = false)String age){
        System.out.print(name);
        System.out.print(age);

    }

    @PostMapping("/getDataById/{id}")
    public String getDataById(@PathVariable("id")String id,@RequestBody JsonObject data){
        String msg = "";
        if("1".equals(id)){
            msg = "the id is 1";
        }else{
            msg = "the id is not 1";
        }
        return msg;
    }

    @PostMapping("/getJsonData")
    public JsonObject getJsonData(@RequestBody JsonObject data){
        return data;
    }
}
