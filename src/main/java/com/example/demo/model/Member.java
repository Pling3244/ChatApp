package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Member {

    private String id;
    private String pw;
    private String nickname;

    // firebase timestamp type
//    private Date create_dt;
//    private Date update_dt;
//    private String create_dt;
//    private String update_dt;

}
