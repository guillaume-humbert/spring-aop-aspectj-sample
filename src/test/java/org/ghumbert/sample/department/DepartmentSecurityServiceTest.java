package org.ghumbert.sample.department;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentSecurityServiceTest {

    private DepartmentSecurityService testObject = new DepartmentSecurityService();

    @Test
    public void isRestricted_whenTypical() {
        int nonRestrictedEmployeeId = 1;

        assertThat(testObject.isRestricted(nonRestrictedEmployeeId), is(false));
    }

    @Test
    public void isRestricted_whenRestricted() {
        assertThat(testObject.isRestricted(DepartmentSecurityService.RESTRICTED_DEPARTMENT_ID), is(true));
    }
}
