package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmCitizenData;
import com.epragati.oneportal.repository.MdmCitizenDataRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmCitizenData}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmCitizenDataResource {

    private final Logger log = LoggerFactory.getLogger(MdmCitizenDataResource.class);

    private static final String ENTITY_NAME = "mdmCitizenData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmCitizenDataRepository mdmCitizenDataRepository;

    public MdmCitizenDataResource(MdmCitizenDataRepository mdmCitizenDataRepository) {
        this.mdmCitizenDataRepository = mdmCitizenDataRepository;
    }

    /**
     * {@code POST  /mdm-citizen-data} : Create a new mdmCitizenData.
     *
     * @param mdmCitizenData the mdmCitizenData to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmCitizenData, or with status {@code 400 (Bad Request)} if the mdmCitizenData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-citizen-data")
    public ResponseEntity<MdmCitizenData> createMdmCitizenData(@Valid @RequestBody MdmCitizenData mdmCitizenData) throws URISyntaxException {
        log.debug("REST request to save MdmCitizenData : {}", mdmCitizenData);
        if (mdmCitizenData.getId() != null) {
            throw new BadRequestAlertException("A new mdmCitizenData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmCitizenData result = mdmCitizenDataRepository.save(mdmCitizenData);
        return ResponseEntity.created(new URI("/api/mdm-citizen-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-citizen-data} : Updates an existing mdmCitizenData.
     *
     * @param mdmCitizenData the mdmCitizenData to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmCitizenData,
     * or with status {@code 400 (Bad Request)} if the mdmCitizenData is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmCitizenData couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-citizen-data")
    public ResponseEntity<MdmCitizenData> updateMdmCitizenData(@Valid @RequestBody MdmCitizenData mdmCitizenData) throws URISyntaxException {
        log.debug("REST request to update MdmCitizenData : {}", mdmCitizenData);
        if (mdmCitizenData.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmCitizenData result = mdmCitizenDataRepository.save(mdmCitizenData);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmCitizenData.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-citizen-data} : get all the mdmCitizenData.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmCitizenData in body.
     */
    @GetMapping("/mdm-citizen-data")
    public List<MdmCitizenData> getAllMdmCitizenData() {
        log.debug("REST request to get all MdmCitizenData");
        return mdmCitizenDataRepository.findAll();
    }

    /**
     * {@code GET  /mdm-citizen-data/:id} : get the "id" mdmCitizenData.
     *
     * @param id the id of the mdmCitizenData to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmCitizenData, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-citizen-data/{id}")
    public ResponseEntity<MdmCitizenData> getMdmCitizenData(@PathVariable Long id) {
        log.debug("REST request to get MdmCitizenData : {}", id);
        Optional<MdmCitizenData> mdmCitizenData = mdmCitizenDataRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmCitizenData);
    }

    /**
     * {@code DELETE  /mdm-citizen-data/:id} : delete the "id" mdmCitizenData.
     *
     * @param id the id of the mdmCitizenData to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-citizen-data/{id}")
    public ResponseEntity<Void> deleteMdmCitizenData(@PathVariable Long id) {
        log.debug("REST request to delete MdmCitizenData : {}", id);
        mdmCitizenDataRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
