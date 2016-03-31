package rtg.world.biome.realistic.thaumcraft;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.api.config.BiomeConfig;
import rtg.world.gen.surface.thaumcraft.SurfaceTCMagicalForest;
import rtg.world.gen.terrain.thaumcraft.TerrainTCMagicalForest;

public class RealisticBiomeTCMagicalForest extends RealisticBiomeTCBase {
    public RealisticBiomeTCMagicalForest(BiomeGenBase tcBiome, BiomeConfig config) {
        super(
                tcBiome, Biomes.river,
                new TerrainTCMagicalForest(),
                new SurfaceTCMagicalForest(config, tcBiome.topBlock, tcBiome.fillerBlock)
        );
    }
}
