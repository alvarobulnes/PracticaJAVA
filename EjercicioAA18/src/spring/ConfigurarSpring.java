package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("spring") //le indica al programa el paquete de la configuración
@EnableAspectJAutoProxy //lo declaro como proxy

public class ConfigurarSpring {

}