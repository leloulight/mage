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
package mage.sets.innistrad;

import java.util.UUID;
import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.TargetController;
import mage.MageInt;
import mage.abilities.TriggeredAbility;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.condition.common.NoSpellsWereCastLastTurnCondition;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.TransformSourceEffect;
import mage.abilities.keyword.FirstStrikeAbility;
import mage.abilities.keyword.TransformAbility;
import mage.cards.CardImpl;

/**
 *
 * @author North
 */
public class KruinOutlaw extends CardImpl {

    public KruinOutlaw(UUID ownerId) {
        super(ownerId, 152, "Kruin Outlaw", Rarity.RARE, new CardType[]{CardType.CREATURE}, "{1}{R}{R}");
        this.expansionSetCode = "ISD";
        this.subtype.add("Human");
        this.subtype.add("Rogue");
        this.subtype.add("Werewolf");

        this.canTransform = true;
        this.secondSideCard = new TerrorOfKruinPass(ownerId);

        this.color.setRed(true);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        this.addAbility(FirstStrikeAbility.getInstance());
        // At the beginning of each upkeep, if no spells were cast last turn, transform Kruin Outlaw.
        this.addAbility(new TransformAbility());
        TriggeredAbility ability = new BeginningOfUpkeepTriggeredAbility(new TransformSourceEffect(true), TargetController.ANY, false);
        this.addAbility(new ConditionalTriggeredAbility(ability, NoSpellsWereCastLastTurnCondition.getInstance(), TransformAbility.NO_SPELLS_TRANSFORM_RULE));
    }

    public KruinOutlaw(final KruinOutlaw card) {
        super(card);
    }

    @Override
    public KruinOutlaw copy() {
        return new KruinOutlaw(this);
    }
}
