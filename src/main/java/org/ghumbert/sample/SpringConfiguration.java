package org.ghumbert.sample;

import org.aspectj.lang.Aspects;
import org.ghumbert.sample.department.DepartmentAccessAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfiguration {

    @Bean
    public DepartmentAccessAspect departmentAccessAspect() {
        return Aspects.aspectOf(DepartmentAccessAspect.class);
    }

}
