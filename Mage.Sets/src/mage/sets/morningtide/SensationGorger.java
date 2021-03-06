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
package mage.sets.morningtide;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.abilityword.KinshipAbility;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.DrawCardAllEffect;
import mage.abilities.effects.common.discard.DiscardHandAllEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Rarity;

/**
 *
 * @author LevelX2
 */
public class SensationGorger extends CardImpl {

    public SensationGorger(UUID ownerId) {
        super(ownerId, 102, "Sensation Gorger", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{1}{R}{R}");
        this.expansionSetCode = "MOR";
        this.subtype.add("Goblin");
        this.subtype.add("Shaman");

        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Kinship - At the beginning of your upkeep, you may look at the top card of your library. If it shares a creature type with Sensation Gorger, you may reveal it. 
        // If you do, each player discards his or her hand, then draws four cards.
        KinshipAbility ability = new KinshipAbility(new DiscardHandAllEffect());
        Effect effect = new DrawCardAllEffect(4);
        effect.setText(", then draws four cards");
        ability.addKinshipEffect(effect);
        this.addAbility(ability);
    }

    public SensationGorger(final SensationGorger card) {
        super(card);
    }

    @Override
    public SensationGorger copy() {
        return new SensationGorger(this);
    }
}
