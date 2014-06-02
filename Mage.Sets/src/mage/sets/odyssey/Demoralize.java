/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.sets.odyssey;

import java.util.UUID;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.abilities.condition.common.CardsInControllerGraveCondition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.common.AddContinuousEffectToGame;
import mage.abilities.effects.common.combat.CantBlockAllEffect;
import mage.abilities.effects.common.combat.CantBeBlockedByOneAllEffect;
import mage.cards.CardImpl;
import mage.constants.Duration;
import mage.filter.common.FilterCreaturePermanent;


/**
 *
 * @author LevelX2
 */
public class Demoralize extends CardImpl {

    public Demoralize(UUID ownerId) {
        super(ownerId, 184, "Demoralize", Rarity.COMMON, new CardType[]{CardType.INSTANT}, "{2}{R}");
        this.expansionSetCode = "ODY";

        this.color.setRed(true);

        // Each creature can't be blocked this turn except by two or more creatures.
        this.getSpellAbility().addEffect(new CantBeBlockedByOneAllEffect(2, new FilterCreaturePermanent(), Duration.EndOfTurn));

        // Threshold — If seven or more cards are in your graveyard, creatures can't block this turn.
        this.getSpellAbility().addEffect(
                new ConditionalOneShotEffect(
                    new AddContinuousEffectToGame(new CantBlockAllEffect(new FilterCreaturePermanent(), Duration.EndOfTurn)),
                    new CardsInControllerGraveCondition(7),
                    "<br/><br/><i>Threshold</i> - If seven or more cards are in your graveyard, creatures can't block this turn"
                ));
    }


    public Demoralize(final Demoralize card) {
        super(card);
    }

    @Override
    public Demoralize copy() {
        return new Demoralize(this);
    }
}