package com.pl.jwiki.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

//扫描多个包
//@ComponentScan({"com.pl","com.ppl"})  识别带有 @Component、@Service、@Repository、@Controller
@ComponentScan("com.pl")
@SpringBootApplication //SpringBootApplication包含ComponentScan    ComponentScan只能扫描当前的子包
@MapperScan("com.pl.jwiki.mapper")  //识别mapper接口
public class JwikiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(JwikiApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JwikiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }


}
