package com.fireincident.fire_incident_backend.repository;

import com.fireincident.fire_incident_backend.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}