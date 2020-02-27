package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmServiceMaster;
import com.epragati.oneportal.repository.MdmServiceMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmServiceMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmServiceMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmServiceMasterResource.class);

    private static final String ENTITY_NAME = "mdmServiceMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmServiceMasterRepository mdmServiceMasterRepository;

    public MdmServiceMasterResource(MdmServiceMasterRepository mdmServiceMasterRepository) {
        this.mdmServiceMasterRepository = mdmServiceMasterRepository;
    }

    /**
     * {@code POST  /mdm-service-masters} : Create a new mdmServiceMaster.
     *
     * @param mdmServiceMaster the mdmServiceMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmServiceMaster, or with status {@code 400 (Bad Request)} if the mdmServiceMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-service-masters")
    public ResponseEntity<MdmServiceMaster> createMdmServiceMaster(@Valid @RequestBody MdmServiceMaster mdmServiceMaster) throws URISyntaxException {
        log.debug("REST request to save MdmServiceMaster : {}", mdmServiceMaster);
        if (mdmServiceMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmServiceMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmServiceMaster result = mdmServiceMasterRepository.save(mdmServiceMaster);
        return ResponseEntity.created(new URI("/api/mdm-service-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-service-masters} : Updates an existing mdmServiceMaster.
     *
     * @param mdmServiceMaster the mdmServiceMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmServiceMaster,
     * or with status {@code 400 (Bad Request)} if the mdmServiceMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmServiceMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-service-masters")
    public ResponseEntity<MdmServiceMaster> updateMdmServiceMaster(@Valid @RequestBody MdmServiceMaster mdmServiceMaster) throws URISyntaxException {
        log.debug("REST request to update MdmServiceMaster : {}", mdmServiceMaster);
        if (mdmServiceMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmServiceMaster result = mdmServiceMasterRepository.save(mdmServiceMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmServiceMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-service-masters} : get all the mdmServiceMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmServiceMasters in body.
     */
    @GetMapping("/mdm-service-masters")
    public List<MdmServiceMaster> getAllMdmServiceMasters() {
        log.debug("REST request to get all MdmServiceMasters");
        return mdmServiceMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-service-masters/:id} : get the "id" mdmServiceMaster.
     *
     * @param id the id of the mdmServiceMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmServiceMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-service-masters/{id}")
    public ResponseEntity<MdmServiceMaster> getMdmServiceMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmServiceMaster : {}", id);
        Optional<MdmServiceMaster> mdmServiceMaster = mdmServiceMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmServiceMaster);
    }

    /**
     * {@code DELETE  /mdm-service-masters/:id} : delete the "id" mdmServiceMaster.
     *
     * @param id the id of the mdmServiceMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-service-masters/{id}")
    public ResponseEntity<Void> deleteMdmServiceMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmServiceMaster : {}", id);
        mdmServiceMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
