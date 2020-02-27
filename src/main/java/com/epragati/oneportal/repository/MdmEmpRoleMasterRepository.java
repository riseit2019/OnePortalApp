package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmEmpRoleMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmEmpRoleMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmEmpRoleMasterRepository extends JpaRepository<MdmEmpRoleMaster, Long> {

}
