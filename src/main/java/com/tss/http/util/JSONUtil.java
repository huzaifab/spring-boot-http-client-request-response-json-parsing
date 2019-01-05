package com.tss.http.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class JSONUtil {
  public static List<String> getAllAPIPermissions (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][*]['attributes']['permissions']", JSONArray.class)
        .forEach(
            e -> ((JSONArray) e)
                .forEach(i -> perms.add(((String) i)))
        );
    return new ArrayList<>(perms);
  }
  public static List<String> getAllAPIPermissionsTypeMobile (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][?(@.type=='mobile')]['attributes']['permissions']", JSONArray.class)
        .forEach(
            e -> ((JSONArray) e)
                .forEach(i -> perms.add(((String) i)))
        );
    return new ArrayList<>(perms);
  }
  public static List<String> getAllAPIPermissionsTypeWebORMobile (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][?(@.type=='web')]['attributes']['permissions']",  JSONArray.class)
        .forEach(
            e -> ((JSONArray) e)
                .forEach(i -> perms.add(((String) i)))
        );
    
    JsonPath
    .parse(body)
    .read("$['data'][?(@.type=='mobile')]['attributes']['permissions']",  JSONArray.class)
    .forEach(
        e -> ((JSONArray) e)
            .forEach(i -> perms.add(((String) i)))
    );
    return new ArrayList<>(perms);
  }
  public static List<String> getAllAPIType (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][*]['days']", JSONArray.class)
        .forEach(
            e -> ((JSONArray) e)
                .forEach(i -> perms.add(((String) i)))
        );
    return new ArrayList<>(perms);
  }
  public static List<String> getAllAPITypeApiOrMobile (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][?(@.type=='api')]['days']", JSONArray.class)
        .forEach(
            e -> ((JSONArray) e)
                .forEach(i -> perms.add(((String) i)))
        );
    JsonPath
    .parse(body)
    .read("$['data'][?(@.type=='mobile')]['days']", JSONArray.class)
    .forEach(
        e -> ((JSONArray) e)
            .forEach(i -> perms.add(((String) i)))
    );
    return new ArrayList<>(perms);
  }
  public static int getDataArraySize (String body) {
    return JsonPath
    .parse(body)
    .read("$['data'][*]", JSONArray.class).size();
  }
  public static List<String> getAllTypes (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][*]['type']", JSONArray.class)
        .forEach(
            e -> perms.add((String) e)
        );
    return new ArrayList<>(perms);
  }
  public static List<String> getAllTypesHavingIdUidApi (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][?(@.id=='uid-api')]['type']", JSONArray.class)
        .forEach(
            e -> perms.add((String) e)
        );
    return new ArrayList<>(perms);
  }
  /*public static List<String> getAllTypesHavingDaySunday (String body) {
    Set<String> perms = new HashSet<>();
    JsonPath
        .parse(body)
        .read("$['data'][?(@.days=='SUNDAY')]['type']", JSONArray.class)
        .forEach(
            e -> perms.add((String) e)
        );
    return new ArrayList<>(perms);
  }*/
}