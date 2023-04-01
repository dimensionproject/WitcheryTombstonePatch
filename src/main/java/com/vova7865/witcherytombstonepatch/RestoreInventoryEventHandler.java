package com.vova7865.witcherytombstonepatch;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import ovh.corail.tombstone.api.event.RestoreInventoryEvent;

public class RestoreInventoryEventHandler {
    private static final String WITCHERY_PRIOR_INCARNATION_TAG_NAME = "WitcheryPriIncUsr";

    @SubscribeEvent
    public void handleRestoreInventory(RestoreInventoryEvent event) {
        if (!(event.getInventory() instanceof IItemHandlerModifiable))
            throw new IllegalStateException("Tombstone inventory isn't modifiable");
        IItemHandlerModifiable inventory = (IItemHandlerModifiable) event.getInventory();
        for(int slot = 0; slot < inventory.getSlots(); slot ++) {
            ItemStack itemStack = inventory.getStackInSlot(slot).copy();
            NBTTagCompound tag = itemStack.getTagCompound();
            if (tag == null)
                continue;
            if (tag.hasKey(WITCHERY_PRIOR_INCARNATION_TAG_NAME)) {
                tag.removeTag(WITCHERY_PRIOR_INCARNATION_TAG_NAME);
                if (tag.isEmpty()) {
                    itemStack.setTagCompound(null);
                }
                inventory.setStackInSlot(slot, itemStack);
            }
        }
    }
}
