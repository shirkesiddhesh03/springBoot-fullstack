package com.siddhesh.fullStack.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;

import com.siddhesh.fullStack.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>
{

	Optional <Employee> findEmployeeById(long id);

}
