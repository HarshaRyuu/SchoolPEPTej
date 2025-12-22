/*package com.nimblix.SchoolPEPProject.Repository;

public interface HomeworkRepository {
}

 */
package com.nimblix.SchoolPEPProject.Repository;

import com.nimblix.SchoolPEPProject.Model.HomeWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomeworkRepository extends JpaRepository<HomeWork, Long> {
}

