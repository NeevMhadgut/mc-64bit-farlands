import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MapGenVillage extends MapGenStructure {
   public static List a = Arrays.asList(BiomeGenBase.c, BiomeGenBase.d, BiomeGenBase.e, BiomeGenBase.f, BiomeGenBase.g, BiomeGenBase.h, BiomeGenBase.n, BiomeGenBase.w);
   private final int f;

   public MapGenVillage(int par1) {
      this.f = par1;
   }

   @Override
   protected boolean canSpawnStructureAtCoords(long par1, long par2) {
      byte byte0 = 32;
      byte byte1 = 8;
      long i = par1;
      long j = par2;
      if (par1 < 0L) {
         par1 -= byte0 - 1;
      }

      if (par2 < 0L) {
         par2 -= byte0 - 1;
      }

      long k = par1 / byte0;
      long l = par2 / byte0;
      Random random = this.d.setRandomSeed(k, l, 10387312L);
      k *= byte0;
      l *= byte0;
      k += random.nextInt(byte0 - byte1);
      l += random.nextInt(byte0 - byte1);
      par1 = i;
      par2 = j;
      if (par1 == k && par2 == l) {
         boolean flag = this.d.i().areBiomesViable(par1 * 16L + 8L, par2 * 16L + 8L, 0L, a);
         if (flag) {
            return true;
         }
      }

      return false;
   }

   @Override
   protected StructureStart getStructureStart(long par1, long par2) {
      return new StructureVillageStart(this.d, this.c, par1, par2, this.f);
   }
}
