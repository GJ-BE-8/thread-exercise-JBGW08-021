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

package com.nhnacademy;

import com.nhnacademy.count.SharedCounter;
import com.nhnacademy.thread.CounterIncreaseHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App 
{

    public static void main( String[] args )
    {

        //TODO#1 shardCounter 객체를 0으로 초기화 합니다.
        SharedCounter sharedCounter = new SharedCounter(0);

        //TODO#2 counterIncreaseHandler 객체를 생성 합니다.
        CounterIncreaseHandler counterIncreaseHandler = new CounterIncreaseHandler(sharedCounter);

        //TODO#3 counterIncreaseHandler를 이용해서 threadA를 생성 합니다.
        Thread threadA = new Thread(counterIncreaseHandler);    //Thread에 syn 효과 삽입.

        //TODO#4 threadA의 thread name을 "thread-A"로 설정 합니다.

        //TODO#5 threadA를 시작 합니다.


        //TODO#6 counterIncreaseHandler를 이용해서 threadB를 생성 합니다.
        Thread threadB = null;

        //TODO#7 threadB의 name을 'thread-B' 로 설정 합니다.

        //TODO#8 threadB를 시작 합니다.

        //TODO#9 main thread가 실행 후 20초 후 threadA, threadB 종료될 수 있도록 interrupt 발생 시킵니다.


        //TODO#10 main Thread는 threadA와 threadB의 상태가 terminated가 될 때 까지 대기 합니다. 즉 threadA, threadB가 종료될 때 까지 대기(양보) 합니다.


        log.debug("System exit!");
    }
}
