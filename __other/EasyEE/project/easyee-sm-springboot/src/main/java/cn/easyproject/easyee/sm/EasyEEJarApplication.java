package cn.easyproject.easyee.sm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * Run with JAR
 * 
 * <pre>
 * 1. Use `pom_jar.xml` to `pom.xml`
 * 
 * 2. Uncomment the comment, Run `EasyEEJarApplication.java` 
 * </pre>
 * 
 * @author easyproject.cn
 *
 */
@SpringBootApplication(
		scanBasePackages = { "cn.easyproject.easyee.sm" }, 
		exclude = { SecurityAutoConfiguration.class })
@ImportResource({ 
	
	/* Redis */
	// Single Node
//	"classpath*:/redis/spring_shiro.xml",
	// Redis Sentinel
//	"classpath*:/redis/redis_sentinel.xml",
	/*Shiro*/
	// EhCache
	"classpath*:/shiro/shiro_ehcache.xml"
	// Redis
//	"classpath*:/shiro/shiro_redis.xml"
})
@MapperScan(basePackages={
		"cn.easyproject.easyee.**.dao"
})
@EnableTransactionManagement
@ServletComponentScan
public class EasyEEJarApplication {

	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EasyEEJarApplication.class);
		app.run();
	
	}

}
