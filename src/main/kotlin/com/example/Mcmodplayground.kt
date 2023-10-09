package com.example

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup

import net.minecraft.registry.Registry
import net.minecraft.registry.Registries

import net.minecraft.util.Identifier
import net.minecraft.text.Text
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

import org.slf4j.LoggerFactory

import CustomItem

class Mcmodplayground: ModInitializer {
    private val logger = LoggerFactory.getLogger("mcmod-playground")

    public companion object Static {
	val _CustomItem: CustomItem = CustomItem(FabricItemSettings().maxCount(69))
	val _ItemGroup = FabricItemGroup.builder()
	    .icon({ (() -> ItemStack(_CustomItem)) })
	    .displayName( Text.translatable("itemGroup.tutorial.test_group") )
	    .entries({ context, entries -> entries.add(_CustomItem) })
	    .build()
    }


    override fun onInitialize() {
	Registry.register(Registries.ITEM_GROUP, Identifier("tutorial", "test_group"), _ItemGroup)

	val itemId = Identifier("tutorial", "custom_item")
	Registry.register(Registries.ITEM, itemId, _CustomItem)

	FuelRegistry.INSTANCE.add(_CustomItem, 300)
	CompostingChanceRegistry.INSTANCE.add(_CustomItem, 0.75F)

	/*
	ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(
	    {content -> content.add(m_CustomItem)}
	)
	*/


    }
}
