package cn.zzf.spring.cloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author GaoFeng
 * @date 2020/11/4 11:59
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001Application {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashboard9001Application.class, args);
    }

   /* @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/
}
