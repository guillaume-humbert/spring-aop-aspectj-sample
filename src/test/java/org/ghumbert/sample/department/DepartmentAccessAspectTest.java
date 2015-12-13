package org.ghumbert.sample.department;

import org.ghumbert.sample.AccessException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentAccessAspectTest {

    @InjectMocks
    private DepartmentAccessAspect testObject = new DepartmentAccessAspect();

    @Mock
    private DepartmentSecurityService departmentSecurityService;
    private final int nonRestrictedEmployeeId = 1;
    private final int restrictedEmployeeId = 2;

    @Before
    public void setUp() {
        DepartmentAccessAspect.activate();
        when(departmentSecurityService.isRestricted(nonRestrictedEmployeeId)).thenReturn(false);
        when(departmentSecurityService.isRestricted(restrictedEmployeeId)).thenReturn(true);
    }

    @Test
    public void secureEmployees_whenTypical() {
        testObject.secureEmployees(nonRestrictedEmployeeId);
    }

    @Test(expected = AccessException.class)
    public void secureEmployees_whenRestricted() {
        testObject.secureEmployees(restrictedEmployeeId);
    }

}
