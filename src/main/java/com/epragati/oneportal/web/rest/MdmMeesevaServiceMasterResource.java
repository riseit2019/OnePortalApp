package com.epragati.oneportal.web.rest;

import com.epragati.oneportal.domain.MdmMeesevaServiceMaster;
import com.epragati.oneportal.repository.MdmMeesevaServiceMasterRepository;
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
 * REST controller for managing {@link com.epragati.oneportal.domain.MdmMeesevaServiceMaster}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class MdmMeesevaServiceMasterResource {

    private final Logger log = LoggerFactory.getLogger(MdmMeesevaServiceMasterResource.class);

    private static final String ENTITY_NAME = "mdmMeesevaServiceMaster";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MdmMeesevaServiceMasterRepository mdmMeesevaServiceMasterRepository;

    public MdmMeesevaServiceMasterResource(MdmMeesevaServiceMasterRepository mdmMeesevaServiceMasterRepository) {
        this.mdmMeesevaServiceMasterRepository = mdmMeesevaServiceMasterRepository;
    }

    /**
     * {@code POST  /mdm-meeseva-service-masters} : Create a new mdmMeesevaServiceMaster.
     *
     * @param mdmMeesevaServiceMaster the mdmMeesevaServiceMaster to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mdmMeesevaServiceMaster, or with status {@code 400 (Bad Request)} if the mdmMeesevaServiceMaster has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mdm-meeseva-service-masters")
    public ResponseEntity<MdmMeesevaServiceMaster> createMdmMeesevaServiceMaster(@Valid @RequestBody MdmMeesevaServiceMaster mdmMeesevaServiceMaster) throws URISyntaxException {
        log.debug("REST request to save MdmMeesevaServiceMaster : {}", mdmMeesevaServiceMaster);
        if (mdmMeesevaServiceMaster.getId() != null) {
            throw new BadRequestAlertException("A new mdmMeesevaServiceMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MdmMeesevaServiceMaster result = mdmMeesevaServiceMasterRepository.save(mdmMeesevaServiceMaster);
        return ResponseEntity.created(new URI("/api/mdm-meeseva-service-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mdm-meeseva-service-masters} : Updates an existing mdmMeesevaServiceMaster.
     *
     * @param mdmMeesevaServiceMaster the mdmMeesevaServiceMaster to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mdmMeesevaServiceMaster,
     * or with status {@code 400 (Bad Request)} if the mdmMeesevaServiceMaster is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mdmMeesevaServiceMaster couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mdm-meeseva-service-masters")
    public ResponseEntity<MdmMeesevaServiceMaster> updateMdmMeesevaServiceMaster(@Valid @RequestBody MdmMeesevaServiceMaster mdmMeesevaServiceMaster) throws URISyntaxException {
        log.debug("REST request to update MdmMeesevaServiceMaster : {}", mdmMeesevaServiceMaster);
        if (mdmMeesevaServiceMaster.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MdmMeesevaServiceMaster result = mdmMeesevaServiceMasterRepository.save(mdmMeesevaServiceMaster);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, mdmMeesevaServiceMaster.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mdm-meeseva-service-masters} : get all the mdmMeesevaServiceMasters.
     *
     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mdmMeesevaServiceMasters in body.
     */
    @GetMapping("/mdm-meeseva-service-masters")
    public List<MdmMeesevaServiceMaster> getAllMdmMeesevaServiceMasters(@RequestParam(required = false) String filter) {
        if ("meesevaserviceid-is-null".equals(filter)) {
            log.debug("REST request to get all MdmMeesevaServiceMasters where meesevaServiceId is null");
            return StreamSupport
                .stream(mdmMeesevaServiceMasterRepository.findAll().spliterator(), false)
                .filter(mdmMeesevaServiceMaster -> mdmMeesevaServiceMaster.getMeesevaServiceId() == null)
                .collect(Collectors.toList());
        }
        log.debug("REST request to get all MdmMeesevaServiceMasters");
        return mdmMeesevaServiceMasterRepository.findAll();
    }

    /**
     * {@code GET  /mdm-meeseva-service-masters/:id} : get the "id" mdmMeesevaServiceMaster.
     *
     * @param id the id of the mdmMeesevaServiceMaster to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mdmMeesevaServiceMaster, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mdm-meeseva-service-masters/{id}")
    public ResponseEntity<MdmMeesevaServiceMaster> getMdmMeesevaServiceMaster(@PathVariable Long id) {
        log.debug("REST request to get MdmMeesevaServiceMaster : {}", id);
        Optional<MdmMeesevaServiceMaster> mdmMeesevaServiceMaster = mdmMeesevaServiceMasterRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(mdmMeesevaServiceMaster);
    }

    /**
     * {@code DELETE  /mdm-meeseva-service-masters/:id} : delete the "id" mdmMeesevaServiceMaster.
     *
     * @param id the id of the mdmMeesevaServiceMaster to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mdm-meeseva-service-masters/{id}")
    public ResponseEntity<Void> deleteMdmMeesevaServiceMaster(@PathVariable Long id) {
        log.debug("REST request to delete MdmMeesevaServiceMaster : {}", id);
        mdmMeesevaServiceMasterRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
