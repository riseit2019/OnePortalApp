package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmActivityMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmActivityMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmActivityMasterRepository extends JpaRepository<MdmActivityMaster, Long> {

}