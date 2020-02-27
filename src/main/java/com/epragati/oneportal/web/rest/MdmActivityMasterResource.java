package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmActivityMaster;
import com.epragati.oneportal.repository.MdmActivityMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmActivityMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmActivityMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmActivityMasterResource.class);

    private static final String ENTITY_NAME = "mdmActivityMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmActivityMasterRepository mdmActivityMasterRepository;

    public MdmActivityMasterResource(MdmActivityMasterRepository mdmActivityMasterRepository) {
        this.mdmActivityMasterRepository = mdmActivityMasterRepository;
    }

    /**
     * {@code POST  /mdm-activity-masters} : Create a new mdmActivityMaster.
     *
     * @param mdmActivityMaster the mdmActivityMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmActivityMaster, or with status {@code 400 (Bad Request)} if the mdmActivityMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-activity-masters")
    public ResponseEntity<MdmActivityMaster> createMdmActivityMaster(@Valid @RequestBody MdmActivityMaster mdmActivityMaster) throws URISyntaxException {
        log.debug("REST request to save MdmActivityMaster : {}", mdmActivityMaster);
        if (mdmActivityMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmActivityMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmActivityMaster result = mdmActivityMasterRepository.save(mdmActivityMaster);
        return ResponseEntity.created(new URI("/api/mdm-activity-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-activity-masters} : Updates an existing mdmActivityMaster.
     *
     * @param mdmActivityMaster the mdmActivityMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmActivityMaster,
     * or with status {@code 400 (Bad Request)} if the mdmActivityMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmActivityMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-activity-masters")
    public ResponseEntity<MdmActivityMaster> updateMdmActivityMaster(@Valid @RequestBody MdmActivityMaster mdmActivityMaster) throws URISyntaxException {
        log.debug("REST request to update MdmActivityMaster : {}", mdmActivityMaster);
        if (mdmActivityMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmActivityMaster result = mdmActivityMasterRepository.save(mdmActivityMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmActivityMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-activity-masters} : get all the mdmActivityMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmActivityMasters in body.
     */
    @GetMapping("/mdm-activity-masters")
    public List<MdmActivityMaster> getAllMdmActivityMasters() {
        log.debug("REST request to get all MdmActivityMasters");
        return mdmActivityMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-activity-masters/:id} : get the "id" mdmActivityMaster.
     *
     * @param id the id of the mdmActivityMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmActivityMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-activity-masters/{id}")
    public ResponseEntity<MdmActivityMaster> getMdmActivityMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmActivityMaster : {}", id);
        Optional<MdmActivityMaster> mdmActivityMaster = mdmActivityMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmActivityMaster);
    }

    /**
     * {@code DELETE  /mdm-activity-masters/:id} : delete the "id" mdmActivityMaster.
     *
     * @param id the id of the mdmActivityMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-activity-masters/{id}")
    public ResponseEntity<Void> deleteMdmActivityMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmActivityMaster : {}", id);
        mdmActivityMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
