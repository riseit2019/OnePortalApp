package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmEmpRoleMaster;
import com.epragati.oneportal.repository.MdmEmpRoleMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmEmpRoleMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmEmpRoleMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmEmpRoleMasterResource.class);

    private static final String ENTITY_NAME = "mdmEmpRoleMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmEmpRoleMasterRepository mdmEmpRoleMasterRepository;

    public MdmEmpRoleMasterResource(MdmEmpRoleMasterRepository mdmEmpRoleMasterRepository) {
        this.mdmEmpRoleMasterRepository = mdmEmpRoleMasterRepository;
    }

    /**
     * {@code POST  /mdm-emp-role-masters} : Create a new mdmEmpRoleMaster.
     *
     * @param mdmEmpRoleMaster the mdmEmpRoleMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmEmpRoleMaster, or with status {@code 400 (Bad Request)} if the mdmEmpRoleMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-emp-role-masters")
    public ResponseEntity<MdmEmpRoleMaster> createMdmEmpRoleMaster(@Valid @RequestBody MdmEmpRoleMaster mdmEmpRoleMaster) throws URISyntaxException {
        log.debug("REST request to save MdmEmpRoleMaster : {}", mdmEmpRoleMaster);
        if (mdmEmpRoleMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmEmpRoleMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmEmpRoleMaster result = mdmEmpRoleMasterRepository.save(mdmEmpRoleMaster);
        return ResponseEntity.created(new URI("/api/mdm-emp-role-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-emp-role-masters} : Updates an existing mdmEmpRoleMaster.
     *
     * @param mdmEmpRoleMaster the mdmEmpRoleMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmEmpRoleMaster,
     * or with status {@code 400 (Bad Request)} if the mdmEmpRoleMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmEmpRoleMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-emp-role-masters")
    public ResponseEntity<MdmEmpRoleMaster> updateMdmEmpRoleMaster(@Valid @RequestBody MdmEmpRoleMaster mdmEmpRoleMaster) throws URISyntaxException {
        log.debug("REST request to update MdmEmpRoleMaster : {}", mdmEmpRoleMaster);
        if (mdmEmpRoleMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmEmpRoleMaster result = mdmEmpRoleMasterRepository.save(mdmEmpRoleMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmEmpRoleMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-emp-role-masters} : get all the mdmEmpRoleMasters.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmEmpRoleMasters in body.
     */
    @GetMapping("/mdm-emp-role-masters")
    public List<MdmEmpRoleMaster> getAllMdmEmpRoleMasters() {
        log.debug("REST request to get all MdmEmpRoleMasters");
        return mdmEmpRoleMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-emp-role-masters/:id} : get the "id" mdmEmpRoleMaster.
     *
     * @param id the id of the mdmEmpRoleMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmEmpRoleMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-emp-role-masters/{id}")
    public ResponseEntity<MdmEmpRoleMaster> getMdmEmpRoleMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmEmpRoleMaster : {}", id);
        Optional<MdmEmpRoleMaster> mdmEmpRoleMaster = mdmEmpRoleMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmEmpRoleMaster);
    }

    /**
     * {@code DELETE  /mdm-emp-role-masters/:id} : delete the "id" mdmEmpRoleMaster.
     *
     * @param id the id of the mdmEmpRoleMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-emp-role-masters/{id}")
    public ResponseEntity<Void> deleteMdmEmpRoleMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmEmpRoleMaster : {}", id);
        mdmEmpRoleMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
