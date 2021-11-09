package com.lhosdp.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicTempleRequest {
//
//      "touser":"ooop86Sj2vg7PKZA1idapWwL1ICs",
//              "template_id":"gQvXq6BE59NVwTRU-HmaC_lYo-zMKycBA0tU3poo8hs",
//              "url":"https://small.lbapp.cn/#/auth/forward",
//              "data":{
//
    private String touser;
    private String template_id;
    private String url;
    private java.util.Map<String, PublicData> data;


}
