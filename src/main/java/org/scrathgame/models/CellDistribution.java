package org.scrathgame.models;

import java.util.Map;

/**
 * @author dym
 * Date: 25.01.2024
 */
public record CellDistribution(
        int column,
        int row,
        Map<String, Integer> symbols
) {
}
