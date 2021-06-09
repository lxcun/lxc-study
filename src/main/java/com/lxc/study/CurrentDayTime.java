package com.lxc.study;

import com.lxc.study.constant.StudyConstant;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.time.Instant;

/**
 * @Author: coraliao
 * @Date: 2021/6/9 10:06 上午
 */
@Slf4j
public class CurrentDayTime {
    public static void main(String[] args) {
        // 方式一
        DateTime dateTime = new DateTime();
        long now = dateTime.getMillis() / StudyConstant.MILLIS_IN_SECOND;
        long curDateTime = dateTime.withTimeAtStartOfDay().getMillis() / StudyConstant.MILLIS_IN_SECOND;
        long nextDateTime = curDateTime + StudyConstant.DAY_SECOND;
        log.info("now: {}, curDateTime: {}, nextDateTime: {}", now, curDateTime, nextDateTime);

        // 方式二
        // 结束时间在当天的，轮询当日结束
        now = Instant.now().getEpochSecond();
        long curDayTime = now - (now % StudyConstant.DAY_SECOND) - StudyConstant.HOUR8_SECOND;
        long nextDayTime = curDayTime + StudyConstant.DAY_SECOND - StudyConstant.HOUR8_SECOND;
        log.info("now:{}, now1:{}, curDayTime:{} ,nextDayTime:{}", now, System.currentTimeMillis() / 1000, curDayTime, nextDayTime);
    }
}
