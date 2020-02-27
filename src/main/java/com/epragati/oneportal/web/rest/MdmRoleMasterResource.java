package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmRoleMaster;
import com.epragati.oneportal.repository.MdmRoleMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmRoleMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmRoleMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmRoleMasterResource.class);

    private static final String ENTITY_NAME = "mdmRoleMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmRoleMasterRepository mdmRoleMasterRepository;

    public MdmRoleMasterResource(MdmRoleMasterRepository mdmRoleMasterRepository) {
        this.mdmRoleMasterRepository = mdmRoleMasterRepository;
    }

    /**
     * {@code POST  /mdm-role-masters} : Create a new mdmRoleMaster.
     *
     * @param mdmRoleMaster the mdmRoleMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmRoleMaster, or with status {@code 400 (Bad Request)} if the mdmRoleMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-role-masters")
    public ResponseEntity<MdmRoleMaster> createMdmRoleMaster(@Valid @RequestBody MdmRoleMaster mdmRoleMaster) throws URISyntaxException {
        log.debug("REST request to save MdmRoleMaster : {}", mdmRoleMaster);
        if (mdmRoleMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmRoleMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmRoleMaster result = mdmRoleMasterRepository.save(mdmRoleMaster);
        return ResponseEntity.created(new URI("/api/mdm-role-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-role-masters} : Updates an existing mdmRoleMaster.
     *
     * @param mdmRoleMaster the mdmRoleMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmRoleMaster,
     * or with status {@code 400 (Bad Request)} if the mdmRoleMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmRoleMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-role-masters")
    public ResponseEntity<MdmRoleMaster> updateMdmRoleMaster(@Valid @RequestBody MdmRoleMaster mdmRoleMaster) throws URISyntaxException {
        log.debug("REST request to update MdmRoleMaster : {}", mdmRoleMaster);
        if (mdmRoleMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmRoleMaster result = mdmRoleMasterRepository.save(mdmRoleMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmRoleMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-role-masters} : get all the mdmRoleMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmRoleMasters in body.
     */
    @GetMapping("/mdm-role-masters")
    public List<MdmRoleMaster> getAllMdmRoleMasters() {
        log.debug("REST request to get all MdmRoleMasters");
        return mdmRoleMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-role-masters/:id} : get the "id" mdmRoleMaster.
     *
     * @param id the id of the mdmRoleMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmRoleMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-role-masters/{id}")
    public ResponseEntity<MdmRoleMaster> getMdmRoleMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmRoleMaster : {}", id);
        Optional<MdmRoleMaster> mdmRoleMaster = mdmRoleMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmRoleMaster);
    }

    /**
     * {@code DELETE  /mdm-role-masters/:id} : delete the "id" mdmRoleMaster.
     *
     * @param id the id of the mdmRoleMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-role-masters/{id}")
    public ResponseEntity<Void> deleteMdmRoleMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmRoleMaster : {}", id);
        mdmRoleMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
