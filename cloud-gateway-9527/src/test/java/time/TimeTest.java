package time;

import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;

/**
 * @author GaoFeng
 * @date 2020/11/4 22:51
 */
@Slf4j
public class TimeTest {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        log.info(now.toString());
    }
}
