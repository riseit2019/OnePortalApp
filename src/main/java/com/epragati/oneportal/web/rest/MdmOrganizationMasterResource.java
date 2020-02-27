package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmOrganizationMaster;
import com.epragati.oneportal.repository.MdmOrganizationMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmOrganizationMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmOrganizationMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmOrganizationMasterResource.class);

    private static final String ENTITY_NAME = "mdmOrganizationMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmOrganizationMasterRepository mdmOrganizationMasterRepository;

    public MdmOrganizationMasterResource(MdmOrganizationMasterRepository mdmOrganizationMasterRepository) {
        this.mdmOrganizationMasterRepository = mdmOrganizationMasterRepository;
    }

    /**
     * {@code POST  /mdm-organization-masters} : Create a new mdmOrganizationMaster.
     *
     * @param mdmOrganizationMaster the mdmOrganizationMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmOrganizationMaster, or with status {@code 400 (Bad Request)} if the mdmOrganizationMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-organization-masters")
    public ResponseEntity<MdmOrganizationMaster> createMdmOrganizationMaster(@Valid @RequestBody MdmOrganizationMaster mdmOrganizationMaster) throws URISyntaxException {
        log.debug("REST request to save MdmOrganizationMaster : {}", mdmOrganizationMaster);
        if (mdmOrganizationMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmOrganizationMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmOrganizationMaster result = mdmOrganizationMasterRepository.save(mdmOrganizationMaster);
        return ResponseEntity.created(new URI("/api/mdm-organization-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-organization-masters} : Updates an existing mdmOrganizationMaster.
     *
     * @param mdmOrganizationMaster the mdmOrganizationMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmOrganizationMaster,
     * or with status {@code 400 (Bad Request)} if the mdmOrganizationMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmOrganizationMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-organization-masters")
    public ResponseEntity<MdmOrganizationMaster> updateMdmOrganizationMaster(@Valid @RequestBody MdmOrganizationMaster mdmOrganizationMaster) throws URISyntaxException {
        log.debug("REST request to update MdmOrganizationMaster : {}", mdmOrganizationMaster);
        if (mdmOrganizationMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmOrganizationMaster result = mdmOrganizationMasterRepository.save(mdmOrganizationMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmOrganizationMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-organization-masters} : get all the mdmOrganizationMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmOrganizationMasters in body.
     */
    @GetMapping("/mdm-organization-masters")
    public List<MdmOrganizationMaster> getAllMdmOrganizationMasters() {
        log.debug("REST request to get all MdmOrganizationMasters");
        return mdmOrganizationMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-organization-masters/:id} : get the "id" mdmOrganizationMaster.
     *
     * @param id the id of the mdmOrganizationMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmOrganizationMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-organization-masters/{id}")
    public ResponseEntity<MdmOrganizationMaster> getMdmOrganizationMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmOrganizationMaster : {}", id);
        Optional<MdmOrganizationMaster> mdmOrganizationMaster = mdmOrganizationMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmOrganizationMaster);
    }

    /**
     * {@code DELETE  /mdm-organization-masters/:id} : delete the "id" mdmOrganizationMaster.
     *
     * @param id the id of the mdmOrganizationMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-organization-masters/{id}")
    public ResponseEntity<Void> deleteMdmOrganizationMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmOrganizationMaster : {}", id);
        mdmOrganizationMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
