package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmOrganizationMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmOrganizationMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmOrganizationMasterRepository extends JpaRepository<MdmOrganizationMaster, Long> {

}
