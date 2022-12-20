package proiect.isi.deliverytracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proiect.isi.deliverytracker.models.Shipment;
import proiect.isi.deliverytracker.services.ShipmentService;

@RestController
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping(path = "/shipment/{id}")
    ResponseEntity<Shipment> getShipmentById(@PathVariable("id") String id) {

        Shipment shipment = shipmentService.getShipmentById(id);

        if (shipment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shipment, HttpStatus.OK);
    }

    @PostMapping(path = "/shipment")
    ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {

        return new ResponseEntity<>(shipmentService.storeShipment(shipment), HttpStatus.CREATED);
    }

    @PutMapping(path = "/shipment")
    ResponseEntity<Shipment> updateShipment(@RequestBody Shipment shipment) {

        return new ResponseEntity<>(shipmentService.updateShipment(shipment), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/shipment/{id}")
    ResponseEntity<Void> deleteShipment(@PathVariable("id") String id) {

        shipmentService.deleteShipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
