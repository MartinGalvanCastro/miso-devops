package com.example.blacklistapi.infrastructure.adapters.output.persistence.mapper;

import com.example.blacklistapi.domain.model.BlacklistEntry;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.entity.BlacklistEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting between domain model BlacklistEntry and persistence entity
 * BlacklistEntity.
 */
@Mapper(componentModel = "spring")
public interface BlacklistMapper {

  /**
   * Converts a domain model BlacklistEntry to a persistence entity BlacklistEntity.
   *
   * @param entry the BlacklistEntry domain object to convert.
   * @return the corresponding BlacklistEntity.
   */
  BlacklistEntity toEntity(BlacklistEntry entry);

  /**
   * Converts a persistence entity BlacklistEntity to a domain model BlacklistEntry.
   *
   * @param entity the BlacklistEntity to convert.
   * @return the corresponding BlacklistEntry domain object.
   */
  @InheritInverseConfiguration(name = "toEntity")
  BlacklistEntry toDomain(BlacklistEntity entity);
}
