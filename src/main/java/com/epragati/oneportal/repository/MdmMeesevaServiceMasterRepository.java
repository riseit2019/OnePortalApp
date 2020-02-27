package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmMeesevaServiceMaster;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmMeesevaServiceMaster entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmMeesevaServiceMasterRepository extends JpaRepository<MdmMeesevaServiceMaster, Long> {

}
