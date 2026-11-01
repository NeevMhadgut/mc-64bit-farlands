import java.util.Random;

public class BiomeGenJungle extends BiomeGenBase {
   public BiomeGenJungle(int par1) {
      super(par1);
      this.I.z = 25 * (this.M - 20);
      this.I.B = 25;
      this.I.A = 4;
      this.J.add(new bg(EntityOcelot.class, 2, 1, 1));
      this.K.add(new bg(rd.class, 10, 4, 4));
   }

   @Override
   public WorldGenerator a(Random par1Random) {
      if (par1Random.nextInt(10) == 0) {
         return this.O;
      } else if (par1Random.nextInt(2) == 0 && this.M == 22) {
         return new WorldGenShrub(3, 0);
      } else if (par1Random.nextInt(3) == 0 && this.M == 22) {
         return new WorldGenHugeTrees(false, 10 + par1Random.nextInt(20), 3, 3);
      } else {
         return this.M == 22 ? new WorldGenTrees(false, 4 + par1Random.nextInt(7), 3, 3, true) : new WorldGenTrees(false);
      }
   }

   @Override
   public WorldGenerator b(Random par1Random) {
      return par1Random.nextInt(4) == 0 ? new WorldGenTallGrass(Block.X.bO, 2) : new WorldGenTallGrass(Block.X.bO, 1);
   }

   @Override
   public void decorate(World par1World, Random par2Random, long par3, long par4) {
      super.decorate(par1World, par2Random, par3, par4);
      if (this.M == 22) {
         WorldGenVines worldgenvines = new WorldGenVines();

         for (int i = 0; i < 50; i++) {
            long j = par3 + par2Random.nextInt(16) + 8L;
            byte byte0 = 64;
            long k = par4 + par2Random.nextInt(16) + 8L;
            worldgenvines.generate(par1World, par2Random, j, byte0, k);
         }
      }
   }
}
