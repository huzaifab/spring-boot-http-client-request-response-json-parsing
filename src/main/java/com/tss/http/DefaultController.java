package com.tss.http;

/**
 * @author huzaifa bhavnagri
 */
import org.springframework.web.bind.annotation.RestController;
import com.tss.http.service.HttpJSONService;
import com.tss.http.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DefaultController {
  
  @Autowired(required=true)
  HttpJSONService httpJSONService;
  
  @GetMapping("/httpresponse/{id}")
  public ResponseEntity<?> sayHello(@PathVariable int id) {
    if(id==1) {
      //List All Permissiong from All type[web, api, mobile]
      return new ResponseEntity<>(JSONUtil.getAllAPIPermissions(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==2) {
      //List All Permissiong from only type[mobile]
      return new ResponseEntity<>(JSONUtil.getAllAPIPermissionsTypeMobile(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==3) {
      //List All Permissiong from only type[web, mobile]
      return new ResponseEntity<>(JSONUtil.getAllAPIPermissionsTypeWebORMobile(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==4) {
      //List All Days from All type[web, api, mobile]
      return new ResponseEntity<>(JSONUtil.getAllAPIType(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==5) {
      //List All Days from only type[api, mobile]
      return new ResponseEntity<>(JSONUtil.getAllAPITypeApiOrMobile(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==6) {
      //Display total size of List comes in Data [web, api, mobile] - it must be 3
      return new ResponseEntity<>(JSONUtil.getDataArraySize(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==7) {
      //List All types - it must be 3 - [web, api, mobile]
      return new ResponseEntity<>(JSONUtil.getAllTypes(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } else if(id==8) {
      //List All types which has id = uid-api - it must be [api]
      return new ResponseEntity<>(JSONUtil.getAllTypesHavingIdUidApi(httpJSONService.getJSONResponse()), HttpStatus.OK);
    } /*
      else if(id==9) {
      //List All types which has Sunday in days - it must be [api, mobile]
      return new ResponseEntity<>(JSONUtil.getAllTypesHavingDaySunday(httpJSONService.getJSONResponse()), HttpStatus.OK);
      } */
     else { 
      return new ResponseEntity<>("Please select options from [1,2,3,4,5,6,7,8]", HttpStatus.NOT_IMPLEMENTED);
    }
  }
}