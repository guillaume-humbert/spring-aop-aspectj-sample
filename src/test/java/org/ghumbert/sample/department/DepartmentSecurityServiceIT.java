package org.ghumbert.sample.department;

import org.ghumbert.sample.AccessException;
import org.ghumbert.sample.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class DepartmentSecurityServiceIT {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testNonRestrictedDepartment() {
        int nonRestrictedDepartmentId = 1;

        Department department = departmentRepository.findOne(nonRestrictedDepartmentId);

        assertThat(department, notNullValue());
    }

    @Test(expected = AccessException.class)
    public void testRestrictedDepartment() {
        departmentRepository.findOne(DepartmentSecurityService.RESTRICTED_DEPARTMENT_ID);
    }

}
