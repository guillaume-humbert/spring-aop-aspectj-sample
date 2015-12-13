package org.ghumbert.sample.department;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.ghumbert.sample.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentAccessAspect {

    private static boolean activated = true;

    @Autowired
    private DepartmentSecurityService departmentSecurityService;

    @Pointcut(value = "execution(* org.ghumbert.sample.department.DepartmentRepository.findOne(*)) && args(departmentId)")
    private void employeeRepository(int departmentId) {

    }

    @Before(value = "employeeRepository(departmentId)", argNames = "departmentId")
    public void secureEmployees(int departmentId) {
        if (activated && departmentSecurityService.isRestricted(departmentId)) {
            throw new AccessException();
        }
    }

    public static void deactivate() {
        activated = false;
    }

    public static void activate() {
        activated = true;
    }

}
