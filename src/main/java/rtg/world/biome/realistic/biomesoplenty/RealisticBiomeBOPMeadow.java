package rtg.world.biome.realistic.biomesoplenty;

import biomesoplenty.api.biome.BOPBiomes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.world.gen.surface.biomesoplenty.SurfaceBOPMeadow;
import rtg.world.gen.terrain.biomesoplenty.TerrainBOPMeadow;

public class RealisticBiomeBOPMeadow extends RealisticBiomeBOPBase {
    public static BiomeGenBase bopBiome = BOPBiomes.meadow.get();

    public static IBlockState topBlock = bopBiome.topBlock;
    public static IBlockState fillerBlock = bopBiome.fillerBlock;

    public RealisticBiomeBOPMeadow() {
        super(
                bopBiome, Biomes.river,
                new TerrainBOPMeadow(),
                new SurfaceBOPMeadow(config, topBlock, fillerBlock)
        );
    }
}
