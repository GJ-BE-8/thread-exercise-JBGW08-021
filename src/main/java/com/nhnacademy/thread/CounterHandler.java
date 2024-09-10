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
public class CounterHandler implements Runnable  {
    private final Object monitor;
    private final long countMaxSize;

    private long count;

    public CounterHandler(long countMaxSize, Object monitor) {
        //TODO#4 countMaxSize<=0 or monitor 객체가 null 이면 IllegalArgumentException이 발생 합니다.
        if(countMaxSize<=0 || monitor==null){
            throw new IllegalArgumentException();
        }

        //TODO#5  countMaxSize, count, monitor 변수를 초기화 합니다.
        this.monitor = monitor;
        this.countMaxSize = countMaxSize;
    }

    @Override
    public void run() {
        //TODO#6 Thread에 의해서 run() method가 호출되면 무한 대기 합니다. monitor객체를 이용해서 구현하세요
        //monitor는 여러 Thread가 동시에 접근할 수 없도록  접근을 제어해야 합니다.
        synchronized (monitor){ //monitor가 이 스레드와 동기화됨 + 이거 실행하는 동안 락
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            log.debug("thread:{},state:{},count:{}",Thread.currentThread().getName(),Thread.currentThread().getState(),count);

        }while (count<countMaxSize);
    }
}
