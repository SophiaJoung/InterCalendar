package com.ssu.intercalendar.common;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BaseResponse {
    public Boolean status;
}


/*
{
    status : true
}
// Class 리턴해줘야 하지
// 리턴 타입은 BaseResponse고
// BaseResponse 객체에, status를 true로 해서 리턴해주면 됨.

 */