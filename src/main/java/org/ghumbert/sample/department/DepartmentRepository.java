package org.ghumbert.sample.department;

import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    public Department findOne(int departmentId) {
        return new Department();
    }

}
