package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmRoleMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmRoleMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmRoleMasterRepository extends JpaRepository<MdmRoleMaster, Long> {

}
