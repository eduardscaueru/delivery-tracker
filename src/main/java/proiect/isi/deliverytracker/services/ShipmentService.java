package proiect.isi.deliverytracker.services;

import proiect.isi.deliverytracker.models.Shipment;

public interface ShipmentService {

    Shipment getShipmentById(String id);

    Shipment storeShipment(Shipment shipment);

    Shipment updateShipment(Shipment shipment);

    void deleteShipment(String id);
}
