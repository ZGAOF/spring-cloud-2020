package cn.zzf.spring.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GaoFeng
 * @date 2020/11/4 21:15
 */
@Configuration
public class RouteLocatorConfig {

    public static final String NEWS_BAIDU = "https://news.baidu.com";

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("baidu_guonei", r -> r.path("/guonei").uri(NEWS_BAIDU + "/guonei"))
                .build();
    }

    @Bean
    public RouteLocator routes2(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("baidu_guoji", r -> r.path("/guoji").uri(NEWS_BAIDU + "/guonei"))
                .build();
    }
}
