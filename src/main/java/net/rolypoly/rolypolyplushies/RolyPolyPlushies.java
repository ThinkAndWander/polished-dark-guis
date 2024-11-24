package net.rolypoly.rolypolyplushies;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RolyPolyPlushies implements ModInitializer {
	public static final String MOD_ID = "rolypolyplushies";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// region Block definitions
    public static final Block PLUSH_FOX = registerBlock("plush_fox",
		    new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).noCollision()));
	// endregion

	// region Methods
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(RolyPolyPlushies.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(Registries.ITEM, new Identifier(RolyPolyPlushies.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings()));
	}
	// endregion

	@Override
	public void onInitialize() {}
}