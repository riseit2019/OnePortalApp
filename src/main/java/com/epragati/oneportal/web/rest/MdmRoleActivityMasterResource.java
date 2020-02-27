package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmRoleActivityMaster;
import com.epragati.oneportal.repository.MdmRoleActivityMasterRepository;
import com.epragati.oneportal.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmRoleActivityMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmRoleActivityMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmRoleActivityMasterResource.class);

    private static final String ENTITY_NAME = "mdmRoleActivityMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmRoleActivityMasterRepository mdmRoleActivityMasterRepository;

    public MdmRoleActivityMasterResource(MdmRoleActivityMasterRepository mdmRoleActivityMasterRepository) {
        this.mdmRoleActivityMasterRepository = mdmRoleActivityMasterRepository;
    }

    /**
     * {@code POST  /mdm-role-activity-masters} : Create a new mdmRoleActivityMaster.
     *
     * @param mdmRoleActivityMaster the mdmRoleActivityMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmRoleActivityMaster, or with status {@code 400 (Bad Request)} if the mdmRoleActivityMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-role-activity-masters")
    public ResponseEntity<MdmRoleActivityMaster> createMdmRoleActivityMaster(@Valid @RequestBody MdmRoleActivityMaster mdmRoleActivityMaster) throws URISyntaxException {
        log.debug("REST request to save MdmRoleActivityMaster : {}", mdmRoleActivityMaster);
        if (mdmRoleActivityMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmRoleActivityMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmRoleActivityMaster result = mdmRoleActivityMasterRepository.save(mdmRoleActivityMaster);
        return ResponseEntity.created(new URI("/api/mdm-role-activity-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-role-activity-masters} : Updates an existing mdmRoleActivityMaster.
     *
     * @param mdmRoleActivityMaster the mdmRoleActivityMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmRoleActivityMaster,
     * or with status {@code 400 (Bad Request)} if the mdmRoleActivityMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmRoleActivityMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-role-activity-masters")
    public ResponseEntity<MdmRoleActivityMaster> updateMdmRoleActivityMaster(@Valid @RequestBody MdmRoleActivityMaster mdmRoleActivityMaster) throws URISyntaxException {
        log.debug("REST request to update MdmRoleActivityMaster : {}", mdmRoleActivityMaster);
        if (mdmRoleActivityMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmRoleActivityMaster result = mdmRoleActivityMasterRepository.save(mdmRoleActivityMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmRoleActivityMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-role-activity-masters} : get all the mdmRoleActivityMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmRoleActivityMasters in body.
     */
    @GetMapping("/mdm-role-activity-masters")
    public List<MdmRoleActivityMaster> getAllMdmRoleActivityMasters() {
        log.debug("REST request to get all MdmRoleActivityMasters");
        return mdmRoleActivityMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-role-activity-masters/:id} : get the "id" mdmRoleActivityMaster.
     *
     * @param id the id of the mdmRoleActivityMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmRoleActivityMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-role-activity-masters/{id}")
    public ResponseEntity<MdmRoleActivityMaster> getMdmRoleActivityMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmRoleActivityMaster : {}", id);
        Optional<MdmRoleActivityMaster> mdmRoleActivityMaster = mdmRoleActivityMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmRoleActivityMaster);
    }

    /**
     * {@code DELETE  /mdm-role-activity-masters/:id} : delete the "id" mdmRoleActivityMaster.
     *
     * @param id the id of the mdmRoleActivityMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-role-activity-masters/{id}")
    public ResponseEntity<Void> deleteMdmRoleActivityMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmRoleActivityMaster : {}", id);
        mdmRoleActivityMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
