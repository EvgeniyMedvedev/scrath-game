package org.scrathgame.components.matchers;


import org.scrathgame.models.CombinationGroup;

import java.math.BigDecimal;

/**
 * @author dym
 * Date: 25.01.2024
 */
public record MatchingResult(
        String symbol,
        String combination,
        CombinationGroup group,
        BigDecimal rewardMultiplier
) {
}
