package net.bluehill.ingameeditor.data

import net.minecraft.entity.player.PlayerAbilities
import net.minecraft.text.Text

class PlayerAbilityDatas(private val abilities: PlayerAbilities) : Iterable<AbstractData> {
    override fun iterator(): Iterator<AbstractData> =
        sequence {
            yield(
                BooleanData(
                    Text.literal("Flying"),
                    Text.literal("flying"),
                    { abilities.flying },
                    { abilities.flying = it })
            )

            yield(
                FloatData(
                    Text.literal("Fly speed"),
                    Text.literal("flySpeed"),
                    { abilities.flySpeed },
                    { abilities.flySpeed = it }
                )
            )

            yield(
                BooleanData(
                    Text.literal("Creative Mode"),
                    Text.literal("instabuild"),
                    { abilities.creativeMode },
                    { abilities.creativeMode = it })
            )

            yield(
                BooleanData(
                    Text.literal("Invulnerable"),
                    Text.literal("invulnerable"),
                    { abilities.invulnerable },
                    { abilities.invulnerable = it })
            )

            yield(
                BooleanData(
                    Text.literal("Allow modify world"),
                    Text.literal("mayBuild"),
                    { abilities.allowModifyWorld },
                    { abilities.allowModifyWorld = it })
            )

            yield(
                BooleanData(
                    Text.literal("Allow flying"),
                    Text.literal("mayfly"),
                    { abilities.allowFlying },
                    { abilities.allowFlying = it })
            )

            yield(
                FloatData(
                    Text.literal("Walk speed"),
                    Text.literal("walkSpeed"),
                    { abilities.walkSpeed },
                    { abilities.walkSpeed = it }
                )
            )
        }.iterator()
}
