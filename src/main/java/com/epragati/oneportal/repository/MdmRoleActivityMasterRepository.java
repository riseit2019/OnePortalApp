package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmRoleActivityMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmRoleActivityMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmRoleActivityMasterRepository extends JpaRepository<MdmRoleActivityMaster, Long> {

}
