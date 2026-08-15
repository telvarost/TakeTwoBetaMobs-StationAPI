package com.github.telvarost.taketwobetamobs.enums;

public enum SpawnRegionEnum {
    NONE("None"),
    CHUNK_SPECIFIC("Chunk Specific"),
    BIOME_SPECIFIC("Biome Specific"),
    DIMENSION_SPECIFIC("Dimension Specific"),
    ALL_REGIONS("All Regions");

    final String stringValue;

    SpawnRegionEnum() {
        this.stringValue = "Chunk Specific";
    }

    SpawnRegionEnum(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}