package org.ghumbert.sample.department;

import org.springframework.stereotype.Service;

@Service
public class DepartmentSecurityService {

    public static final int RESTRICTED_DEPARTMENT_ID = 2;

    public boolean isRestricted(int employeeId) {
        return employeeId == RESTRICTED_DEPARTMENT_ID;
    }

}
