package org.scrathgame.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author dym
 * Date: 24.01.2024
 */
public record Symbol(
        @JsonProperty("reward_multiplier")
        BigDecimal rewardMultiplier,
        BigDecimal extra,
        SymbolType type,
        ImpactType impact
) {
//        public Symbol(BigDecimal extra,
//                      SymbolType type,
//                      ImpactType impact) {
//                this(BigDecimal.ONE, extra,
//                        type, impact);
//        }
}
