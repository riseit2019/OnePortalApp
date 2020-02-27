package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmEmployeeMaster;
import com.epragati.oneportal.repository.MdmEmployeeMasterRepository;
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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmEmployeeMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmEmployeeMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmEmployeeMasterResource.class);

    private static final String ENTITY_NAME = "mdmEmployeeMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmEmployeeMasterRepository mdmEmployeeMasterRepository;

    public MdmEmployeeMasterResource(MdmEmployeeMasterRepository mdmEmployeeMasterRepository) {
        this.mdmEmployeeMasterRepository = mdmEmployeeMasterRepository;
    }

    /**
     * {@code POST  /mdm-employee-masters} : Create a new mdmEmployeeMaster.
     *
     * @param mdmEmployeeMaster the mdmEmployeeMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmEmployeeMaster, or with status {@code 400 (Bad Request)} if the mdmEmployeeMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-employee-masters")
    public ResponseEntity<MdmEmployeeMaster> createMdmEmployeeMaster(@Valid @RequestBody MdmEmployeeMaster mdmEmployeeMaster) throws URISyntaxException {
        log.debug("REST request to save MdmEmployeeMaster : {}", mdmEmployeeMaster);
        if (mdmEmployeeMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmEmployeeMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmEmployeeMaster result = mdmEmployeeMasterRepository.save(mdmEmployeeMaster);
        return ResponseEntity.created(new URI("/api/mdm-employee-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-employee-masters} : Updates an existing mdmEmployeeMaster.
     *
     * @param mdmEmployeeMaster the mdmEmployeeMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmEmployeeMaster,
     * or with status {@code 400 (Bad Request)} if the mdmEmployeeMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmEmployeeMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-employee-masters")
    public ResponseEntity<MdmEmployeeMaster> updateMdmEmployeeMaster(@Valid @RequestBody MdmEmployeeMaster mdmEmployeeMaster) throws URISyntaxException {
        log.debug("REST request to update MdmEmployeeMaster : {}", mdmEmployeeMaster);
        if (mdmEmployeeMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmEmployeeMaster result = mdmEmployeeMasterRepository.save(mdmEmployeeMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmEmployeeMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-employee-masters} : get all the mdmEmployeeMasters.
     *
     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmEmployeeMasters in body.
     */
    @GetMapping("/mdm-employee-masters")
    public List<MdmEmployeeMaster> getAllMdmEmployeeMasters(@RequestParam(required = false) String filter) {
        if ("organizationcode-is-null".equals(filter)) {
            log.debug("REST request to get all MdmEmployeeMasters where organizationCode is null");
            return StreamSupport
                .stream(mdmEmployeeMasterRepository.findAll().spliterator(), false)
                .filter(mdmEmployeeMaster -> mdmEmployeeMaster.getOrganizationCode() == null)
                .collect(Collectors.toList());
        }
        if ("personid-is-null".equals(filter)) {
            log.debug("REST request to get all MdmEmployeeMasters where personId is null");
            return StreamSupport
                .stream(mdmEmployeeMasterRepository.findAll().spliterator(), false)
                .filter(mdmEmployeeMaster -> mdmEmployeeMaster.getPersonId() == null)
                .collect(Collectors.toList());
        }
        log.debug("REST request to get all MdmEmployeeMasters");
        return mdmEmployeeMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-employee-masters/:id} : get the "id" mdmEmployeeMaster.
     *
     * @param id the id of the mdmEmployeeMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmEmployeeMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-employee-masters/{id}")
    public ResponseEntity<MdmEmployeeMaster> getMdmEmployeeMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmEmployeeMaster : {}", id);
        Optional<MdmEmployeeMaster> mdmEmployeeMaster = mdmEmployeeMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmEmployeeMaster);
    }

    /**
     * {@code DELETE  /mdm-employee-masters/:id} : delete the "id" mdmEmployeeMaster.
     *
     * @param id the id of the mdmEmployeeMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-employee-masters/{id}")
    public ResponseEntity<Void> deleteMdmEmployeeMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmEmployeeMaster : {}", id);
        mdmEmployeeMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
