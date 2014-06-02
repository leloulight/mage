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
package mage.sets.homelands;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.effects.OneShotEffect;
import mage.cards.CardImpl;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Rarity;
import mage.game.Game;
import mage.players.Player;
import mage.target.TargetPlayer;

/**
 *
 * @author Quercitron
 */
public class Forget extends CardImpl {

    public Forget(UUID ownerId) {
        super(ownerId, 32, "Forget", Rarity.RARE, new CardType[]{CardType.SORCERY}, "{U}{U}");
        this.expansionSetCode = "HML";

        this.color.setBlue(true);

        // Target player discards two cards, then draws as many cards as he or she discarded this way.
        this.getSpellAbility().addEffect(new ForgetEffect());
        this.getSpellAbility().addTarget(new TargetPlayer(true));
    }

    public Forget(final Forget card) {
        super(card);
    }

    @Override
    public Forget copy() {
        return new Forget(this);
    }
}

class ForgetEffect extends OneShotEffect {

    public ForgetEffect() {
        super(Outcome.DrawCard);
        this.staticText = "Target player discards two cards, then draws as many cards as he or she discarded this way";
    }
    
    public ForgetEffect(final ForgetEffect effect) {
        super(effect);
    }
    
    @Override
    public ForgetEffect copy() {
        return new ForgetEffect(this);
    }
    
    @Override
    public boolean apply(Game game, Ability source) {
        Player targetPlayer = game.getPlayer(source.getFirstTarget());
        if (targetPlayer != null) {
            int count = Math.min(2, targetPlayer.getHand().size());
            targetPlayer.discard(2, source, game);
            targetPlayer.drawCards(count, game);
            return true;
        }
        return false;
    }
    
}
