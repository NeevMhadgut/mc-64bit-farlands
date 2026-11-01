import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WorldChunkManagerHell extends WorldChunkManager {
   private BiomeGenBase a;
   private float b;
   private float c;

   public WorldChunkManagerHell(BiomeGenBase par1BiomeGenBase, float par2, float par3) {
      this.a = par1BiomeGenBase;
      this.b = par2;
      this.c = par3;
   }

   @Override
   public BiomeGenBase getBiomeGenAt(long par1, long par2) {
      return this.a;
   }

   @Override
   public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5) {
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, this.a);
      return par1ArrayOfBiomeGenBase;
   }

   @Override
   public float[] getTemperatures(float[] par1ArrayOfFloat, long par2, long par3, int par4, int par5) {
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, this.b);
      return par1ArrayOfFloat;
   }

   @Override
   public float[] getRainfall(float[] par1ArrayOfFloat, long par2, long par3, int par4, int par5) {
      if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
         par1ArrayOfFloat = new float[par4 * par5];
      }

      Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, this.c);
      return par1ArrayOfFloat;
   }

   @Override
   public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5) {
      if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
         par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
      }

      Arrays.fill(par1ArrayOfBiomeGenBase, 0, par4 * par5, this.a);
      return par1ArrayOfBiomeGenBase;
   }

   @Override
   public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, long par2, long par3, int par4, int par5, boolean par6) {
      return this.loadBlockGeneratorData(par1ArrayOfBiomeGenBase, par2, par3, par4, par5);
   }

   @Override
   public ChunkPosition findBiomePosition(long par1, long par2, int par3, List par4List, Random par5Random) {
      return par4List.contains(this.a) ? new ChunkPosition(par1 - par3 + par5Random.nextInt(par3 * 2 + 1), 0, par2 - par3 + par5Random.nextInt(par3 * 2 + 1)) : null;
   }

   @Override
   public boolean areBiomesViable(long par1, long par2, long par3, List par4List) {
      return par4List.contains(this.a);
   }
}
