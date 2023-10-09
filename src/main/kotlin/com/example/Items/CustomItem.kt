

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.world.World
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.sound.SoundEvents

class CustomItem: Item {
    constructor(settings: Settings): super(settings)

    public override fun use(
	world: World,
	player: PlayerEntity,
	hand: Hand
    ): TypedActionResult<ItemStack> {
    	player.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F)
	return TypedActionResult.success(player.getStackInHand(hand))
    }
}
