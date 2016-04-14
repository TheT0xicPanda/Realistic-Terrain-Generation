package rtg.world.biome.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.biome.BiomeConfig;
import rtg.api.biome.vanilla.config.BiomeConfigVanillaForest;
import rtg.world.biome.deco.DecoFallenTree;
import rtg.world.biome.deco.DecoFallenTree.LogCondition;
import rtg.world.biome.deco.DecoFlowersRTG;
import rtg.world.biome.deco.DecoGrass;
import rtg.world.biome.deco.DecoShrubCustom;
import rtg.world.biome.deco.DecoTree;
import rtg.world.biome.deco.DecoTree.TreeCondition;
import rtg.world.biome.deco.DecoTree.TreeType;
import rtg.world.biome.deco.helper.DecoHelper5050;
import rtg.world.gen.surface.vanilla.SurfaceVanillaForest;
import rtg.world.gen.terrain.vanilla.TerrainVanillaForest;

public class RealisticBiomeVanillaForest extends RealisticBiomeVanillaBase
{
    
    public static Block topBlock = BiomeGenBase.forest.topBlock;
    public static Block fillerBlock = BiomeGenBase.forest.fillerBlock;
    
    public RealisticBiomeVanillaForest(BiomeConfig config)
    {
    
        super(config, 
            BiomeGenBase.forest,
            BiomeGenBase.river,
            new TerrainVanillaForest(),
            new SurfaceVanillaForest(config, Blocks.grass, Blocks.dirt, false, null, 0f, 1.5f, 60f, 65f, 1.5f, Blocks.dirt, (byte)2, 0.10f)
        );

		/**
		 * ##################################################
		 * # DECORATIONS (ORDER MATTERS)
		 * ##################################################
		 */
		
        // Trees first.
		DecoTree bigPines = new DecoTree();
		bigPines.strengthFactorForLoops = 8f;
		bigPines.treeType = TreeType.BIG_PINES;
		bigPines.distribution.noiseDivisor = 100f;
		bigPines.distribution.noiseFactor = 6f;
		bigPines.distribution.noiseAddend = 0.8f;
		bigPines.treeCondition = TreeCondition.NOISE_GREATER_AND_RANDOM_CHANCE;
		bigPines.treeConditionNoise = 0f;
		bigPines.treeConditionChance = 1;
		bigPines.maxY = 110;
		this.addDeco(bigPines);
		
		// More trees.
		DecoTree smallPinesTreesForest = new DecoTree();
		smallPinesTreesForest.strengthFactorForLoops = 3f;
		smallPinesTreesForest.treeType = TreeType.SMALL_PINES_TREES_FORESTS;
		smallPinesTreesForest.treeCondition = TreeCondition.RANDOM_CHANCE;
		smallPinesTreesForest.treeConditionChance = 4;
		smallPinesTreesForest.maxY = 110;
		this.addDeco(smallPinesTreesForest);
		
		// Add some fallen trees of the oak and spruce variety (50/50 distribution).
        DecoFallenTree decoFallenOak = new DecoFallenTree();
        decoFallenOak.logCondition = LogCondition.RANDOM_CHANCE;
        decoFallenOak.logConditionChance = 16;
        decoFallenOak.maxY = 100;
        decoFallenOak.logBlock = Blocks.log;
        decoFallenOak.logMeta = (byte)0;
        decoFallenOak.leavesBlock = Blocks.leaves;
        decoFallenOak.leavesMeta = (byte)-1;
        decoFallenOak.minSize = 3;
        decoFallenOak.maxSize = 6;
		
        DecoFallenTree decoFallenSpruce = new DecoFallenTree();
        decoFallenSpruce.logCondition = LogCondition.RANDOM_CHANCE;
        decoFallenSpruce.logConditionChance = 24;
        decoFallenSpruce.maxY = 100;
        decoFallenSpruce.logBlock = Blocks.log;
        decoFallenSpruce.logMeta = (byte)1;
        decoFallenSpruce.leavesBlock = Blocks.leaves;
        decoFallenSpruce.leavesMeta = (byte)-1;
        decoFallenSpruce.minSize = 3;
        decoFallenSpruce.maxSize = 6;
        
        DecoHelper5050 decoFallenTree = new DecoHelper5050(decoFallenOak, decoFallenSpruce);
		this.addDeco(decoFallenTree, this.config._boolean(BiomeConfigVanillaForest.decorationLogsId));
        
        // Shrubs to fill in the blanks.
        DecoShrubCustom decoShrubOak = new DecoShrubCustom();
        decoShrubOak.maxY = 110;
        decoShrubOak.strengthFactor = 4f;
        decoShrubOak.chance = 3;
		this.addDeco(decoShrubOak);
		
        DecoShrubCustom decoShrubSpruce = new DecoShrubCustom();
        decoShrubSpruce.logBlock = Blocks.log;
        decoShrubSpruce.logMeta = 1;
        decoShrubSpruce.leavesBlock = Blocks.leaves;
        decoShrubSpruce.leavesMeta = 1;
        decoShrubSpruce.maxY = 110;
        decoShrubSpruce.strengthFactor = 4f;
        decoShrubSpruce.chance = 9;
		this.addDeco(decoShrubSpruce);
        
		// Only 1-block tall flowers so we can see the trees better.
		DecoFlowersRTG decoFlowersRTG = new DecoFlowersRTG();
		decoFlowersRTG.flowers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		decoFlowersRTG.maxY = 128;
		decoFlowersRTG.strengthFactor = 6f;
        this.addDeco(decoFlowersRTG);
        
        // Grass filler.
		DecoGrass decoGrass = new DecoGrass();
		decoGrass.minY = 53;
		decoGrass.maxY = 128;
		decoGrass.loops = 12;
        this.addDeco(decoGrass);    
    }
}
