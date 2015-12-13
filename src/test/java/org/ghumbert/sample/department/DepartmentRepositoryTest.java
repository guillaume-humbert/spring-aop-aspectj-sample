package org.ghumbert.sample.department;

import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DepartmentRepositoryTest {

    @Test
    public void findOne_whenTypical() {
        DepartmentAccessAspect.deactivate();
        int arbitraryDepartmentId = 123;

        DepartmentRepository testObject = new DepartmentRepository();
        Department department = testObject.findOne(arbitraryDepartmentId);

        assertThat(department, notNullValue());
    }

}
