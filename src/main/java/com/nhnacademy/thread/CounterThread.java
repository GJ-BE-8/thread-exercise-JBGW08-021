/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
//TODO#1 CounterThread는 Thread를 상속 합니다.
public class CounterThread extends Thread{
    private final long countMaxSize;
    private long count;

    public CounterThread(String name, long countMaxSize) {
        //TODO#2 name <-- null 이거나 공백 문자열이면 IllegalArgumentException이 발생 합니다.
        if(Objects.isNull(name) || name.isBlank()){
            throw new IllegalArgumentException("문자열이 null이나 공백 오류");
        }

        //TODO#3 countMaxSize <=0 이면 IllegalArgumentException이 발생 합니다.
        if(countMaxSize <= 0){
            throw new IllegalArgumentException("countMaxSize 0이하 오류");
        }


        this.setName(name);
        this.countMaxSize = countMaxSize;
        this.count = 0;
    }

    @Override
    public void run() {

        /*TODO#4 run method를 구현 합니다.
            1초에 한 번식 다음과 같이 출력 됩니다.
            - Thread.sleep(1000)을 사용하세요.
            ex) thread:my-thread, count:1
            - count : 1~10 까지 출력 됩니다.
            - thread name : this.getName()<- 호출, CounterThread 가 Thread를 extends 하고 있음.
         */

        do {
            try {
                Thread.sleep(1000);
                count++;
                log.info("thread:{}, count:{}", this.getName(), count);
            } catch (InterruptedException e) {
                log.info("실행 정지");
                throw new RuntimeException(e);
            }

        }while (count<countMaxSize);
    }
}
