package com.sarad.shinyapp.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class AdResource {

    @Autowired
    private AdService adService;

    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody AdDTO adDTO) {

        Object error = adService.validate(adDTO);
        if (null != error) {
            return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(adService.create(adDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{partnerId}")
    public ResponseEntity<Object> findActiveByPartnerId(@PathVariable String partnerId) {
        AdDTO adDTO = adService.findActiveByPartnerId(partnerId);
        if (null == adDTO) {
            return new ResponseEntity<Object>("Unable to find ad for " + partnerId, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(adDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<Object>(adService.findAll(), HttpStatus.OK);
    }

}
