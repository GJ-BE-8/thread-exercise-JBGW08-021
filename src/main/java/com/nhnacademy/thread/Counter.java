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

@Slf4j
public class Counter {
    private final long countMaxSize;
    private long count;

    public Counter(long countMaxSize) {
            if (countMaxSize < 0) {
                // TODO#1: countMaxSize < 0 일 때 IllegalArgumentException 발생
                throw new IllegalArgumentException("countMaxSize must be >= 0");
            }
            this.countMaxSize = countMaxSize;
            //TODO#2 this.countMaxSize 초기화 합니다.
            this.count = 0;
            //TODO#3 this.count 값을 0으로 초기화 합니다.
    }

    public void run() {

        do {
            try {
                Thread.sleep(java.time.Duration.ofSeconds(1)); // 1초 대기
            } catch (InterruptedException e) {
                log.error("Thread interrupted", e); // 예외를 로깅
                Thread.currentThread().interrupt(); // 스레드 중단 상태를 복구
                return; // 스레드를 종료
            }
            /*TODO#4 1초 간격 으로 count++ 됩니다.
              Thread.sleep method를 사용하세요.
              https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Thread.html#sleep(java.time.Duration)
            */
            count++;

            log.info("name:{}, count:{}", Thread.currentThread().getName(), count);

            /*TODO#5 count 출력
                name:{Thread name}, count:{count 변수}
                Thread name : Thread.currentThread().getName();
                ex) name:my-thread, count:1
             */

        }while (count<countMaxSize);
    }
}
