package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmServiceMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmServiceMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmServiceMasterRepository extends JpaRepository<MdmServiceMaster, Long> {

}
