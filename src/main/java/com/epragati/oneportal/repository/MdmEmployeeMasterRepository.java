package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmEmployeeMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmEmployeeMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmEmployeeMasterRepository extends JpaRepository<MdmEmployeeMaster, Long> {

}
