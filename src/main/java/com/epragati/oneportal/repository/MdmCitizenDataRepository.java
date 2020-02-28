package com.epragati.oneportal.repository;

import com.epragati.oneportal.domain.MdmCitizenData;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the MdmCitizenData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MdmCitizenDataRepository extends JpaRepository<MdmCitizenData, Long> {

}
